package com.javiersc.compose.resources.gradle.plugin.utils

import com.android.build.api.dsl.AndroidSourceDirectorySet
import com.android.build.gradle.LibraryExtension
import com.javiersc.compose.resources.gradle.plugin.DefaultSuffix
import com.javiersc.compose.resources.gradle.plugin.DrawableDirName
import java.io.File
import org.gradle.api.Project
import org.gradle.api.file.SourceDirectorySet
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

internal val Project.commonMainSourceSet: KotlinSourceSet?
    get() =
        extensions.getByType<KotlinProjectExtension>().sourceSets.toList().firstOrNull {
            kotlinSourceSet ->
            kotlinSourceSet.name == "commonMain"
        }

internal val Project.commonMainKotlin: SourceDirectorySet?
    get() = commonMainSourceSet?.kotlin

internal val Project.commonMainResources: SourceDirectorySet?
    get() = commonMainSourceSet?.resources

internal val Project.commonMainResourcesDirs: List<File>
    get() = commonMainResources?.srcDirs?.toList().orEmpty()

internal val Project.androidSourceDirectorySetResources: AndroidSourceDirectorySet?
    get() = extensions.findByType<LibraryExtension>()?.sourceSets?.findByName("main")?.res

internal fun commonMainDrawables(commonMainResourcesDirs: List<File>): List<File> =
    commonMainResourcesDirs
        .flatMap { file -> file.walkTopDown().maxDepth(1) }
        .firstOrNull { file -> file.isDirectory && file.name == DrawableDirName }
        ?.walkTopDown()
        ?.toList()
        ?.filter(File::isFile)
        .orEmpty()

internal fun commonMainDrawablesGroupedBySuffix(
    commonMainDrawables: List<File>,
    suffixes: List<String>,
): Map<String, List<File>> =
    commonMainDrawables.groupBy { file ->
        suffixes.firstOrNull { suffix -> file.nameWithoutExtension.endsWith(suffix) }
            ?: DefaultSuffix
    }

internal val List<Project>.commonMainDrawablesMerged: List<File>
    get() = flatMap { project -> commonMainDrawables(TODO("Investigate how to merge resources")) }

internal class AllProjects(val mainProject: Project, val subProjects: List<Project>) {
    val allProjects: List<Project> = listOf(mainProject) + subProjects
}
