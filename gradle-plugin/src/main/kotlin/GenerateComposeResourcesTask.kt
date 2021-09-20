package com.javiersc.compose.resources

import com.javiersc.compose.resources.generators.composeResourceGenerator
import com.javiersc.compose.resources.generators.drawableGenerator
import com.javiersc.compose.resources.utils.commonMainDrawablesGroupedBySuffix
import java.io.File
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jetbrains.kotlin.gradle.internal.ensureParentDirsCreated

internal open class GenerateComposeResourcesTask : DefaultTask() {

    @TaskAction
    fun run() {
        val packageName = checkNotNull(project.composeResourcesExtension.packageName)

        val composeResource = composeResourceGenerator(packageName)
        File("${project.generationDir}/ComposeResource.kt").apply {
            ensureParentDirsCreated()
            writeText(composeResource)
        }

        val drawables = drawableGenerator(packageName, project.commonMainDrawablesGroupedBySuffix)
        File("${project.generationDir}/Drawables.kt").apply {
            ensureParentDirsCreated()
            writeText(drawables)
        }
    }
}
