package com.example.nectarapplication

import androidx.compose.material3.DrawerState
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object AppDestinations {
    const val SPLASH_ROUTE = "splash"
    const val ONBOARDING_ROUTE = "onboarding"
    const val LOGIN_ROUTE = "login"
    const val LOCATION_ROUTE = "location"
    const val SING_UP_ROUTE = "sign-up"
    const val HOME_ROUTE = "home"
    const val SEARCH_ROUTE = "search"
    const val MY_CART_ROUTE = "myCart"
    const val FAVOURITES_ROUTE = "favourites"
    const val ACCOUNT_ROUTE = "account"
    const val DETAIL_ROUTE = "Detail/{detailProductId}"
}

class MainNavActions(
    navController: NavHostController,
    scope: CoroutineScope,
    drawerState: DrawerState,

) {
    val navigateToSplash: () -> Unit = {
        navController.navigate(AppDestinations.SPLASH_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }

    val navigateToOnboarding: () -> Unit = {
        navController.navigate(AppDestinations.ONBOARDING_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }

    val navigateToLogin: () -> Unit = {
        navController.navigate(AppDestinations.LOGIN_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }

    val navigateToLocation: () -> Unit = {
        navController.navigate(AppDestinations.LOCATION_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }
    val navigateToSingUp: () -> Unit = {
        navController.navigate(AppDestinations.SING_UP_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }
    val navigateToHome: () -> Unit = {
        navController.navigate(AppDestinations.HOME_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }
    val navigateToSearch: () -> Unit = {
        navController.navigate(AppDestinations.SEARCH_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }
    val navigateToMyCart: () -> Unit = {
        navController.navigate(AppDestinations.MY_CART_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }
    val navigateToFavourites: () -> Unit = {
        navController.navigate(AppDestinations.FAVOURITES_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }
    val navigateToAccount: () -> Unit = {
        navController.navigate(AppDestinations.ACCOUNT_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }
    val navigateToDetail: () -> Unit = {
        navController.navigate(AppDestinations.DETAIL_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }
}