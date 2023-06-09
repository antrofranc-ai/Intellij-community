// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.refactoring.introduce.extractionEngine

import com.intellij.openapi.extensions.ExtensionPointName

/**
 * Allows to modify ExtractableCodeDescriptor within [ExtractionData.performAnalysis].
 */
interface AdditionalExtractableAnalyser {

    fun amendDescriptor(descriptor: ExtractableCodeDescriptor): ExtractableCodeDescriptor

    companion object {
        val EP_NAME = ExtensionPointName.create<AdditionalExtractableAnalyser>("org.jetbrains.kotlin.additionalExtractableAnalyser")
    }
}
