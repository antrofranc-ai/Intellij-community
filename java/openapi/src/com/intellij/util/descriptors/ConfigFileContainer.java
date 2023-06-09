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

package com.intellij.util.descriptors;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.ModificationTracker;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ConfigFileContainer extends Disposable, ModificationTracker {
  Project getProject();

  void addListener(ConfigFileListener listener, Disposable parentDisposable);

  void addListener(ConfigFileListener listener);

  void removeListener(ConfigFileListener listener);

  List<ConfigFile> getConfigFiles();

  ConfigFileInfoSet getConfiguration();

  @Nullable
  ConfigFile getConfigFile(ConfigFileMetaData metaData);
}
