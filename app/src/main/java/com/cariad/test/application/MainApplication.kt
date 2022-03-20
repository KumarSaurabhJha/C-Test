package com.cariad.test.application

import android.app.Application

class MainApplication : Application() {
    companion object {
        lateinit var appInstance: MainApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
}