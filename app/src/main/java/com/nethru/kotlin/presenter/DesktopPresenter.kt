package com.nethru.kotlin.presenter

import com.nethru.kotlin.api.DesktopApi
import com.nethru.kotlin.view.DesktopView
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers

class DesktopPresenter {
    private lateinit var desktopApi: DesktopApi
    private lateinit var desktopView: DesktopView

    private lateinit var subscription: Subscription

    fun onViewCreated(view: DesktopView) {
        desktopView = view
    }

    fun setDesktopApi(api: DesktopApi) {
        desktopApi = api
    }

    fun loadDesktop(code: Int) {
        subscription = desktopApi!!
                .find(code)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ desktopView.onDesktopLoaded(it) }, { desktopView.onError(it) })
    }
}