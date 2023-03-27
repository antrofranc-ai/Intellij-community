// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
@file:Suppress("ReplaceGetOrSet")

package com.intellij.openapi.project.impl

import com.intellij.ide.*
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.ProjectCloseListener
import com.intellij.openapi.project.ex.ProjectManagerEx
import com.intellij.project.stateStore
import com.intellij.testFramework.*
import com.intellij.testFramework.assertions.Assertions.assertThat
import com.intellij.ui.DeferredIconImpl
import com.intellij.util.IconUtil
import com.intellij.util.PathUtil
import com.intellij.util.messages.SimpleMessageBusConnection
import com.intellij.util.ui.EmptyIcon
import kotlinx.coroutines.runBlocking
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExternalResource
import java.awt.Color
import java.nio.file.Path

class RecentProjectsTest {
  companion object {
    @ClassRule
    @JvmField
    val appRule = ApplicationRule()

    @ClassRule
    @JvmField
    val edtRule = EdtRule()
  }

  @Rule
  @JvmField
  val disposableRule = DisposableRule()

  @Rule
  @JvmField
  internal val busConnection = RecentProjectManagerListenerRule()

  @Rule
  @JvmField
  val tempDir = TemporaryDirectory()

  @Test
  fun mostRecentOnTop() = runBlocking {
    val p1 = createAndOpenProject("p1")
    val p2 = createAndOpenProject("p2")
    val p3 = createAndOpenProject("p3")

    checkRecents("p3", "p2", "p1")

    doReopenCloseAndCheck(p2, "p2", "p3", "p1")
    doReopenCloseAndCheck(p1, "p1", "p2", "p3")
    doReopenCloseAndCheck(p3, "p3", "p1", "p2")
  }

  @Test
  fun groupOrder() = runBlocking {
    val p1 = createAndOpenProject("p1")
    val p2 = createAndOpenProject("p2")
    val p3 = createAndOpenProject("p3")
    val p4 = createAndOpenProject("p4")

    val manager = RecentProjectsManager.getInstance()
    val g1 = ProjectGroup("g1")
    val g2 = ProjectGroup("g2")
    manager.addGroup(g1)
    manager.addGroup(g2)

    g1.addProject(p1.toString())
    g1.addProject(p2.toString())
    g2.addProject(p3.toString())

    checkGroups(listOf("g2", "g1"))

    doReopenCloseAndCheckGroups(p4, listOf("g2", "g1"))
    doReopenCloseAndCheckGroups(p1, listOf("g1", "g2"))
    doReopenCloseAndCheckGroups(p3, listOf("g2", "g1"))
  }

  @Test
  fun timestampForOpenProjectUpdatesWhenGetStateCalled(): Unit = runBlocking {
    val z1 = tempDir.newPath("z1")
    val projectManager = ProjectManagerEx.getInstanceEx()
    var project = projectManager.openProjectAsync(z1, createTestOpenProjectOptions(runPostStartUpActivities = false))!!
    try {
      val recentProjectManager = RecentProjectsManagerBase.getInstanceEx()
      recentProjectManager.projectOpened(project)

      val timestamp = getProjectOpenTimestamp("z1")
      projectManager.forceCloseProjectAsync(project)
      project = projectManager.openProjectAsync(z1, createTestOpenProjectOptions(runPostStartUpActivities = false))!!
      recentProjectManager.projectOpened(project)
      recentProjectManager.updateLastProjectPath()
      // "Timestamp for an opened project has not been updated"
      assertThat(getProjectOpenTimestamp("z1")).isGreaterThan(timestamp)
    }
    finally {
      projectManager.forceCloseProjectAsync(project)
    }
  }

  @Test
  fun solutionLikeProjectIcon() {
    // For Rider
    val rpm = (RecentProjectsManager.getInstance() as RecentProjectsManagerBase)

    val projectDir = Path.of("${PlatformTestUtil.getPlatformTestDataPath()}/recentProjects/dotNetSampleRecent/Povysh")
    val slnFile = projectDir.resolve("Povysh.sln")

    val icon = (rpm.getProjectIcon(slnFile.toString(), isProjectValid = true) as DeferredIconImpl<*>).evaluate()
    assertThat(icon).isNotInstanceOf(EmptyIcon::class.java)

    // Check that image is loaded from file, and not generated by IDE
    val iconImage = IconUtil.toBufferedImage(icon)
    for (x in 0 until iconImage.width) {
      for (y in 0 until iconImage.height) {
        val color = iconImage.getRGB(x, y)
        assertThat(color).isEqualTo(Color.BLUE.rgb)
      }
    }
  }

  private fun getProjectOpenTimestamp(@Suppress("SameParameterValue") projectName: String): Long {
    val additionalInfo = RecentProjectsManagerBase.getInstanceEx().state.additionalInfo
    for (s in additionalInfo.keys) {
      if (s.endsWith(projectName) || s.substringBeforeLast('_').endsWith(projectName)) {
        return additionalInfo.get(s)!!.projectOpenTimestamp
      }
    }
    return -1
  }

  private suspend fun doReopenCloseAndCheck(projectPath: Path, vararg results: String) {
    openProjectAndClose(projectPath)
    checkRecents(*results)
  }

  private suspend fun openProjectAndClose(projectPath: Path) {
    val projectManager = ProjectManagerEx.getInstanceEx()
    val project = projectManager.openProjectAsync(projectPath, createTestOpenProjectOptions(runPostStartUpActivities = false))!!
    try {
      RecentProjectsManagerBase.getInstanceEx().projectOpened(project)
    }
    finally {
      projectManager.forceCloseProjectAsync(project)
    }
  }

  private suspend fun doReopenCloseAndCheckGroups(projectPath: Path, results: List<String>) {
    openProjectAndClose(projectPath)
    checkGroups(results)
  }

  private fun checkRecents(vararg recents: String) {
    val recentProjects = listOf(*recents)
    val state = (RecentProjectsManager.getInstance() as RecentProjectsManagerBase).state
    val projects = state.additionalInfo.keys.asSequence()
      .map { s -> PathUtil.getFileName(s).substringAfter('_').substringBeforeLast('_') }
      .filter { recentProjects.contains(it) }
      .toList()
    assertThat(projects.reversed()).isEqualTo(recentProjects)
  }

  private fun checkGroups(groups: List<String>) {
    val recentGroups = RecentProjectListActionProvider.getInstance().getActions(false, true).asSequence()
      .filter { a -> a is ProjectGroupActionGroup }
      .map { a -> (a as ProjectGroupActionGroup).group.name }
      .toList()
    assertThat(recentGroups).isEqualTo(groups)
  }

  private suspend fun createAndOpenProject(name: String): Path {
    val path = tempDir.newPath(name)
    val projectManager = ProjectManagerEx.getInstanceEx()
    var project = projectManager.openProjectAsync(path, createTestOpenProjectOptions(runPostStartUpActivities = false))!!
    try {
      val recentProjectManager = RecentProjectsManagerBase.getInstanceEx()
      recentProjectManager.projectOpened(project)
      project.stateStore.saveComponent(RecentProjectsManager.getInstance() as RecentProjectsManagerBase)
      projectManager.forceCloseProjectAsync(project)
      project = projectManager.openProjectAsync(path, createTestOpenProjectOptions(runPostStartUpActivities = false))!!
      recentProjectManager.projectOpened(project)
      return path
    }
    finally {
      projectManager.forceCloseProjectAsync(project)
    }
  }
}

internal class RecentProjectManagerListenerRule : ExternalResource() {
  private var connection: SimpleMessageBusConnection? = null

  override fun before() {
    connection = ApplicationManager.getApplication().messageBus.simpleConnect()
    connection!!.subscribe(ProjectCloseListener.TOPIC, RecentProjectsManagerBase.MyProjectListener())
    connection!!.subscribe(AppLifecycleListener.TOPIC, RecentProjectsManagerBase.MyAppLifecycleListener())
  }

  override fun after() {
    connection?.disconnect()
  }
}