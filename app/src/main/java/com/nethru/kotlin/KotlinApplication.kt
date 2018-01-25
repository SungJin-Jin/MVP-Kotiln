package com.nethru.kotlin

import android.app.Application
import com.nethru.kotlin.activity.MainActivity
import com.nethru.kotlin.module.DesktopModule
import dagger.Component
import javax.inject.Singleton

class KotlinApplication : Application() {

    lateinit var injector: AppInjector

    @Singleton
    @Component(modules = arrayOf(DesktopModule::class))
    interface AppInjector {
        fun inject(mainActivity: MainActivity)
    }

    override fun onCreate() {
        super.onCreate()
        injector = DaggerKotlinApplication_AppInjector.builder().build()
    }

}