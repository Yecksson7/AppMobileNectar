package com.example.nectarapplication.screens.MyCartScreen

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
    myCartViewModel: MyCartViewModel,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    navigationActions: MainNavActions
) {

    val uiState by myCartViewModel.uiState.collectAsStateWithLifecycle()

    ListRoute(
        listViewModel = myCartViewModel,
        uiState = uiState,
        onToggleFavorite = { myCartViewModel.toggleFavourite(it) },
        openDrawer = openDrawer,
        snackbarHostState = snackbarHostState,
        navigationActions = navigationActions
    )
}

@Composable
fun ListRoute(
    listViewModel: MyCartViewModel,
    uiState: ListUiState,
    onToggleFavorite: (String) -> Unit,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState,
    navigationActions: MainNavActions
) {

    listViewModel.getItems()?.let { MyCartScreen(it, navigationActions, PaddingValues(16.dp), onToggleFavorite) }
}