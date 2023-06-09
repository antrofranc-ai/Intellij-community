/*
 * Copyright 2000-2015 JetBrains s.r.o.
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
package com.intellij.lang.properties.editor.inspections;

import com.intellij.codeInspection.CommonProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.QuickFix;
import com.intellij.codeInspection.util.InspectionMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Dmitry Batkovich
 */
public class ResourceBundleEditorProblemDescriptor implements CommonProblemDescriptor {
  private final ProblemHighlightType myHighlightType;
  private final @InspectionMessage String myDescriptionTemplate;
  private final @NotNull QuickFix @NotNull [] myFixes;

  public ResourceBundleEditorProblemDescriptor(final ProblemHighlightType type, @InspectionMessage String template, @NotNull QuickFix @NotNull ... fixes) {
    myHighlightType = type;
    myDescriptionTemplate = template;
    myFixes = fixes;
  }

  @NotNull
  public ProblemHighlightType getHighlightType() {
    return myHighlightType;
  }

  @NotNull
  @Override
  public String getDescriptionTemplate() {
    return myDescriptionTemplate;
  }

  @Override
  public @NotNull QuickFix @Nullable [] getFixes() {
    return myFixes;
  }
}
