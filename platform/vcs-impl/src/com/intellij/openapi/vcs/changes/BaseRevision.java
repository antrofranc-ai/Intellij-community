/*
 * Copyright 2000-2012 JetBrains s.r.o.
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
package com.intellij.openapi.vcs.changes;

import com.intellij.openapi.vcs.AbstractVcs;
import com.intellij.openapi.vcs.FilePath;
import com.intellij.openapi.vcs.history.VcsRevisionNumber;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BaseRevision {
  private final FilePath myPath;
  private final VcsRevisionNumber myRevision;
  private final AbstractVcs myVcs;

  public BaseRevision(@Nullable AbstractVcs vcs, @NotNull VcsRevisionNumber revision, @NotNull FilePath path) {
    myVcs = vcs;
    myRevision = revision;
    myPath = path;
  }

  @NotNull
  public String getPath() {
    return myPath.getPath();
  }

  @NotNull
  public FilePath getFilePath() {
    return myPath;
  }

  @NotNull
  public VcsRevisionNumber getRevision() {
    return myRevision;
  }

  @Nullable
  public AbstractVcs getVcs() {
    return myVcs;
  }
}
