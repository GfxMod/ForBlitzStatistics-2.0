package ru.gfxmod.data.applicationinfo.local

import ru.gfxmod.domain.applicationinfo.model.ApplicationInfoModel

class ApplicationInfoCache {
    private var cachedData: ApplicationInfoModel? = null

    fun getData(): ApplicationInfoModel? {
        return cachedData
    }

    fun saveData(data: ApplicationInfoModel) {
        cachedData = data
    }
}