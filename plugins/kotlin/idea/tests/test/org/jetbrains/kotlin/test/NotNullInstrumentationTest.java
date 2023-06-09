// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.test;

import junit.framework.TestCase;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;

public class NotNullInstrumentationTest extends TestCase {

    public void testArgument() {
        try {
            //noinspection ConstantConditions
            instrumented(null);
        } catch (IllegalArgumentException e) {
            return;
        }

        Assert.fail("IllegalArgumentException is expected");
    }

    private void instrumented(@NotNull Object o) {
        // This method should be instrumented with not null check
    }
}
