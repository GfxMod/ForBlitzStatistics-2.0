package ru.gfxmod.domain.account_search.model

import ru.gfxmod.domain.value_class.AccountID

data class AccountSearchModel(
    val nickname: String,
    val accountId: AccountID
)
