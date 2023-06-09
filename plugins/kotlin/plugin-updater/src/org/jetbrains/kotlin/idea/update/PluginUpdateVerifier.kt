// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.update

import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.openapi.extensions.ExtensionPointName

abstract class PluginUpdateVerifier {
    abstract val verifierName: String

    /**
     * @param pluginDescriptor
     * @return null means verifier is not responsible for the given plugin descriptor.
     */
    abstract fun verify(pluginDescriptor: IdeaPluginDescriptor): PluginVerifyResult?

    companion object {
        internal var EP_NAME = ExtensionPointName<PluginUpdateVerifier>("org.jetbrains.kotlin.pluginUpdateVerifier")
    }
}