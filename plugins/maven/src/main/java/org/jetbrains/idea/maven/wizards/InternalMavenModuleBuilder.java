// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.idea.maven.wizards;

import com.intellij.ide.NewProjectWizardLegacy;
import com.intellij.ide.projectWizard.ProjectSettingsStep;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

@ApiStatus.Internal
public final class InternalMavenModuleBuilder extends AbstractMavenModuleBuilder {

  @Override
  public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ModulesProvider modulesProvider) {
    return new ModuleWizardStep[]{
      new MavenStructureWizardStep(this, wizardContext),
      new SelectPropertiesStep(wizardContext.getProject(), this)
    };
  }

  @Override
  public boolean isAvailable() {
    return NewProjectWizardLegacy.isAvailable();
  }

  @NotNull
  @Override
  public List<Class<? extends ModuleWizardStep>> getIgnoredSteps() {
    return Collections.singletonList(ProjectSettingsStep.class);
  }
}
