/*
 * Copyright 2000-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.find.editorHeaderActions;

import com.intellij.find.EditorSearchSession;
import com.intellij.ide.lightEdit.LightEditCompatible;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ShortcutProvider;
import com.intellij.openapi.actionSystem.ShortcutSet;
import com.intellij.openapi.actionSystem.ex.ActionUtil;
import com.intellij.openapi.project.DumbAwareAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public abstract class OccurrenceAction extends DumbAwareAction implements ShortcutProvider, LightEditCompatible {
  protected OccurrenceAction(@NotNull String baseActionId, @NotNull Icon icon) {
    ActionUtil.copyFrom(this, baseActionId);
    getTemplatePresentation().setIcon(icon);
  }

  @Override
  public void update(@NotNull AnActionEvent e) {
    EditorSearchSession search = e.getData(EditorSearchSession.SESSION_KEY);
    if (search == null) {
      e.getPresentation().setEnabledAndVisible(false);
      return;
    }

    boolean visible = !search.getFindModel().isReplaceState() || availableForReplace();
    boolean hasMatches = search.hasMatches();
    e.getPresentation().setVisible(visible);
    e.getPresentation().setEnabled(visible && hasMatches && (availableForSelection() || search.getFindModel().isGlobal()));
  }

  @Override
  public @NotNull ActionUpdateThread getActionUpdateThread() {
    return ActionUpdateThread.BGT;
  }

  protected boolean availableForReplace() {
    return false;
  }

  protected boolean availableForSelection() {
    return false;
  }

  @Nullable
  @Override
  public ShortcutSet getShortcut() {
    return getShortcutSet();
  }
}
