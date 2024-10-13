package com.example.nectarapplication.shared


import com.example.nectarapplication.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi{
    @POST("auth/login")
    suspend fun login(@Body loguin: com.example.nectarapplication.model.LoginRequest): Response<LoginResponse>
}