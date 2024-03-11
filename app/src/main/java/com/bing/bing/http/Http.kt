package com.bing.bing.http

import com.bing.bing.serializer.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object Http {

    @OptIn(ExperimentalSerializationApi::class)
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        explicitNulls = true
    }
    private val contentType = "application/json".toMediaType()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.apiopen.top/")
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    val api: Api by lazy { retrofit.create(Api::class.java) }

}