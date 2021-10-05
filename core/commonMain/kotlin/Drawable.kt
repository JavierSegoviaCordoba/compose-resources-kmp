package com.javiersc.compose.resources.core

public class Drawable(
    public val name: String,
    public val extension: String,
    public val type: String,
) {

    public val nameWithExtension: String
        get() = "$name.$extension"
}
