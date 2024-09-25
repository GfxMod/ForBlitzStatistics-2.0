package ru.gfxmod.domain.applicationinfo.repository

import ru.gfxmod.domain.applicationinfo.model.ApplicationInfoModel

interface ApplicationInfoRepository {
    suspend fun getApplicationInfo(): ApplicationInfoModel
}