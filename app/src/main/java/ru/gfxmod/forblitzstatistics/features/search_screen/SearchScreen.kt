package ru.gfxmod.forblitzstatistics.features.search_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import ru.gfxmod.domain.account_clan.model.AccountClanModel
import ru.gfxmod.domain.account_search.model.AccountSearchModel
import ru.gfxmod.forblitzstatistics.R
import ru.gfxmod.forblitzstatistics.common.NICKNAME_ALLOWED_SYMBOLS
import ru.gfxmod.forblitzstatistics.common.NICKNAME_MAX_LENGTH
import ru.gfxmod.forblitzstatistics.ui.theme.dimenExtraLarge
import ru.gfxmod.forblitzstatistics.ui.theme.dimenExtraSmall
import ru.gfxmod.forblitzstatistics.ui.theme.dimenLarge
import ru.gfxmod.forblitzstatistics.ui.theme.dimenMedium
import ru.gfxmod.forblitzstatistics.ui.theme.dimenSmall
import ru.gfxmod.forblitzstatistics.ui.theme.textLarge
import ru.gfxmod.forblitzstatistics.ui.theme.textMedium

@Composable
fun SearchScreen(
    navController: NavHostController,
    viewModel: SearchScreenViewModel = koinViewModel()
) {
    val searchResults by viewModel.searchResults.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar(modifier = Modifier.fillMaxWidth(), onSearch = { search ->
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.searchResults.collect { searchResults ->
                    if (!searchResults.isNullOrEmpty()) {
                        viewModel.loadClans(searchResults.map { it.accountId })
                    }
                }
            }
            viewModel.loadSearchResults(search)
        }, onBackClick = {
            navController.popBackStack()
        }, onClearClick = {
            viewModel.clearSearchResults()
        })

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = dimenSmall
                ),
            verticalArrangement = Arrangement.spacedBy(dimenExtraSmall),
            contentPadding = PaddingValues(vertical = dimenMedium)
        ) {
            if (searchResults != null) {
                itemsIndexed(searchResults!!) { i, accountSearchModel ->
                    AccountSearchRow(
                        first = i == 0,
                        last = i == searchResults!!.size - 1,
                        accountSearchModel = accountSearchModel,
                        accountClanModel = viewModel.clans.collectAsState().value?.get(accountSearchModel.accountId)
                    )
                }
            }
        }
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit,
    onBackClick: () -> Unit = {},
    onClearClick: () -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = modifier
            .height(dimenExtraLarge + dimenMedium)
            .padding(dimenSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimenMedium)
    ) {
        Icon(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clickable(onClick = onBackClick)
                .padding(dimenExtraSmall),
            painter = painterResource(id = R.drawable.rounded_arrow_back_24),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground
        )

        BasicTextField(modifier = Modifier
            .focusRequester(focusRequester)
            .weight(1.0f),
            value = text,
            onValueChange = {
                if (it.length <= NICKNAME_MAX_LENGTH) {
                    text = it.filter { char -> char in NICKNAME_ALLOWED_SYMBOLS }
                }
            },
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                fontSize = textLarge,
                color = MaterialTheme.colorScheme.onBackground
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurfaceVariant),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = {
                focusManager.clearFocus()
                keyboardController?.hide()
                onSearch(text)
            }),
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
            })

        Icon(modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1f)
            .clickable {
                onClearClick()
                text = ""
            }
            .padding(dimenExtraSmall),
            painter = painterResource(id = R.drawable.rounded_close_24),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground)

        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}

@Composable
fun AccountSearchRow(
    accountSearchModel: AccountSearchModel,
    accountClanModel: AccountClanModel? = null,
    first: Boolean = false,
    last: Boolean = false
) {
    Row(
        modifier = Modifier
            .height(dimenExtraLarge + dimenMedium)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceContainer, shape = if (!first && !last) {
                    MaterialTheme.shapes.extraSmall
                } else if (first) {
                    RoundedCornerShape(
                        dimenLarge, dimenLarge, dimenExtraSmall, dimenExtraSmall
                    )
                } else {
                    RoundedCornerShape(
                        dimenExtraSmall, dimenExtraSmall, dimenLarge, dimenLarge
                    )
                }
            )
            .padding(horizontal = dimenSmall + dimenExtraSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .height(dimenLarge + dimenExtraSmall)
                .aspectRatio(1f)
                .background(
                    color = MaterialTheme.colorScheme.surfaceContainerHighest,
                    shape = RoundedCornerShape(dimenExtraLarge)
                )
                .padding(dimenExtraSmall),
            painter = painterResource(id = R.drawable.outline_search_24),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground
        )

        Spacer(Modifier.width(dimenMedium))

        Text(
            modifier = Modifier.wrapContentHeight(),
            text = accountSearchModel.nickname,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = textMedium,
            fontWeight = FontWeight.Black
        )

        accountClanModel?.clan?.clanTag?.let {
            Spacer(Modifier.width(dimenExtraSmall))
            Text(
                modifier = Modifier.wrapContentHeight(),
                text = "[$it]",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = textMedium,
                fontWeight = FontWeight.Black
            )
        }

    }

}