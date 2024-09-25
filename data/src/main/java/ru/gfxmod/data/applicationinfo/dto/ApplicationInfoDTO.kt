package ru.gfxmod.data.applicationinfo.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ApplicationInfoDTO(
    @SerialName("statisticAppVersion")
    val statisticAppVersionDTO: StatisticAppVersionDTO,
    @SerialName("statisticsApiKeys")
    val statisticsApiKeysDTO: StatisticsApiKeysDTO,
    @SerialName("statisticsAdUnitIds")
    val statisticsAdUnitIdsDTO: StatisticsAdUnitIdsDTO
) {
    @Serializable
    data class StatisticAppVersionDTO(
        @SerialName("currentAppVersion")
        val currentAppVersion: Int,
        @SerialName("minimalAppVersion")
        val minimalAppVersion: Int
    )

    @Serializable
    data class StatisticsApiKeysDTO(
        @SerialName("lesta")
        val lesta: String,
        @SerialName("wargaming")
        val wargaming: String
    )

    @Serializable
    data class StatisticsAdUnitIdsDTO(
        @SerialName("banner")
        val banner: String,
        @SerialName("interstitial")
        val interstitial: String
    )
}
