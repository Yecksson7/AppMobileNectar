package com.example.nectarapplication.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.nectarapplication.MainNavActions

@Composable
fun ListRoute(
    listViewModel: HomeViewModel,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    navigationActions: MainNavActions
) {

    val uiState by listViewModel.uiState.collectAsStateWithLifecycle()

    ListRoute(
        listViewModel = listViewModel,
        uiState = uiState,
        onToggleFavorite = { listViewModel.toggleFavourite(it) },
        openDrawer = openDrawer,
        snackbarHostState = snackbarHostState,
        navigationActions = navigationActions
    )
}

@Composable
fun ListRoute(
    listViewModel: HomeViewModel,
    uiState: ListUiState,
    onToggleFavorite: (String) -> Unit,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState,
    navigationActions: MainNavActions
) {

    HomeScreen(
        navigationActions,
        PaddingValues(16.dp),
        onToggleFavorite)
}