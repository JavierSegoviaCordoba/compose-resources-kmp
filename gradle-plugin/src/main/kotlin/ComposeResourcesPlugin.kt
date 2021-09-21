package com.javiersc.compose.resources

import com.javiersc.compose.resources.generators.generateComposeResources
import com.javiersc.compose.resources.utils.androidSourceDirectorySetResources
import com.javiersc.compose.resources.utils.commonMainKotlin
import com.javiersc.compose.resources.utils.commonMainResourcesDirs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.register

public class ComposeResourcesPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.createComposeResourcesExtension().apply { packageName }

        project.commonMainKotlin?.srcDirs(project.generationDir)

        project.commonMainResourcesDirs.forEach { srcDir ->
            project.androidSourceDirectorySetResources?.srcDir(srcDir)
        }

        project.afterEvaluate {
            project.tasks.register<GenerateComposeResourcesTask>(GenerateComposeResourcesTask.name)
            project.tasks.findByName("preBuild")?.dependsOn(GenerateComposeResourcesTask.name)
            if (System.getProperty("idea.sync.active")?.toBoolean() == true) {
                project.generateComposeResources()
            }
        }
    }
}
