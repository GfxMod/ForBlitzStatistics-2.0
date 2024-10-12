package ru.gfxmod.forblitzstatistics.features.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.gfxmod.domain.account_clan.model.AccountClanModel
import ru.gfxmod.domain.account_clan.repository.AccountClanRepository
import ru.gfxmod.domain.account_search.model.AccountSearchModel
import ru.gfxmod.domain.account_search.repository.AccountSearchRepository
import ru.gfxmod.domain.applicationinfo.repository.ApplicationInfoRepository
import ru.gfxmod.domain.value_class.AccountID

class SearchScreenViewModel(
    private val applicationInfoRepository: ApplicationInfoRepository,
    private val accountSearchRepository: AccountSearchRepository,
    private val accountClanRepository: AccountClanRepository
) : ViewModel() {

    private val _searchResults = MutableStateFlow<List<AccountSearchModel>?>(null)
    val searchResults: StateFlow<List<AccountSearchModel>?> get() = _searchResults

    private val _clans = MutableStateFlow<Map<AccountID, AccountClanModel>?>(null)
    val clans: StateFlow<Map<AccountID, AccountClanModel>?> get() = _clans

    fun loadSearchResults(search: String) {
        CoroutineScope(Dispatchers.IO).launch {
            _searchResults.value = accountSearchRepository.getAccounts(
                search = search,
                token = applicationInfoRepository.getApplicationInfo().statisticsApiKeysModel.wargaming
            )
        }
    }

    fun clearSearchResults() {
        viewModelScope.launch {
            _searchResults.value = null
        }
    }

    fun loadClans(accountIds: Collection<AccountID>) {
        CoroutineScope(Dispatchers.IO).launch {
            _clans.value = accountClanRepository.getAccountClan(
                accountIds = accountIds,
                token = applicationInfoRepository.getApplicationInfo().statisticsApiKeysModel.wargaming
            )
        }
    }

}
