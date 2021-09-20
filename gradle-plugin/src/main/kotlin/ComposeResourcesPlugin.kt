package com.javiersc.compose.resources

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.register

public class ComposeResourcesPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.createComposeResourcesExtension().apply { packageName }

        project.tasks.register<GenerateComposeResourcesTask>("generateComposeResources")
    }
}
