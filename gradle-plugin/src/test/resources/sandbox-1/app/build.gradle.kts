plugins {
    kotlin("multiplatform")
    id("com.javiersc.compose.resources")
}

kotlin {
    jvm()
}

composeResources {
    suffixes = listOf("custom", "dark")
    packageName = "com.javiersc.sandboxOne.app"
}
