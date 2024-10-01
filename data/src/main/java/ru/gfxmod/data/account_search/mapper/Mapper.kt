package ru.gfxmod.data.account_search.mapper

import ru.gfxmod.data.account_search.dto.AccountSearchDTO
import ru.gfxmod.domain.account_search.model.AccountSearchModel

fun AccountSearchDTO.AccountSearchElementDTO.toAccountSearchModel() = AccountSearchModel(nickname, accountId)