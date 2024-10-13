package com.example.nectarapplication.model

import kotlinx.serialization.SerialName

data class LoginRequest(
    @SerialName("username") val username: String,
    @SerialName("password") val password: String)