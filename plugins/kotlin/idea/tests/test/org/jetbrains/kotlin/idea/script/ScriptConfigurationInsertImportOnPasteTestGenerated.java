// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.script;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.idea.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.idea.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.jetbrains.kotlin.idea.base.test.TestRoot;
import org.junit.runner.RunWith;

/**
 * This class is generated by {@link org.jetbrains.kotlin.testGenerator.generator.TestGenerator}.
 * DO NOT MODIFY MANUALLY.
 */
@SuppressWarnings("all")
@TestRoot("idea/tests")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public abstract class ScriptConfigurationInsertImportOnPasteTestGenerated extends AbstractScriptConfigurationInsertImportOnPasteTest {
    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/script/definition/imports")
    public static class Copy extends AbstractScriptConfigurationInsertImportOnPasteTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTestCopy, this, testDataFilePath);
        }

        @TestMetadata("implicitImport")
        public void testImplicitImport() throws Exception {
            runTest("testData/script/definition/imports/implicitImport/");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/script/definition/imports")
    public static class Cut extends AbstractScriptConfigurationInsertImportOnPasteTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTestCut, this, testDataFilePath);
        }

        @TestMetadata("implicitImport")
        public void testImplicitImport() throws Exception {
            runTest("testData/script/definition/imports/implicitImport/");
        }
    }
}