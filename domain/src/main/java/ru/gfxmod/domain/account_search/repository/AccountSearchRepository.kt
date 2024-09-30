package ru.gfxmod.domain.account_search.repository;

import ru.gfxmod.domain.account_search.model.AccountSearchModel

interface AccountSearchRepository {
    suspend fun getAccounts(search: String, token: String): List<AccountSearchModel>
}
