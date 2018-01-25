package com.nethru.kotlin.module

import com.nethru.kotlin.api.DesktopApi
import com.nethru.kotlin.api.RetrofitBuilder.Companion.retrofit
import com.nethru.kotlin.presenter.DesktopPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DesktopModule {

    @Provides
    @Singleton
    fun provideDesktopPresenter(): DesktopPresenter {
        return DesktopPresenter()
    }

    @Provides
    @Singleton
    internal fun provideDesktopApi(): DesktopApi {
        return retrofit.create(DesktopApi::class.java)
    }
}