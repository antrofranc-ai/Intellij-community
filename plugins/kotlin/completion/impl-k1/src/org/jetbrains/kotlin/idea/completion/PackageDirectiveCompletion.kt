// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PlainPrefixMatcher
import com.intellij.patterns.PlatformPatterns
import org.jetbrains.kotlin.idea.caches.resolve.getResolutionFacade
import org.jetbrains.kotlin.idea.util.CallType
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPackageDirective
import org.jetbrains.kotlin.psi.KtSimpleNameExpression
import org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter

/**
 * Performs completion in package directive. Should suggest only packages and avoid showing fake package produced by
 * DUMMY_IDENTIFIER.
 */
object PackageDirectiveCompletion {
    val DUMMY_IDENTIFIER = "___package___"
    val ACTIVATION_PATTERN = PlatformPatterns.psiElement().inside(KtPackageDirective::class.java)

    fun perform(parameters: CompletionParameters, result: CompletionResultSet): Boolean {
        val position = parameters.position
        if (!ACTIVATION_PATTERN.accepts(position)) return false

        val file = position.containingFile as KtFile

        val expression = file.findElementAt(parameters.offset)?.parent as? KtSimpleNameExpression ?: return false

        val prefixLength = parameters.offset - expression.textOffset
        val prefix = expression.text!!
        val prefixMatcher = PlainPrefixMatcher(prefix.substring(0, prefixLength))
        val resultSet = result.withPrefixMatcher(prefixMatcher)

        val resolutionFacade = expression.getResolutionFacade()

        val packageMemberScope = resolutionFacade.moduleDescriptor.getPackage(file.packageFqName.parent()).memberScope

        val variants = packageMemberScope.getContributedDescriptors(DescriptorKindFilter.PACKAGES, prefixMatcher.asNameFilter())
        val lookupElementFactory = BasicLookupElementFactory(
            resolutionFacade.project,
            InsertHandlerProvider(callType = CallType.PACKAGE_DIRECTIVE, editor = parameters.editor, expectedInfosCalculator = { emptyList() })
        )
        for (variant in variants) {
            val lookupElement = lookupElementFactory.createLookupElement(variant)
            if (!lookupElement.lookupString.contains(DUMMY_IDENTIFIER)) {
                resultSet.addElement(lookupElement)
            }
        }

        return true
    }
}
