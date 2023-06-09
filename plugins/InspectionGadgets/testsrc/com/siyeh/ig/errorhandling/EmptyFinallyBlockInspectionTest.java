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
package com.siyeh.ig.errorhandling;

import com.intellij.codeInspection.InspectionProfileEntry;
import com.siyeh.InspectionGadgetsBundle;
import com.siyeh.ig.LightJavaInspectionTestCase;

public class EmptyFinallyBlockInspectionTest extends LightJavaInspectionTestCase {
  @Override
  protected InspectionProfileEntry getInspection() {
    return new EmptyFinallyBlockInspection();
  }

  @SuppressWarnings("EmptyFinallyBlock")
  public void testSimple() {
    doTest("""
             class C {
               void m() throws Exception {
                 try { throw new Exception(); }
                 /*Empty 'finally' block*//*_*/finally/**/ { }
               }
             }""");
    myFixture.findSingleIntention(InspectionGadgetsBundle.message("remove.try.finally.block.quickfix"));
  }

  @SuppressWarnings("EmptyFinallyBlock")
  public void testResources() {
    doTest("""
             class C {
               void m() throws Exception {
                 try (AutoCloseable r = null) { throw new Exception(); }
                 /*Empty 'finally' block*//*_*/finally/**/ { }
               }
             }""");
    myFixture.findSingleIntention(InspectionGadgetsBundle.message("remove.finally.block.quickfix"));
  }
}
