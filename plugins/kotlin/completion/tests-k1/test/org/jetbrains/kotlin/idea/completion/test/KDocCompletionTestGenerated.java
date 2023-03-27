// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.completion.test;

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
@TestRoot("completion/tests-k1")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
@TestMetadata("../testData/kdoc")
public class KDocCompletionTestGenerated extends AbstractJvmBasicCompletionTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @TestMetadata("AfterPackageName.kt")
    public void testAfterPackageName() throws Exception {
        runTest("../testData/kdoc/AfterPackageName.kt");
    }

    @TestMetadata("AutoPopupAfterAtInKDoc.kt")
    public void testAutoPopupAfterAtInKDoc() throws Exception {
        runTest("../testData/kdoc/AutoPopupAfterAtInKDoc.kt");
    }

    @TestMetadata("ExtensionsFQLink.kt")
    public void testExtensionsFQLink() throws Exception {
        runTest("../testData/kdoc/ExtensionsFQLink.kt");
    }

    @TestMetadata("ExtensionsForNestedClassFQLink.kt")
    public void testExtensionsForNestedClassFQLink() throws Exception {
        runTest("../testData/kdoc/ExtensionsForNestedClassFQLink.kt");
    }

    @TestMetadata("FQLink.kt")
    public void testFQLink() throws Exception {
        runTest("../testData/kdoc/FQLink.kt");
    }

    @TestMetadata("FQLinkInTag1.kt")
    public void testFQLinkInTag1() throws Exception {
        runTest("../testData/kdoc/FQLinkInTag1.kt");
    }

    @TestMetadata("FQLinkInTag2.kt")
    public void testFQLinkInTag2() throws Exception {
        runTest("../testData/kdoc/FQLinkInTag2.kt");
    }

    @TestMetadata("Link.kt")
    public void testLink() throws Exception {
        runTest("../testData/kdoc/Link.kt");
    }

    @TestMetadata("MemberEnumEntryFQLink.kt")
    public void testMemberEnumEntryFQLink() throws Exception {
        runTest("../testData/kdoc/MemberEnumEntryFQLink.kt");
    }

    @TestMetadata("MemberEnumEntryLink.kt")
    public void testMemberEnumEntryLink() throws Exception {
        runTest("../testData/kdoc/MemberEnumEntryLink.kt");
    }

    @TestMetadata("MemberLink.kt")
    public void testMemberLink() throws Exception {
        runTest("../testData/kdoc/MemberLink.kt");
    }

    @TestMetadata("NoAutoPopupAfterDigitInKDoc.kt")
    public void testNoAutoPopupAfterDigitInKDoc() throws Exception {
        runTest("../testData/kdoc/NoAutoPopupAfterDigitInKDoc.kt");
    }

    @TestMetadata("NoCompletionAfterFunName.kt")
    public void testNoCompletionAfterFunName() throws Exception {
        runTest("../testData/kdoc/NoCompletionAfterFunName.kt");
    }

    @TestMetadata("NoTopLevelForQualified.kt")
    public void testNoTopLevelForQualified() throws Exception {
        runTest("../testData/kdoc/NoTopLevelForQualified.kt");
    }

    @TestMetadata("NotTagName.kt")
    public void testNotTagName() throws Exception {
        runTest("../testData/kdoc/NotTagName.kt");
    }

    @TestMetadata("ParamTag.kt")
    public void testParamTag() throws Exception {
        runTest("../testData/kdoc/ParamTag.kt");
    }

    @TestMetadata("SkipExistingParamTag.kt")
    public void testSkipExistingParamTag() throws Exception {
        runTest("../testData/kdoc/SkipExistingParamTag.kt");
    }

    @TestMetadata("TagName.kt")
    public void testTagName() throws Exception {
        runTest("../testData/kdoc/TagName.kt");
    }

    @TestMetadata("TagNameAfterAt.kt")
    public void testTagNameAfterAt() throws Exception {
        runTest("../testData/kdoc/TagNameAfterAt.kt");
    }

    @TestMetadata("TagNameInClass.kt")
    public void testTagNameInClass() throws Exception {
        runTest("../testData/kdoc/TagNameInClass.kt");
    }

    @TestMetadata("TagNameInExtensionFunction.kt")
    public void testTagNameInExtensionFunction() throws Exception {
        runTest("../testData/kdoc/TagNameInExtensionFunction.kt");
    }

    @TestMetadata("TagNameMiddle.kt")
    public void testTagNameMiddle() throws Exception {
        runTest("../testData/kdoc/TagNameMiddle.kt");
    }

    @TestMetadata("TagNameStart.kt")
    public void testTagNameStart() throws Exception {
        runTest("../testData/kdoc/TagNameStart.kt");
    }
}