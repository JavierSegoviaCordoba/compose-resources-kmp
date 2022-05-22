rootProject.name = providers.gradleProperty("project.name").get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    versionCatalogs {
        create("libs") { from(files("gradle/libs.toml")) }
        create("pluginLibs") { from(files("gradle/pluginLibs.toml")) }
    }
}

include(
    ":core",
    ":gradle-plugin",
)
