import org.gradle.api.JavaVersion
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("android-library")
    id("com.javiersc.compose.resources")
}

tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = JavaVersion.VERSION_11.toString()
    targetCompatibility = JavaVersion.VERSION_11.toString()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

kotlin {
    android()
    jvm()
}

android {
    namespace = "com.javiersc.sandbox.one.app"
    compileSdkVersion(32)

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    defaultConfig {
        minSdkVersion(23)
    }
}

composeResources {
    suffixes = listOf("custom", "dark")
    packageName = "com.javiersc.sandbox.one.app"
}

val composeResourcesVersion = property("composeResourcesVersion")

dependencies {
    "commonMainImplementation"("com.javiersc.compose:compose-resources:$composeResourcesVersion")
}
