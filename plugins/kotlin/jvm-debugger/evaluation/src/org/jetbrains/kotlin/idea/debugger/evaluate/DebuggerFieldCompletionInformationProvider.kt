// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.debugger.evaluate

import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.idea.completion.CompletionInformationProvider

class DebuggerFieldCompletionInformationProvider : CompletionInformationProvider {
    override fun getContainerAndReceiverInformation(descriptor: DeclarationDescriptor) =
        (descriptor as? DebuggerFieldPropertyDescriptor)?.description?.let { " $it" }
}