package com.example.demoretex

import android.app.Application
import com.example.demoretex.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                apiModule,
                retrofitModule,
                viewModelModule,
                repositoryModule,
                dataSourceModule
            )
        }
    }
}