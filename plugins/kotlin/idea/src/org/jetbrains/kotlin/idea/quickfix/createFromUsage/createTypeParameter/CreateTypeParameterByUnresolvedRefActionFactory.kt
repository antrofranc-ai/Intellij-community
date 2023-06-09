// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.quickfix.createFromUsage.createTypeParameter

import com.intellij.psi.PsiElement
import com.intellij.psi.SmartPsiElementPointer
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.descriptors.TypeParameterDescriptor
import org.jetbrains.kotlin.descriptors.annotations.Annotations
import org.jetbrains.kotlin.descriptors.impl.TypeParameterDescriptorImpl
import org.jetbrains.kotlin.diagnostics.Diagnostic
import org.jetbrains.kotlin.idea.FrontendInternals
import org.jetbrains.kotlin.idea.caches.resolve.getResolutionFacade
import org.jetbrains.kotlin.idea.caches.resolve.resolveToDescriptorIfAny
import org.jetbrains.kotlin.idea.quickfix.KotlinIntentionActionFactoryWithDelegate
import org.jetbrains.kotlin.idea.quickfix.QuickFixWithDelegateFactory
import org.jetbrains.kotlin.idea.quickfix.createFromUsage.createClass.getUnsubstitutedTypeConstraintInfo
import org.jetbrains.kotlin.idea.refactoring.canRefactor
import org.jetbrains.kotlin.idea.refactoring.introduce.isObjectOrNonInnerClass
import org.jetbrains.kotlin.idea.resolve.frontendService
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.getParentOfTypeAndBranch
import org.jetbrains.kotlin.psi.psiUtil.parents
import org.jetbrains.kotlin.storage.StorageManager
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.TypeProjectionImpl
import org.jetbrains.kotlin.types.Variance
import org.jetbrains.kotlin.types.typeUtil.containsError

data class TypeParameterInfo(
    val name: String,
    val upperBoundType: KotlinType?,
    val fakeTypeParameter: TypeParameterDescriptor
)

data class CreateTypeParameterData(
    val declaration: KtTypeParameterListOwner,
    val typeParameters: List<TypeParameterInfo>
)

object CreateTypeParameterByUnresolvedRefActionFactory : KotlinIntentionActionFactoryWithDelegate<KtUserType, CreateTypeParameterData>() {
    override fun getElementOfInterest(diagnostic: Diagnostic): KtUserType? {
        val ktUserType = diagnostic.psiElement.getParentOfTypeAndBranch<KtUserType> { referenceExpression } ?: return null
        if (ktUserType.getParentOfTypeAndBranch<KtConstructorCalleeExpression> { typeReference } != null) return null
        if (ktUserType.qualifier != null) return null
        if (ktUserType.getParentOfTypeAndBranch<KtUserType>(true) { qualifier } != null) return null
        if (ktUserType.typeArgumentList != null) return null
        return ktUserType
    }

    @OptIn(FrontendInternals::class)
    fun extractFixData(element: KtTypeElement, newName: String): CreateTypeParameterData? {
        val declaration = element.parents.firstOrNull {
            it is KtProperty || it is KtNamedFunction || it is KtClass
        } as? KtTypeParameterListOwner ?: return null
        if (!declaration.canRefactor()) return null
        val containingDescriptor = declaration.resolveToDescriptorIfAny() ?: return null
        val fakeTypeParameter = createFakeTypeParameterDescriptor(
            containingDescriptor, newName, declaration.getResolutionFacade().frontendService<StorageManager>()
        )
        val upperBoundType = getUnsubstitutedTypeConstraintInfo(element)?.let {
            it.performSubstitution(it.typeParameter.typeConstructor to TypeProjectionImpl(fakeTypeParameter.defaultType))?.upperBound
        }
        if (upperBoundType != null && upperBoundType.containsError()) return null
        return CreateTypeParameterData(declaration, listOf(TypeParameterInfo(newName, upperBoundType, fakeTypeParameter)))
    }

    override fun extractFixData(element: KtUserType, diagnostic: Diagnostic): CreateTypeParameterData? {
        val name = element.referencedName ?: return null
        return extractFixData(element, name)
    }

    override fun createFixes(
        originalElementPointer: SmartPsiElementPointer<KtUserType>,
        diagnostic: Diagnostic,
        quickFixDataFactory: (KtUserType) -> CreateTypeParameterData?
    ): List<QuickFixWithDelegateFactory> {
        val ktUserType = originalElementPointer.element ?: return emptyList()
        val name = ktUserType.referencedName ?: return emptyList()
        return getPossibleTypeParameterContainers(ktUserType)
            .asSequence()
            .filter { declaration ->
                declaration.isWritable && declaration.typeParameters.all { it.name != name }
            }.map {
                QuickFixWithDelegateFactory factory@{
                    val originalElement = originalElementPointer.element ?: return@factory null
                    val data = quickFixDataFactory(originalElement)?.copy(declaration = it) ?: return@factory null
                    CreateTypeParameterFromUsageFix(originalElement, data, presentTypeParameterNames = true)
                }
            }
            .toList()
    }
}

fun createFakeTypeParameterDescriptor(
    containingDescriptor: DeclarationDescriptor,
    name: String,
    storageManager: StorageManager
): TypeParameterDescriptor {
    return TypeParameterDescriptorImpl
        .createWithDefaultBound(
            containingDescriptor, Annotations.EMPTY, false,
            Variance.INVARIANT, Name.identifier(name), -1,
            storageManager
        )
}

fun getPossibleTypeParameterContainers(startFrom: PsiElement): List<KtTypeParameterListOwner> {
    val stopAt = startFrom.parents.firstOrNull(::isObjectOrNonInnerClass)?.parent
    return (if (stopAt != null) startFrom.parents.takeWhile { it != stopAt } else startFrom.parents)
        .filterIsInstance<KtTypeParameterListOwner>()
        .filter {
            ((it is KtClass && !it.isInterface() && it !is KtEnumEntry) ||
                    it is KtNamedFunction ||
                    (it is KtProperty && !it.isLocal && it.receiverTypeReference != null) ||
                    it is KtTypeAlias) && it.nameIdentifier != null
        }
        .toList()
}