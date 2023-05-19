hubdle {
    config {
        analysis()
        coverage()
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
                            hubdle.android.toolsBuild.gradle,
                            hubdle.jetbrains.kotlin.kotlinGradlePlugin,
                        )
                    }
                }
            }


            main {
                dependencies {
                    api(projects.composeResources)
                    implementation(hubdle.android.toolsBuild.gradle)
                    implementation(hubdle.jetbrains.kotlin.kotlinGradlePlugin)
                }
            }

            testFunctional()
        }
    }
}

tasks.testDependsOnPublishToMavenLocalTestFrom(projects.composeResources)
