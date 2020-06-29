package com.lv.library_core.net

import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("https://www.baidu.com")
    suspend fun baidu(): String
}