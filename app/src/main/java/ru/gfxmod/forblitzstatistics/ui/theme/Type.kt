package ru.gfxmod.forblitzstatistics.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.gfxmod.forblitzstatistics.R

private val inter = FontFamily(
    Font(R.font.inter),
)

val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = textExtraSmall,
        lineHeight = textSmall,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = textSmall,
        lineHeight = textMedium,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = textMedium,
        lineHeight = textLarge,
        letterSpacing = 0.5.sp
    )
)