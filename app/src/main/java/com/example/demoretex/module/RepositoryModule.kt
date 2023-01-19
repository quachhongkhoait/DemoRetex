package com.example.demoretex.module

import com.example.demoretex.data.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MovieRepository(get()) }
}
