package com.example.nectarapplication


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectarapplication.data.DetailItems
import com.example.nectarapplication.data.ExploreItems
import com.example.nectarapplication.data.FavouritesItems
import com.example.nectarapplication.data.HomeProducts
import com.example.nectarapplication.data.MyCartItems
import com.example.nectarapplication.screens.Detail.DetailScreen
import com.example.nectarapplication.screens.Explore.ExploreScreen
import com.example.nectarapplication.screens.Favourites.FavouritesScreen
import com.example.nectarapplication.screens.Location.SelectLocationScreen
import com.example.nectarapplication.screens.MyCart.MyCartScreen
import com.example.nectarapplication.screens.account.AccountScreen
import com.example.nectarapplication.screens.categories.BeveragesScreenPreview
import com.example.nectarapplication.screens.checkout.CheckoutPopupScreen
import com.example.nectarapplication.screens.filters.FiltersPopup
import com.example.nectarapplication.screens.home.HomeScreen
import com.example.nectarapplication.screens.login.LoginScreen
import com.example.nectarapplication.screens.login.LoginViewModel
import com.example.nectarapplication.screens.onboarding.OnboardingScreen
import com.example.nectarapplication.screens.orderAccepted.OrderAcceptedScreenPreview
import com.example.nectarapplication.screens.search.SearchScreen
import com.example.nectarapplication.screens.singUp.SignUpScreen
import com.example.nectarapplication.screens.splash.SplashScreen

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestinations.SPLASH_ROUTE,
    navigationActions: MainNavActions
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(AppDestinations.SPLASH_ROUTE) {
            SplashScreen(
                navigationActions = navigationActions
            )
        }


        composable(AppDestinations.ONBOARDING_ROUTE) {
            OnboardingScreen(
                navigationActions = navigationActions
            )
        }


        composable(AppDestinations.LOGIN_ROUTE) {
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(
                loginViewModel = loginViewModel,
                navigationActions = navigationActions
            )
        }


        composable(AppDestinations.LOCATION_ROUTE) {

            SelectLocationScreen(
                navigationActions = navigationActions
            )
        }
        //SingUpScreen route
        composable(AppDestinations.SING_UP_ROUTE) {
            SignUpScreen(
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.HOME_ROUTE) {
            HomeScreen(
                navController,
                HomeProducts,
                navigationActions = navigationActions,
            )
        }
        composable(AppDestinations.EXPLORE_ROUTE) {
            ExploreScreen(
                ExploreItems,
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.MY_CART_ROUTE) {
            MyCartScreen(
                MyCartItems,
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.FAVOURITES_ROUTE) {
            FavouritesScreen(
                FavouritesItems,
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.DETAIL_ROUTE) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("detailProductId")?.toInt()
            val detailProduct = DetailItems.find { it.id == itemId }
            detailProduct?.let {
                DetailScreen(detailProduct = it)
            } ?: run {

            }
        }



        composable(AppDestinations.ACCOUNT_ROUTE) {
            AccountScreen(
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.CATEGORIES_ROUTE) {
            BeveragesScreenPreview(
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.FILTERS_ROUTE) {
            FiltersPopup(
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.CHECK_OUT_ROUTE) {
            CheckoutPopupScreen(
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.SEARCH_ROUTE) {
            SearchScreen(
                navigationsActions = navigationActions
            )
        }
        composable(AppDestinations.ORDER_ACCEPTED_ROUTE) {
            OrderAcceptedScreenPreview(
                navigationActions = navigationActions
            )
        }
    }
}
