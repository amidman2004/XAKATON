package com.example.testvoronkov.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color


val gol0 = Color(0xFDFAFCFF)
val gol1 = Color(0xFD007BFF)
val gol = Color(0xFD73EAFF)
val gol_1 = Color(0xFD007BFF)
val gol_2 = Color(0xFD005D6D)

val white = Color(0xFFFFFFFF)
val turquoise = Color(0xFF00ACAB)
val blue = Color(0xFF0518A1)
val yellow = Color(0xFFEDED00)



val baseLightPalette= JetHabbitColors(
    //primaryBackground = Color(0xFD007BFF),
    primaryText = Color(0xFDFFFFFF),
    //secondaryBackground = Color(0xFD005D6D),
    //secondaryText = Color(0xFD005D6D),
    tintColor = Color.Magenta
)

val baseDarkPalette = JetHabbitColors(
    //primaryBackground = Color(0xFD007BFF),
    primaryText = Color(0xFD000000),
    //secondaryBackground = Color(0xFD005D6D),
    //secondaryText = Color(0xFD005D6D),
    tintColor = Color.Magenta
)

val TextPrimaryLightPalette = baseLightPalette.copy(
    primaryText = Color(0xFFC50000)
)

val TextPrimaryDarkPalette = baseDarkPalette.copy(
    primaryText = Color(0xFF00FFE1)
)


val purpleLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFFA900FF)
)

val purpleDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFF28003D)
)

val orangeLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFFE6FF00)
)

val orangeDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFFF79400)
)

val redLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFFFF0000)
)

val redDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFF7E0000)
)

val GreenLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFFFF0000)
)

val GreenDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFF7E0000)
)


val blueLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFF0054FF)
)

val blueDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFF0014C5)
)


