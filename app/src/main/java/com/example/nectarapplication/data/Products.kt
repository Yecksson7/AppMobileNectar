package com.example.nectarapplication.data

import androidx.compose.runtime.Immutable

@Immutable
data class Products(
    val id: Int,
    val image: String,
    val title: String,
    val price: Double,
    val content: String,
    val stock: Int = 0
)