// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.kotlin.tools.projectWizard.wizard.ui.secondStep.modulesEditor

import org.jetbrains.annotations.NonNls
import org.jetbrains.kotlin.tools.projectWizard.moduleConfigurators.TargetConfigurator
import org.jetbrains.kotlin.tools.projectWizard.settings.buildsystem.*

class NewModuleCreator {
    private fun suggestName(@NonNls name: String, modules: List<Module>): String {
        val names = modules.map(Module::name).toSet()
        if (name !in names) return name
        var index = 1
        while ("${name}_$index" in names) {
            index++
        }
        return "${name}_$index"
    }

    private fun newTarget(
        configurator: TargetConfigurator,
        allTargets: List<Module>
    ): Module = MultiplatformTargetModule(
        suggestName(
            configurator.suggestedModuleName ?: configurator.moduleType.name,
            allTargets
        ),
        configurator,
        SourcesetType.values().map { sourcesetType ->
            Sourceset(
                sourcesetType,
                dependencies = emptyList()
            )
        }
    )

    fun create(
        target: Module?,
        allowMultiplatform: Boolean,
        allowSinglePlatformJsBrowser: Boolean,
        allowSinglePlatformJsNode: Boolean,
        allowAndroid: Boolean,
        allowIos: Boolean,
        allModules: List<Module>,
        createModule: (Module) -> Unit
    ) = CreateModuleOrTargetPopup.create(
        target = target,
        allowMultiplatform = allowMultiplatform,
        allowSinglePlatformJsBrowser = allowSinglePlatformJsBrowser,
        allowSinglePlatformJsNode = allowSinglePlatformJsNode,
        allowAndroid = allowAndroid,
        allowIos = allowIos,
        createTarget = { targetConfigurator ->
            createModule(newTarget(targetConfigurator, target?.subModules.orEmpty()))
        },
        createModule = { configurator ->
            val name = suggestName(configurator.suggestedModuleName ?: "module", allModules)
            val sourcesets = when (configurator.moduleKind) {
                ModuleKind.multiplatform -> emptyList()
                else -> SourcesetType.values().map { sourcesetType ->
                    Sourceset(
                        sourcesetType,
                        dependencies = emptyList()
                    )
                }
            }
            val createdModule = Module(
                name,
                configurator,
                template = null,
                sourceSets = sourcesets,
                subModules = emptyList()
            )
            createModule(createdModule)
        }
    )
}