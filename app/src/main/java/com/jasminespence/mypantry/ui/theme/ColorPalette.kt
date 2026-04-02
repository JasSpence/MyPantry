package com.jasminespence.mypantry.ui.theme

import androidx.compose.ui.graphics.Color

class ColorPalette {
    var color: Color
    var onColor: Color
    var surface: Color
    var onSurface: Color
    var container: Color
    var onContainer: Color

    constructor(
        color: Color,
        onColor: Color,
        surface: Color,
        onSurface: Color,
        container: Color,
        onContainer: Color
    ) {
        this.color = color
        this.onColor = onColor
        this.surface = surface
        this.onSurface = onSurface
        this.container = container
        this.onContainer = onContainer
    }
}