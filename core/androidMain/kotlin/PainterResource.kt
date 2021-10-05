package com.javiersc.compose.resources.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun painterResource(drawable: Drawable): Painter =
    painterResource(resource = drawable.name, type = drawable.type)

@Composable
actual fun painterResource(resource: String, type: String): Painter {
    val resourceName = resource.replaceAfterLast(".", "").dropLast(1)
    return androidx.compose.ui.res.painterResource(
        with(LocalContext.current) { resources.getIdentifier(resourceName, type, packageName) }
    )
}
