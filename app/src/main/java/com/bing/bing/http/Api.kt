package com.bing.bing.http

import com.bing.bing.model.SignupModel
import com.bing.bing.model.SignupRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("api/login")
    suspend fun signup(@Body body: SignupRequest): SignupModel

}