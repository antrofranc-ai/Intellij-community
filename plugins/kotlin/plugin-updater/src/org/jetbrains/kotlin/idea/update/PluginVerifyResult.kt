// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.update

class PluginVerifyResult {
    var verified: Boolean = true

    /**
     * Short sentence explaining why plugin is available in JetBrains repository but can't be installed.
     * Unapproved result should have a not-null declined message.
     */
    var declineMessage: String? = null

    companion object {
        @JvmOverloads
        fun decline(reason: String? = null): PluginVerifyResult = PluginVerifyResult().apply {
            declineMessage = reason
            verified = false
        }

        fun accept() = PluginVerifyResult()
    }
}
