package com.natersfantasy.piggyrichrpg.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = PiggyRichColor.Giraffe,
    primaryVariant = PiggyRichColor.Giraffe,
    secondary = PiggyRichColor.GiraffePattern,
    surface = PiggyRichColor.Gray818181,
    background = PiggyRichColor.Gray818181,
)

private val LightColorPalette = lightColors(
    primary = PiggyRichColor.Giraffe,
    primaryVariant = PiggyRichColor.Giraffe,
    secondary = PiggyRichColor.GiraffePattern,
    surface = Color.White,
    background = Color.White,


    /* Other default colors to override
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun PiggyRichRPGTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = PiggyPigTypography,
        shapes = Shapes,
        content = content
    )
}