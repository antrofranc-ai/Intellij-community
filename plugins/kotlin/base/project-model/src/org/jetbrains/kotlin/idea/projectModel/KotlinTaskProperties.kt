// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.kotlin.idea.projectModel

import java.io.File
import java.io.Serializable

interface KotlinTaskProperties : Serializable {
    val incremental: Boolean?
    val packagePrefix: String?
    val pureKotlinSourceFolders: List<File>?
    val pluginVersion: String?
}