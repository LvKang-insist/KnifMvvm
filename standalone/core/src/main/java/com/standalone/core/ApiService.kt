package com.standalone.core

import retrofit2.http.*

interface ApiService {

    @GET
    suspend fun get(@Url url: String): String

    @FormUrlEncoded
    @POST
    suspend fun post(@Url url: String, @PartMap mutableMap: MutableMap<String, Any>): String
}