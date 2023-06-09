// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.search

import com.google.common.collect.ImmutableSet
import com.intellij.lexer.Lexer
import com.intellij.psi.TokenType
import com.intellij.psi.impl.cache.impl.BaseFilterLexer
import com.intellij.psi.impl.cache.impl.IdAndToDoScannerBasedOnFilterLexer
import com.intellij.psi.impl.cache.impl.OccurrenceConsumer
import com.intellij.psi.impl.cache.impl.id.LexerBasedIdIndexer
import com.intellij.psi.impl.cache.impl.todo.LexerBasedTodoIndexer
import com.intellij.psi.search.UsageSearchContext
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import org.jetbrains.kotlin.kdoc.lexer.KDocTokens
import org.jetbrains.kotlin.lexer.KotlinLexer
import org.jetbrains.kotlin.lexer.KtToken
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.types.expressions.OperatorConventions
import java.util.*

const val KOTLIN_NAMED_ARGUMENT_SEARCH_CONTEXT: Short = 0x20

private val ALL_SEARCHABLE_OPERATIONS: ImmutableSet<KtToken> = ImmutableSet
    .builder<KtToken>()
    .addAll(OperatorConventions.UNARY_OPERATION_NAMES.keys)
    .addAll(OperatorConventions.BINARY_OPERATION_NAMES.keys)
    .addAll(OperatorConventions.ASSIGNMENT_OPERATIONS.keys)
    .addAll(OperatorConventions.COMPARISON_OPERATIONS)
    .addAll(OperatorConventions.EQUALS_OPERATIONS)
    .addAll(OperatorConventions.IN_OPERATIONS)
    .add(KtTokens.LBRACKET)
    .add(KtTokens.BY_KEYWORD)
    .build()

class KotlinFilterLexer(private val occurrenceConsumer: OccurrenceConsumer) : BaseFilterLexer(KotlinLexer(), occurrenceConsumer) {
    private companion object {
        private val CODE_TOKENS = TokenSet.orSet(
            TokenSet.create(*ALL_SEARCHABLE_OPERATIONS.toTypedArray()),
            TokenSet.create(KtTokens.IDENTIFIER)
        )

        private val COMMENT_TOKENS = TokenSet.orSet(KtTokens.COMMENTS, TokenSet.create(KDocTokens.KDOC))
        private const val MAX_PREV_TOKENS = 2
    }

    private val prevTokens = ArrayDeque<IElementType>(MAX_PREV_TOKENS)

    private var prevTokenStart = -1
    private var prevTokenEnd = -1

    override fun advance() {
        val tokenType = myDelegate.tokenType

        when (tokenType) {
            KtTokens.EQ -> {
                if (prevTokens.peekFirst() == KtTokens.IDENTIFIER) {
                    val prevPrev = prevTokens.elementAtOrNull(1)
                    if (prevPrev == KtTokens.COMMA || prevPrev == KtTokens.LPAR) {
                        occurrenceConsumer.addOccurrence(
                            bufferSequence,
                            null,
                            prevTokenStart,
                            prevTokenEnd,
                            KOTLIN_NAMED_ARGUMENT_SEARCH_CONTEXT.toInt()
                        )
                    }
                }
            }

            KtTokens.LPAR -> {
                if (isMultiDeclarationPosition()) {
                    addOccurrenceInToken(UsageSearchContext.IN_CODE.toInt())
                }
            }

            KtTokens.IDENTIFIER -> {
                if (myDelegate.tokenText.startsWith("`")) {
                    scanWordsInToken(UsageSearchContext.IN_CODE.toInt(), false, false)
                } else {
                    addOccurrenceInToken(UsageSearchContext.IN_CODE.toInt())
                    if (myDelegate.tokenText == "TODO") {
                        // Heuristics to reduce mismatches between indexer and searcher. The searcher returns only occurrences of TO_DO
                        // as the callee of a call expression, but we can't tell calls and other usages apart based on limited lexer context,
                        // so we just exclude occurrences in declaration names (and even that doesn't work precisely because it doesn't handle
                        // declarations with type parameters)
                        val prevToken = prevTokens.peekFirst()
                        if (prevToken != KtTokens.FUN_KEYWORD && prevToken != KtTokens.VAR_KEYWORD && prevToken != KtTokens.VAL_KEYWORD && prevToken != KtTokens.CLASS_KEYWORD) {
                            advanceTodoItemCountsInToken()
                        }
                    }
                }
            }

            in CODE_TOKENS -> addOccurrenceInToken(UsageSearchContext.IN_CODE.toInt())

            in KtTokens.STRINGS -> scanWordsInToken(UsageSearchContext.IN_STRINGS + UsageSearchContext.IN_FOREIGN_LANGUAGES, false, true)

            in COMMENT_TOKENS -> {
                scanWordsInToken(UsageSearchContext.IN_COMMENTS.toInt(), false, false)
                advanceTodoItemCountsInToken()
            }
        }

        if (tokenType != TokenType.WHITE_SPACE && tokenType !in COMMENT_TOKENS) {
            if (prevTokens.size == MAX_PREV_TOKENS) {
                prevTokens.removeLast()
            }
            prevTokens.addFirst(tokenType)
            prevTokenStart = tokenStart
            prevTokenEnd = tokenEnd
        }

        myDelegate.advance()
    }

    private fun isMultiDeclarationPosition(): Boolean {
        val first = prevTokens.peekFirst()
        if (first == KtTokens.VAL_KEYWORD || first == KtTokens.VAR_KEYWORD) return true
        return first == KtTokens.LPAR && prevTokens.elementAtOrNull(1) == KtTokens.FOR_KEYWORD
    }
}

class KotlinIdIndexer : LexerBasedIdIndexer() {
    override fun createLexer(consumer: OccurrenceConsumer): Lexer = KotlinFilterLexer(consumer)

    override fun getVersion() = 3
}

class KotlinTodoIndexer : LexerBasedTodoIndexer(), IdAndToDoScannerBasedOnFilterLexer {
    override fun getVersion() = 2

    override fun createLexer(consumer: OccurrenceConsumer) = KotlinFilterLexer(consumer)
}
