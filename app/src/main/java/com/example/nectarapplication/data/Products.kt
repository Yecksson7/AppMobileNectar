package com.example.nectarapplication.data

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class Products(
    val id: Int,
    val image: Int,
    val title: String,
    val borderColor: Color,
    val backgroundColor: Color
)