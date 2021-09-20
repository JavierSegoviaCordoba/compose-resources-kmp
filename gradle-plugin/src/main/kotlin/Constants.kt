@file:Suppress("TopLevelPropertyNaming")

package com.javiersc.compose.resources

import org.gradle.api.Project

internal const val DefaultSuffix = "default"
internal val Project.generationDir
    get() = "$buildDir/generated/source/composeResources/kotlin"
internal const val DrawableDirName = "drawable"
internal const val resourcesDirName = "resources"
