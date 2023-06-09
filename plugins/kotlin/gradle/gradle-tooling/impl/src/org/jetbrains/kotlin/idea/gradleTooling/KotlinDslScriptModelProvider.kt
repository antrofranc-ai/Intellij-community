// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.gradleTooling

import org.gradle.tooling.BuildController
import org.gradle.tooling.model.Model
import org.gradle.tooling.model.gradle.GradleBuild
import org.gradle.tooling.model.kotlin.dsl.KotlinDslScriptsModel
import org.jetbrains.plugins.gradle.model.ProjectImportModelProvider

class KotlinDslScriptModelProvider : ProjectImportModelProvider {
    private val kotlinDslScriptModelClass: Class<*> = KotlinDslScriptsModel::class.java

    override fun populateBuildModels(
        controller: BuildController,
        buildModel: GradleBuild,
        consumer: ProjectImportModelProvider.BuildModelConsumer
    ) {
        buildModel.projects.forEach {
            if (it.parent == null) {
                try {
                    val model = controller.findModel(it, kotlinDslScriptModelClass)
                    if (model != null) {
                        consumer.consumeProjectModel(it, model, kotlinDslScriptModelClass)
                    }
                } catch (e: Throwable) {
                    consumer.consumeProjectModel(
                        it,
                        BrokenKotlinDslScriptsModel(e), kotlinDslScriptModelClass
                    )
                }
            }
        }
    }

    override fun populateProjectModels(
        controller: BuildController,
        projectModel: Model,
        modelConsumer: ProjectImportModelProvider.ProjectModelConsumer
    ) = Unit
}