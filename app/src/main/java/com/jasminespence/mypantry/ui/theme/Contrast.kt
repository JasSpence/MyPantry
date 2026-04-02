package com.jasminespence.mypantry.ui.theme


enum class Contrast(value: Int) {
    STANDARD(0),
    MEDIUM(1),
    HIGH(2),
    DYNAMIC(3)
}

val contrastChoices = listOf(
    Contrast.STANDARD,
    Contrast.MEDIUM,
    Contrast.HIGH
)

val allContrasts = listOf(
    Contrast.STANDARD,
    Contrast.MEDIUM,
    Contrast.HIGH,
    Contrast.DYNAMIC
)