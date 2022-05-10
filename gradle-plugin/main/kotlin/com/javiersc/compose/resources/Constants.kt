@file:Suppress("TopLevelPropertyNaming")

package com.javiersc.compose.resources

import org.gradle.api.file.ProjectLayout

internal const val DefaultSuffix = "default"
internal val ProjectLayout.generationDir: String
    get() = "${buildDirectory.asFile.get()}/generated/source/composeResources/kotlin"
internal const val DrawableDirName = "drawable"
internal const val resourcesDirName = "resources"
