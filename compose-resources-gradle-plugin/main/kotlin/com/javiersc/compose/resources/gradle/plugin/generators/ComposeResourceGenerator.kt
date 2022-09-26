package com.javiersc.compose.resources.gradle.plugin.generators

internal fun composeResourceGenerator(packageName: String): String =
    """
        |package $packageName
        |
        |interface ComposeResource {
        |
        |    companion object
        |}
        |
    """
        .trimMargin()
