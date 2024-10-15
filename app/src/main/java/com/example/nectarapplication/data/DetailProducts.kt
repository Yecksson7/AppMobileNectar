package com.example.nectarapplication.data

import androidx.compose.runtime.Immutable


@Immutable
data class DetailProducts(
    val id: Int,
    val image: Int,
    val title: String,
    val porcion: String,
    val precio: Double,
    val productDetail: String
)