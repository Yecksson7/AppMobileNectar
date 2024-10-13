package com.example.nectarapplication.model

import kotlinx.serialization.SerialName

data class LoginResponse(
    @SerialName("token")
    val token: String)