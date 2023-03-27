// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.fir.parameterInfo;

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
@TestRoot("fir")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
@TestMetadata("../idea/tests/testData/parameterInfo")
public abstract class FirParameterInfoTestGenerated extends AbstractFirParameterInfoTest {
    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../idea/tests/testData/parameterInfo/annotations")
    public static class Annotations extends AbstractFirParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("ConstructorCall.kt")
        public void testConstructorCall() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/annotations/ConstructorCall.kt");
        }

        @TestMetadata("ConstructorCallWithUseSite.kt")
        public void testConstructorCallWithUseSite() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/annotations/ConstructorCallWithUseSite.kt");
        }

        @TestMetadata("FunctionCall.kt")
        public void testFunctionCall() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/annotations/FunctionCall.kt");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../idea/tests/testData/parameterInfo/arrayAccess")
    public static class ArrayAccess extends AbstractFirParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("ktij-5382.kt")
        public void testKtij_5382() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/arrayAccess/ktij-5382.kt");
        }

        @TestMetadata("Overloads.kt")
        public void testOverloads() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/arrayAccess/Overloads.kt");
        }

        @TestMetadata("Overloads2.kt")
        public void testOverloads2() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/arrayAccess/Overloads2.kt");
        }

        @TestMetadata("Set.kt")
        public void testSet() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/arrayAccess/Set.kt");
        }

        @TestMetadata("SetTooManyArgs.kt")
        public void testSetTooManyArgs() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/arrayAccess/SetTooManyArgs.kt");
        }

        @TestMetadata("Simple.kt")
        public void testSimple() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/arrayAccess/Simple.kt");
        }

        @TestMetadata("UpdateOnTypingGet.kt")
        public void testUpdateOnTypingGet() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/arrayAccess/UpdateOnTypingGet.kt");
        }

        @TestMetadata("UpdateOnTypingSet.kt")
        public void testUpdateOnTypingSet() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/arrayAccess/UpdateOnTypingSet.kt");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../idea/tests/testData/parameterInfo/functionCall")
    public static class FunctionCall extends AbstractFirParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("Conflicting.kt")
        public void testConflicting() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/Conflicting.kt");
        }

        @TestMetadata("DataClassComponentFunction.kt")
        public void testDataClassComponentFunction() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/DataClassComponentFunction.kt");
        }

        @TestMetadata("DataClassCopy.kt")
        public void testDataClassCopy() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/DataClassCopy.kt");
        }

        @TestMetadata("DefaultConstructor.kt")
        public void testDefaultConstructor() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/DefaultConstructor.kt");
        }

        @TestMetadata("DefaultValuesFromLib.kt")
        public void testDefaultValuesFromLib() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/DefaultValuesFromLib.kt");
        }

        @TestMetadata("Deprecated.kt")
        public void testDeprecated() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/Deprecated.kt");
        }

        @TestMetadata("DeprecatedHidden.kt")
        public void testDeprecatedHidden() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/DeprecatedHidden.kt");
        }

        @TestMetadata("deprecatedSinceKotlinApplicable.kt")
        public void testDeprecatedSinceKotlinApplicable() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/deprecatedSinceKotlinApplicable.kt");
        }

        @TestMetadata("deprecatedSinceKotlinNotApplicable.kt")
        public void testDeprecatedSinceKotlinNotApplicable() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/deprecatedSinceKotlinNotApplicable.kt");
        }

        @TestMetadata("EnumValueOf.kt")
        public void testEnumValueOf() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/EnumValueOf.kt");
        }

        @TestMetadata("EnumValues.kt")
        public void testEnumValues() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/EnumValues.kt");
        }

        @TestMetadata("ExtensionOnCapturedScopeChange.kt")
        public void testExtensionOnCapturedScopeChange() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/ExtensionOnCapturedScopeChange.kt");
        }

        @TestMetadata("ExtensionOnClassObject.kt")
        public void testExtensionOnClassObject() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/ExtensionOnClassObject.kt");
        }

        @TestMetadata("FunctionalValue1.kt")
        public void testFunctionalValue1() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/FunctionalValue1.kt");
        }

        @TestMetadata("FunctionalValue2.kt")
        public void testFunctionalValue2() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/FunctionalValue2.kt");
        }

        @TestMetadata("FunctionalValueAndTypeAlias.kt")
        public void testFunctionalValueAndTypeAlias() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/FunctionalValueAndTypeAlias.kt");
        }

        @TestMetadata("FunctionalValueGeneric1.kt")
        public void testFunctionalValueGeneric1() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/FunctionalValueGeneric1.kt");
        }

        @TestMetadata("FunctionalValueGeneric2.kt")
        public void testFunctionalValueGeneric2() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/FunctionalValueGeneric2.kt");
        }

        @TestMetadata("InheritedFunctions.kt")
        public void testInheritedFunctions() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/InheritedFunctions.kt");
        }

        @TestMetadata("InheritedWithCurrentFunctions.kt")
        public void testInheritedWithCurrentFunctions() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/InheritedWithCurrentFunctions.kt");
        }

        @TestMetadata("Invoke.kt")
        public void testInvoke() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/Invoke.kt");
        }

        @TestMetadata("lambdaArgument.kt")
        public void testLambdaArgument() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/lambdaArgument.kt");
        }

        @TestMetadata("lambdaArgument2.kt")
        public void testLambdaArgument2() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/lambdaArgument2.kt");
        }

        @TestMetadata("lambdaArgumentForEach.kt")
        public void testLambdaArgumentForEach() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/lambdaArgumentForEach.kt");
        }

        @TestMetadata("lambdaArgumentGroupBy.kt")
        public void testLambdaArgumentGroupBy() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/lambdaArgumentGroupBy.kt");
        }

        @TestMetadata("LocalFunctionBug.kt")
        public void testLocalFunctionBug() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/LocalFunctionBug.kt");
        }

        @TestMetadata("MixedNamedArguments.kt")
        public void testMixedNamedArguments() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/MixedNamedArguments.kt");
        }

        @TestMetadata("MixedNamedArguments2.kt")
        public void testMixedNamedArguments2() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/MixedNamedArguments2.kt");
        }

        @TestMetadata("NamedAndDefaultParameter.kt")
        public void testNamedAndDefaultParameter() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NamedAndDefaultParameter.kt");
        }

        @TestMetadata("NamedParameter.kt")
        public void testNamedParameter() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NamedParameter.kt");
        }

        @TestMetadata("NamedParameter2.kt")
        public void testNamedParameter2() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NamedParameter2.kt");
        }

        @TestMetadata("NamedParameter3.kt")
        public void testNamedParameter3() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NamedParameter3.kt");
        }

        @TestMetadata("NamedParameter4.kt")
        public void testNamedParameter4() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NamedParameter4.kt");
        }

        @TestMetadata("NoAnnotations.kt")
        public void testNoAnnotations() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NoAnnotations.kt");
        }

        @TestMetadata("NoCandidatesDeprecatedHidden.kt")
        public void testNoCandidatesDeprecatedHidden() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NoCandidatesDeprecatedHidden.kt");
        }

        @TestMetadata("NoCandidatesNotAccessible.kt")
        public void testNoCandidatesNotAccessible() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NoCandidatesNotAccessible.kt");
        }

        @TestMetadata("NoCandidatesSelfDelegatedConstructorCall.kt")
        public void testNoCandidatesSelfDelegatedConstructorCall() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NoCandidatesSelfDelegatedConstructorCall.kt");
        }

        @TestMetadata("NoCandidatesWrongImplicitReceiver.kt")
        public void testNoCandidatesWrongImplicitReceiver() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NoCandidatesWrongImplicitReceiver.kt");
        }

        @TestMetadata("NoCandidatesWrongReceiver.kt")
        public void testNoCandidatesWrongReceiver() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NoCandidatesWrongReceiver.kt");
        }

        @TestMetadata("NoShadowedDeclarations.kt")
        public void testNoShadowedDeclarations() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NoShadowedDeclarations.kt");
        }

        @TestMetadata("NoShadowedDeclarations2.kt")
        public void testNoShadowedDeclarations2() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NoShadowedDeclarations2.kt");
        }

        @TestMetadata("NoSynthesizedParameterNames.kt")
        public void testNoSynthesizedParameterNames() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NoSynthesizedParameterNames.kt");
        }

        @TestMetadata("NotAccessible.kt")
        public void testNotAccessible() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NotAccessible.kt");
        }

        @TestMetadata("NotGreen.kt")
        public void testNotGreen() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NotGreen.kt");
        }

        @TestMetadata("Nullability.kt")
        public void testNullability() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/Nullability.kt");
        }

        @TestMetadata("NullableTypeCall.kt")
        public void testNullableTypeCall() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/NullableTypeCall.kt");
        }

        @TestMetadata("OtherConstructorFromSecondary.kt")
        public void testOtherConstructorFromSecondary() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/OtherConstructorFromSecondary.kt");
        }

        @TestMetadata("ParameterNameAnnotationConflict.kt")
        public void testParameterNameAnnotationConflict() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/ParameterNameAnnotationConflict.kt");
        }

        @TestMetadata("ParameterNameAnnotationInFunctionType.kt")
        public void testParameterNameAnnotationInFunctionType() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/ParameterNameAnnotationInFunctionType.kt");
        }

        @TestMetadata("ParameterNameAnnotationInNonFunctionType.kt")
        public void testParameterNameAnnotationInNonFunctionType() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/ParameterNameAnnotationInNonFunctionType.kt");
        }

        @TestMetadata("Println.kt")
        public void testPrintln() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/Println.kt");
        }

        @TestMetadata("PrivateConstructor.kt")
        public void testPrivateConstructor() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/PrivateConstructor.kt");
        }

        @TestMetadata("Simple.kt")
        public void testSimple() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/Simple.kt");
        }

        @TestMetadata("SimpleConstructor.kt")
        public void testSimpleConstructor() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SimpleConstructor.kt");
        }

        @TestMetadata("SmartCastReceiver.kt")
        public void testSmartCastReceiver() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SmartCastReceiver.kt");
        }

        @TestMetadata("SmartCastReceiver2.kt")
        public void testSmartCastReceiver2() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SmartCastReceiver2.kt");
        }

        @TestMetadata("SubstituteExpectedType.kt")
        public void testSubstituteExpectedType() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SubstituteExpectedType.kt");
        }

        @TestMetadata("SubstituteExplicitTypeArgs.kt")
        public void testSubstituteExplicitTypeArgs() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SubstituteExplicitTypeArgs.kt");
        }

        @TestMetadata("SubstituteFromArguments1.kt")
        public void testSubstituteFromArguments1() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SubstituteFromArguments1.kt");
        }

        @TestMetadata("SubstituteFromArguments2.kt")
        public void testSubstituteFromArguments2() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SubstituteFromArguments2.kt");
        }

        @TestMetadata("SubstituteFromArguments3.kt")
        public void testSubstituteFromArguments3() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SubstituteFromArguments3.kt");
        }

        @TestMetadata("SubstituteFromArguments4.kt")
        public void testSubstituteFromArguments4() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SubstituteFromArguments4.kt");
        }

        @TestMetadata("SubstituteFromArgumentsOnTyping.kt")
        public void testSubstituteFromArgumentsOnTyping() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SubstituteFromArgumentsOnTyping.kt");
        }

        @TestMetadata("SubstitutedTypeParamInReceiver.kt")
        public void testSubstitutedTypeParamInReceiver() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SubstitutedTypeParamInReceiver.kt");
        }

        @TestMetadata("SuperConstructorCall.kt")
        public void testSuperConstructorCall() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SuperConstructorCall.kt");
        }

        @TestMetadata("SuperConstructorFromSecondary.kt")
        public void testSuperConstructorFromSecondary() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/SuperConstructorFromSecondary.kt");
        }

        @TestMetadata("TooManyArgs.kt")
        public void testTooManyArgs() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/TooManyArgs.kt");
        }

        @TestMetadata("TooManyArgs2.kt")
        public void testTooManyArgs2() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/TooManyArgs2.kt");
        }

        @TestMetadata("TrailingComma.kt")
        public void testTrailingComma() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/TrailingComma.kt");
        }

        @TestMetadata("TwoFunctions.kt")
        public void testTwoFunctions() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/TwoFunctions.kt");
        }

        @TestMetadata("TwoFunctionsGrey.kt")
        public void testTwoFunctionsGrey() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/TwoFunctionsGrey.kt");
        }

        @TestMetadata("TwoSmartCasts.kt")
        public void testTwoSmartCasts() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/TwoSmartCasts.kt");
        }

        @TestMetadata("TypeAliasConstructor.kt")
        public void testTypeAliasConstructor() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/TypeAliasConstructor.kt");
        }

        @TestMetadata("TypeInference.kt")
        public void testTypeInference() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/TypeInference.kt");
        }

        @TestMetadata("UnmappedAfterCurrent.kt")
        public void testUnmappedAfterCurrent() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/UnmappedAfterCurrent.kt");
        }

        @TestMetadata("UnmappedBeforeCurrent.kt")
        public void testUnmappedBeforeCurrent() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/UnmappedBeforeCurrent.kt");
        }

        @TestMetadata("UnmappedCurrent.kt")
        public void testUnmappedCurrent() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/UnmappedCurrent.kt");
        }

        @TestMetadata("UnresolvedAfterCurrent.kt")
        public void testUnresolvedAfterCurrent() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/UnresolvedAfterCurrent.kt");
        }

        @TestMetadata("UnresolvedBeforeCurrent.kt")
        public void testUnresolvedBeforeCurrent() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/UnresolvedBeforeCurrent.kt");
        }

        @TestMetadata("UnresolvedCurrent.kt")
        public void testUnresolvedCurrent() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/UnresolvedCurrent.kt");
        }

        @TestMetadata("UpdateOnTyping.kt")
        public void testUpdateOnTyping() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/UpdateOnTyping.kt");
        }

        @TestMetadata("Vararg.kt")
        public void testVararg() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/Vararg.kt");
        }

        @TestMetadata("VarargBeforeArgs.kt")
        public void testVarargBeforeArgs() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/VarargBeforeArgs.kt");
        }

        @TestMetadata("VarargFirstArgTrailingComma.kt")
        public void testVarargFirstArgTrailingComma() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/VarargFirstArgTrailingComma.kt");
        }

        @TestMetadata("VarargMultipleArgsTrailingComma.kt")
        public void testVarargMultipleArgsTrailingComma() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/VarargMultipleArgsTrailingComma.kt");
        }

        @TestMetadata("VarargNamedArg.kt")
        public void testVarargNamedArg() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/VarargNamedArg.kt");
        }

        @TestMetadata("VarargSpreadArg.kt")
        public void testVarargSpreadArg() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/VarargSpreadArg.kt");
        }

        @TestMetadata("VarargUpdateOnTyping.kt")
        public void testVarargUpdateOnTyping() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/functionCall/VarargUpdateOnTyping.kt");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../idea/tests/testData/parameterInfo/typeArguments")
    public static class TypeArguments extends AbstractFirParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("BaseClass.kt")
        public void testBaseClass() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/BaseClass.kt");
        }

        @TestMetadata("BaseClassNoParens.kt")
        public void testBaseClassNoParens() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/BaseClassNoParens.kt");
        }

        @TestMetadata("ConflictingWithArgument.kt")
        public void testConflictingWithArgument() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/ConflictingWithArgument.kt");
        }

        @TestMetadata("ConflictingWithArgumentNoParens.kt")
        public void testConflictingWithArgumentNoParens() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/ConflictingWithArgumentNoParens.kt");
        }

        @TestMetadata("Constraints.kt")
        public void testConstraints() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/Constraints.kt");
        }

        @TestMetadata("ConstructorCall.kt")
        public void testConstructorCall() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/ConstructorCall.kt");
        }

        @TestMetadata("ConstructorCallNoParens.kt")
        public void testConstructorCallNoParens() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/ConstructorCallNoParens.kt");
        }

        @TestMetadata("FunctionCall.kt")
        public void testFunctionCall() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/FunctionCall.kt");
        }

        @TestMetadata("FunctionCallNoParens.kt")
        public void testFunctionCallNoParens() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/FunctionCallNoParens.kt");
        }

        @TestMetadata("JavaClass.kt")
        public void testJavaClass() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/JavaClass.kt");
        }

        @TestMetadata("JavaClassNoParens.kt")
        public void testJavaClassNoParens() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/JavaClassNoParens.kt");
        }

        @TestMetadata("NoCandidatesDeprecatedHidden.kt")
        public void testNoCandidatesDeprecatedHidden() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/NoCandidatesDeprecatedHidden.kt");
        }

        @TestMetadata("NoCandidatesNotAccessible.kt")
        public void testNoCandidatesNotAccessible() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/NoCandidatesNotAccessible.kt");
        }

        @TestMetadata("NoCandidatesWrongReceiver.kt")
        public void testNoCandidatesWrongReceiver() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/NoCandidatesWrongReceiver.kt");
        }

        @TestMetadata("Overloads.kt")
        public void testOverloads() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/Overloads.kt");
        }

        @TestMetadata("OverloadsNoParens.kt")
        public void testOverloadsNoParens() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/OverloadsNoParens.kt");
        }

        @TestMetadata("ParameterizedClassConstructor.kt")
        public void testParameterizedClassConstructor() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/ParameterizedClassConstructor.kt");
        }

        @TestMetadata("ParameterizedClassConstructorNoParens.kt")
        public void testParameterizedClassConstructorNoParens() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/ParameterizedClassConstructorNoParens.kt");
        }

        @TestMetadata("Reified.kt")
        public void testReified() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/Reified.kt");
        }

        @TestMetadata("ReifiedNoParens.kt")
        public void testReifiedNoParens() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/ReifiedNoParens.kt");
        }

        @TestMetadata("SubstitutedTypeParamInReceiver.kt")
        public void testSubstitutedTypeParamInReceiver() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/SubstitutedTypeParamInReceiver.kt");
        }

        @TestMetadata("SubstitutedTypeParamInReceiverNoParens.kt")
        public void testSubstitutedTypeParamInReceiverNoParens() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/SubstitutedTypeParamInReceiverNoParens.kt");
        }

        @TestMetadata("VariableType.kt")
        public void testVariableType() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/typeArguments/VariableType.kt");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../idea/tests/testData/parameterInfo/withLib1")
    public static class WithLib1 extends AbstractFirParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("useJavaFromLib.kt")
        public void testUseJavaFromLib() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/withLib1/useJavaFromLib.kt");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../idea/tests/testData/parameterInfo/withLib2")
    public static class WithLib2 extends AbstractFirParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("useJavaSAMFromLib.kt")
        public void testUseJavaSAMFromLib() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/withLib2/useJavaSAMFromLib.kt");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../idea/tests/testData/parameterInfo/withLib3")
    public static class WithLib3 extends AbstractFirParameterInfoTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("useJavaSAMFromLib.kt")
        public void testUseJavaSAMFromLib() throws Exception {
            runTest("../idea/tests/testData/parameterInfo/withLib3/useJavaSAMFromLib.kt");
        }
    }
}