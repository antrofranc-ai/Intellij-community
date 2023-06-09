// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.quickfix

import com.intellij.codeInsight.intention.IntentionAction
import org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.descriptors.DeclarationDescriptorWithVisibility
import org.jetbrains.kotlin.descriptors.DescriptorVisibilities.*
import org.jetbrains.kotlin.diagnostics.Diagnostic
import org.jetbrains.kotlin.diagnostics.DiagnosticFactory3
import org.jetbrains.kotlin.idea.caches.resolve.findModuleDescriptor
import org.jetbrains.kotlin.idea.search.usagesSearch.descriptor
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtModifierListOwner
import org.jetbrains.kotlin.psi.psiUtil.containingClass
import org.jetbrains.kotlin.resolve.DescriptorToSourceUtils
import org.jetbrains.kotlin.resolve.DescriptorUtils
import org.jetbrains.kotlin.resolve.descriptorUtil.getAllSuperclassesWithoutAny

object MakeVisibleFactory : KotlinIntentionActionsFactory() {
    override fun doCreateActions(diagnostic: Diagnostic): List<IntentionAction> {
        val element = diagnostic.psiElement as? KtElement ?: return emptyList()
        val usageModule = element.findModuleDescriptor()

        @Suppress("UNCHECKED_CAST")
        val factory = diagnostic.factory as DiagnosticFactory3<*, DeclarationDescriptor, *, DeclarationDescriptor>
        val descriptor = factory.cast(diagnostic).c as? DeclarationDescriptorWithVisibility ?: return emptyList()
        val declaration = DescriptorToSourceUtils.descriptorToDeclaration(descriptor) as? KtModifierListOwner ?: return emptyList()

        if (declaration.hasModifier(KtTokens.SEALED_KEYWORD) && descriptor is ClassConstructorDescriptor) return emptyList()

        val module = DescriptorUtils.getContainingModule(descriptor)
        val targetVisibilities = when (descriptor.visibility) {
            PRIVATE, INVISIBLE_FAKE -> mutableListOf(PUBLIC).apply {
                if (module == usageModule) add(INTERNAL)
                val superClasses = (element.containingClass()?.descriptor as? ClassDescriptor)?.getAllSuperclassesWithoutAny()
                if (superClasses?.contains(declaration.containingClass()?.descriptor) == true) add(PROTECTED)
            }
            else -> listOf(PUBLIC)
        }

        return targetVisibilities.mapNotNull { ChangeVisibilityFix.create(declaration, descriptor, it) }
    }
}
