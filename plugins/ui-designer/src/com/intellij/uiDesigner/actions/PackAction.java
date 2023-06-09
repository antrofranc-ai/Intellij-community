// Copyright 2000-2021 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.uiDesigner.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.uiDesigner.designSurface.GuiEditor;
import com.intellij.uiDesigner.radComponents.RadComponent;
import com.intellij.uiDesigner.radComponents.RadContainer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class PackAction extends AbstractGuiEditorAction {
  @Override
  protected void actionPerformed(final GuiEditor editor, final List<? extends RadComponent> selection, final AnActionEvent e) {
    RadContainer container = getContainerToPack(selection);
    if (container != null) {
      container.getDelegee().setSize(container.getMinimumSize());
      container.getDelegee().revalidate();
    }
  }

  @Override
  protected void update(@NotNull GuiEditor editor, final ArrayList<? extends RadComponent> selection, final AnActionEvent e) {
    e.getPresentation().setEnabled(getContainerToPack(selection) != null);
  }

  private static RadContainer getContainerToPack(final List<? extends RadComponent> selection) {
    if (selection.size() != 1 || !(selection.get(0) instanceof RadContainer container)) {
      return null;
    }

    if (!container.getParent().isXY()) {
      return null;
    }
    return container;
  }
}
