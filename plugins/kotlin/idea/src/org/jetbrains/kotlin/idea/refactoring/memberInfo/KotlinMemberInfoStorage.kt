// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.refactoring.memberInfo

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiNamedElement
import com.intellij.refactoring.classMembers.AbstractMemberInfoStorage
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.idea.FrontendInternals
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.caches.resolve.getResolutionFacade
import org.jetbrains.kotlin.idea.refactoring.isInterfaceClass
import org.jetbrains.kotlin.idea.resolve.frontendService
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.DescriptorUtils
import org.jetbrains.kotlin.resolve.OverloadChecker
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode
import org.jetbrains.kotlin.resolve.source.getPsi
import org.jetbrains.kotlin.types.typeUtil.immediateSupertypes

class KotlinMemberInfoStorage(
    classOrObject: KtClassOrObject,
    filter: (KtNamedDeclaration) -> Boolean = { true }
) : AbstractMemberInfoStorage<KtNamedDeclaration, PsiNamedElement, KotlinMemberInfo>(classOrObject, filter) {

    @OptIn(FrontendInternals::class)
    override fun memberConflict(member1: KtNamedDeclaration, member: KtNamedDeclaration): Boolean {
        val descriptor1 = member1.resolveToDescriptorWrapperAware()
        val descriptor = member.resolveToDescriptorWrapperAware()
        if (descriptor1.name != descriptor.name) return false

        return when {
            descriptor1 is FunctionDescriptor && descriptor is FunctionDescriptor -> {
                val overloadUtil = member1.getResolutionFacade().frontendService<OverloadChecker>()
                !overloadUtil.isOverloadable(descriptor1, descriptor)
            }
            descriptor1 is PropertyDescriptor && descriptor is PropertyDescriptor ||
                    descriptor1 is ClassDescriptor && descriptor is ClassDescriptor -> true
            else -> false
        }
    }

    override fun buildSubClassesMap(aClass: PsiNamedElement) {
        val classDescriptor = aClass.getClassDescriptorIfAny() ?: return
        val classType = classDescriptor.defaultType
        for (supertype in classType.immediateSupertypes()) {
            val superClass = supertype.constructor.declarationDescriptor?.source?.getPsi()
            if (superClass is KtClass || superClass is PsiClass) {
                getSubclasses(superClass as PsiNamedElement).add(aClass)
                buildSubClassesMap(superClass)
            }
        }
    }

    override fun isInheritor(baseClass: PsiNamedElement, aClass: PsiNamedElement): Boolean {
        val baseDescriptor = baseClass.getClassDescriptorIfAny() ?: return false
        val currentDescriptor = aClass.getClassDescriptorIfAny() ?: return false
        return DescriptorUtils.isSubclass(currentDescriptor, baseDescriptor)
    }

    override fun extractClassMembers(aClass: PsiNamedElement, temp: ArrayList<KotlinMemberInfo>) {
        if (aClass is KtClassOrObject) {
            temp += extractClassMembers(aClass, aClass == myClass) { myFilter.includeMember(it) }
        }
    }
}

fun extractClassMembers(
    aClass: KtClassOrObject,
    collectSuperTypeEntries: Boolean = true,
    filter: ((KtNamedDeclaration) -> Boolean)? = null
): List<KotlinMemberInfo> {
    fun KtClassOrObject.extractFromClassBody(
        filter: ((KtNamedDeclaration) -> Boolean)?,
        isCompanion: Boolean,
        result: MutableCollection<KotlinMemberInfo>
    ) {
        declarations
            .asSequence()
            .filter {
                it is KtNamedDeclaration
                        && it !is KtConstructor<*>
                        && !(it is KtObjectDeclaration && it.isCompanion())
                        && (filter == null || filter(it))
            }
            .mapTo(result) { KotlinMemberInfo(it as KtNamedDeclaration, isCompanionMember = isCompanion) }
    }

    val result = ArrayList<KotlinMemberInfo>()

    if (collectSuperTypeEntries) {
        aClass.superTypeListEntries
            .asSequence()
            .filterIsInstance<KtSuperTypeEntry>()
            .mapNotNull {
                val typeReference = it.typeReference ?: return@mapNotNull null
                val type = typeReference.analyze(BodyResolveMode.PARTIAL)[BindingContext.TYPE, typeReference]
                val classDescriptor = type?.constructor?.declarationDescriptor as? ClassDescriptor
                when (val classPsi = classDescriptor?.source?.getPsi()) {
                    is KtClass -> classPsi
                    is PsiClass -> KtPsiClassWrapper(classPsi)
                    else -> null
                }
            }
            .filter { it.isInterfaceClass() }
            .mapTo(result) { KotlinMemberInfo(it, true) }
    }

    aClass.primaryConstructor
        ?.valueParameters
        ?.asSequence()
        ?.filter { it.hasValOrVar() }
        ?.mapTo(result) { KotlinMemberInfo(it) }

    aClass.extractFromClassBody(filter, false, result)
    (aClass as? KtClass)?.companionObjects?.firstOrNull()?.extractFromClassBody(filter, true, result)

    return result
}