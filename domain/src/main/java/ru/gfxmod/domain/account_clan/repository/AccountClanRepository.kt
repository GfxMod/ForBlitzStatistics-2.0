package ru.gfxmod.domain.account_clan.repository

import ru.gfxmod.domain.account_clan.model.AccountClanModel
import ru.gfxmod.domain.value_class.AccountID

interface AccountClanRepository {
    suspend fun getAccountClan(accountIds: Collection<AccountID>, token: String): Map<AccountID, AccountClanModel>
}