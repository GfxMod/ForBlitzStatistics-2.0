package ru.gfxmod.domain.account_clan.repository

import ru.gfxmod.domain.account_clan.model.AccountClanModel

interface AccountClanRepository {
    suspend fun getAccountClan(accountIds: Collection<Int>, token: String): Map<Int, AccountClanModel>
}