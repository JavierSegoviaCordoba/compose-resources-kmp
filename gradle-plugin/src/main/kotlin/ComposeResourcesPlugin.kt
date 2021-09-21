package com.javiersc.compose.resources

import com.android.build.gradle.LibraryExtension
import com.javiersc.compose.resources.utils.commonMainKotlin
import com.javiersc.compose.resources.utils.commonMainResourcesDirs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register

public class ComposeResourcesPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.createComposeResourcesExtension().apply { packageName }

        project.commonMainKotlin?.srcDirs(project.generationDir)

        project.commonMainResourcesDirs.forEach { srcDir ->
            project
                .extensions
                .findByType<LibraryExtension>()
                ?.sourceSets
                ?.get("main")
                ?.res
                ?.srcDir(srcDir)
        }

        project.tasks.register<GenerateComposeResourcesTask>("generateComposeResources")
    }
}
