package ru.gfxmod.data.account_clan.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.gfxmod.data.value_class.AccountIDDTO
import ru.gfxmod.data.value_class.ClanIDDTO

@Serializable
data class AccountClanDTO(
    @SerialName("data") val data: HashMap<AccountIDDTO, AccountClanElementDTO?>
) {

    @Serializable
    data class AccountClanElementDTO(
        @SerialName("account_id") val accountId: AccountIDDTO,

        @SerialName("joined_at") val joinedAt: Int,

        @SerialName("clan_id") val clanId: ClanIDDTO,

        @SerialName("role") val role: String,

        @SerialName("account_name") val accountName: String,

        @SerialName("clan") val clan: Clan
    ) {

        @Serializable
        data class Clan(
            @SerialName("members_count") val membersCount: Int,

            @SerialName("name") val name: String,

            @SerialName("created_at") val createdAt: Int,

            @SerialName("tag") val tag: String,

            @SerialName("clan_id") val clanId: ClanIDDTO,

            @SerialName("emblem_set_id") val emblemSetId: Int
        )

    }
}
