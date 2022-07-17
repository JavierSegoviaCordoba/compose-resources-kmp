package com.javiersc.compose.resources.gradle.plugin

import com.javiersc.compose.resources.gradle.plugin.utils.androidSourceDirectorySetResources
import com.javiersc.compose.resources.gradle.plugin.utils.commonMainKotlin
import com.javiersc.compose.resources.gradle.plugin.utils.commonMainResourcesDirs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.register

public class ComposeResourcesPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.createComposeResourcesExtension().apply { packageName }

        project.commonMainKotlin?.srcDirs(project.layout.generationDir)

        project.androidSourceDirectorySetResources?.srcDirs(project.commonMainResourcesDirs)

        project.afterEvaluate {
            project.tasks.register<GenerateComposeResourcesTask>(GenerateComposeResourcesTask.name)
            project.tasks.findByName("preBuild")?.dependsOn(GenerateComposeResourcesTask.name)
            //    if (System.getProperty("idea.sync.active")?.toBoolean() == true) {
            //        // TODO: maybe run task using Gradle idea plugin?
            //    }
        }
    }
}
