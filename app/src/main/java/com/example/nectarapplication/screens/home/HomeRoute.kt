package com.example.nectarapplication.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.data.CartProducts

@Composable
fun HomeRoute(
    homeProducts: List<CartProducts>,
    homeViewModel: HomeViewModel,
    navigationActions: MainNavActions,
    navHostController: NavHostController
) {

    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        navHostController,
        cartProducts = homeProducts,
        navigationActions = navigationActions
    )
}
