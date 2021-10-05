package com.javiersc.compose.resources.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

public class Drawable(
    public val name: String,
    public val extension: String,
    public val type: String,
) {

    public val nameWithExtension: String
        get() = "$name.$extension"
}

@Composable
public fun painterResource(drawable: Drawable): Painter =
    painterResource(resource = drawable.nameWithExtension, type = drawable.type)
