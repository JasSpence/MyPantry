package com.jasminespence.mypantry.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

data class AppColorPalettes(
    val darkTheme: Boolean,
    val contrastLevel: Contrast
) {
    val lightBlue get() = lightBlue(darkTheme, contrastLevel)
    val red get() = red(darkTheme, contrastLevel)
    val pink get() = pink(darkTheme, contrastLevel)
    val orange get() = orange(darkTheme, contrastLevel)
    val yellow get() = yellow(darkTheme, contrastLevel)
    val turquoise get() = turquoise(darkTheme, contrastLevel)
    val green get() = green(darkTheme, contrastLevel)
    val cyan get() = cyan(darkTheme, contrastLevel)
    val blue get() = blue(darkTheme, contrastLevel)
    val darkBlue get() = darkBlue(darkTheme, contrastLevel)
    val purple get() = purple(darkTheme, contrastLevel)
    val grey get() = grey(darkTheme, contrastLevel)
}

val LocalAppColorPalettes = compositionLocalOf<AppColorPalettes> {
    error("No AppColorPalettes provided")
}

val ColorScheme.colorPalettes: AppColorPalettes
    @Composable
    get() = LocalAppColorPalettes.current

val ColorScheme.deactivatedPalette: ColorPalette
    @Composable
    get() = LocalAppColorPalettes.current.grey

fun lightBlue(
    darkScheme: Boolean, 
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) lightBlueHighContrastDarkScheme else lightBlueHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) lightBlueMediumContrastDarkScheme else lightBlueMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) lightBlueDarkScheme else lightBlueLightScheme
    else -> if (darkScheme) lightBlueDarkScheme else lightBlueLightScheme
}

//val ColorScheme.lightBlue: ColorPalette
//    @Composable
//    get() {
//        val darkScheme: Boolean = isSystemInDarkTheme()
//        val contrast: Contrast = resolveColorScheme(dynamicColor = false)
//        return when (contrast) {
//            Contrast.HIGH -> if (darkScheme) lightBlueHighContrastDarkScheme else lightBlueHighContrastLightScheme
//            Contrast.MEDIUM -> if (darkScheme) lightBlueMediumContrastDarkScheme else lightBlueMediumContrastLightScheme
//            Contrast.STANDARD -> if (darkScheme) lightBlueDarkScheme else lightBlueLightScheme
//            else -> if (darkScheme) lightBlueDarkScheme else lightBlueLightScheme
//        }
//    }

fun red(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) redHighContrastDarkScheme else redHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) redMediumContrastDarkScheme else redMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) redDarkScheme else redLightScheme
    else -> if (darkScheme) redDarkScheme else redLightScheme
}

fun pink(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) pinkHighContrastDarkScheme else pinkHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) pinkMediumContrastDarkScheme else pinkMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) pinkDarkScheme else pinkLightScheme
    else -> if (darkScheme) pinkDarkScheme else pinkLightScheme
}

fun orange(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) orangeHighContrastDarkScheme else orangeHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) orangeMediumContrastDarkScheme else orangeMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) orangeDarkScheme else orangeLightScheme
    else -> if (darkScheme) orangeDarkScheme else orangeLightScheme
}

fun yellow(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) yellowHighContrastDarkScheme else yellowHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) yellowMediumContrastDarkScheme else yellowMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) yellowDarkScheme else yellowLightScheme
    else -> if (darkScheme) yellowDarkScheme else yellowLightScheme
}

fun turquoise(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) turquoiseHighContrastDarkScheme else turquoiseHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) turquoiseMediumContrastDarkScheme else turquoiseMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) turquoiseDarkScheme else turquoiseLightScheme
    else -> if (darkScheme) turquoiseDarkScheme else turquoiseLightScheme
}

fun green(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) greenHighContrastDarkScheme else greenHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) greenMediumContrastDarkScheme else greenMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) greenDarkScheme else greenLightScheme
    else -> if (darkScheme) greenDarkScheme else greenLightScheme
}

fun cyan(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) cyanHighContrastDarkScheme else cyanHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) cyanMediumContrastDarkScheme else cyanMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) cyanDarkScheme else cyanLightScheme
    else -> if (darkScheme) cyanDarkScheme else cyanLightScheme
}

fun blue(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) blueHighContrastDarkScheme else blueHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) blueMediumContrastDarkScheme else blueMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) blueDarkScheme else blueLightScheme
    else -> if (darkScheme) blueDarkScheme else blueLightScheme
}

fun darkBlue(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) darkBlueHighContrastDarkScheme else darkBlueHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) darkBlueMediumContrastDarkScheme else darkBlueMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) darkBlueDarkScheme else darkBlueLightScheme
    else -> if (darkScheme) darkBlueDarkScheme else darkBlueLightScheme
}

fun purple(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) purpleHighContrastDarkScheme else purpleHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) purpleMediumContrastDarkScheme else purpleMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) purpleDarkScheme else purpleLightScheme
    else -> if (darkScheme) purpleDarkScheme else purpleLightScheme
}

fun grey(
    darkScheme: Boolean,
    contrast: Contrast
): ColorPalette = when (contrast) {
    Contrast.HIGH -> if (darkScheme) greyHighContrastDarkScheme else greyHighContrastLightScheme
    Contrast.MEDIUM -> if (darkScheme) greyMediumContrastDarkScheme else greyMediumContrastLightScheme
    Contrast.STANDARD -> if (darkScheme) greyDarkScheme else greyLightScheme
    else -> if (darkScheme) greyDarkScheme else greyLightScheme
}

// ------LightBlue------

private val lightBlueLightScheme = ColorPalette(
    color = lightBlueLight,
    onColor = onLightBlueLight,
    surface = lightBlueSurfaceLight,
    onSurface = onLightBlueSurfaceLight,
    container = lightBlueContainerLight,
    onContainer = onLightBlueContainerLight
)

private val lightBlueMediumContrastLightScheme = ColorPalette(
    color = lightBlueLightMediumContrast,
    onColor = onLightBlueLightMediumContrast,
    surface = lightBlueSurfaceLightMediumContrast,
    onSurface = onLightBlueSurfaceLightMediumContrast,
    container = lightBlueContainerLightMediumContrast,
    onContainer = onLightBlueContainerLightMediumContrast
)

private val lightBlueHighContrastLightScheme = ColorPalette(
    color = lightBlueLightHighContrast,
    onColor = onLightBlueLightHighContrast,
    surface = lightBlueSurfaceLightHighContrast,
    onSurface = onLightBlueSurfaceLightHighContrast,
    container = lightBlueContainerLightHighContrast,
    onContainer = onLightBlueContainerLightHighContrast
)

private val lightBlueDarkScheme = ColorPalette(
    color = lightBlueDark,
    onColor = onLightBlueDark,
    surface = lightBlueSurfaceDark,
    onSurface = onLightBlueSurfaceDark,
    container = lightBlueContainerDark,
    onContainer = onLightBlueContainerDark
)

private val lightBlueMediumContrastDarkScheme = ColorPalette(
    color = lightBlueDarkMediumContrast,
    onColor = onLightBlueDarkMediumContrast,
    surface = lightBlueSurfaceDarkMediumContrast,
    onSurface = onLightBlueSurfaceDarkMediumContrast,
    container = lightBlueContainerDarkMediumContrast,
    onContainer = onLightBlueContainerDarkMediumContrast
)

private val lightBlueHighContrastDarkScheme = ColorPalette(
    color = lightBlueDarkHighContrast,
    onColor = onLightBlueDarkHighContrast,
    surface = lightBlueSurfaceDarkHighContrast,
    onSurface = onLightBlueSurfaceDarkHighContrast,
    container = lightBlueContainerDarkHighContrast,
    onContainer = onLightBlueContainerDarkHighContrast
)

// ------Red------

private val redLightScheme = ColorPalette(
    color = redLight,
    onColor = onRedLight,
    surface = redSurfaceLight,
    onSurface = onRedSurfaceLight,
    container = redContainerLight,
    onContainer = onRedContainerLight
)

private val redMediumContrastLightScheme = ColorPalette(
    color = redLightMediumContrast,
    onColor = onRedLightMediumContrast,
    surface = redSurfaceLightMediumContrast,
    onSurface = onRedSurfaceLightMediumContrast,
    container = redContainerLightMediumContrast,
    onContainer = onRedContainerLightMediumContrast
)

private val redHighContrastLightScheme = ColorPalette(
    color = redLightHighContrast,
    onColor = onRedLightHighContrast,
    surface = redSurfaceLightHighContrast,
    onSurface = onRedSurfaceLightHighContrast,
    container = redContainerLightHighContrast,
    onContainer = onRedContainerLightHighContrast
)

private val redDarkScheme = ColorPalette(
    color = redDark,
    onColor = onRedDark,
    surface = redSurfaceDark,
    onSurface = onRedSurfaceDark,
    container = redContainerDark,
    onContainer = onRedContainerDark
)

private val redMediumContrastDarkScheme = ColorPalette(
    color = redDarkMediumContrast,
    onColor = onRedDarkMediumContrast,
    surface = redSurfaceDarkMediumContrast,
    onSurface = onRedSurfaceDarkMediumContrast,
    container = redContainerDarkMediumContrast,
    onContainer = onRedContainerDarkMediumContrast
)

private val redHighContrastDarkScheme = ColorPalette(
    color = redDarkHighContrast,
    onColor = onRedDarkHighContrast,
    surface = redSurfaceDarkHighContrast,
    onSurface = onRedSurfaceDarkHighContrast,
    container = redContainerDarkHighContrast,
    onContainer = onRedContainerDarkHighContrast
)

// ------Pink------

private val pinkLightScheme = ColorPalette(
    color = pinkLight,
    onColor = onPinkLight,
    surface = pinkSurfaceLight,
    onSurface = onPinkSurfaceLight,
    container = pinkContainerLight,
    onContainer = onPinkContainerLight
)

private val pinkMediumContrastLightScheme = ColorPalette(
    color = pinkLightMediumContrast,
    onColor = onPinkLightMediumContrast,
    surface = pinkSurfaceLightMediumContrast,
    onSurface = onPinkSurfaceLightMediumContrast,
    container = pinkContainerLightMediumContrast,
    onContainer = onPinkContainerLightMediumContrast
)

private val pinkHighContrastLightScheme = ColorPalette(
    color = pinkLightHighContrast,
    onColor = onPinkLightHighContrast,
    surface = pinkSurfaceLightHighContrast,
    onSurface = onPinkSurfaceLightHighContrast,
    container = pinkContainerLightHighContrast,
    onContainer = onPinkContainerLightHighContrast
)

private val pinkDarkScheme = ColorPalette(
    color = pinkDark,
    onColor = onPinkDark,
    surface = pinkSurfaceDark,
    onSurface = onPinkSurfaceDark,
    container = pinkContainerDark,
    onContainer = onPinkContainerDark
)

private val pinkMediumContrastDarkScheme = ColorPalette(
    color = pinkDarkMediumContrast,
    onColor = onPinkDarkMediumContrast,
    surface = pinkSurfaceDarkMediumContrast,
    onSurface = onPinkSurfaceDarkMediumContrast,
    container = pinkContainerDarkMediumContrast,
    onContainer = onPinkContainerDarkMediumContrast
)

private val pinkHighContrastDarkScheme = ColorPalette(
    color = pinkDarkHighContrast,
    onColor = onPinkDarkHighContrast,
    surface = pinkSurfaceDarkHighContrast,
    onSurface = onPinkSurfaceDarkHighContrast,
    container = pinkContainerDarkHighContrast,
    onContainer = onPinkContainerDarkHighContrast
)

// ------Orange------

private val orangeLightScheme = ColorPalette(
    color = orangeLight,
    onColor = onOrangeLight,
    surface = orangeSurfaceLight,
    onSurface = onOrangeSurfaceLight,
    container = orangeContainerLight,
    onContainer = onOrangeContainerLight
)

private val orangeMediumContrastLightScheme = ColorPalette(
    color = orangeLightMediumContrast,
    onColor = onOrangeLightMediumContrast,
    surface = orangeSurfaceLightMediumContrast,
    onSurface = onOrangeSurfaceLightMediumContrast,
    container = orangeContainerLightMediumContrast,
    onContainer = onOrangeContainerLightMediumContrast
)

private val orangeHighContrastLightScheme = ColorPalette(
    color = orangeLightHighContrast,
    onColor = onOrangeLightHighContrast,
    surface = orangeSurfaceLightHighContrast,
    onSurface = onOrangeSurfaceLightHighContrast,
    container = orangeContainerLightHighContrast,
    onContainer = onOrangeContainerLightHighContrast
)

private val orangeDarkScheme = ColorPalette(
    color = orangeDark,
    onColor = onOrangeDark,
    surface = orangeSurfaceDark,
    onSurface = onOrangeSurfaceDark,
    container = orangeContainerDark,
    onContainer = onOrangeContainerDark
)

private val orangeMediumContrastDarkScheme = ColorPalette(
    color = orangeDarkMediumContrast,
    onColor = onOrangeDarkMediumContrast,
    surface = orangeSurfaceDarkMediumContrast,
    onSurface = onOrangeSurfaceDarkMediumContrast,
    container = orangeContainerDarkMediumContrast,
    onContainer = onOrangeContainerDarkMediumContrast
)

private val orangeHighContrastDarkScheme = ColorPalette(
    color = orangeDarkHighContrast,
    onColor = onOrangeDarkHighContrast,
    surface = orangeSurfaceDarkHighContrast,
    onSurface = onOrangeSurfaceDarkHighContrast,
    container = orangeContainerDarkHighContrast,
    onContainer = onOrangeContainerDarkHighContrast
)

// ------Yellow------

private val yellowLightScheme = ColorPalette(
    color = yellowLight,
    onColor = onYellowLight,
    surface = yellowSurfaceLight,
    onSurface = onYellowSurfaceLight,
    container = yellowContainerLight,
    onContainer = onYellowContainerLight
)

private val yellowMediumContrastLightScheme = ColorPalette(
    color = yellowLightMediumContrast,
    onColor = onYellowLightMediumContrast,
    surface = yellowSurfaceLightMediumContrast,
    onSurface = onYellowSurfaceLightMediumContrast,
    container = yellowContainerLightMediumContrast,
    onContainer = onYellowContainerLightMediumContrast
)

private val yellowHighContrastLightScheme = ColorPalette(
    color = yellowLightHighContrast,
    onColor = onYellowLightHighContrast,
    surface = yellowSurfaceLightHighContrast,
    onSurface = onYellowSurfaceLightHighContrast,
    container = yellowContainerLightHighContrast,
    onContainer = onYellowContainerLightHighContrast
)

private val yellowDarkScheme = ColorPalette(
    color = yellowDark,
    onColor = onYellowDark,
    surface = yellowSurfaceDark,
    onSurface = onYellowSurfaceDark,
    container = yellowContainerDark,
    onContainer = onYellowContainerDark
)

private val yellowMediumContrastDarkScheme = ColorPalette(
    color = yellowDarkMediumContrast,
    onColor = onYellowDarkMediumContrast,
    surface = yellowSurfaceDarkMediumContrast,
    onSurface = onYellowSurfaceDarkMediumContrast,
    container = yellowContainerDarkMediumContrast,
    onContainer = onYellowContainerDarkMediumContrast
)

private val yellowHighContrastDarkScheme = ColorPalette(
    color = yellowDarkHighContrast,
    onColor = onYellowDarkHighContrast,
    surface = yellowSurfaceDarkHighContrast,
    onSurface = onYellowSurfaceDarkHighContrast,
    container = yellowContainerDarkHighContrast,
    onContainer = onYellowContainerDarkHighContrast
)

// ------Turquoise------

private val turquoiseLightScheme = ColorPalette(
    color = turquoiseLight,
    onColor = onTurquoiseLight,
    surface = turquoiseSurfaceLight,
    onSurface = onTurquoiseSurfaceLight,
    container = turquoiseContainerLight,
    onContainer = onTurquoiseContainerLight
)

private val turquoiseMediumContrastLightScheme = ColorPalette(
    color = turquoiseLightMediumContrast,
    onColor = onTurquoiseLightMediumContrast,
    surface = turquoiseSurfaceLightMediumContrast,
    onSurface = onTurquoiseSurfaceLightMediumContrast,
    container = turquoiseContainerLightMediumContrast,
    onContainer = onTurquoiseContainerLightMediumContrast
)

private val turquoiseHighContrastLightScheme = ColorPalette(
    color = turquoiseLightHighContrast,
    onColor = onTurquoiseLightHighContrast,
    surface = turquoiseSurfaceLightHighContrast,
    onSurface = onTurquoiseSurfaceLightHighContrast,
    container = turquoiseContainerLightHighContrast,
    onContainer = onTurquoiseContainerLightHighContrast
)

private val turquoiseDarkScheme = ColorPalette(
    color = turquoiseDark,
    onColor = onTurquoiseDark,
    surface = turquoiseSurfaceDark,
    onSurface = onTurquoiseSurfaceDark,
    container = turquoiseContainerDark,
    onContainer = onTurquoiseContainerDark
)

private val turquoiseMediumContrastDarkScheme = ColorPalette(
    color = turquoiseDarkMediumContrast,
    onColor = onTurquoiseDarkMediumContrast,
    surface = turquoiseSurfaceDarkMediumContrast,
    onSurface = onTurquoiseSurfaceDarkMediumContrast,
    container = turquoiseContainerDarkMediumContrast,
    onContainer = onTurquoiseContainerDarkMediumContrast
)

private val turquoiseHighContrastDarkScheme = ColorPalette(
    color = turquoiseDarkHighContrast,
    onColor = onTurquoiseDarkHighContrast,
    surface = turquoiseSurfaceDarkHighContrast,
    onSurface = onTurquoiseSurfaceDarkHighContrast,
    container = turquoiseContainerDarkHighContrast,
    onContainer = onTurquoiseContainerDarkHighContrast
)

// ------Green------

private val greenLightScheme = ColorPalette(
    color = greenLight,
    onColor = onGreenLight,
    surface = greenSurfaceLight,
    onSurface = onGreenSurfaceLight,
    container = greenContainerLight,
    onContainer = onGreenContainerLight
)

private val greenMediumContrastLightScheme = ColorPalette(
    color = greenLightMediumContrast,
    onColor = onGreenLightMediumContrast,
    surface = greenSurfaceLightMediumContrast,
    onSurface = onGreenSurfaceLightMediumContrast,
    container = greenContainerLightMediumContrast,
    onContainer = onGreenContainerLightMediumContrast
)

private val greenHighContrastLightScheme = ColorPalette(
    color = greenLightHighContrast,
    onColor = onGreenLightHighContrast,
    surface = greenSurfaceLightHighContrast,
    onSurface = onGreenSurfaceLightHighContrast,
    container = greenContainerLightHighContrast,
    onContainer = onGreenContainerLightHighContrast
)

private val greenDarkScheme = ColorPalette(
    color = greenDark,
    onColor = onGreenDark,
    surface = greenSurfaceDark,
    onSurface = onGreenSurfaceDark,
    container = greenContainerDark,
    onContainer = onGreenContainerDark
)

private val greenMediumContrastDarkScheme = ColorPalette(
    color = greenDarkMediumContrast,
    onColor = onGreenDarkMediumContrast,
    surface = greenSurfaceDarkMediumContrast,
    onSurface = onGreenSurfaceDarkMediumContrast,
    container = greenContainerDarkMediumContrast,
    onContainer = onGreenContainerDarkMediumContrast
)

private val greenHighContrastDarkScheme = ColorPalette(
    color = greenDarkHighContrast,
    onColor = onGreenDarkHighContrast,
    surface = greenSurfaceDarkHighContrast,
    onSurface = onGreenSurfaceDarkHighContrast,
    container = greenContainerDarkHighContrast,
    onContainer = onGreenContainerDarkHighContrast
)

// ------Cyan------

private val cyanLightScheme = ColorPalette(
    color = cyanLight,
    onColor = onCyanLight,
    surface = cyanSurfaceLight,
    onSurface = onCyanSurfaceLight,
    container = cyanContainerLight,
    onContainer = onCyanContainerLight
)

private val cyanMediumContrastLightScheme = ColorPalette(
    color = cyanLightMediumContrast,
    onColor = onCyanLightMediumContrast,
    surface = cyanSurfaceLightMediumContrast,
    onSurface = onCyanSurfaceLightMediumContrast,
    container = cyanContainerLightMediumContrast,
    onContainer = onCyanContainerLightMediumContrast
)

private val cyanHighContrastLightScheme = ColorPalette(
    color = cyanLightHighContrast,
    onColor = onCyanLightHighContrast,
    surface = cyanSurfaceLightHighContrast,
    onSurface = onCyanSurfaceLightHighContrast,
    container = cyanContainerLightHighContrast,
    onContainer = onCyanContainerLightHighContrast
)

private val cyanDarkScheme = ColorPalette(
    color = cyanDark,
    onColor = onCyanDark,
    surface = cyanSurfaceDark,
    onSurface = onCyanSurfaceDark,
    container = cyanContainerDark,
    onContainer = onCyanContainerDark
)

private val cyanMediumContrastDarkScheme = ColorPalette(
    color = cyanDarkMediumContrast,
    onColor = onCyanDarkMediumContrast,
    surface = cyanSurfaceDarkMediumContrast,
    onSurface = onCyanSurfaceDarkMediumContrast,
    container = cyanContainerDarkMediumContrast,
    onContainer = onCyanContainerDarkMediumContrast
)

private val cyanHighContrastDarkScheme = ColorPalette(
    color = cyanDarkHighContrast,
    onColor = onCyanDarkHighContrast,
    surface = cyanSurfaceDarkHighContrast,
    onSurface = onCyanSurfaceDarkHighContrast,
    container = cyanContainerDarkHighContrast,
    onContainer = onCyanContainerDarkHighContrast
)

// ------Blue------

private val blueLightScheme = ColorPalette(
    color = blueLight,
    onColor = onBlueLight,
    surface = blueSurfaceLight,
    onSurface = onBlueSurfaceLight,
    container = blueContainerLight,
    onContainer = onBlueContainerLight
)

private val blueMediumContrastLightScheme = ColorPalette(
    color = blueLightMediumContrast,
    onColor = onBlueLightMediumContrast,
    surface = blueSurfaceLightMediumContrast,
    onSurface = onBlueSurfaceLightMediumContrast,
    container = blueContainerLightMediumContrast,
    onContainer = onBlueContainerLightMediumContrast
)

private val blueHighContrastLightScheme = ColorPalette(
    color = blueLightHighContrast,
    onColor = onBlueLightHighContrast,
    surface = blueSurfaceLightHighContrast,
    onSurface = onBlueSurfaceLightHighContrast,
    container = blueContainerLightHighContrast,
    onContainer = onBlueContainerLightHighContrast
)

private val blueDarkScheme = ColorPalette(
    color = blueDark,
    onColor = onBlueDark,
    surface = blueSurfaceDark,
    onSurface = onBlueSurfaceDark,
    container = blueContainerDark,
    onContainer = onBlueContainerDark
)

private val blueMediumContrastDarkScheme = ColorPalette(
    color = blueDarkMediumContrast,
    onColor = onBlueDarkMediumContrast,
    surface = blueSurfaceDarkMediumContrast,
    onSurface = onBlueSurfaceDarkMediumContrast,
    container = blueContainerDarkMediumContrast,
    onContainer = onBlueContainerDarkMediumContrast
)

private val blueHighContrastDarkScheme = ColorPalette(
    color = blueDarkHighContrast,
    onColor = onBlueDarkHighContrast,
    surface = blueSurfaceDarkHighContrast,
    onSurface = onBlueSurfaceDarkHighContrast,
    container = blueContainerDarkHighContrast,
    onContainer = onBlueContainerDarkHighContrast
)

// ------DarkBlue------

private val darkBlueLightScheme = ColorPalette(
    color = darkBlueLight,
    onColor = onDarkBlueLight,
    surface = darkBlueSurfaceLight,
    onSurface = onDarkBlueSurfaceLight,
    container = darkBlueContainerLight,
    onContainer = onDarkBlueContainerLight
)

private val darkBlueMediumContrastLightScheme = ColorPalette(
    color = darkBlueLightMediumContrast,
    onColor = onDarkBlueLightMediumContrast,
    surface = darkBlueSurfaceLightMediumContrast,
    onSurface = onDarkBlueSurfaceLightMediumContrast,
    container = darkBlueContainerLightMediumContrast,
    onContainer = onDarkBlueContainerLightMediumContrast
)

private val darkBlueHighContrastLightScheme = ColorPalette(
    color = darkBlueLightHighContrast,
    onColor = onDarkBlueLightHighContrast,
    surface = darkBlueSurfaceLightHighContrast,
    onSurface = onDarkBlueSurfaceLightHighContrast,
    container = darkBlueContainerLightHighContrast,
    onContainer = onDarkBlueContainerLightHighContrast
)

private val darkBlueDarkScheme = ColorPalette(
    color = darkBlueDark,
    onColor = onDarkBlueDark,
    surface = darkBlueSurfaceDark,
    onSurface = onDarkBlueSurfaceDark,
    container = darkBlueContainerDark,
    onContainer = onDarkBlueContainerDark
)

private val darkBlueMediumContrastDarkScheme = ColorPalette(
    color = darkBlueDarkMediumContrast,
    onColor = onDarkBlueDarkMediumContrast,
    surface = darkBlueSurfaceDarkMediumContrast,
    onSurface = onDarkBlueSurfaceDarkMediumContrast,
    container = darkBlueContainerDarkMediumContrast,
    onContainer = onDarkBlueContainerDarkMediumContrast
)

private val darkBlueHighContrastDarkScheme = ColorPalette(
    color = darkBlueDarkHighContrast,
    onColor = onDarkBlueDarkHighContrast,
    surface = darkBlueSurfaceDarkHighContrast,
    onSurface = onDarkBlueSurfaceDarkHighContrast,
    container = darkBlueContainerDarkHighContrast,
    onContainer = onDarkBlueContainerDarkHighContrast
)

// ------Purple------

private val purpleLightScheme = ColorPalette(
    color = purpleLight,
    onColor = onPurpleLight,
    surface = purpleSurfaceLight,
    onSurface = onPurpleSurfaceLight,
    container = purpleContainerLight,
    onContainer = onPurpleContainerLight
)

private val purpleMediumContrastLightScheme = ColorPalette(
    color = purpleLightMediumContrast,
    onColor = onPurpleLightMediumContrast,
    surface = purpleSurfaceLightMediumContrast,
    onSurface = onPurpleSurfaceLightMediumContrast,
    container = purpleContainerLightMediumContrast,
    onContainer = onPurpleContainerLightMediumContrast
)

private val purpleHighContrastLightScheme = ColorPalette(
    color = purpleLightHighContrast,
    onColor = onPurpleLightHighContrast,
    surface = purpleSurfaceLightHighContrast,
    onSurface = onPurpleSurfaceLightHighContrast,
    container = purpleContainerLightHighContrast,
    onContainer = onPurpleContainerLightHighContrast
)

private val purpleDarkScheme = ColorPalette(
    color = purpleDark,
    onColor = onPurpleDark,
    surface = purpleSurfaceDark,
    onSurface = onPurpleSurfaceDark,
    container = purpleContainerDark,
    onContainer = onPurpleContainerDark
)

private val purpleMediumContrastDarkScheme = ColorPalette(
    color = purpleDarkMediumContrast,
    onColor = onPurpleDarkMediumContrast,
    surface = purpleSurfaceDarkMediumContrast,
    onSurface = onPurpleSurfaceDarkMediumContrast,
    container = purpleContainerDarkMediumContrast,
    onContainer = onPurpleContainerDarkMediumContrast
)

private val purpleHighContrastDarkScheme = ColorPalette(
    color = purpleDarkHighContrast,
    onColor = onPurpleDarkHighContrast,
    surface = purpleSurfaceDarkHighContrast,
    onSurface = onPurpleSurfaceDarkHighContrast,
    container = purpleContainerDarkHighContrast,
    onContainer = onPurpleContainerDarkHighContrast
)

// ------Grey------

private val greyLightScheme = ColorPalette(
    color = greyLight,
    onColor = onGreyLight,
    surface = greySurfaceLight,
    onSurface = onGreySurfaceLight,
    container = greyContainerLight,
    onContainer = onGreyContainerLight
)

private val greyMediumContrastLightScheme = ColorPalette(
    color = greyLightMediumContrast,
    onColor = onGreyLightMediumContrast,
    surface = greySurfaceLightMediumContrast,
    onSurface = onGreySurfaceLightMediumContrast,
    container = greyContainerLightMediumContrast,
    onContainer = onGreyContainerLightMediumContrast
)

private val greyHighContrastLightScheme = ColorPalette(
    color = greyLightHighContrast,
    onColor = onGreyLightHighContrast,
    surface = greySurfaceLightHighContrast,
    onSurface = onGreySurfaceLightHighContrast,
    container = greyContainerLightHighContrast,
    onContainer = onGreyContainerLightHighContrast
)

private val greyDarkScheme = ColorPalette(
    color = greyDark,
    onColor = onGreyDark,
    surface = greySurfaceDark,
    onSurface = onGreySurfaceDark,
    container = greyContainerDark,
    onContainer = onGreyContainerDark
)

private val greyMediumContrastDarkScheme = ColorPalette(
    color = greyDarkMediumContrast,
    onColor = onGreyDarkMediumContrast,
    surface = greySurfaceDarkMediumContrast,
    onSurface = onGreySurfaceDarkMediumContrast,
    container = greyContainerDarkMediumContrast,
    onContainer = onGreyContainerDarkMediumContrast
)

private val greyHighContrastDarkScheme = ColorPalette(
    color = greyDarkHighContrast,
    onColor = onGreyDarkHighContrast,
    surface = greySurfaceDarkHighContrast,
    onSurface = onGreySurfaceDarkHighContrast,
    container = greyContainerDarkHighContrast,
    onContainer = onGreyContainerDarkHighContrast
)