/*
 * Copyright (c) 2021 Matthias Geisler (bitPogo) / All rights reserved.
 *
 * Use of this source code is governed by LGPL v2.1
 */

package tech.antibytes.gradle.project.dependency

object Dependency {
    val gradle = GradlePlugin
    val antibytes = AntiBytes

    val sqldelight = SqlDelight

    object SqlDelight {
        const val android = "com.squareup.sqldelight:android-driver:${Version.sqldelight}"
        const val jvm = "com.squareup.sqldelight:sqlite-driver:${Version.sqldelight}"
        const val js = "com.squareup.sqldelight:sqljs-driver:${Version.sqldelight}"
        const val native = "com.squareup.sqldelight:native-driver:${Version.sqldelight}"
        const val coroutines = "com.squareup.sqldelight:coroutines-extensions:${Version.sqldelight}"
    }

    object AntiBytes {
        val test = Test

        object Test {
            val kmp = KmpTest

            object KmpTest {
                const val annotations = "tech.antibytes.test-utils-kmp:test-utils-annotations:${Version.antibytes.test}"
                const val core = "tech.antibytes.test-utils-kmp:test-utils:${Version.antibytes.test}"
                const val fixture = "tech.antibytes.kfixture:core:${Version.antibytes.kfixture}"
                const val coroutine = "tech.antibytes.test-utils-kmp:test-utils-coroutine:${Version.antibytes.test}"
                const val ktor = "tech.antibytes.test-utils-kmp:test-utils-ktor:${Version.antibytes.test}"
                const val kmock = "tech.antibytes.kmock:kmock:${Version.antibytes.kmock}"
            }

            val jvm = JvmTest

            object JvmTest {
                const val annotations = "tech.antibytes.test-utils-kmp:test-utils-annotations-jvm:${Version.antibytes.test}"
                const val core = "tech.antibytes.test-utils-kmp:test-utils-jvm:${Version.antibytes.test}"
                const val fixture = "tech.antibytes.kfixture:core-jvm:${Version.antibytes.kfixture}"
                const val coroutine = "tech.antibytes.test-utils-kmp:test-utils-coroutine-jvm:${Version.antibytes.test}"
                const val ktor = "tech.antibytes.test-utils-kmp:test-utils-ktor-jvm:${Version.antibytes.test}"
                const val kmock = "tech.antibytes.kmock:kmock-jvm:${Version.antibytes.kmock}"
            }

            val js = JsTest

            object JsTest {
                const val annotations = "tech.antibytes.test-utils-kmp:test-utils-annotations-js:${Version.antibytes.test}"
                const val core = "tech.antibytes.test-utils-kmp:test-utils-js:${Version.antibytes.test}"
                const val fixture = "tech.antibytes.kfixture:core-js:${Version.antibytes.kfixture}"
                const val coroutine = "tech.antibytes.test-utils-kmp:test-utils-coroutine-js:${Version.antibytes.test}"
                const val ktor = "tech.antibytes.test-utils-kmp:test-utils-ktor-js:${Version.antibytes.test}"
                const val kmock = "tech.antibytes.kmock:kmock-js:${Version.antibytes.kmock}"
            }

            val android = AndroidTest

            object AndroidTest {
                const val annotations = "tech.antibytes.test-utils-kmp:test-utils-annotations-android:${Version.antibytes.test}"
                const val core = "tech.antibytes.test-utils-kmp:test-utils-android:${Version.antibytes.test}"
                const val fixture = "tech.antibytes.kfixture:core-android:${Version.antibytes.kfixture}"
                const val coroutine = "tech.antibytes.test-utils-kmp:test-utils-coroutine-android:${Version.antibytes.test}"
                const val ktor = "tech.antibytes.test-utils-kmp:test-utils-ktor-android:${Version.antibytes.test}"
                const val kmock = "tech.antibytes.kmock:kmock-android:${Version.antibytes.kmock}"
            }
        }
    }

    val jvm = Jvm

    object Jvm {
        const val slf4jApi = "org.slf4j:slf4j-api:${Version.jvm.slf4j}"
        const val slf4jNop = "org.slf4j:slf4j-nop:${Version.jvm.slf4j}"
    }

    val google = Google

    object Google {
        val hilt = Hilt

        object Hilt {
            const val core = "com.google.dagger:hilt-android:${Version.google.hilt}"
            const val compiler = "com.google.dagger:hilt-compiler:${Version.google.hilt}"
            const val composeNavigation = "androidx.hilt:hilt-navigation-compose:${Version.google.hiltCompose}"
            const val test = "com.google.dagger:hilt-android-testing:${Version.google.hilt}"
        }
    }

    val androidx = AndroidX

    object AndroidX {
        const val annotation = "androidx.annotation:annotation:${Version.androidx.annotation}"
    }
}
