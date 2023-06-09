// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.debugger.sequence.psi.sequence

import org.jetbrains.kotlin.idea.debugger.sequence.psi.KotlinPsiUtil
import org.jetbrains.kotlin.idea.debugger.sequence.psi.StreamCallChecker
import org.jetbrains.kotlin.idea.core.receiverType
import org.jetbrains.kotlin.idea.core.resolveType
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.typeUtil.supertypes

class SequenceCallChecker : StreamCallChecker {
    override fun isIntermediateCall(expression: KtCallExpression): Boolean {
        val receiverType = expression.receiverType() ?: return false
        val expressionType = expression.resolveType() ?: return false
        return isSequenceInheritor(receiverType) && isSequenceInheritor(expressionType)
    }

    override fun isTerminationCall(expression: KtCallExpression): Boolean {
        val receiverType = expression.receiverType() ?: return false
        val expressionType = expression.resolveType() ?: return false
        return isSequenceInheritor(receiverType) && !isSequenceInheritor(expressionType)
    }

    private fun isSequenceInheritor(type: KotlinType): Boolean =
        isSequenceType(type) || type.supertypes().any(this::isSequenceType)

    private fun isSequenceType(type: KotlinType): Boolean =
        "kotlin.sequences.Sequence" == KotlinPsiUtil.getTypeWithoutTypeParameters(type)
}