package com.example.nectarapplication.screens.Explore


import androidx.compose.runtime.Composable
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.data.Products

@Composable
fun ExploreRoute(
    exploreItems: List<Products>,
    exploreViewModel: ExploreViewModel,
    navigationActions: MainNavActions
) {

    ExploreRoute(
        exploreViewModel,
        navigationActions = navigationActions
    )
}

@Composable
fun ExploreRoute(
    exploreViewModel: ExploreViewModel,
    navigationActions: MainNavActions
) {

    exploreViewModel.getItems()?.let { ExploreScreen(it, navigationActions) }
}