// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.kotlin.gradle.idea.importing.newTests

import com.intellij.lang.annotation.HighlightSeverity
import org.jetbrains.kotlin.gradle.newTests.AbstractKotlinMppGradleImportingTest
import org.jetbrains.kotlin.gradle.newTests.TestConfigurationDslScope
import org.jetbrains.kotlin.gradle.newTests.testFeatures.checkers.contentRoots.ContentRootsChecker
import org.jetbrains.kotlin.gradle.newTests.testFeatures.checkers.orderEntries.OrderEntriesChecker
import org.jetbrains.kotlin.test.TestMetadata
import org.junit.Test

@TestMetadata("newMppTests/tier1")
class KotlinMppTierOneCasesImportingTests : AbstractKotlinMppGradleImportingTest() {
    override fun TestConfigurationDslScope.defaultTestConfiguration() {
        hideHighlightsBelow = HighlightSeverity.ERROR

        // checked in Tier0 for most cases
        hideStdlib = true
        hideKotlinTest = true
        hideKotlinNativeDistribution = true
    }

    @Test
    fun testTwoKmmLibrariesSource() {
        doTest {
            // Inter-project dependencies are checked in Tier Zero, only concerned
            // with dependencies on kmmLib
            excludeDependencies(".*kmmConsumer.*")

            // Don't list modules from kmmLib, we only interested on dependencies on them
            excludeModules(".*kmmLib.*")

            onlyCheckers(OrderEntriesChecker)
        }
    }

    @Test
    fun testTwoKmmLibrariesBinary() {
        doTest {
            // Inter-project dependencies are checked in Tier Zero, only concerned
            // with dependencies on kmmLib
            excludeDependencies(".*kmmConsumer.*")

            // Don't list modules from kmmLib, we only interested on dependencies on them
            excludeModules(".*kmmLib.*")

            publish("kmmLib")
            onlyCheckers(OrderEntriesChecker)
        }
    }

    @Test
    fun testAndroidAppConsumesKmmLibSource() {
        doTest {
            // Inter-project dependencies are checked in Tier Zero, only concerned
            // with dependencies on kmmLib
            excludeDependencies(".*androidApp.*")

            // Don't list modules from kmmLib, we only interested on dependencies on them
            excludeModules(".*kmmLib.*")
            onlyCheckers(OrderEntriesChecker)
        }
    }

    @Test
    fun testAndroidAppConsumesKmmLibBinary() {
        doTest {
            // Inter-project dependencies are checked in Tier Zero, only concerned
            // with dependencies on kmmLib
            excludeDependencies(".*androidApp.*")

            // Don't list modules from kmmLib, we only interested on dependencies on them
            excludeModules(".*kmmLib.*")

            publish("kmmLib")
            onlyCheckers(OrderEntriesChecker)
        }
    }

    @Test
    fun testKmmAppConsumesAndroidLibSource() {
        doTest {
            excludeModules(".*(androidLib|common|ios).*") // <=> only Android-platform modules of kmmApp
            excludeDependencies(".*kmmApp.*") // don't show inter-project dependencies
            onlyCheckers(OrderEntriesChecker)
        }
    }

    @Test
    fun testKmmAppConsumesAndroidLibBinary() {
        doTest {
            excludeModules(".*(androidLib|common|ios).*") // <=> only Android-platform modules of kmmApp
            excludeDependencies(".*kmmApp.*") // don't show inter-project dependencies

            publish("androidLib")
            onlyCheckers(OrderEntriesChecker)
        }
    }

    @Test
    fun testKotlinJvmConsumesKmmLibBinary() {
        doTest {
            onlyCheckers(OrderEntriesChecker)
            onlyDependencies(from = ".*kJvm.*", to = ".*kmmLib.*")
            publish("kmmLib")
        }
    }

    @Test
    fun testKotlinJvmConsumesKmmLibSource() {
        doTest {
            onlyCheckers(OrderEntriesChecker)
            onlyDependencies(from = ".*kJvm.*", to = ".*kmmLib.*")
        }
    }

    @Test
    fun testPureJavaConsumesKmmLibBinary() {
        doTest {
            onlyCheckers(OrderEntriesChecker)
            onlyDependencies(from = ".*javaOnly.*", to = ".*kmmLib.*")
            publish("kmmLib")
        }
    }

    @Test
    fun testAdvancedMppLibrary() {
        doTest {
            // doesn't introduce any conceptually new source sets (like JVM+Android shared ones)
            disableCheckers(ContentRootsChecker)

            hideStdlib = false
            hideKotlinTest = false
            hideKotlinNativeDistribution = false
        }
    }
}
