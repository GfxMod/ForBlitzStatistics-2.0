package ru.gfxmod.forblitzstatistics.features.search_screen.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import ru.gfxmod.forblitzstatistics.R
import ru.gfxmod.forblitzstatistics.app.ui.theme.dimenExtraLarge
import ru.gfxmod.forblitzstatistics.app.ui.theme.dimenExtraSmall
import ru.gfxmod.forblitzstatistics.app.ui.theme.dimenLarge
import ru.gfxmod.forblitzstatistics.app.ui.theme.dimenMedium
import ru.gfxmod.forblitzstatistics.app.ui.theme.dimenSmall
import ru.gfxmod.forblitzstatistics.app.ui.theme.textLarge
import ru.gfxmod.forblitzstatistics.app.ui.theme.transparentWhite

@Composable
fun StartScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color.Transparent)
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
            modifier.height(dimenExtraLarge)
        )
        Search(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimenExtraLarge * 2)
                .background(
                    color = MaterialTheme.colorScheme.surfaceContainer,
                    shape = MaterialTheme.shapes.extraLarge
                )
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
            tint = transparentWhite
        )

        Spacer(Modifier.width(dimenSmall))

        VerticalDivider(
            color = transparentWhite
        )

        Text(
            text = stringResource(R.string.enter_nickname),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimenSmall),
            textAlign = TextAlign.Center,
            fontSize = textLarge,
            color = transparentWhite
        )

    }
}