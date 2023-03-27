// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.debugger.evaluate;

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
@TestMetadata("../../completion/testData/handlers/runtimeCast")
public class CodeFragmentCompletionHandlerTestGenerated extends AbstractCodeFragmentCompletionHandlerTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @TestMetadata("CastPrivateFun.kt")
    public void testCastPrivateFun() throws Exception {
        runTest("../../completion/testData/handlers/runtimeCast/CastPrivateFun.kt");
    }

    @TestMetadata("CastPropertyWithSmartCast.kt")
    public void testCastPropertyWithSmartCast() throws Exception {
        runTest("../../completion/testData/handlers/runtimeCast/CastPropertyWithSmartCast.kt");
    }

    @TestMetadata("InsertExtFunction.kt")
    public void testInsertExtFunction() throws Exception {
        runTest("../../completion/testData/handlers/runtimeCast/InsertExtFunction.kt");
    }

    @TestMetadata("InsertFunction.kt")
    public void testInsertFunction() throws Exception {
        runTest("../../completion/testData/handlers/runtimeCast/InsertFunction.kt");
    }

    @TestMetadata("InsertImport.kt")
    public void testInsertImport() throws Exception {
        runTest("../../completion/testData/handlers/runtimeCast/InsertImport.kt");
    }

    @TestMetadata("NotImportedExtension.kt")
    public void testNotImportedExtension() throws Exception {
        runTest("../../completion/testData/handlers/runtimeCast/NotImportedExtension.kt");
    }
}