/*
 * Copyright 2000-2009 JetBrains s.r.o.
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
package com.intellij.refactoring.replaceConstructorWithFactory;

import com.intellij.java.refactoring.JavaRefactoringBundle;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.refactoring.ui.UsageViewDescriptorAdapter;
import org.jetbrains.annotations.NotNull;

class ReplaceConstructorWithFactoryViewDescriptor extends UsageViewDescriptorAdapter {
  private final PsiMethod myConstructor;
  private final PsiClass myClass;

  ReplaceConstructorWithFactoryViewDescriptor(
    PsiMethod constructor) {
    super();
    myConstructor = constructor;
    myClass = null;
  }

  ReplaceConstructorWithFactoryViewDescriptor(PsiClass aClass) {
    super();
    myClass = aClass;
    myConstructor = null;
  }

  @Override
  public PsiElement @NotNull [] getElements() {
    if (myConstructor != null) {
      return new PsiElement[] {myConstructor};
    } else {
      return new PsiElement[] {myClass};
    }
  }

  @Override
  public String getProcessedElementsHeader() {
    if (myConstructor != null) {
      return JavaRefactoringBundle.message("replace.constructor.with.factory.method");
    } else {
      return JavaRefactoringBundle.message("replace.default.constructor.with.factory.method");
    }
  }
}
