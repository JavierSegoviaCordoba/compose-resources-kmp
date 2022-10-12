plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        explicitApi()
        publishing()
    }

    kotlin {
        gradle {
            plugin {
                tags("compose", "jetpack compose", "compose multiplatform")
                gradlePlugin {
                    plugins {
                        create("ComposeResources") {
                            id = "com.javiersc.compose.resources"
                            implementationClass =
                                "com.javiersc.compose.resources.gradle.plugin.ComposeResourcesPlugin"
                            displayName = "Compose Resources KMP"
                            description = """Compose Resources to be used in Kotlin Multiplatform"""
                        }
                    }
                }
                main {
                    dependencies {
                        api(projects.composeResources)
                        implementation(androidToolsBuildGradle())
                        implementation(jetbrainsKotlinGradlePlugin())
                    }
                }
                pluginUnderTestDependencies(
                    androidToolsBuildGradle(),
                    jetbrainsKotlinGradlePlugin(),
                )
            }
        }
    }
}

tasks.testDependsOnPublishToMavenLocalTestFrom(projects.composeResources)
