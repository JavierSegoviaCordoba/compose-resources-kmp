package com.javiersc.compose.resources

import com.javiersc.compose.resources.generators.generateComposeResources
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

internal open class GenerateComposeResourcesTask : DefaultTask() {

    @TaskAction
    fun run() {
        project.generateComposeResources()
    }

    companion object {

        const val name = "generateComposeResources"
    }
}
