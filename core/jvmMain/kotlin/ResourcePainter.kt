package com.javiersc.compose.resources.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable
actual fun painterResource(resource: String, type: String): Painter =
    androidx.compose.ui.res.painterResource(resource)
