package tech.antibytes.gradle.project.script

import tech.antibytes.gradle.dependency.Version

plugins {
    id("com.diffplug.spotless")
}

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude("buildSrc/build/", "**/buildSrc/build/", "**/external/")
        ktlint(Version.gradle.ktLint).editorConfigOverride(
            mapOf(
                "disabled_rules" to "no-wildcard-imports",
                "ij_kotlin_imports_layout" to "*"
            )
        )
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint(Version.gradle.ktLint)
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
    format("misc") {
        target("**/*.adoc", "**/*.md", "**/.gitignore", ".java-version")

        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
}
