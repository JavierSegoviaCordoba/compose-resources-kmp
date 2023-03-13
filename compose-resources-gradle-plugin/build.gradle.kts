hubdle {
    config {
        analysis()
        documentation {
            api()
        }
        explicitApi()
        publishing()
    }

    kotlin {
        jvm {
            features {
                jvmVersion(JavaVersion.VERSION_11)

                gradle {
                    plugin {
                        gradlePlugin {
                            plugins {
                                create("ComposeResources") {
                                    id = "com.javiersc.compose.resources"
                                    implementationClass =
                                        "com.javiersc.compose.resources.gradle.plugin.ComposeResourcesPlugin"
                                    displayName = "Compose Resources KMP"
                                    description = """Compose Resources to be used in Kotlin Multiplatform"""
                                    tags.set(
                                        listOf(
                                            "compose",
                                            "jetpack compose",
                                            "compose multiplatform",
                                        )
                                    )
                                }
                            }
                        }
                        pluginUnderTestDependencies(
                            androidToolsBuildGradle(),
                            jetbrainsKotlinGradlePlugin(),
                        )
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

            testFunctional()
        }
    }
}

tasks.testDependsOnPublishToMavenLocalTestFrom(projects.composeResources)
