package com.cariad.test.di

import com.cariad.test.presentation.viewmodel.POIViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { POIViewModel(get()) }
}