import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    alias(libs.plugins.gradle.publish)
}

val groupIdentifier = "io.github.santimattius.android"
val siteUrl = "https://github.com/santimattius/android-project-setup"

group = "${groupIdentifier}"
version = "1.0.0"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.firebase.performance.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    implementation(libs.truth)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    website = "${siteUrl}"
    vcsUrl = "${siteUrl}.git"

    plugins {
        register("androidApplicationCompose") {
            id = "${groupIdentifier}.application.compose"
            displayName = "Android Application Compose"
            description = "Setup your app using compose"
            tags = listOf("android", "compose")
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "${groupIdentifier}.application"
            displayName = "Basic Android Application Setup"
            description = "Setup your android app with basic configurations"
            tags = listOf("android")
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationJacoco") {
            id = "${groupIdentifier}.application.jacoco"
            displayName = "Android Application with Jacoco"
            description = "Setup your android app with Jacoco"
            tags = listOf("android")
            implementationClass = "AndroidApplicationJacocoConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "${groupIdentifier}.library.compose"
            displayName = "Android Library Compose"
            description = "Setup your library using compose"
            tags = listOf("android", "compose")
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "${groupIdentifier}.library"
            displayName = "Basic Android Library Setup"
            description = "Setup your android library with basic configurations"
            tags = listOf("android")
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "${groupIdentifier}.feature"
            displayName = "Android Feature Setup"
            description = "Setup your android feature with basic configurations"
            tags = listOf("android")
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidLibraryJacoco") {
            id = "${groupIdentifier}.library.jacoco"
            displayName = "Android Library with Jacoco"
            description = "Setup your android library with Jacoco"
            tags = listOf("android")
            implementationClass = "AndroidLibraryJacocoConventionPlugin"
        }
        register("androidTest") {
            id = "${groupIdentifier}.test"
            displayName = "Android Test Setup"
            description = "Setup your android test with basic configurations"
            tags = listOf("android")
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("androidHilt") {
            id = "${groupIdentifier}.hilt"
            displayName = "Android Hilt Setup"
            description = "Setup your android app with Hilt"
            tags = listOf("android")
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "${groupIdentifier}.room"
            displayName = "Android Room Setup"
            description = "Setup your android app with Room"
            tags = listOf("android")
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("androidFirebase") {
            id = "${groupIdentifier}.application.firebase"
            displayName = "Android Application with Firebase"
            description = "Setup your android app with Firebase"
            tags = listOf("android", "firebase")
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }
        register("androidLint") {
            id = "${groupIdentifier}.lint"
            displayName = "Android Lint Setup"
            description = "Setup your android app with lint"
            tags = listOf("android")
            implementationClass = "AndroidLintConventionPlugin"
        }
        register("jvmLibrary") {
            id = "${groupIdentifier}.jvm.library"
            displayName = "JVM Library"
            description = "Setup your jvm library with basic configurations"
            tags = listOf("jvm")
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}
