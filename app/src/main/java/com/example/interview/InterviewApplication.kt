package com.example.interview

import android.app.Application
import com.example.interview.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class InterviewApplication : Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger()
            androidContext(this@InterviewApplication)
            modules(appModule)
        }
    }
}