package com.javiersc.compose.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable public expect fun painterResource(resource: String, type: String): Painter
