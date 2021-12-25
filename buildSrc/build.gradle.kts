plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    // TODO: remove when the next issue is fixed:
    //  https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(pluginLibs.javaClass.superclass.protectionDomain.codeSource.location))

    pluginLibs.apply {
        implementation(android.toolsBuild.gradle)

        implementation(javiersc.gradlePlugins.allPluginsX)

        implementation(jetbrains.compose.composeGradlePluginX)
        implementation(jetbrains.kotlin.kotlinGradlePluginX)
        implementation(jetbrains.kotlinx.binaryCompatibilityValidator)
    }
}
