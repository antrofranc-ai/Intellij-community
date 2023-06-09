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
package com.intellij.util.indexing;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndexKey;

/**
 * @deprecated please don't use file ids directly,
 * use {@link com.intellij.psi.stubs.StubIndex#getContainingFiles(StubIndexKey, Object, Project, GlobalSearchScope)} instead.
 * It lazily will restore files from its ids.
 */
@Deprecated(forRemoval = true)
public interface IdIterator {
  IdIterator EMPTY = new IdIterator() {
    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public int next() {
      throw new IllegalStateException();
    }

    @Override
    public int size() {
      return 0;
    }
  };

  boolean hasNext();

  int next();

  int size();
}
