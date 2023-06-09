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
package com.intellij.java.psi.impl.source.tree.java;

import com.intellij.codeInsight.JavaCodeInsightTestCase;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ex.PathManagerEx;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.testFramework.HeavyPlatformTestCase;
import com.intellij.testFramework.PsiTestUtil;
import com.intellij.util.IncorrectOperationException;

import java.io.File;

@HeavyPlatformTestCase.WrapInCommand
public class BindToElementTest extends JavaCodeInsightTestCase {
  public static final String TEST_ROOT = PathManagerEx.getTestDataPath() + "/psi/impl/bindToElementTest/".replace('/', File.separatorChar);

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    VirtualFile root = WriteCommandAction.runWriteCommandAction(null, (Computable<VirtualFile>)() -> LocalFileSystem.getInstance().refreshAndFindFileByIoFile(
      new File(new File(TEST_ROOT), "prj")
    ));
    assertNotNull(root);
    PsiTestUtil.addSourceRoot(myModule, root);
  }

  public void testSingleClassImport() throws Exception {
    doTest(() -> {
      PsiElement element = myFile.findElementAt(myEditor.getCaretModel().getOffset());
      final PsiJavaCodeReferenceElement referenceElement = PsiTreeUtil.getParentOfType(element, PsiJavaCodeReferenceElement.class);
      final PsiClass aClassA = JavaPsiFacade.getInstance(myProject).findClass("p2.A", GlobalSearchScope.moduleScope(myModule));
      assertNotNull(aClassA);
      ApplicationManager.getApplication().runWriteAction(() -> {
        try {
          referenceElement.bindToElement(aClassA);
        }
        catch (IncorrectOperationException e) {
          LOG.error(e);
        }
      });
    });
  }

  public void testReplacingType() throws Exception {
    doTest(() -> {
      final PsiElement elementAt = myFile.findElementAt(myEditor.getCaretModel().getOffset());
      final PsiTypeElement typeElement = PsiTreeUtil.getParentOfType(elementAt, PsiTypeElement.class);
      final PsiClass aClassA = JavaPsiFacade.getInstance(myProject).findClass("p2.A", GlobalSearchScope.moduleScope(myModule));
      assertNotNull(aClassA);
      final PsiElementFactory factory = myJavaFacade.getElementFactory();
      final PsiClassType type = factory.createType(aClassA);
      ApplicationManager.getApplication().runWriteAction(() -> {
        try {
          typeElement.replace(factory.createTypeElement(type));
        }
        catch (IncorrectOperationException e) {
          LOG.error(e);
        }
      });
    });
  }

  private void doTest(final Runnable runnable) throws Exception {
    final String relativeFilePath = "/psi/impl/bindToElementTest/" + getTestName(false);
    configureByFile(relativeFilePath + ".java");
    runnable.run();
    checkResultByFile(relativeFilePath + ".java.after");
  }
}
