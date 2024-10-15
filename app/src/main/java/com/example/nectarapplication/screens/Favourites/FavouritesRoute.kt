package com.example.nectarapplication.screens.Favourites

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.data.CartProducts
import com.example.nectarapplication.data.Products

@Composable
fun FavouritesRoute(
    favouritesItems: List<CartProducts>,
    favouritesViewModel: FavouritesViewModel,
    navigationActions: MainNavActions
) {

    val uiState by favouritesViewModel.uiState.collectAsStateWithLifecycle()

    FavouritesRoute(
        favouritesViewModel = favouritesViewModel,
        navigationActions = navigationActions
    )
}

@Composable
fun FavouritesRoute(
    favouritesViewModel: FavouritesViewModel,
    navigationActions: MainNavActions
) {

    favouritesViewModel.getItems()?.let { FavouritesScreen( it, navigationActions ) }
}