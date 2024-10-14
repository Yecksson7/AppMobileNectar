package com.example.nectarapplication.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.data.CartProducts

@Composable
fun HomeRoute(
    homeProducts: List<CartProducts>,
    homeViewModel: HomeViewModel,
    navigationActions: MainNavActions
) {

    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        cartProducts = homeProducts,
        navigationActions = navigationActions
    )
}
