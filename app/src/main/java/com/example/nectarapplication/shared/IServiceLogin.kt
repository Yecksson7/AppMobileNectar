package com.example.nectarapplication.shared

interface IServiceLogin {
    suspend fun login(username: String, password: String): String
}