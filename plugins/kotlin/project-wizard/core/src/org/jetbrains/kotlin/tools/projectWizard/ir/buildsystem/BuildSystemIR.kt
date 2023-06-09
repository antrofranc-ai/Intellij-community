// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.kotlin.tools.projectWizard.ir.buildsystem

import org.jetbrains.kotlin.tools.projectWizard.ir.IR
import org.jetbrains.kotlin.tools.projectWizard.plugins.printer.BuildFilePrinter
import kotlin.reflect.KClass

interface BuildSystemIR : IR {
    fun BuildFilePrinter.render()
}

interface BuildSystemIRWithPriority : BuildSystemIR {
    val priority: Int? get() = null
}

// IR element, which is not hardcoded into the parent IR structure and can be printed
// In any place of the parent IR
interface FreeIR : BuildSystemIR

interface SingleIR : BuildSystemIR

interface KotlinIR : BuildSystemIR

fun List<BuildSystemIR>.removeSingleIRDuplicates(): List<BuildSystemIR> {
    if (none { it is SingleIR }) return this
    val result = mutableListOf<BuildSystemIR>()
    val met = mutableSetOf<KClass<out BuildSystemIR>>()
    for (ir in this) {
        if (ir is SingleIR) {
            if (ir::class !in met) {
                result += ir
                met += ir::class
            }
        } else result += ir
    }
    return result
}

fun BuildSystemIR.render(printer: BuildFilePrinter) {
    with(printer) { render() }
}
