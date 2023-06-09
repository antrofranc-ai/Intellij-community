// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.kotlin.idea.debugger.test.sequence.psi.java

import org.junit.internal.runners.JUnit38ClassRunner
import org.junit.runner.RunWith

@RunWith(JUnit38ClassRunner::class)
class LocationPositiveChainTest : PositiveJavaStreamTest("location") {
    fun testAnonymousBody() = doTest()

    fun testAssignExpression() = doTest()

    fun testFirstParameterOfFunction() = doTest()
    fun testLambdaBody() = doTest()

    fun testParameterInAssignExpression() = doTest()
    fun testParameterInReturnExpression() = doTest()

    fun testReturnExpression() = doTest()

    fun testSecondParameterOfFunction() = doTest()

    fun testSingleExpression() = doTest()

    fun testBeforeStatement() = doTest()

    fun testBetweenChainCallsBeforeDot() = doTest()
    fun testBetweenChainCallsAfterDot() = doTest()

    fun testInEmptyParameterList() = doTest()

    fun testBetweenParametersBeforeComma() = doTest()
    fun testBetweenParametersAfterComma() = doTest()

    fun testInAnyLambda() = doTest()
    fun testInAnyAnonymous() = doTest()
    fun testInString() = doTest()
    fun testInVariableName() = doTest()
    fun testInMethodReference() = doTest()

    fun testAsMethodExpression() = doTest()
}