package com.example.nectarapplication.data

import androidx.compose.runtime.Immutable

@Immutable
data class CartProducts(
    val id: Int,
    val image: Int,
    val title: String,
    val porcion: String,
    val precio: Double
)