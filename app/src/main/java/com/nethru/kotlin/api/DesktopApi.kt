package com.nethru.kotlin.api

import com.nethru.howltalk.domain.Desktop
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface DesktopApi {

    @GET("desktop")
    fun find(@Query("code") code: Int): Observable<Desktop>
}
