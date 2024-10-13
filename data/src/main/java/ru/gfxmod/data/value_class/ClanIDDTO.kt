package ru.gfxmod.data.value_class

import kotlinx.serialization.Serializable
import ru.gfxmod.domain.value_class.ClanID

@Serializable
@JvmInline
value class ClanIDDTO(
    val clanID: Int
)

fun ClanIDDTO.toClanID() = ClanID(clanID)
