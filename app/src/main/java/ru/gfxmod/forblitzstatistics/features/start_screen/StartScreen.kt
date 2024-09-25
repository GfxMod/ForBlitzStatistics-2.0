package ru.gfxmod.forblitzstatistics.features.start_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import ru.gfxmod.forblitzstatistics.R
import ru.gfxmod.forblitzstatistics.ui.theme.dimenExtraLarge
import ru.gfxmod.forblitzstatistics.ui.theme.dimenExtraSmall
import ru.gfxmod.forblitzstatistics.ui.theme.dimenLarge
import ru.gfxmod.forblitzstatistics.ui.theme.dimenMedium
import ru.gfxmod.forblitzstatistics.ui.theme.dimenSmall
import ru.gfxmod.forblitzstatistics.ui.theme.textLarge
import org.koin.androidx.compose.koinViewModel

@Composable
fun StartScreen(
    viewModel: StartScreenViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val applicationInfo by viewModel.applicationInfo.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getApplicationData()
    }

    Column(
        modifier
            .fillMaxSize()
            .padding(dimenMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(dimenMedium * 16)
                .padding(dimenLarge),
            imageVector = ImageVector.vectorResource(R.drawable.forblitzstatistics_logo),
            contentDescription = stringResource(R.string.app_name)
        )
        Spacer(
            Modifier.height(dimenExtraLarge)
        )
        Search(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimenExtraLarge * 2)
                .background(
                    color = MaterialTheme.colorScheme.surfaceContainer,
                    shape = MaterialTheme.shapes.extraLarge
                )
                .clickable {
                    Log.d("nowDebug", "applicationInfo = $applicationInfo")
                    navController.navigate("search")
                }
        )
    }
}

@Composable
fun Search(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(dimenMedium)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .padding(dimenExtraSmall),
            painter = painterResource(id = R.drawable.outline_search_24),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
        )

        Spacer(Modifier.width(dimenSmall))

        VerticalDivider(
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = stringResource(R.string.enter_nickname),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimenSmall),
            textAlign = TextAlign.Center,
            fontSize = textLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}