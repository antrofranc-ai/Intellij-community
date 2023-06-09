// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.codeInsight

import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import org.jetbrains.kotlin.descriptors.CallableDescriptor
import org.jetbrains.kotlin.idea.caches.resolve.resolveToDescriptorIfAny
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.types.KotlinType

class KotlinTypeDeclarationProvider : TypeDeclarationProvider {
    override fun getSymbolTypeDeclarations(symbol: PsiElement): Array<PsiElement>? {
        if (symbol.containingFile !is KtFile) return null

        if (symbol is PsiWhiteSpace) {
            // Navigate to type of first parameter in lambda, works with the help of KotlinTargetElementEvaluator for the 'it' case
            val lBraceElement = symbol.containingFile.findElementAt(maxOf(symbol.textOffset - 1, 0))
            if (lBraceElement?.text == "{") {
                val functionLiteral = lBraceElement.parent as? KtFunctionLiteral
                if (functionLiteral != null) {
                    return functionLiteral.getTypeDeclarationFromCallable { descriptor -> descriptor.valueParameters.firstOrNull()?.type }
                }
            }
        }

        if (symbol is KtFunctionLiteral) {
            // Navigate to receiver type of extension lambda
            return symbol.getTypeDeclarationFromCallable { descriptor -> descriptor.extensionReceiverParameter?.type }
        }

        if (symbol is KtTypeReference) {
            val declaration = symbol.parent
            if (declaration is KtCallableDeclaration && declaration.receiverTypeReference == symbol) {
                // Navigate to function receiver type, works with the help of KotlinTargetElementEvaluator for the 'this' in extension declaration
                return declaration.getTypeDeclarationFromCallable { descriptor -> descriptor.extensionReceiverParameter?.type }
            }
        }

        if (symbol !is KtDeclaration) return emptyArray()
        return symbol.getTypeDeclarationFromCallable { descriptor -> descriptor.returnType }
    }

    private fun KtDeclaration.getTypeDeclarationFromCallable(typeFromDescriptor: (CallableDescriptor) -> KotlinType?): Array<PsiElement> {
        val callableDescriptor = resolveToDescriptorIfAny() as? CallableDescriptor ?: return emptyArray()
        val type = typeFromDescriptor(callableDescriptor) ?: return emptyArray()
        val classifierDescriptor = type.constructor.declarationDescriptor ?: return emptyArray()
        return DescriptorToSourceUtilsIde.getAllDeclarations(project, classifierDescriptor).toTypedArray()
    }
}