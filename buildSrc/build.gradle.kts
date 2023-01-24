import tech.antibytes.gradle.project.dependency.Dependency
import tech.antibytes.gradle.project.dependency.addCustomRepositories

plugins {
    `kotlin-dsl`

    id("tech.antibytes.gradle.project.dependency")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    addCustomRepositories()
}

dependencies {
    implementation(Dependency.gradle.dependency)
    implementation(Dependency.gradle.serialization)
    implementation(Dependency.gradle.sqldelight)
    implementation(Dependency.gradle.hilt)
}
