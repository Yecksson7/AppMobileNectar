package com.example.nectarapplication.screens.MyCart

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.data.CartProducts
import com.example.nectarapplication.data.Products

@Composable
fun MyCartRoute(
    myCartItems: List<CartProducts>,
    myCartViewModel: MyCartViewModel,
    navigationActions: MainNavActions
) {

    val uiState by myCartViewModel.uiState.collectAsStateWithLifecycle()

    MyCartRoute(
        listViewModel = myCartViewModel,
        onToggleFavorite = { myCartViewModel.toggleFavourite(it) },
        navigationActions = navigationActions
    )
}

@Composable
fun MyCartRoute(
    listViewModel: MyCartViewModel,
    onToggleFavorite: (String) -> Unit,
    navigationActions: MainNavActions
) {

    listViewModel.getItems()?.let { MyCartScreen(it, navigationActions, PaddingValues(16.dp), onToggleFavorite) }
}