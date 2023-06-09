plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

group = "org.jetbrains.kotlin.mpp.tests"
version = "1.0"

publishing {
    repositories {
        maven("$rootDir/repo")
    }
}

kotlin {
    js(IR)
    jvm()
    linuxX64()
    macosX64() // TODO: switch later when M1 agents arrive
    iosArm64()
    iosX64() // TODO: switch later when M1 agents arrive

    sourceSets {
        listOf("Main", "Test").forEach { classifier ->
            val common = getByName("common$classifier")

            val jvmAndNative = create("jvmAndNative$classifier") {
                dependsOn(common)
            }

            val native = create("native$classifier") {
                dependsOn(jvmAndNative)
            }

            val apple = create("apple$classifier") {
                dependsOn(native)
            }

            val jvm = getByName("jvm$classifier") {
                dependsOn(jvmAndNative)
            }

            val linuxX64 = getByName("linuxX64$classifier") {
                dependsOn(native)
            }

            val macosX64 = getByName("macosX64$classifier") {
                dependsOn(apple)
            }

            val iosArm64 = getByName("iosArm64$classifier") {
                dependsOn(apple)
            }

            val iosX64 = getByName("iosX64$classifier") {
                dependsOn(apple)
            }
        }
    }
}
