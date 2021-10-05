package com.javiersc.compose.resources.core

class Drawable(
    val name: String,
    val extension: String,
    val type: String,
) {

    val nameWithExtension: String
        get() = "$name.$extension"
}
