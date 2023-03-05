package com.javiersc.compose.resources.gradle.plugin

import com.javiersc.compose.resources.gradle.plugin.utils.androidSourceDirectorySetResources
import com.javiersc.compose.resources.gradle.plugin.utils.commonMainKotlin
import com.javiersc.compose.resources.gradle.plugin.utils.commonMainResourcesDirs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.plugins.BasePlugin
import org.gradle.api.tasks.TaskProvider
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.register

public class ComposeResourcesPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.pluginManager.apply(BasePlugin::class)

        project.createComposeResourcesExtension().apply { packageName }

        project.commonMainKotlin?.srcDirs(project.layout.generationDir)

        project.androidSourceDirectorySetResources?.srcDirs(project.commonMainResourcesDirs)

        val assembleTask: TaskProvider<Task> = project.tasks.named(BasePlugin.ASSEMBLE_TASK_NAME)

        val generateComposeResourcesTask: TaskProvider<GenerateComposeResourcesTask> =
            project.tasks.register<GenerateComposeResourcesTask>(GenerateComposeResourcesTask.name)

        generateComposeResourcesTask.configure { task -> task.dependsOn(assembleTask) }
    }
}
