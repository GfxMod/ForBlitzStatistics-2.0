package ru.gfxmod.domain.applicationinfo.model


data class ApplicationInfoModel(
    val statisticAppVersionModel: StatisticAppVersionModel,
    val statisticsApiKeysModel: StatisticsApiKeysModel,
    val statisticsAdUnitIdsModel: StatisticsAdUnitIdsModel
) {
    data class StatisticAppVersionModel(
        val currentAppVersion: Int,
        val minimalAppVersion: Int
    )

    data class StatisticsApiKeysModel(
        val lesta: String,
        val wargaming: String
    )

    data class StatisticsAdUnitIdsModel(
        val banner: String,
        val interstitial: String
    )
}
