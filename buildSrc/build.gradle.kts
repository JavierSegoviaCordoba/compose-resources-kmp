plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    // TODO: remove when the next issue is fixed:
    //  https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(files(pluginLibs.javaClass.superclass.protectionDomain.codeSource.location))

    pluginLibs.apply {
        implementation(android.toolsBuild.gradle)

        implementation(javiersc.gradlePlugins.allProjects)
        implementation(javiersc.gradlePlugins.changelog)
        implementation(javiersc.gradlePlugins.codeAnalysis)
        implementation(javiersc.gradlePlugins.codeFormatter)
        implementation(javiersc.gradlePlugins.docs)
        implementation(javiersc.gradlePlugins.kotlinMultiplatform)
        implementation(javiersc.gradlePlugins.nexus)
        implementation(javiersc.gradlePlugins.publishGradlePluginX)
        implementation(javiersc.gradlePlugins.publishKotlinJvm)
        implementation(javiersc.gradlePlugins.publishKotlinMultiplatform)
        implementation(javiersc.gradlePlugins.readmeBadges)
        implementation(javiersc.gradlePlugins.versioning)

        implementation(jetbrains.compose.composeGradlePluginX)
        implementation(jetbrains.kotlin.kotlinGradlePluginX)
        implementation(jetbrains.kotlinx.binaryCompatibilityValidator)
    }
}
