package com.cariad.test.di

import com.cariad.test.data.repository.POIRepository
import org.koin.dsl.module


val restRepositoryModule = module {
    single {
        POIRepository(get())
    }
}