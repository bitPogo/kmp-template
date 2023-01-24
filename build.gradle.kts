import tech.antibytes.gradle.project.config.repositories.Repositories.projectRepositories
import tech.antibytes.gradle.dependency.helper.addCustomRepositories
import tech.antibytes.gradle.dependency.helper.ensureKotlinVersion

plugins {
    id("tech.antibytes.gradle.project.dependency")

    id("tech.antibytes.gradle.dependency")

    id("tech.antibytes.gradle.setup")

    alias(antibytesCatalog.plugins.gradle.antibytes.dependencyHelper)
    // alias(antibytesCatalog.plugins.gradle.antibytes.publishing)
    alias(antibytesCatalog.plugins.gradle.antibytes.quality)
}

allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }
        addCustomRepositories(projectRepositories)
    }

    // ensureKotlinVersion(antibytesCatalog.versions.kotlin.language.get())
}

tasks.named<Wrapper>("wrapper") {
    gradleVersion = "7.5.1"
    distributionType = Wrapper.DistributionType.ALL
}
