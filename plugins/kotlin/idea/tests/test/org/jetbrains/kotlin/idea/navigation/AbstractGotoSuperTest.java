// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.navigation;

import com.intellij.openapi.actionSystem.IdeActions;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractGotoSuperTest extends AbstractGotoActionTest {
    @NotNull
    @Override
    protected String getActionName() {
        return IdeActions.ACTION_GOTO_SUPER;
    }
}
