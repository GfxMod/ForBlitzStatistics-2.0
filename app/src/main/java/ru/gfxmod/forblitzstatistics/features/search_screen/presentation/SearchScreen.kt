package ru.gfxmod.forblitzstatistics.features.search_screen.presentation

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import ru.gfxmod.forblitzstatistics.R
import ru.gfxmod.forblitzstatistics.app.ui.theme.dimenExtraLarge
import ru.gfxmod.forblitzstatistics.app.ui.theme.dimenExtraSmall
import ru.gfxmod.forblitzstatistics.app.ui.theme.dimenMedium
import ru.gfxmod.forblitzstatistics.app.ui.theme.dimenSmall
import ru.gfxmod.forblitzstatistics.app.ui.theme.textLarge
import ru.gfxmod.forblitzstatistics.common.NICKNAME_ALLOWED_SYMBOLS
import ru.gfxmod.forblitzstatistics.common.NICKNAME_MAX_LENGTH

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    setStatusBarColor: @Composable (Color) -> Unit = {}
) {
    Column(modifier = modifier) {
        setStatusBarColor(MaterialTheme.colorScheme.surfaceContainerLowest)
        TopBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimenExtraLarge * 2)
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
        )
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf("") }

    val focusRequester = remember { FocusRequester() }

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
            painter = painterResource(id = R.drawable.forblitzstatistics_logo),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
        )

        Spacer(Modifier.width(dimenSmall))

        VerticalDivider(
            color = MaterialTheme.colorScheme.onSurface
        )

        BasicTextField(
            value = text,
            onValueChange = {
                if (it.length <= NICKNAME_MAX_LENGTH) {
                    text = it.filter { char -> char in NICKNAME_ALLOWED_SYMBOLS }
                }
            },
            modifier = Modifier
                .focusRequester(focusRequester)
                .fillMaxWidth()
                .padding(horizontal = dimenSmall),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                fontSize = textLarge,
                color = MaterialTheme.colorScheme.onSurface
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            decorationBox = { innerTextField ->
                if (text.isEmpty()) {
                    Text(
                        text = stringResource(R.string.enter_nickname),
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Start,
                        fontSize = textLarge
                    )
                }
                innerTextField()
            }
        )

        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }


    }
}