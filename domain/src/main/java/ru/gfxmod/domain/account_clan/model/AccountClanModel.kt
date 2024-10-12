package ru.gfxmod.domain.account_clan.model

data class AccountClanModel(
    val accountId: Int,
    val accountName: String,
    val clan: Clan
) {
    data class Clan(
        val clanId: Int,
        val joinedAt: Int,
        val role: String,
        val emblemSetId: Int,
        var clanName: String,
        var clanTag: String
    )
}