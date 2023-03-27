// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.highlighter;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.idea.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.idea.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.jetbrains.kotlin.idea.base.test.TestRoot;
import org.junit.runner.RunWith;
import org.jetbrains.kotlin.test.TargetBackend;

/**
 * This class is generated by {@link org.jetbrains.kotlin.testGenerator.generator.TestGenerator}.
 * DO NOT MODIFY MANUALLY.
 */
@SuppressWarnings("all")
@TestRoot("idea/tests")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
@TestMetadata("testData/diagnosticMessage/js")
public class DiagnosticMessageJsTestGenerated extends AbstractDiagnosticMessageJsTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, TargetBackend.JS, testDataFilePath);
    }

    @TestMetadata("jsCodeErrorHtml.kt")
    public void testJsCodeErrorHtml() throws Exception {
        runTest("testData/diagnosticMessage/js/jsCodeErrorHtml.kt");
    }

    @TestMetadata("jsCodeErrorText.kt")
    public void testJsCodeErrorText() throws Exception {
        runTest("testData/diagnosticMessage/js/jsCodeErrorText.kt");
    }
}