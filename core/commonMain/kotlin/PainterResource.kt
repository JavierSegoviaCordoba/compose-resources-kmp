package com.javiersc.compose.resources.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable expect fun painterResource(drawable: Drawable): Painter

@Composable expect fun painterResource(resource: String, type: String): Painter
