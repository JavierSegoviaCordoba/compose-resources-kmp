package com.javiersc.compose.resources.gradle.plugin.generators

import com.javiersc.compose.resources.gradle.plugin.generators.drawables.drawableGenerator
import java.io.File

internal fun generateComposeResources(
    packageName: String?,
    composeResourceFile: File,
    commonMainDrawablesGroupedBySuffix: Map<String, List<File>>,
    drawablesFile: File,
) {
    checkNotNull(packageName)

    val composeResource = composeResourceGenerator(packageName)
    composeResourceFile.writeText(composeResource)

    val drawables = drawableGenerator(packageName, commonMainDrawablesGroupedBySuffix)
    drawablesFile.writeText(drawables)
}
