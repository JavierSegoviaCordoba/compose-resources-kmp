plugins {
    `kotlin-jvm`
    `java-gradle-plugin`
    `javiersc-publish-gradle-plugin`
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

kotlin {
    explicitApi()
}

dependencies {
    // TODO: remove when the next issue is fixed:
    //  https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(files(pluginLibs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation(projects.core)
    api(projects.projectAccessor)

    implementation(gradleApi())
    implementation(gradleKotlinDsl())

    implementation(pluginLibs.android.toolsBuild.gradle)
    implementation(pluginLibs.jetbrains.kotlin.kotlinGradlePluginX)

    testImplementation(libs.jetbrains.kotlin.kotlinTest)
    testImplementation(libs.jetbrains.kotlin.kotlinTestJunit)
    testImplementation(libs.kotest.kotestAssertionsCore)
    testImplementation(gradleTestKit())
}
