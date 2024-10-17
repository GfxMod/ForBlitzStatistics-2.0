package ru.gfxmod.forblitzstatistics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.gfxmod.forblitzstatistics.ui.theme.ForBlitzStatisticsTheme
import ru.gfxmod.forblitzstatistics.common.TRANSITION_LENGTH
import ru.gfxmod.forblitzstatistics.features.search_screen.SearchScreen
import ru.gfxmod.forblitzstatistics.features.start_screen.StartScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForBlitzStatisticsTheme {
                rememberSystemUiController().apply {
                    setStatusBarColor(
                        color = MaterialTheme.colorScheme.background
                    )
                    setNavigationBarColor(
                        color = MaterialTheme.colorScheme.background
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = MaterialTheme.colorScheme.background
                        )
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "start",
                        enterTransition = {
                            fadeIn(animationSpec = tween(durationMillis = TRANSITION_LENGTH))
                        },
                        exitTransition = {
                            fadeOut(animationSpec = tween(durationMillis = TRANSITION_LENGTH))
                        }
                    ) {
                        composable("start") { StartScreen(navController = navController) }

                        composable("search") {
                            SearchScreen(
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }

}