package com.example.dagger2

import android.app.Application
import com.example.dagger2.dagger.AppComponent
import com.example.dagger2.dagger.AppModule
import com.example.dagger2.dagger.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger()
    }

    private fun initDagger(): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(this))
                    .build()
}
