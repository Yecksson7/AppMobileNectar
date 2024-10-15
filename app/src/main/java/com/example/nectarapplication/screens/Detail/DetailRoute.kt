package com.example.nectarapplication.screens.Detail

import androidx.compose.runtime.Composable
import com.example.nectarapplication.MainNavActions

@Composable
fun DetailRoute(
    detailViewModel: DetailViewModel,

) {
    val items = detailViewModel.getItems()


    items?.firstOrNull()?.let { selectedProduct ->
        DetailScreen(detailProduct = selectedProduct)
    }
}