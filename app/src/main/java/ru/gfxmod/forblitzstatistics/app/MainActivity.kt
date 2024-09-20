package ru.gfxmod.forblitzstatistics.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.gfxmod.forblitzstatistics.app.ui.theme.ForBlitzStatisticsTheme
import ru.gfxmod.forblitzstatistics.features.search_screen.presentation.StartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForBlitzStatisticsTheme {
                rememberSystemUiController().apply {
                    setStatusBarColor(
                        color = MaterialTheme.colorScheme.surface
                    )
                    setNavigationBarColor(
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.surface,
                                    MaterialTheme.colorScheme.surfaceVariant,
                                )
                            )
                        )
                ) {
                    StartScreen()
                }
            }
        }
    }
}