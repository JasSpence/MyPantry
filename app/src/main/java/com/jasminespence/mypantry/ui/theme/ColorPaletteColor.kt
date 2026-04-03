package com.jasminespence.mypantry.ui.theme
import androidx.compose.ui.graphics.Color

// TODO: Add Dark Scheme Colours

// Colour Roles:
// Surface – A role used for backgrounds and large, low-emphasis areas of the screen.
// Colour (Primary, Secondary, Tertiary) – Accent colour roles used to emphasise or de-emphasise foreground elements.
// Container – Roles used as a fill colour for foreground elements like buttons. They should not be used for text or icons.
// On – Roles starting with this term indicate a colour for text or icons on top of its paired parent colour. For example, on primary is used for text and icons against the primary fill color.
// Variant – Roles ending with this term offer a lower emphasis alternative to its non-variant pair. For example, outline variant is a less emphasised version of the outline color.

// Requirements:
// Standard contrast -> _   CHOICE: 3:1
// Medium contrast -> 3:1   CHOICE: 4.5:1
// High contrast -> 7:1     CHOICE: 7:1
//
// Check contrast at: https://webaim.org/resources/contrastchecker/
// Create tints and shades at: https://maketintsandshades.com/
// (with container as base shade)
//
// Colour <-> Surface
// Standard: +0.2 <-> -0.8
// Medium: +0.4 <-> -0.8/-0.9
// High: +0.6 <-> -0.9
//
// On <-> _
// Shades generated from: https://maketintsandshades.com/

// ----LightBlue----

// LightBlue - Colour
val lightBlueLight = Color(0xFF3D91B2)
val onLightBlueLight = Color(0xFFEDF8FC)
val lightBlueLightMediumContrast = Color(0xFF2E6D85)
val onLightBlueLightMediumContrast = Color(0xFFEDF8FC)
val lightBlueLightHighContrast = Color(0xFF1E4859)
val onLightBlueLightHighContrast = Color(0xFFEDF8FC)
val lightBlueDark = Color(0xFF)
val onLightBlueDark = Color(0xFF)
val lightBlueDarkMediumContrast = Color(0xFF)
val onLightBlueDarkMediumContrast = Color(0xFF)
val lightBlueDarkHighContrast = Color(0xFF)
val onLightBlueDarkHighContrast = Color(0xFF)

// LightBlue - Surface
val lightBlueSurfaceLight = Color(0xFFDBF0F8)
val onLightBlueSurfaceLight = Color(0xFF357F9B)
val lightBlueSurfaceLightMediumContrast = Color(0xFFEDF8FC)
val onLightBlueSurfaceLightMediumContrast = Color(0xFF2E6D85)
val lightBlueSurfaceLightHighContrast = Color(0xFFEDF8FC)
val onLightBlueSurfaceLightHighContrast = Color(0xFF1E4859)
val lightBlueSurfaceDark = Color(0xFF)
val onLightBlueSurfaceDark = Color(0xFF)
val lightBlueSurfaceDarkMediumContrast = Color(0xFF)
val onLightBlueSurfaceDarkMediumContrast = Color(0xFF)
val lightBlueSurfaceDarkHighContrast = Color(0xFF)
val onLightBlueSurfaceDarkHighContrast = Color(0xFF)

// LightBlue - Container
val lightBlueContainerLight = Color(0xFF4CB5DE)
val onLightBlueContainerLight = Color(0xFF1E4859)
val lightBlueContainerLightMediumContrast = lightBlueContainerLight
val onLightBlueContainerLightMediumContrast = Color(0xFF173643)
val lightBlueContainerLightHighContrast = lightBlueContainerLight
val onLightBlueContainerLightHighContrast = Color(0xFF081216)
val lightBlueContainerDark = Color(0xFF)
val onLightBlueContainerDark = Color(0xFF)
val lightBlueContainerDarkMediumContrast = lightBlueContainerDark
val onLightBlueContainerDarkMediumContrast = Color(0xFF)
val lightBlueContainerDarkHighContrast = lightBlueContainerDark
val onLightBlueContainerDarkHighContrast = Color(0xFF)

// ----Red----

// Red - Colour
val redLight = Color(0xFFC13E3F)
val onRedLight = Color(0xFFFAC1C1)
val redLightMediumContrast = Color(0xFF912F2F)
val onRedLightMediumContrast = Color(0xFFFAC1C1)
val redLightHighContrast = Color(0xFF601F20)
val onRedLightHighContrast = Color(0xFFFAC1C1)
val redDark = Color(0xFF)
val onRedDark = Color(0xFF)
val redDarkMediumContrast = Color(0xFF)
val onRedDarkMediumContrast = Color(0xFF)
val redDarkHighContrast = Color(0xFF)
val onRedDarkHighContrast = Color(0xFF)

// Red - Surface
val redSurfaceLight = Color(0xFFFCDCDC)
val onRedSurfaceLight = Color(0xFFC13E3F)
val redSurfaceLightMediumContrast = Color(0xFFFCDCDC)
val onRedSurfaceLightMediumContrast = Color(0xFFA93737)
val redSurfaceLightHighContrast = Color(0xFFFEEDED)
val onRedSurfaceLightHighContrast = Color(0xFF792728)
val redSurfaceDark = Color(0xFF)
val onRedSurfaceDark = Color(0xFF)
val redSurfaceDarkMediumContrast = Color(0xFF)
val onRedSurfaceDarkMediumContrast = Color(0xFF)
val redSurfaceDarkHighContrast = Color(0xFF)
val onRedSurfaceDarkHighContrast = Color(0xFF)

// Red - Container
val redContainerLight = Color(0xFFF14E4F)
val onRedContainerLight = Color(0xFF6C2324)
val redContainerLightMediumContrast = redContainerLight
val onRedContainerLightMediumContrast = Color(0xFF3C1414)
val redContainerLightHighContrast = Color(0xFFF47172)
val onRedContainerLightHighContrast = Color(0xFF0C0404)
val redContainerDark = Color(0xFF)
val onRedContainerDark = Color(0xFF)
val redContainerDarkMediumContrast = redContainerDark
val onRedContainerDarkMediumContrast = Color(0xFF)
val redContainerDarkHighContrast = redContainerDark
val onRedContainerDarkHighContrast = Color(0xFF)

// ----Pink----

// Pink - Colour
val pinkLight = Color(0xFFC25477)
val onPinkLight = Color(0xFFFBD2DF)
val pinkLightMediumContrast = Color(0xFF913F59)
val onPinkLightMediumContrast = Color(0xFFFBD2DF)
val pinkLightHighContrast = Color(0xFF612A3C)
val onPinkLightHighContrast = Color(0xFFFBD2DF)
val pinkDark = Color(0xFF)
val onPinkDark = Color(0xFF)
val pinkDarkMediumContrast = Color(0xFF)
val onPinkDarkMediumContrast = Color(0xFF)
val pinkDarkHighContrast = Color(0xFF)
val onPinkDarkHighContrast = Color(0xFF)


// Pink - Surface
val pinkSurfaceLight = Color(0xFFFCE1EA)
val onPinkSurfaceLight = Color(0xFFC25477)
val pinkSurfaceLightMediumContrast = Color(0xFFFCE1EA)
val onPinkSurfaceLightMediumContrast = Color(0xFF9D4461)
val pinkSurfaceLightHighContrast = Color(0xFFFEF0F4)
val onPinkSurfaceLightHighContrast = Color(0xFF79354B)
val pinkSurfaceDark = Color(0xFF)
val onPinkSurfaceDark = Color(0xFF)
val pinkSurfaceDarkMediumContrast = Color(0xFF)
val onPinkSurfaceDarkMediumContrast = Color(0xFF)
val pinkSurfaceDarkHighContrast = Color(0xFF)
val onPinkSurfaceDarkHighContrast = Color(0xFF)

// Pink - Container
val pinkContainerLight = Color(0xFFF26995)
val onPinkContainerLight = Color(0xFF6D2F43)
val pinkContainerLightMediumContrast = pinkContainerLight
val onPinkContainerLightMediumContrast = Color(0xFF49202D)
val pinkContainerLightHighContrast = Color(0xFFF3719A)
val onPinkContainerLightHighContrast = Color(0xFF0C0507)
val pinkContainerDark = Color(0xFF)
val onPinkContainerDark = Color(0xFF)
val pinkContainerDarkMediumContrast = pinkContainerDark
val onPinkContainerDarkMediumContrast = Color(0xFF)
val pinkContainerDarkHighContrast = pinkContainerDark
val onPinkContainerDarkHighContrast = Color(0xFF)

// ----Orange----

// Orange - Colour
val orangeLight = Color(0xFFCA6B16)
val onOrangeLight = Color(0xFFFFE7D1)
val orangeLightMediumContrast = Color(0xFF985010)
val onOrangeLightMediumContrast = Color(0xFFFFE7D1)
val orangeLightHighContrast = Color(0xFF65360B)
val onOrangeLightHighContrast = Color(0xFFFFE7D1)
val orangeDark = Color(0xFF)
val onOrangeDark = Color(0xFF)
val orangeDarkMediumContrast = Color(0xFF)
val onOrangeDarkMediumContrast = Color(0xFF)
val orangeDarkHighContrast = Color(0xFF)
val onOrangeDarkHighContrast = Color(0xFF)

// Orange - Surface
val orangeSurfaceLight = Color(0xFFFFE7D1)
val onOrangeSurfaceLight = Color(0xFFBE6514)
val orangeSurfaceLightMediumContrast = Color(0xFFFFE7D1)
val onOrangeSurfaceLightMediumContrast = Color(0xFF985010)
val orangeSurfaceLightHighContrast = Color(0xFFFFF3E8)
val onOrangeSurfaceLightHighContrast = Color(0xFF65360B)
val orangeSurfaceDark = Color(0xFF)
val onOrangeSurfaceDark = Color(0xFF)
val orangeSurfaceDarkMediumContrast = Color(0xFF)
val onOrangeSurfaceDarkMediumContrast = Color(0xFF)
val orangeSurfaceDarkHighContrast = Color(0xFF)
val onOrangeSurfaceDarkHighContrast = Color(0xFF)

// Orange - Container
val orangeContainerLight = Color(0xFFFD861B)
val onOrangeContainerLight = Color(0xFF723C0C)
val orangeContainerLightMediumContrast = orangeContainerLight
val onOrangeContainerLightMediumContrast = Color(0xFF4C2808)
val orangeContainerLightHighContrast = orangeContainerLight
val onOrangeContainerLightHighContrast = Color(0xFF261404)
val orangeContainerDark = Color(0xFF)
val onOrangeContainerDark = Color(0xFF)
val orangeContainerDarkMediumContrast = orangeContainerDark
val onOrangeContainerDarkMediumContrast = Color(0xFF)
val orangeContainerDarkHighContrast = orangeContainerDark
val onOrangeContainerDarkHighContrast = Color(0xFF)

// ----Yellow----

// Yellow - Colour
val yellowLight = Color(0xFFB38603)
val onYellowLight = Color(0xFFFFF9E6)
val yellowLightMediumContrast = Color(0xFF806002)
val onYellowLightMediumContrast = Color(0xFFFFF9E6)
val yellowLightHighContrast = Color(0xFF664C02)
val onYellowLightHighContrast = Color(0xFFFFF9E6)
val yellowDark = Color(0xFF)
val onYellowDark = Color(0xFF)
val yellowDarkMediumContrast = Color(0xFF)
val onYellowDarkMediumContrast = Color(0xFF)
val yellowDarkHighContrast = Color(0xFF)
val onYellowDarkHighContrast = Color(0xFF)

// Yellow - Surface
val yellowSurfaceLight = Color(0xFFFFF9E6)
val onYellowSurfaceLight = Color(0xFFB38603)
val yellowSurfaceLightMediumContrast = Color(0xFFFFF9E6)
val onYellowSurfaceLightMediumContrast = Color(0xFF8C6902)
val yellowSurfaceLightHighContrast = Color(0xFFFFF9E6)
val onYellowSurfaceLightHighContrast = Color(0xFF664C02)
val yellowSurfaceDark = Color(0xFF)
val onYellowSurfaceDark = Color(0xFF)
val yellowSurfaceDarkMediumContrast = Color(0xFF)
val onYellowSurfaceDarkMediumContrast = Color(0xFF)
val yellowSurfaceDarkHighContrast = Color(0xFF)
val onYellowSurfaceDarkHighContrast = Color(0xFF)

// Yellow - Container
val yellowContainerLight = Color(0xFFFFBF04)
val onYellowContainerLight = Color(0xFF806002)
val yellowContainerLightMediumContrast = yellowContainerLight
val onYellowContainerLightMediumContrast = Color(0xFF664C02)
val yellowContainerLightHighContrast = yellowContainerLight
val onYellowContainerLightHighContrast = Color(0xFF403001)
val yellowContainerDark = Color(0xFF)
val onYellowContainerDark = Color(0xFF)
val yellowContainerDarkMediumContrast = yellowContainerDark
val onYellowContainerDarkMediumContrast = Color(0xFF)
val yellowContainerDarkHighContrast = yellowContainerDark
val onYellowContainerDarkHighContrast = Color(0xFF)

// ----Turquoise----

// Turquoise - Colour
val turquoiseLight = Color(0xFF24956D)
val onTurquoiseLight = Color(0xFFCCF5E6)
val turquoiseLightMediumContrast = Color(0xFF1F805D)
val onTurquoiseLightMediumContrast = Color(0xFFEBFBF5)
val turquoiseLightHighContrast = Color(0xFF14553E)
val onTurquoiseLightHighContrast = Color(0xFFEBFBF5)
val turquoiseDark = Color(0xFF)
val onTurquoiseDark = Color(0xFF)
val turquoiseDarkMediumContrast = Color(0xFF)
val onTurquoiseDarkMediumContrast = Color(0xFF)
val turquoiseDarkHighContrast = Color(0xFF)
val onTurquoiseDarkHighContrast = Color(0xFF)

// Turquoise - Surface
val turquoiseSurfaceLight = Color(0xFFD6F7EB)
val onTurquoiseSurfaceLight = Color(0xFF24956D)
val turquoiseSurfaceLightMediumContrast = Color(0xFFEBFBF5)
val onTurquoiseSurfaceLightMediumContrast = Color(0xFF1C7555)
val turquoiseSurfaceLightHighContrast = Color(0xFFEBFBF5)
val onTurquoiseSurfaceLightHighContrast = Color(0xFF14553E)
val turquoiseSurfaceDark = Color(0xFF)
val onTurquoiseSurfaceDark = Color(0xFF)
val turquoiseSurfaceDarkMediumContrast = Color(0xFF)
val onTurquoiseSurfaceDarkMediumContrast = Color(0xFF)
val turquoiseSurfaceDarkHighContrast = Color(0xFF)
val onTurquoiseSurfaceDarkHighContrast = Color(0xFF)

// Turquoise - Container
val turquoiseContainerLight = Color(0xFF33D59B)
val onTurquoiseContainerLight = Color(0xFF1A6B4E)
val turquoiseContainerLightMediumContrast = turquoiseContainerLight
val onTurquoiseContainerLightMediumContrast = Color(0xFF124B36)
val turquoiseContainerLightHighContrast = turquoiseContainerLight
val onTurquoiseContainerLightHighContrast = Color(0xFF0A2B1F)
val turquoiseContainerDark = Color(0xFF)
val onTurquoiseContainerDark = Color(0xFF)
val turquoiseContainerDarkMediumContrast = turquoiseContainerDark
val onTurquoiseContainerDarkMediumContrast = Color(0xFF)
val turquoiseContainerDarkHighContrast = turquoiseContainerDark
val onTurquoiseContainerDarkHighContrast = Color(0xFF)

// ----Green----

// Green - Colour
val greenLight = Color(0xFF3F8A0F)
val onGreenLight = Color(0xFFBDE8A2)
val greenLightMediumContrast = Color(0xFF36760D)
val onGreenLightMediumContrast = Color(0xFFDEF3D0)
val greenLightHighContrast = Color(0xFF244F09)
val onGreenLightHighContrast = Color(0xFFDEF3D0)
val greenDark = Color(0xFF)
val onGreenDark = Color(0xFF)
val greenDarkMediumContrast = Color(0xFF)
val onGreenDarkMediumContrast = Color(0xFF)
val greenDarkHighContrast = Color(0xFF)
val onGreenDarkHighContrast = Color(0xFF)

// Green - Surface
val greenSurfaceLight = Color(0xFFDEF3D0)
val onGreenSurfaceLight = Color(0xFF3F8A0F)
val greenSurfaceLightMediumContrast = Color(0xFFDEF3D0)
val onGreenSurfaceLightMediumContrast = Color(0xFF36760D)
val greenSurfaceLightHighContrast = Color(0xFFEFF9E8)
val onGreenSurfaceLightHighContrast = Color(0xFF244F09)
val greenSurfaceDark = Color(0xFF)
val onGreenSurfaceDark = Color(0xFF)
val greenSurfaceDarkMediumContrast = Color(0xFF)
val onGreenSurfaceDarkMediumContrast = Color(0xFF)
val greenSurfaceDarkHighContrast = Color(0xFF)
val onGreenSurfaceDarkHighContrast = Color(0xFF)

// Green - Container
val greenContainerLight = Color(0xFF5AC516)
val onGreenContainerLight = Color(0xFF28590A)
val greenContainerLightMediumContrast = greenContainerLight
val onGreenContainerLightMediumContrast = Color(0xFF204508)
val greenContainerLightHighContrast = greenContainerLight
val onGreenContainerLightHighContrast = Color(0xFF0E1E03)
val greenContainerDark = Color(0xFF)
val onGreenContainerDark = Color(0xFF)
val greenContainerDarkMediumContrast = greenContainerDark
val onGreenContainerDarkMediumContrast = Color(0xFF)
val greenContainerDarkHighContrast = greenContainerDark
val onGreenContainerDarkHighContrast = Color(0xFF)

// ----Cyan----

// Cyan - Colour
val cyanLight = Color(0xFF219294)
val onCyanLight = Color(0xFFD5F6F6)
val cyanLightMediumContrast = Color(0xFF1C7D7F)
val onCyanLightMediumContrast = Color(0xFFEAFAFB)
val cyanLightHighContrast = Color(0xFF135355)
val onCyanLightHighContrast = Color(0xFFEAFAFB)
val cyanDark = Color(0xFF)
val onCyanDark = Color(0xFF)
val cyanDarkMediumContrast = Color(0xFF)
val onCyanDarkMediumContrast = Color(0xFF)
val cyanDarkHighContrast = Color(0xFF)
val onCyanDarkHighContrast = Color(0xFF)

// Cyan - Surface
val cyanSurfaceLight = Color(0xFFD5F6F6)
val onCyanSurfaceLight = Color(0xFF219294)
val cyanSurfaceLightMediumContrast = Color(0xFFEAFAFB)
val onCyanSurfaceLightMediumContrast = Color(0xFF1A7275)
val cyanSurfaceLightHighContrast = Color(0xFFEAFAFB)
val onCyanSurfaceLightHighContrast = Color(0xFF135355)
val cyanSurfaceDark = Color(0xFF)
val onCyanSurfaceDark = Color(0xFF)
val cyanSurfaceDarkMediumContrast = Color(0xFF)
val onCyanSurfaceDarkMediumContrast = Color(0xFF)
val cyanSurfaceDarkHighContrast = Color(0xFF)
val onCyanSurfaceDarkHighContrast = Color(0xFF)

// Cyan - Container
val cyanContainerLight = Color(0xFF2FD0D4)
val onCyanContainerLight = Color(0xFF18686A)
val cyanContainerLightMediumContrast = cyanContainerLight
val onCyanContainerLightMediumContrast = Color(0xFF10494A)
val cyanContainerLightHighContrast = cyanContainerLight
val onCyanContainerLightHighContrast = Color(0xFF092A2A)
val cyanContainerDark = Color(0xFF)
val onCyanContainerDark = Color(0xFF)
val cyanContainerDarkMediumContrast = cyanContainerDark
val onCyanContainerDarkMediumContrast = Color(0xFF)
val cyanContainerDarkHighContrast = cyanContainerDark
val onCyanContainerDarkHighContrast = Color(0xFF)

// ----Blue----

// Blue - Colour
val blueLight = Color(0xFF507DC3)
val onBlueLight = Color(0xFFE0EBFD)
val blueLightMediumContrast = Color(0xFF3C5E92)
val onBlueLightMediumContrast = Color(0xFFE0EBFD)
val blueLightHighContrast = Color(0xFF283E62)
val onBlueLightHighContrast = Color(0xFFE0EBFD)
val blueDark = Color(0xFF)
val onBlueDark = Color(0xFF)
val blueDarkMediumContrast = Color(0xFF)
val onBlueDarkMediumContrast = Color(0xFF)
val blueDarkHighContrast = Color(0xFF)
val onBlueDarkHighContrast = Color(0xFF)

// Blue - Surface
val blueSurfaceLight = Color(0xFFE0EBFD)
val onBlueSurfaceLight = Color(0xFF4B75B7)
val blueSurfaceLightMediumContrast = Color(0xFFE0EBFD)
val onBlueSurfaceLightMediumContrast = Color(0xFF3C5E92)
val blueSurfaceLightHighContrast = Color(0xFFF0F5FE)
val onBlueSurfaceLightHighContrast = Color(0xFF2D466E)
val blueSurfaceDark = Color(0xFF)
val onBlueSurfaceDark = Color(0xFF)
val blueSurfaceDarkMediumContrast = Color(0xFF)
val onBlueSurfaceDarkMediumContrast = Color(0xFF)
val blueSurfaceDarkHighContrast = Color(0xFF)
val onBlueSurfaceDarkHighContrast = Color(0xFF)

// Blue - Container
val blueContainerLight = Color(0xFF649CF4)
val onBlueContainerLight = Color(0xFF283E62)
val blueContainerLightMediumContrast = blueContainerLight
val onBlueContainerLightMediumContrast = Color(0xFF141F31)
val blueContainerLightHighContrast = blueContainerLight
val onBlueContainerLightHighContrast = Color(0xFF05080C)
val blueContainerDark = Color(0xFF)
val onBlueContainerDark = Color(0xFF)
val blueContainerDarkMediumContrast = blueContainerDark
val onBlueContainerDarkMediumContrast = Color(0xFF)
val blueContainerDarkHighContrast = blueContainerDark
val onBlueContainerDarkHighContrast = Color(0xFF)

// ----DarkBlue----

// DarkBlue - Colour
val darkBlueLight = Color(0xFF2653B4)
val onDarkBlueLight = Color(0xFFACC3F3)
val darkBlueLightMediumContrast = Color(0xFF1C3E87)
val onDarkBlueLightMediumContrast = Color(0xFFACC3F3)
val darkBlueLightHighContrast = Color(0xFF283E62)
val onDarkBlueLightHighContrast = Color(0xFFD5E1F9)
val darkBlueDark = Color(0xFF)
val onDarkBlueDark = Color(0xFF)
val darkBlueDarkMediumContrast = Color(0xFF)
val onDarkBlueDarkMediumContrast = Color(0xFF)
val darkBlueDarkHighContrast = Color(0xFF)
val onDarkBlueDarkHighContrast = Color(0xFF)

// DarkBlue - Surface
val darkBlueSurfaceLight = Color(0xFFD5E1F9)
val onDarkBlueSurfaceLight = Color(0xFF2A5ECB)
val darkBlueSurfaceLightMediumContrast = Color(0xFFD5E1F9)
val onDarkBlueSurfaceLightMediumContrast = Color(0xFF2653B4)
val darkBlueSurfaceLightHighContrast = Color(0xFFEAF0FC)
val onDarkBlueSurfaceLightHighContrast = Color(0xFF1F4492)
val darkBlueSurfaceDark = Color(0xFF)
val onDarkBlueSurfaceDark = Color(0xFF)
val darkBlueSurfaceDarkMediumContrast = Color(0xFF)
val onDarkBlueSurfaceDarkMediumContrast = Color(0xFF)
val darkBlueSurfaceDarkHighContrast = Color(0xFF)
val onDarkBlueSurfaceDarkHighContrast = Color(0xFF)

// DarkBlue - Container
val darkBlueContainerLight = Color(0xFF2F68E1)
val onDarkBlueContainerLight = Color(0xFF0A1018)
val darkBlueContainerLightMediumContrast = Color(0xFF4477E4)
val onDarkBlueContainerLightMediumContrast = Color(0xFF05080C)
val darkBlueContainerLightHighContrast = Color(0xFF789DEC)
val onDarkBlueContainerLightHighContrast = Color(0xFF05080C)
val darkBlueContainerDark = Color(0xFF)
val onDarkBlueContainerDark = Color(0xFF)
val darkBlueContainerDarkMediumContrast = darkBlueContainerDark
val onDarkBlueContainerDarkMediumContrast = Color(0xFF)
val darkBlueContainerDarkHighContrast = darkBlueContainerDark
val onDarkBlueContainerDarkHighContrast = Color(0xFF)

// ----Purple----

// Purple - Colour
val purpleLight = Color(0xFF7E56C6)
val onPurpleLight = Color(0xFFE2D3FD)
val purpleLightMediumContrast = Color(0xFF5E4094)
val onPurpleLightMediumContrast = Color(0xFFE2D3FD)
val purpleLightHighContrast = Color(0xFF3F2B63)
val onPurpleLightHighContrast = Color(0xFFE2D3FD)
val purpleDark = Color(0xFF)
val onPurpleDark = Color(0xFF)
val purpleDarkMediumContrast = Color(0xFF)
val onPurpleDarkMediumContrast = Color(0xFF)
val purpleDarkHighContrast = Color(0xFF)
val onPurpleDarkHighContrast = Color(0xFF)

// Purple - Surface
val purpleSurfaceLight = Color(0xFFEBE1FD)
val onPurpleSurfaceLight = Color(0xFF7E56C6)
val purpleSurfaceLightMediumContrast = Color(0xFFEBE1FD)
val onPurpleSurfaceLightMediumContrast = Color(0xFF6E4BAD)
val purpleSurfaceLightHighContrast = Color(0xFFF5F0FE)
val onPurpleSurfaceLightHighContrast = Color(0xFF4F367C)
val purpleSurfaceDark = Color(0xFF)
val onPurpleSurfaceDark = Color(0xFF)
val purpleSurfaceDarkMediumContrast = Color(0xFF)
val onPurpleSurfaceDarkMediumContrast = Color(0xFF)
val purpleSurfaceDarkHighContrast = Color(0xFF)
val onPurpleSurfaceDarkHighContrast = Color(0xFF)

// Purple - Container
val purpleContainerLight = Color(0xFF9D6BF7)
val onPurpleContainerLight = Color(0xFF2F204A)
val purpleContainerLightMediumContrast = purpleContainerLight
val onPurpleContainerLightMediumContrast = Color(0xFF1F1531)
val purpleContainerLightHighContrast = Color(0xFFB189F9)
val onPurpleContainerLightHighContrast = Color(0xFF08050C)
val purpleContainerDark = Color(0xFF)
val onPurpleContainerDark = Color(0xFF)
val purpleContainerDarkMediumContrast = purpleContainerDark
val onPurpleContainerDarkMediumContrast = Color(0xFF)
val purpleContainerDarkHighContrast = purpleContainerDark
val onPurpleContainerDarkHighContrast = Color(0xFF)

// ----Grey----

// Grey - Colour
val greyLight = Color(0xFF888888)
val onGreyLight = Color(0xFFF6F6F6)
val greyLightMediumContrast = Color(0xFF616161)
val onGreyLightMediumContrast = Color(0xFFF6F6F6)
val greyLightHighContrast = Color(0xFF4E4E4E)
val onGreyLightHighContrast = Color(0xFFF6F6F6)
val greyDark = Color(0xFF)
val onGreyDark = Color(0xFF)
val greyDarkMediumContrast = Color(0xFF)
val onGreyDarkMediumContrast = Color(0xFF)
val greyDarkHighContrast = Color(0xFF)
val onGreyDarkHighContrast = Color(0xFF)

// Grey - Surface
val greySurfaceLight = Color(0xFFF3F3F3)
val onGreySurfaceLight = Color(0xFF747474)
val greySurfaceLightMediumContrast = Color(0xFFF9F9F9)
val onGreySurfaceLightMediumContrast = Color(0xFF616161)
val greySurfaceLightHighContrast = Color(0xFFF9F9F9)
val onGreySurfaceLightHighContrast = Color(0xFF4E4E4E)
val greySurfaceDark = Color(0xFF)
val onGreySurfaceDark = Color(0xFF)
val greySurfaceDarkMediumContrast = Color(0xFF)
val onGreySurfaceDarkMediumContrast = Color(0xFF)
val greySurfaceDarkHighContrast = Color(0xFF)
val onGreySurfaceDarkHighContrast = Color(0xFF)

// Grey - Container
val greyContainerLight = Color(0xFFC2C2C2)
val onGreyContainerLight = Color(0xFF575757)
val greyContainerLightMediumContrast = greyContainerLight
val onGreyContainerLightMediumContrast = Color(0xFF444444)
val greyContainerLightHighContrast = greyContainerLight
val onGreyContainerLightHighContrast = Color(0xFF272727)
val greyContainerDark = Color(0xFF)
val onGreyContainerDark = Color(0xFF)
val greyContainerDarkMediumContrast = greyContainerDark
val onGreyContainerDarkMediumContrast = Color(0xFF)
val greyContainerDarkHighContrast = greyContainerDark
val onGreyContainerDarkHighContrast = Color(0xFF)