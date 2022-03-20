package com.cariad.test.di

import com.kumar.test.data.repository.POIRepository
import org.koin.dsl.module


val restRepositoryModule = module {
    single {
        POIRepository(get())
    }
}