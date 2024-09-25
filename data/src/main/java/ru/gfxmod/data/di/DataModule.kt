package ru.gfxmod.data.di

import org.koin.dsl.module
import ru.gfxmod.data.applicationinfo.repository.ApplicationInfoRepositoryImpl
import ru.gfxmod.domain.applicationinfo.repository.ApplicationInfoRepository

val dataModule = module {
    single<ApplicationInfoRepository> { ApplicationInfoRepositoryImpl(get()) }
}