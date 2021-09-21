package com.javiersc.compose.resources.utils

import com.android.build.api.dsl.AndroidSourceDirectorySet
import com.android.build.gradle.LibraryExtension
import com.javiersc.compose.resources.DefaultSuffix
import com.javiersc.compose.resources.DrawableDirName
import com.javiersc.compose.resources.composeResourcesExtension
import java.io.File
import org.gradle.api.Project
import org.gradle.api.file.SourceDirectorySet
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

internal val Project.commonMainSourceSet: KotlinSourceSet?
    get() =
        extensions
            .getByType<org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension>()
            .sourceSets
            .toList()
            .firstOrNull { kotlinSourceSet -> kotlinSourceSet.name == "commonMain" }

internal val Project.commonMainKotlin: SourceDirectorySet?
    get() = commonMainSourceSet?.kotlin

internal val Project.commonMainResources: SourceDirectorySet?
    get() = commonMainSourceSet?.resources

internal val Project.commonMainResourcesDirs: List<File>
    get() = commonMainSourceSet?.resources?.srcDirs?.toList().orEmpty()

internal val Project.androidSourceDirectorySetResources: AndroidSourceDirectorySet?
    get() = extensions.findByType<LibraryExtension>()?.sourceSets?.findByName("main")?.res

internal val Project.commonMainDrawables: List<File>
    get() =
        commonMainResourcesDirs
            .flatMap { file -> file.walkTopDown().maxDepth(1) }
            .firstOrNull { file -> file.isDirectory && file.name == DrawableDirName }
            ?.walkTopDown()
            ?.toList()
            ?.filter(File::isFile)
            .orEmpty()

internal val Project.commonMainDrawablesGroupedBySuffix: Map<String, List<File>>
    get() =
        commonMainDrawables.groupBy { file ->
            composeResourcesExtension.suffixes.firstOrNull { suffix ->
                file.nameWithoutExtension.endsWith(suffix)
            }
                ?: DefaultSuffix
        }

internal val List<Project>.commonMainDrawablesMerged: List<File>
    get() = flatMap { project -> project.commonMainDrawables }

internal class AllProjects(val mainProject: Project, val subProjects: List<Project>) {
    val allProjects: List<Project> = listOf(mainProject) + subProjects
}

internal val AllProjects.commonMainDrawablesGroupedBySuffixMerged: Map<String, List<File>>
    get() =
        allProjects.commonMainDrawablesMerged.groupBy { file ->
            mainProject.composeResourcesExtension.suffixes.firstOrNull { suffix ->
                file.nameWithoutExtension.endsWith(suffix)
            }
                ?: DefaultSuffix
        }
