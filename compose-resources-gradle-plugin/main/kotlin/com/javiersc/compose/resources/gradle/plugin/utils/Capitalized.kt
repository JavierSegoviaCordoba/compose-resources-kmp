package com.javiersc.compose.resources.gradle.plugin.utils

import java.util.Locale.getDefault

internal fun String.capitalizeAfterUnderscore(): String =
    lowercase(getDefault())
        .split("_")
        .mapIndexed { index, text -> if (index == 0) text else text.capitalized() }
        .joinToString("")

internal fun String.capitalized(): String = replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(getDefault()) else it.toString()
}
