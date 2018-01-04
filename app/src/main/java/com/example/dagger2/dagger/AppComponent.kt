package com.example.dagger2.dagger

import com.example.dagger2.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, HttpModule::class))
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}