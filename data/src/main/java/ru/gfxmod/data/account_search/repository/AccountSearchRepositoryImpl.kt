package ru.gfxmod.data.account_search.repository

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import ru.gfxmod.data.account_search.dto.AccountSearchDTO
import ru.gfxmod.data.account_search.mapper.toAccountSearchModel
import ru.gfxmod.domain.account_search.model.AccountSearchModel
import ru.gfxmod.domain.account_search.repository.AccountSearchRepository

class AccountSearchRepositoryImpl(
    private val client: HttpClient
) : AccountSearchRepository {

    companion object {
        const val API_WOT_BLITZ_DOMAIN = "https://api.wotblitz.eu/"
        val json = Json { ignoreUnknownKeys = true }
    }

    override suspend fun getAccounts(search: String, token: String): List<AccountSearchModel> {
        return json.decodeFromString<AccountSearchDTO>(
            client.get {
                url("$API_WOT_BLITZ_DOMAIN${buildApiWotBlitzExtension(token)}")
                parameter("search", search)
            }.bodyAsText().also {
                println(it)
            }
        ).data.map { it.toAccountSearchModel() }
    }

    private fun buildApiWotBlitzExtension(
        token: String
    ) = "wotb/account/list/?application_id=$token"

}