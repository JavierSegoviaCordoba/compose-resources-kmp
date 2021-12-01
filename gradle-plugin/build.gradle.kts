plugins {
    `kotlin-jvm`
    `java-gradle-plugin`
    `javiersc-kotlin-library`
    `javiersc-publish`
}

pluginBundle {
    tags =
        listOf(
            "compose",
            "jetpack compose",
            "compose multiplatform",
        )
}

gradlePlugin {
    plugins {
        create("ComposeResources") {
            id = "com.javiersc.compose.resources"
            implementationClass = "com.javiersc.compose.resources.ComposeResourcesPlugin"
            displayName = "Compose Resources KMP"
            description =
                """Compose Resources to be used in Kotlin Multiplatform"""
        }
    }
}

dependencies {
    // TODO: remove when the next issue is fixed:
    //  https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(files(pluginLibs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation(projects.core)

    implementation(gradleApi())
    implementation(gradleKotlinDsl())

    implementation(pluginLibs.android.toolsBuild.gradle)
    implementation(pluginLibs.jetbrains.kotlin.kotlinGradlePluginX)

    testImplementation(libs.jetbrains.kotlin.kotlinTest)
    testImplementation(libs.kotest.kotestAssertionsCore)
    testImplementation(gradleTestKit())
}
