// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.roots.ui

import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ui.configuration.*
import com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.kotlin.config.ResourceKotlinRootType
import org.jetbrains.kotlin.config.SourceKotlinRootType
import org.jetbrains.kotlin.config.TestResourceKotlinRootType
import org.jetbrains.kotlin.config.TestSourceKotlinRootType

class KotlinContentEntriesEditor(
    moduleName: String,
    state: ModuleConfigurationState
) : CommonContentEntriesEditor(
    moduleName,
    state,
    SourceKotlinRootType,
    TestSourceKotlinRootType,
    ResourceKotlinRootType,
    TestResourceKotlinRootType
) {
    private val javaEditor by lazy {
        object : JavaContentEntriesEditor(moduleName, state) {
            public override fun addContentEntries(files: Array<out VirtualFile>?) = super.addContentEntries(files)
        }
    }

    override fun createContentEntryEditor(contentEntryUrl: String): ContentEntryEditor {
        return object : JavaContentEntryEditor(contentEntryUrl, editHandlers) {
            override fun getModel() = this@KotlinContentEntriesEditor.model
        }
    }

    override fun addContentEntries(files: Array<out VirtualFile>?): MutableList<ContentEntry> = javaEditor.addContentEntries(files)
}