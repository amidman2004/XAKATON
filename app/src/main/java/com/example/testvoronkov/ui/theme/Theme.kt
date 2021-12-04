package com.example.testvoronkov.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import java.time.format.TextStyle

private val DarkColorPalette = darkColors(
    primary = gol0,
    primaryVariant = gol0,
    secondary = gol0
)

private val LightColorPalette = lightColors(
    primary = gol0,
    primaryVariant = gol0,
    secondary = gol0

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)


@Composable
fun MainThem(
    style: JetHabbitStyle = JetHabbitStyle.Purple,
    textSize: JetHabbitSize = JetHabbitSize.Medium,
    paddingSize: JetHabbitSize = JetHabbitSize.Medium,
    corners: JetHabbitCorners = JetHabbitCorners.Rounded,
    darkThem: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = when(darkThem){
        true->{
            when(style){
                JetHabbitStyle.Purple -> purpleDarkPalette
                JetHabbitStyle.gradient -> GradientDarkPalette
                //JetHabbitStyle.Blue -> blueDarkPalette
                //JetHabbitStyle.Red -> redDarkPalette
                //JetHabbitStyle.Green -> GreenDarkPalette
                //JetHabbitStyle.Orange -> orangeDarkPalette
                JetHabbitStyle.textPrimary -> TextPrimaryDarkPalette
            }
        }
        false->{
            when(style){
                JetHabbitStyle.Purple -> purpleLightPalette
                JetHabbitStyle.gradient -> GradientLightPalette
                //JetHabbitStyle.Blue -> blueLightPalette
                //JetHabbitStyle.Red -> redLightPalette
                //JetHabbitStyle.Green -> GreenLightPalette
                //JetHabbitStyle.Orange -> orangeLightPalette
                JetHabbitStyle.textPrimary -> TextPrimaryLightPalette
            }
        }
    }


    CompositionLocalProvider(
        LocalJetHabbitColors provides colors,
        content = content

    )
}

@Composable
fun TestVoronkovTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}