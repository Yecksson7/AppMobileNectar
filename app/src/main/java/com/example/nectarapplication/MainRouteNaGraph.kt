package com.example.nectarapplication

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nectarapplication.data.DetailItems
import com.example.nectarapplication.data.DetailProducts
import com.example.nectarapplication.data.ExploreItems
import com.example.nectarapplication.data.FavouritesItems
import com.example.nectarapplication.data.HomeProducts
import com.example.nectarapplication.data.MyCartItems
import com.example.nectarapplication.screens.Detail.DetailRoute
import com.example.nectarapplication.screens.Detail.DetailScreen
import com.example.nectarapplication.screens.Detail.DetailViewModel
import com.example.nectarapplication.screens.Explore.ExploreRoute
import com.example.nectarapplication.screens.Explore.ExploreScreen
import com.example.nectarapplication.screens.Explore.ExploreViewModel
import com.example.nectarapplication.screens.Favourites.FavouritesRoute
import com.example.nectarapplication.screens.Favourites.FavouritesScreen
import com.example.nectarapplication.screens.Favourites.FavouritesViewModel
import com.example.nectarapplication.screens.Location.SelectLocationScreen
import com.example.nectarapplication.screens.MyCart.MyCartRoute
import com.example.nectarapplication.screens.MyCart.MyCartScreen
import com.example.nectarapplication.screens.MyCart.MyCartViewModel
import com.example.nectarapplication.screens.account.AccountScreen
import com.example.nectarapplication.screens.home.HomeRoute
import com.example.nectarapplication.screens.home.HomeScreen
import com.example.nectarapplication.screens.home.HomeViewModel
import com.example.nectarapplication.screens.login.LoginScreen
import com.example.nectarapplication.screens.login.LoginViewModel
import com.example.nectarapplication.screens.onboarding.OnboardingScreen
import com.example.nectarapplication.screens.singUp.SignUpScreen
import com.example.nectarapplication.screens.splash.SplashScreen
import com.google.android.gms.analytics.ecommerce.Product

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestinations.SPLASH_ROUTE,
    //viewModel: MainViewModel,
    navigationActions: MainNavActions
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // SplashScreen route
        composable(AppDestinations.SPLASH_ROUTE) {
            //viewModel.setTitle("Splash Screen")
            SplashScreen(
                navigationActions = navigationActions
            )
        }

        // OnboardingScreen route
        composable(AppDestinations.ONBOARDING_ROUTE) {
            //viewModel.setTitle("Onboarding Screen")
            OnboardingScreen(
                navigationActions = navigationActions
            )
        }

        // LoginScreen route
        composable(AppDestinations.LOGIN_ROUTE) {
          //  viewModel.setTitle("Login Screen")
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(
                loginViewModel = loginViewModel,
                navigationActions = navigationActions
            )
        }

        // LocationScreen route
        composable(AppDestinations.LOCATION_ROUTE) {
           // viewModel.setTitle("Location Screen")

            SelectLocationScreen(
                navigationActions = navigationActions
            )
        }
        //SingUpScreen route
        composable(AppDestinations.SING_UP_ROUTE) {
            // viewModel.setTitle("Location Screen")

            SignUpScreen(
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.HOME_ROUTE) {
            //  viewModel.setTitle("Home Screen")
//            val homeViewModel: HomeViewModel = viewModel()
            HomeScreen(
                navController,
                HomeProducts,
                navigationActions = navigationActions,
            )
        }
        composable(AppDestinations.SEARCH_ROUTE) {
            //  viewModel.setTitle("Login Screen")
//            val exploreViewModel: ExploreViewModel = viewModel()
            ExploreScreen(
                ExploreItems,
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.MY_CART_ROUTE) {
            //  viewModel.setTitle("MyCart Screen")
//            val myCartViewModel: MyCartViewModel = viewModel()
            MyCartScreen(
                MyCartItems,
                navigationActions = navigationActions
            )
        }
        composable(AppDestinations.FAVOURITES_ROUTE) {
            //  viewModel.setTitle("MyCart Screen")
//            val favouritesViewModel: FavouritesViewModel = viewModel()
            FavouritesScreen(
                FavouritesItems,
                navigationActions = navigationActions
            )
        }
        composable(
            route = AppDestinations.DETAIL_ROUTE
        ) { backStackEntry ->
            val detailViewModel: DetailViewModel = viewModel()

                DetailRoute(
                    detailViewModel
                )
            }

        composable(AppDestinations.ACCOUNT_ROUTE) {
            //  viewModel.setTitle("Profile Screen")
            AccountScreen(
                navigationActions = navigationActions
            )
        }
    }
}
