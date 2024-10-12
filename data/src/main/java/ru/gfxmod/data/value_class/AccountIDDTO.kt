package ru.gfxmod.data.value_class

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class AccountIDDTO(
    val accountID: Int
)
