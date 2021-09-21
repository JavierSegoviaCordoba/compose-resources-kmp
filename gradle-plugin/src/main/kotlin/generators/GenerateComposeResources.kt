package com.javiersc.compose.resources.generators

import com.javiersc.compose.resources.composeResourcesExtension
import com.javiersc.compose.resources.generationDir
import com.javiersc.compose.resources.utils.commonMainDrawablesGroupedBySuffix
import java.io.File
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.internal.ensureParentDirsCreated

internal fun Project.generateComposeResources() {
    val packageName = checkNotNull(composeResourcesExtension.packageName)

    val composeResource = composeResourceGenerator(packageName)
    File("$generationDir/ComposeResource.kt").apply {
        ensureParentDirsCreated()
        writeText(composeResource)
    }

    val drawables = drawableGenerator(packageName, commonMainDrawablesGroupedBySuffix)
    File("$generationDir/Drawables.kt").apply {
        ensureParentDirsCreated()
        writeText(drawables)
    }
}
