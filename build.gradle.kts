import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import tech.antibytes.gradle.dependency.Version
import tech.antibytes.gradle.project.dependency.addCustomRepositories
import tech.antibytes.gradle.project.dependency.ensureKotlinVersion

plugins {
    id("tech.antibytes.gradle.project.dependency")

    id("tech.antibytes.gradle.dependency")

    id("io.gitlab.arturbosch.detekt") version "1.21.0"

    id("tech.antibytes.gradle.project.script.quality-spotless")
}

allprojects {
    repositories {
        addCustomRepositories()
        mavenCentral()
        google()
        jcenter()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }
    }

    ensureKotlinVersion(Version.kotlin.language)
}

tasks.named<Wrapper>("wrapper") {
    gradleVersion = "7.5.1"
    distributionType = Wrapper.DistributionType.ALL
}

detekt {
    toolVersion = "1.21.0"
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = false // activate all available (even unstable) rules.
    config = files("$projectDir/detekt/config.yml") // point to your custom config defining rules to run, overwriting default behavior
    baseline = file("$projectDir/detekt/baseline.xml") // a way of suppressing issues before introducing detekt
    source = files(projectDir)
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = JavaVersion.VERSION_11.toString()
    exclude(
        "**/external/**",
        "**/.gradle/**",
        "**/target/**",
        "**/.idea/**",
        "**/build/**",
        "**/buildSrc/**",
        ".github/**",
        "gradle/**",
        "**/example/**",
        "**/test/resources/**",
        "**/build.gradle.kts",
        "**/settings.gradle.kts",
        "**/Dangerfile.df.kts"
    )

    reports {
        html.required.set(true)
        xml.required.set(true)
        txt.required.set(false)
        sarif.required.set(false)
    }
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = JavaVersion.VERSION_11.toString()

    exclude(
        "**/external/**",
        "**/.gradle/**",
        "**/target/**",
        "**/.idea/**",
        "**/build/**",
        "**/gradle/wrapper/**",
        ".github/**",
        "assets/**",
        "docs/**",
        "gradle/**",
        "**/example/**",
        "**/*.adoc",
        "**/*.md",
        "**/gradlew",
        "**/LICENSE",
        "**/.java-version",
        "**/gradlew.bat",
        "**/*.png",
        "**/*.properties",
        "**/*.pro",
        "**/*.sq",
        "**/*.xml",
        "**/*.yml"
    )
}
