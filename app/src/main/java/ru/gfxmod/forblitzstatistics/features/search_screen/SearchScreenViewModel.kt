package ru.gfxmod.forblitzstatistics.features.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.gfxmod.domain.account_search.model.AccountSearchModel
import ru.gfxmod.domain.account_search.repository.AccountSearchRepository
import ru.gfxmod.domain.applicationinfo.repository.ApplicationInfoRepository

class SearchScreenViewModel(
    private val applicationInfoRepository: ApplicationInfoRepository,
    private val accountSearchRepository: AccountSearchRepository
) : ViewModel() {

    private val _searchResults = MutableStateFlow<List<AccountSearchModel>?>(null)
    val searchResults: StateFlow<List<AccountSearchModel>?> get() = _searchResults

    fun loadSearchResults(search: String) {
        viewModelScope.launch {
            _searchResults.value = accountSearchRepository.getAccounts(
                search = search,
                token = applicationInfoRepository.getApplicationInfo().statisticsApiKeysModel.wargaming
            )
        }
    }

}
