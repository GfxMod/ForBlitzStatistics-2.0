package ru.gfxmod.data.account_clan.mapper

import ru.gfxmod.data.account_clan.dto.AccountClanDTO
import ru.gfxmod.domain.account_clan.model.AccountClanModel

fun AccountClanDTO.AccountClanElementDTO.toModel(): AccountClanModel = AccountClanModel(
    accountId = this.accountId,
    accountName = this.accountName,
    clan = AccountClanModel.Clan(
        clanId = clanId,
        joinedAt = joinedAt,
        role = role,
        emblemSetId = clan.emblemSetId,
        clanName = clan.name,
        clanTag = clan.tag
    )
)
