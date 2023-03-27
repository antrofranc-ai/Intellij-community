// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.highlighter;

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
@TestMetadata("testData/highlighterMetaInfo")
public abstract class K1HighlightingMetaInfoTestGenerated extends AbstractK1HighlightingMetaInfoTest {
    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/highlighterMetaInfo/dsl")
    public static class Dsl extends AbstractK1HighlightingMetaInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("AnnotatedTypeParameter.kt")
        public void testAnnotatedTypeParameter() throws Exception {
            runTest("testData/highlighterMetaInfo/dsl/AnnotatedTypeParameter.kt");
        }

        @TestMetadata("AnnotatedTypeSpecifier.kt")
        public void testAnnotatedTypeSpecifier() throws Exception {
            runTest("testData/highlighterMetaInfo/dsl/AnnotatedTypeSpecifier.kt");
        }

        @TestMetadata("ImplementsDslInterface.kt")
        public void testImplementsDslInterface() throws Exception {
            runTest("testData/highlighterMetaInfo/dsl/ImplementsDslInterface.kt");
        }

        @TestMetadata("NestedReceivers.kt")
        public void testNestedReceivers() throws Exception {
            runTest("testData/highlighterMetaInfo/dsl/NestedReceivers.kt");
        }

        @TestMetadata("RegularDsl.kt")
        public void testRegularDsl() throws Exception {
            runTest("testData/highlighterMetaInfo/dsl/RegularDsl.kt");
        }

        @TestMetadata("SubclassOfDslClass.kt")
        public void testSubclassOfDslClass() throws Exception {
            runTest("testData/highlighterMetaInfo/dsl/SubclassOfDslClass.kt");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/highlighterMetaInfo/smartCasts")
    public static class SmartCasts extends AbstractK1HighlightingMetaInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("Explicit.kt")
        public void testExplicit() throws Exception {
            runTest("testData/highlighterMetaInfo/smartCasts/Explicit.kt");
        }

        @TestMetadata("Explicit_qualifiedCalls.kt")
        public void testExplicit_qualifiedCalls() throws Exception {
            runTest("testData/highlighterMetaInfo/smartCasts/Explicit_qualifiedCalls.kt");
        }

        @TestMetadata("Explicit_withInvokeCall.kt")
        public void testExplicit_withInvokeCall() throws Exception {
            runTest("testData/highlighterMetaInfo/smartCasts/Explicit_withInvokeCall.kt");
        }

        @TestMetadata("ImplicitAndExplicit_functions.kt")
        public void testImplicitAndExplicit_functions() throws Exception {
            runTest("testData/highlighterMetaInfo/smartCasts/ImplicitAndExplicit_functions.kt");
        }

        @TestMetadata("ImplicitAndExplicit_operators.kt")
        public void testImplicitAndExplicit_operators() throws Exception {
            runTest("testData/highlighterMetaInfo/smartCasts/ImplicitAndExplicit_operators.kt");
        }

        @TestMetadata("ImplicitAndExplicit_properties.kt")
        public void testImplicitAndExplicit_properties() throws Exception {
            runTest("testData/highlighterMetaInfo/smartCasts/ImplicitAndExplicit_properties.kt");
        }

        @TestMetadata("Implicit_stable.kt")
        public void testImplicit_stable() throws Exception {
            runTest("testData/highlighterMetaInfo/smartCasts/Implicit_stable.kt");
        }

        @TestMetadata("Invokes.kt")
        public void testInvokes() throws Exception {
            runTest("testData/highlighterMetaInfo/smartCasts/Invokes.kt");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/highlighterMetaInfo")
    public static class Uncategorized extends AbstractK1HighlightingMetaInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("Annotations.kt")
        public void testAnnotations() throws Exception {
            runTest("testData/highlighterMetaInfo/Annotations.kt");
        }

        @TestMetadata("AutoCreatedItParameter.kt")
        public void testAutoCreatedItParameter() throws Exception {
            runTest("testData/highlighterMetaInfo/AutoCreatedItParameter.kt");
        }

        @TestMetadata("Destructuring.kt")
        public void testDestructuring() throws Exception {
            runTest("testData/highlighterMetaInfo/Destructuring.kt");
        }

        @TestMetadata("Enums.kt")
        public void testEnums() throws Exception {
            runTest("testData/highlighterMetaInfo/Enums.kt");
        }

        @TestMetadata("ExplicitInvokeCall.kt")
        public void testExplicitInvokeCall() throws Exception {
            runTest("testData/highlighterMetaInfo/ExplicitInvokeCall.kt");
        }

        @TestMetadata("Field.kt")
        public void testField() throws Exception {
            runTest("testData/highlighterMetaInfo/Field.kt");
        }

        @TestMetadata("Functions.kt")
        public void testFunctions() throws Exception {
            runTest("testData/highlighterMetaInfo/Functions.kt");
        }

        @TestMetadata("InvokeCall.kt")
        public void testInvokeCall() throws Exception {
            runTest("testData/highlighterMetaInfo/InvokeCall.kt");
        }

        @TestMetadata("JavaTypes.kt")
        public void testJavaTypes() throws Exception {
            runTest("testData/highlighterMetaInfo/JavaTypes.kt");
        }

        @TestMetadata("KDoc.kt")
        public void testKDoc() throws Exception {
            runTest("testData/highlighterMetaInfo/KDoc.kt");
        }

        @TestMetadata("KotlinAnnotationsInJava.kt")
        public void testKotlinAnnotationsInJava() throws Exception {
            runTest("testData/highlighterMetaInfo/KotlinAnnotationsInJava.kt");
        }

        @TestMetadata("KotlinInjection.kt")
        public void testKotlinInjection() throws Exception {
            runTest("testData/highlighterMetaInfo/KotlinInjection.kt");
        }

        @TestMetadata("Labels.kt")
        public void testLabels() throws Exception {
            runTest("testData/highlighterMetaInfo/Labels.kt");
        }

        @TestMetadata("NamedArguments.kt")
        public void testNamedArguments() throws Exception {
            runTest("testData/highlighterMetaInfo/NamedArguments.kt");
        }

        @TestMetadata("NonNullAssertion.kt")
        public void testNonNullAssertion() throws Exception {
            runTest("testData/highlighterMetaInfo/NonNullAssertion.kt");
        }

        @TestMetadata("Object.kt")
        public void testObject() throws Exception {
            runTest("testData/highlighterMetaInfo/Object.kt");
        }

        @TestMetadata("PropertiesWithPropertyDeclarations.kt")
        public void testPropertiesWithPropertyDeclarations() throws Exception {
            runTest("testData/highlighterMetaInfo/PropertiesWithPropertyDeclarations.kt");
        }

        @TestMetadata("Suspend.kt")
        public void testSuspend() throws Exception {
            runTest("testData/highlighterMetaInfo/Suspend.kt");
        }

        @TestMetadata("SyntheticExtensionProperty.kt")
        public void testSyntheticExtensionProperty() throws Exception {
            runTest("testData/highlighterMetaInfo/SyntheticExtensionProperty.kt");
        }

        @TestMetadata("Todo.kt")
        public void testTodo() throws Exception {
            runTest("testData/highlighterMetaInfo/Todo.kt");
        }

        @TestMetadata("TypeAlias.kt")
        public void testTypeAlias() throws Exception {
            runTest("testData/highlighterMetaInfo/TypeAlias.kt");
        }

        @TestMetadata("TypesAndAnnotations.kt")
        public void testTypesAndAnnotations() throws Exception {
            runTest("testData/highlighterMetaInfo/TypesAndAnnotations.kt");
        }

        @TestMetadata("Variables.kt")
        public void testVariables() throws Exception {
            runTest("testData/highlighterMetaInfo/Variables.kt");
        }

        @TestMetadata("VariablesAsFunctions.kt")
        public void testVariablesAsFunctions() throws Exception {
            runTest("testData/highlighterMetaInfo/VariablesAsFunctions.kt");
        }
    }
}