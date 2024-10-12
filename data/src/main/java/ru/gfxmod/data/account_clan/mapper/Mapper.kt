package ru.gfxmod.data.account_clan.mapper

import ru.gfxmod.data.account_clan.dto.AccountClanDTO
import ru.gfxmod.data.value_class.AccountIDDTO
import ru.gfxmod.domain.account_clan.model.AccountClanModel
import ru.gfxmod.domain.value_class.AccountID

fun AccountClanDTO.AccountClanElementDTO.toModel(): AccountClanModel = AccountClanModel(
    accountId = this.accountId.toAccountID(),
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

fun AccountIDDTO.toAccountID() = AccountID(accountID)
