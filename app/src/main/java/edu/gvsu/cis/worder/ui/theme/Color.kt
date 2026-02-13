package edu.gvsu.cis.worder.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

fun Color.lighter(percent: Float = 0.2f) =
    this.copy(red = (red * (1 + percent)).coerceAtMost(1f),
        green = (green * (1 + percent)).coerceAtMost(1f),
        blue = (blue * (1 + percent)).coerceAtMost(1f))

fun Color.darker(percent: Float = 0.2f) =
    this.copy(red = (red * (1 - percent)).coerceAtLeast(0f),
        green = (green * (1 - percent)).coerceAtLeast(0f),
        blue = (blue * (1 - percent)).coerceAtLeast(0f))
