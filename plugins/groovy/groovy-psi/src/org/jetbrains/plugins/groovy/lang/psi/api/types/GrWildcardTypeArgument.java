// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.plugins.groovy.lang.psi.api.types;

import org.jetbrains.annotations.Nullable;

/**
 * @author Dmitry.Krasilschikov
 */
public interface GrWildcardTypeArgument extends GrTypeElement {

  @Nullable
  GrTypeElement getBoundTypeElement();
}
