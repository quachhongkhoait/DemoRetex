package com.example.demoretex.module

import com.example.demoretex.data.source.MovieDataSource
import com.example.demoretex.data.source.remote.MovieRemoteDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModule = module {
    single { MovieRemoteDataSource(get()) } bind (MovieDataSource.Remote::class)
}
