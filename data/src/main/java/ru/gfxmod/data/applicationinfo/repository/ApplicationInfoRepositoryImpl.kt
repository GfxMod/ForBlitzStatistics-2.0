package ru.gfxmod.data.applicationinfo.repository

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import ru.gfxmod.data.applicationinfo.dto.ApplicationInfoDTO
import ru.gfxmod.data.applicationinfo.mapper.toApplicationInfoModel
import ru.gfxmod.domain.applicationinfo.model.ApplicationInfoModel
import ru.gfxmod.domain.applicationinfo.repository.ApplicationInfoRepository

class ApplicationInfoRepositoryImpl(private val client: HttpClient) : ApplicationInfoRepository {

    companion object {
        const val API_FORBLITZ_DOMAIN = "https://statistics.forblitz.ru/"
        const val API_FORBLITZ_EXTENSION = "api/v1/appinfo"
    }

    override suspend fun getApplicationInfo(): ApplicationInfoModel {
        return Json.decodeFromString<ApplicationInfoDTO>(
            client.get("$API_FORBLITZ_DOMAIN$API_FORBLITZ_EXTENSION").bodyAsText()
        ).toApplicationInfoModel()
    }

}

