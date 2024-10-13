package ru.gfxmod.data.value_class

import kotlinx.serialization.Serializable
import ru.gfxmod.domain.value_class.AccountID

@Serializable
@JvmInline
value class AccountIDDTO(
    val accountID: Int
)

fun AccountIDDTO.toAccountID() = AccountID(accountID)
