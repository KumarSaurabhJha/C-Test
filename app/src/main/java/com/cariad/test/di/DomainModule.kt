package com.cariad.test.di

import com.cariad.test.domain.usecases.GetPOIDataUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetPOIDataUseCase(get()) }
}