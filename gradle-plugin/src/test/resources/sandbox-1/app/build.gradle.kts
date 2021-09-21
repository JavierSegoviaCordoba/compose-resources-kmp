plugins {
    kotlin("multiplatform")
    id("android-library")
    id("com.javiersc.compose.resources")
}

kotlin {
    android()
    jvm()
}

android {
    compileSdkVersion(31)

    defaultConfig {
        minSdkVersion(21)
    }
}

composeResources {
    suffixes = listOf("custom", "dark")
    packageName = "com.javiersc.sandboxOne.app"
}
