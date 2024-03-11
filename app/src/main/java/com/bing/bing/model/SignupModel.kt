package com.bing.bing.model

import kotlinx.serialization.Serializable

@Serializable
data class SignupModel(val code: Int, val message: String, val result: SignupResult?= null)

@Serializable
data class SignupResult(val id: Int, val token: String)

@Serializable
data class SignupRequest(val account: String, val password: String)