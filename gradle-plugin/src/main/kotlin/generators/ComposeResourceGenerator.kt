package com.javiersc.compose.resources.generators

internal fun composeResourceGenerator(packageName: String): String =
    """
        |package $packageName
        |
        |interface ComposeResource {
        |
        |    companion object
        |}
        |
    """.trimMargin()
