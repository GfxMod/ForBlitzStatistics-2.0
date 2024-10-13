package ru.gfxmod.data.account_clan.repository

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import ru.gfxmod.data.account_clan.dto.AccountClanDTO
import ru.gfxmod.data.account_clan.mapper.toModel
import ru.gfxmod.data.value_class.toAccountID
import ru.gfxmod.domain.account_clan.model.AccountClanModel
import ru.gfxmod.domain.account_clan.repository.AccountClanRepository
import ru.gfxmod.domain.value_class.AccountID

class AccountClanRepositoryImpl(
    private val client: HttpClient
) : AccountClanRepository {

    companion object {
        const val API_WOT_BLITZ_DOMAIN = "https://api.wotblitz.eu/"
        val json = Json { ignoreUnknownKeys = true }
    }

    override suspend fun getAccountClan(accountIds: Collection<AccountID>, token: String): Map<AccountID, AccountClanModel> {
        return json.decodeFromString<AccountClanDTO>(
            client.get {
                url("${API_WOT_BLITZ_DOMAIN}${buildApiWotBlitzExtension(token)}")
                parameter("account_id", accountIds.joinToString(","))
            }.also {
                println(it)
            }.bodyAsText()
        ).data
            .filter { it.value != null }
            .mapKeys { it.key.toAccountID() }
            .mapValues { it.value!!.toModel() }
    }

    private fun buildApiWotBlitzExtension(
        token: String
    ) = "wotb/clans/accountinfo/?application_id=$token&extra=clan"

}