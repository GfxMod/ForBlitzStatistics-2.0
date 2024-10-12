package ru.gfxmod.forblitzstatistics.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.gfxmod.forblitzstatistics.features.search_screen.SearchScreenViewModel
import ru.gfxmod.forblitzstatistics.features.start_screen.StartScreenViewModel

val appModule = module {
    viewModel { StartScreenViewModel(get()) }
    viewModel { SearchScreenViewModel(get(), get(), get()) }
}