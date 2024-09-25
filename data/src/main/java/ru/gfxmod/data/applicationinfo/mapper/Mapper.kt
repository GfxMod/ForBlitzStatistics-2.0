package ru.gfxmod.data.applicationinfo.mapper

import ru.gfxmod.data.applicationinfo.dto.ApplicationInfoDTO
import ru.gfxmod.domain.applicationinfo.model.ApplicationInfoModel

fun ApplicationInfoDTO.toApplicationInfoModel() = ApplicationInfoModel(
    statisticAppVersionModel = ApplicationInfoModel.StatisticAppVersionModel(
        currentAppVersion = statisticAppVersionDTO.currentAppVersion,
        minimalAppVersion = statisticAppVersionDTO.minimalAppVersion
    ),
    statisticsApiKeysModel = ApplicationInfoModel.StatisticsApiKeysModel(
        lesta = statisticsApiKeysDTO.lesta,
        wargaming = statisticsApiKeysDTO.wargaming
    ),
    statisticsAdUnitIdsModel = ApplicationInfoModel.StatisticsAdUnitIdsModel(
        banner = statisticsAdUnitIdsDTO.banner,
        interstitial = statisticsAdUnitIdsDTO.interstitial
    )
)