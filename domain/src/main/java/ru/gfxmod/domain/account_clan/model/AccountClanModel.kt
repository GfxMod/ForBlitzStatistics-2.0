package ru.gfxmod.domain.account_clan.model

import ru.gfxmod.domain.value_class.AccountID
import ru.gfxmod.domain.value_class.ClanID

data class AccountClanModel(
    val accountId: AccountID,
    val accountName: String,
    val clan: Clan
) {
    data class Clan(
        val clanId: ClanID,
        val joinedAt: Int,
        val role: String,
        val emblemSetId: Int,
        var clanName: String,
        var clanTag: String
    )
}