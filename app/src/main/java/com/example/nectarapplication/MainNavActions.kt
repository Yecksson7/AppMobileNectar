package com.example.nectarapplication

import androidx.compose.material3.DrawerState
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object AppDestinations {
    const val HOME_ITEMS_ROUTE = "home"
    const val DETAILS_ROUTE = "detail/{productsId}"
    const val EXPLORE_ROUTE = "explore"
    const val MY_CART_ROUTE = "myCart"
    const val FAVOURITES = "favourites"
    //const val ACCOUNT = "account"
    //const val FILTERS = "filters"
}

class MainNavActions(
    navController: NavHostController,
    scope: CoroutineScope,
    drawerState: DrawerState,
    snackbarHostState: SnackbarHostState
) {
    val navigateToList: () -> Unit = {
        navController.navigate(AppDestinations.HOME_ITEMS_ROUTE) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToDetail: (bootID: Int) -> Unit = { productID ->
        navController.navigate(
            AppDestinations.DETAILS_ROUTE.replace(
                oldValue = "{bootId}",
                newValue = productID.toString()
            )
        ) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToExplore: () -> Unit = {
        navController.navigate(AppDestinations.EXPLORE_ROUTE) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToMyCart: () -> Unit = {
        navController.navigate(AppDestinations.MY_CART_ROUTE) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToFavorites: () -> Unit = {
        navController.navigate(AppDestinations.FAVOURITES) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
//    val navigateToAccount: () -> Unit = {
//        navController.navigate(AppDestinations.ACCOUNT) {
//            scope.launch {
//                drawerState.close()
//            }
//            popUpTo(navController.graph.findStartDestination().id) {
//                saveState = true
//            }
//            launchSingleTop = true
//            restoreState = true
//        }
//    }
//    val navigateToSettings: () -> Unit = {
//        navController.navigate(AppDestinations.FILTERS) {
//            scope.launch {
//                drawerState.close()
//            }
//            popUpTo(navController.graph.findStartDestination().id) {
//                saveState = true
//            }
//            launchSingleTop = true
//            restoreState = true
//        }
//    }
}