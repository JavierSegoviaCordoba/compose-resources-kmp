package com.javiersc.compose.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext

@Composable
public actual fun painterResource(resource: String, type: String): Painter {
    val resourceName = resource.replaceAfterLast(".", "").dropLast(1)
    return androidx.compose.ui.res.painterResource(
        with(LocalContext.current) { resources.getIdentifier(resourceName, type, packageName) }
    )
}
