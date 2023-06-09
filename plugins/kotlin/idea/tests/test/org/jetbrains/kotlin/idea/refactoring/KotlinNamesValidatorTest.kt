// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.refactoring

import com.intellij.lang.refactoring.NamesValidator
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import org.junit.Assert
import org.junit.internal.runners.JUnit38ClassRunner
import org.junit.runner.RunWith

@RunWith(JUnit38ClassRunner::class)
class KotlinNamesValidatorTest : LightJavaCodeInsightFixtureTestCase() {
    val validator: NamesValidator = KotlinNamesValidator()

    private fun isKeyword(string: String) = validator.isKeyword(string, null)
    private fun isIdentifier(string: String) = validator.isIdentifier(string, null)

    override fun setUp() {
        super.setUp()
        myFixture.configureByFiles()
    }

    fun testKeywords() {
        Assert.assertTrue(isKeyword("val"))
        Assert.assertTrue(isKeyword("class"))
        Assert.assertTrue(isKeyword("fun"))

        Assert.assertFalse(isKeyword("constructor"))
        Assert.assertFalse(isKeyword("123"))
        Assert.assertFalse(isKeyword("a.c"))
        Assert.assertFalse(isKeyword("-"))
    }

    fun testIdentifiers() {
        Assert.assertTrue(isIdentifier("abc"))
        Assert.assertTrue(isIdentifier("q_q"))
        Assert.assertTrue(isIdentifier("constructor"))
        Assert.assertTrue(isIdentifier("`val`"))

        Assert.assertFalse(isIdentifier("val"))
        Assert.assertFalse(isIdentifier("class"))
        Assert.assertFalse(isIdentifier("fun"))

        Assert.assertFalse(isIdentifier("123"))
        Assert.assertFalse(isIdentifier("a.c"))
        Assert.assertFalse(isIdentifier("-"))
        Assert.assertFalse(isIdentifier("``"))
        Assert.assertFalse(isIdentifier(""))
        Assert.assertFalse(isIdentifier("  '"))
    }
}
