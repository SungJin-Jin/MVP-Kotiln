package com.nethru.kotlin.view

import com.nethru.howltalk.domain.Desktop


interface DesktopView {
    fun onDesktopLoaded(desktop: Desktop)

    fun onError(throwable: Throwable)
}