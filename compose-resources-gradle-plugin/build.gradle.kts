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
                        compileOnly(libs.android.toolsBuild.gradle)
                        compileOnly(libs.jetbrains.kotlin.kotlinGradlePlugin)
                    }
                }
                pluginUnderTestDependencies(
                    libs.android.toolsBuild.gradle,
                    libs.jetbrains.kotlin.kotlinGradlePlugin,
                )
            }
        }
    }
}

tasks.withType<Test>().configureEach {
    dependsOn(projects.composeResources.dependencyProject.tasks.named("publishToMavenLocal"))
}
