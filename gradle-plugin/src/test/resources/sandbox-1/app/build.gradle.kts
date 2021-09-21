plugins {
    kotlin("multiplatform")
    id("com.javiersc.compose.resources")
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            println(kotlin.srcDirs)
        }
    }
}

composeResources {
    suffixes = listOf("custom", "dark")
    packageName = "com.javiersc.sandboxOne.app"
}
