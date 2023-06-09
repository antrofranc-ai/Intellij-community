// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.idea.maven.aether;

@FunctionalInterface
interface ThrowingFunction<T, R> {
  R get(T arg) throws Exception;
}
