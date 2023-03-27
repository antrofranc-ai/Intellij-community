// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.checkers;

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
@TestMetadata("testData/checker/js")
public class JsCheckerTestGenerated extends AbstractJsCheckerTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @TestMetadata("basic.kt")
    public void testBasic() throws Exception {
        runTest("testData/checker/js/basic.kt");
    }

    @TestMetadata("dynamic.kt")
    public void testDynamic() throws Exception {
        runTest("testData/checker/js/dynamic.kt");
    }

    @TestMetadata("helloWorld.kt")
    public void testHelloWorld() throws Exception {
        runTest("testData/checker/js/helloWorld.kt");
    }
}