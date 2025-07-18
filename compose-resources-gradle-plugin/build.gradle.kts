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
                hubdle.android.tools.build.gradle,
                hubdle.jetbrains.kotlin.gradle.plugin,
            )
        }
    }

    kotlin {
        jvm {
            features {
                jvmVersion(JavaVersion.VERSION_11)
            }


            main {
                dependencies {
                    api(projects.composeResources)
                    implementation(hubdle.android.tools.build.gradle)
                    implementation(hubdle.jetbrains.kotlin.gradle.plugin)
                }
            }

            testFunctional()
        }
    }
}

tasks.testDependsOnPublishToMavenLocalTestFrom(projects.composeResources)
