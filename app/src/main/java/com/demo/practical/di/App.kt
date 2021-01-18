package com.demo.practical.di

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.INSTANCE.initAppComponent(this, "")
    }


}
