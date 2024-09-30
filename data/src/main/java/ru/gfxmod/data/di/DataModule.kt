package ru.gfxmod.data.di

import org.koin.dsl.module
import ru.gfxmod.data.account_search.repository.AccountSearchRepositoryImpl
import ru.gfxmod.data.applicationinfo.local.ApplicationInfoCache
import ru.gfxmod.data.applicationinfo.repository.ApplicationInfoRepositoryImpl
import ru.gfxmod.domain.account_search.repository.AccountSearchRepository
import ru.gfxmod.domain.applicationinfo.repository.ApplicationInfoRepository

val dataModule = module {
    single<ApplicationInfoRepository> { ApplicationInfoRepositoryImpl(get(), get()) }
    single<ApplicationInfoCache> { ApplicationInfoCache() }
    single<AccountSearchRepository> { AccountSearchRepositoryImpl(get()) }
}