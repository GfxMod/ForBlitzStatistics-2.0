package ru.gfxmod.forblitzstatistics.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.gfxmod.data.di.dataModule
import ru.gfxmod.data.di.networkModule
import ru.gfxmod.domain.di.domainModule
import ru.gfxmod.forblitzstatistics.di.appModule

class ForBlitzStatisticsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ForBlitzStatisticsApplication)
            modules(listOf(appModule, domainModule, dataModule, networkModule))
        }
    }

}