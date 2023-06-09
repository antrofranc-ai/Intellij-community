// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.kotlin.idea.performance.tests.utils.project

import com.intellij.openapi.externalSystem.importing.ImportSpecBuilder
import com.intellij.openapi.externalSystem.service.execution.ProgressExecutionMode
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil
import com.intellij.openapi.externalSystem.util.ExternalSystemUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.io.FileUtil
import org.jetbrains.kotlin.idea.performance.tests.utils.dispatchAllInvocationEvents
import org.jetbrains.plugins.gradle.settings.GradleDefaultProjectSettings
import org.jetbrains.plugins.gradle.settings.GradleProjectSettings
import org.jetbrains.plugins.gradle.settings.GradleSettings
import org.jetbrains.plugins.gradle.util.GradleConstants
import org.jetbrains.plugins.gradle.util.GradleLog
import java.io.File

fun refreshGradleProject(projectPath: String, project: Project) {
    _importProject(FileUtil.toCanonicalPath(File(projectPath).absolutePath), project)

    dispatchAllInvocationEvents()
}

const val GRADLE_JDK_NAME = "Gradle JDK"

/**
 * inspired by org.jetbrains.plugins.gradle.service.project.open.importProject(projectDirectory, project)
 */
private fun _importProject(projectPath: String, project: Project) {
    GradleLog.LOG.info("Import project at $projectPath")
    val gradleProjectSettings = GradleDefaultProjectSettings.createProjectSettings(projectPath)

    GradleSettings.getInstance(project).gradleVmOptions =
        "-Xmx2048m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${System.getProperty("user.dir")}"

    gradleProjectSettings.gradleJvm = GRADLE_JDK_NAME

    GradleSettings.getInstance(project).getLinkedProjectSettings(projectPath)?.let { linkedProjectSettings ->
        linkedProjectSettings.gradleJvm = GRADLE_JDK_NAME
    }

    _attachGradleProjectAndRefresh(gradleProjectSettings, project)
}

/**
 * inspired by org.jetbrains.plugins.gradle.service.project.open.attachGradleProjectAndRefresh(gradleProjectSettings, project)
 * except everything is MODAL_SYNC
 */
private fun _attachGradleProjectAndRefresh(
    gradleProjectSettings: GradleProjectSettings,
    project: Project
) {
    val externalProjectPath = gradleProjectSettings.externalProjectPath
    val settings = ExternalSystemApiUtil.getSettings(project, GradleConstants.SYSTEM_ID)
    if (settings.getLinkedProjectSettings(externalProjectPath) == null) {
        settings.linkProject(gradleProjectSettings)
    }

    StatefulTestGradleProjectRefreshCallback(externalProjectPath, project).use { callback ->
        ExternalSystemUtil.refreshProject(
            externalProjectPath,
            ImportSpecBuilder(project, GradleConstants.SYSTEM_ID)
                .use(ProgressExecutionMode.MODAL_SYNC)
                .callback(callback)
                .build()
        )
    }
}
