package com.example.nectarapplication.screens.Explore

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.nectarapplication.MainNavActions

@Composable
fun ExploreRoute(
    exploreViewModel: ExploreViewModel,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    navigationActions: MainNavActions
) {

    val uiState by exploreViewModel.uiState.collectAsStateWithLifecycle()

    ExploreRoute(
        exploreViewModel,
        uiState = uiState,
        onToggleFavorite = { exploreViewModel.toggleFavourite(it) },
        openDrawer = openDrawer,
        snackbarHostState = snackbarHostState,
        navigationActions = navigationActions
    )
}

@Composable
fun ExploreRoute(
    exploreViewModel: ExploreViewModel,
    uiState: ExploreUiState,
    onToggleFavorite: (String) -> Unit,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState,
    navigationActions: MainNavActions
) {

    exploreViewModel.getItems()?.let { ExploreScreen(it, navigationActions, PaddingValues(16.dp), onToggleFavorite) }
}