package com.example.nectarapplication.screens.Favourites

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.nectarapplication.MainNavActions

@Composable
fun FavouritesRoute(
    favouritesViewModel: FavouritesViewModel,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    navigationActions: MainNavActions
) {

    val uiState by favouritesViewModel.uiState.collectAsStateWithLifecycle()

    FavouritesRoute(
        favouritesViewModel = favouritesViewModel,
        uiState = uiState,
        onToggleFavorite = { favouritesViewModel.toggleFavourite(it) },
        openDrawer = openDrawer,
        snackbarHostState = snackbarHostState,
        navigationActions = navigationActions
    )
}

@Composable
fun FavouritesRoute(
    favouritesViewModel: FavouritesViewModel,
    uiState: FavouritesUiState,
    onToggleFavorite: (String) -> Unit,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState,
    navigationActions: MainNavActions
) {

    favouritesViewModel.getItems()?.let { FavouritesScreen(it, navigationActions) }
}