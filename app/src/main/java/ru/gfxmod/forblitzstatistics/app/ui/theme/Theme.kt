package ru.gfxmod.forblitzstatistics.app.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    surface = backgroundTop,
    surfaceVariant = backgroundBottom,
    surfaceContainerLowest = transparentBlack,
    surfaceContainer = transparentGrey,
    surfaceContainerHigh = transparentWhite
)

private val Shapes = Shapes(
    extraSmall = RoundedCornerShape(dimenExtraSmall),
    small = RoundedCornerShape(dimenSmall),
    medium = RoundedCornerShape(dimenMedium),
    large = RoundedCornerShape(dimenLarge),
    extraLarge = RoundedCornerShape(dimenExtraLarge)
)

@Composable
fun ForBlitzStatisticsTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}