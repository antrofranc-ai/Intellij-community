/*
 * Copyright 2000-2014 JetBrains s.r.o.
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
package org.jetbrains.plugins.groovy.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FixedValuesReferenceProvider extends PsiReferenceProvider {

  private final String[] myValues;

  private final boolean mySoft;

  public FixedValuesReferenceProvider(String @NotNull [] values) {
    this(values, false);
  }

  public FixedValuesReferenceProvider(String @NotNull [] values, boolean soft) {
    myValues = values;
    mySoft = soft;
  }

  @Override
  public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
    return new PsiReference[]{
      new PsiReferenceBase<>(element, mySoft) {
        @Nullable
        @Override
        public PsiElement resolve() {
          return null;
        }

        @Override
        public Object @NotNull [] getVariants() {
          return myValues;
        }
      }
    };
  }
}
