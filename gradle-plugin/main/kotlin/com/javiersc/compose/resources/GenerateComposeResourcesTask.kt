package com.javiersc.compose.resources

import com.javiersc.compose.resources.generators.generateComposeResources
import com.javiersc.compose.resources.utils.commonMainDrawables
import com.javiersc.compose.resources.utils.commonMainDrawablesGroupedBySuffix
import com.javiersc.compose.resources.utils.commonMainResourcesDirs
import java.io.File
import org.gradle.api.DefaultTask
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.jetbrains.kotlin.gradle.internal.ensureParentDirsCreated

@CacheableTask
internal abstract class GenerateComposeResourcesTask : DefaultTask() {

    @Input val generationDir: String = File(project.layout.generationDir).path

    @Input
    val packageName: Property<String?> =
        project
            .objects
            .property(String::class.java)
            .convention(project.composeResourcesExtension.packageName)

    @Input val commonMainResourcesDirs: List<File> = project.commonMainResourcesDirs

    @Input val commonMainDrawables: List<File> = commonMainDrawables(commonMainResourcesDirs)

    @Input
    val suffixes: ListProperty<String> =
        project
            .objects
            .listProperty(String::class.java)
            .convention(project.composeResourcesExtension.suffixes)

    @OutputFile
    val composeResourceFile: File =
        File("$generationDir/ComposeResource.kt").apply { ensureParentDirsCreated() }

    @Internal
    val commonMainDrawablesGroupedBySuffix: Map<String, List<File>> =
        commonMainDrawablesGroupedBySuffix(commonMainDrawables, suffixes.get())

    @OutputFile
    val drawablesFile: File =
        File("$generationDir/Drawables.kt").apply { ensureParentDirsCreated() }

    @TaskAction
    fun run() {
        generateComposeResources(
            packageName = packageName.get(),
            composeResourceFile = composeResourceFile,
            commonMainDrawablesGroupedBySuffix = commonMainDrawablesGroupedBySuffix,
            drawablesFile = drawablesFile,
        )
    }

    companion object {

        const val name = "generateComposeResources"
    }
}
