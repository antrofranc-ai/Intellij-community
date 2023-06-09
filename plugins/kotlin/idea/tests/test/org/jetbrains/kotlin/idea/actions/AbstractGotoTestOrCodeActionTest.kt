// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.actions

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import com.intellij.testIntegration.GotoTestOrCodeHandler

abstract class AbstractGotoTestOrCodeActionTest : AbstractNavigationTest() {
    private object Handler : GotoTestOrCodeHandler() {
        public override fun getSourceAndTargetElements(editor: Editor?, file: PsiFile?) = super.getSourceAndTargetElements(editor, file)
    }

    override fun getSourceAndTargetElements(editor: Editor, file: PsiFile) = Handler.getSourceAndTargetElements(editor, file)
}
