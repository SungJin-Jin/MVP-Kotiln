package com.nethru.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.nethru.howltalk.domain.Desktop
import com.nethru.kotlin.KotlinApplication
import com.nethru.kotlin.R
import com.nethru.kotlin.api.DesktopApi
import com.nethru.kotlin.presenter.DesktopPresenter
import com.nethru.kotlin.view.DesktopView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), DesktopView {

    @Inject
    lateinit var desktopPresenter: DesktopPresenter

    @Inject
    lateinit var desktopApi: DesktopApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as KotlinApplication).injector.inject(this)

        desktopPresenter.setDesktopApi(desktopApi)
        desktopPresenter.onViewCreated(this)

        btnOk.setOnClickListener {
            val code = inputCode.text.toString().toInt()
            desktopPresenter.loadDesktop(code)
        }
    }

    override fun onDesktopLoaded(desktop: Desktop) {
        txtContent.text = desktop.toString()
    }

    override fun onError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }
}
