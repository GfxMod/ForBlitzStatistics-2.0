package ru.gfxmod.data.account_search.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.gfxmod.data.value_class.AccountIDDTO

@Serializable
data class AccountSearchDTO(

    @SerialName("data")
    val data: List<AccountSearchElementDTO>

) {

    @Serializable
    data class AccountSearchElementDTO(
        @SerialName("nickname")
        val nickname: String,
        @SerialName("account_id")
        val accountId: AccountIDDTO
    )

}
