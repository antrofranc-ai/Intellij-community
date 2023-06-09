// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.kotlin.idea.debugger.test.sequence.psi.java

import com.intellij.debugger.streams.wrapper.StreamChainBuilder
import org.jetbrains.kotlin.idea.debugger.test.sequence.KotlinPsiChainBuilderTestCase
import org.jetbrains.kotlin.idea.debugger.sequence.lib.java.JavaStandardLibrarySupportProvider

abstract class PositiveJavaStreamTest(subDirectory: String) : KotlinPsiChainBuilderTestCase.Positive("streams/positive/$subDirectory") {
    override val kotlinChainBuilder: StreamChainBuilder = JavaStandardLibrarySupportProvider().chainBuilder
}