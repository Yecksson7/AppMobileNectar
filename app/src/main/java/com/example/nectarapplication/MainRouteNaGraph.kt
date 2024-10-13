package com.example.nectarapplication

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectarapplication.screens.Location.SelectLocationScreen
import com.example.nectarapplication.screens.login.LoginScreen
import com.example.nectarapplication.screens.login.LoginViewModel
import com.example.nectarapplication.screens.onboarding.OnboardingScreen
import com.example.nectarapplication.screens.singUp.SignUpScreen
import com.example.nectarapplication.screens.splash.SplashScreen

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
    }
}
//@Composable
//fun MainRouteNavGraph(
//    modifier: Modifier = Modifier,
//    navController: NavHostController = rememberNavController(),
//    viewModel: MainActivityViewModel,
//    openDrawer: () -> Unit = {},
//    startDestination: String = AppDestinations.LIST_ITEMS_ROUTE,
//    navigationActions: MainNavActions,
//) {
//    NavHost(
//        navController = navController,
//        startDestination = startDestination,
//        modifier = modifier,
//    ) {
//        composable(
//            route = AppDestinations.LIST_ITEMS_ROUTE,
//        ) {
//            viewModel.setTitleBar(stringResource(R.string.list_title_bar))
//
//            val listViewModel: ListViewModel = viewModel(
//                factory = ListViewModel.provideFactory()
//            )
//
//            listViewModel.setItems(BootListItems)
//
//            HomeRoute(
//                listViewModel = listViewModel,
//                openDrawer = openDrawer,
//                navigationActions = navigationActions
//            )
//        }
//        composable(AppDestinations.DETAILS_ROUTE) { backStackEntry ->
//            viewModel.setTitleBar(stringResource(R.string.detail_title_bar))
//            val bootId = backStackEntry.arguments?.getString("bootId")
//
//            val viewModel: DetailViewModel = viewModel(
//                factory = DetailViewModel.provideFactory()
//            )
//
//            BootListItems.find { it.id == bootId?.toInt() }?.let {
//                viewModel.setItem(it)
//            }
//
//            DetailRoute(
//                navController = navController,
//                detailViewModel = viewModel,
//                openDrawer = openDrawer
//            )
//        }
//        composable(AppDestinations.FAVOURITES) { backStackEntry ->
//            viewModel.setTitleBar(stringResource(R.string.favorite_title_bar))
//
//            val viewModel: FavouriteViewModel = viewModel(
//                factory = FavouriteViewModel.provideFactory()
//            )
//
//            FavouriteRoute(
//                FavouriteItems,
//                navController = navController,
//                navigationActions = navigationActions,
//                favouriteViewModel = viewModel,
//                openDrawer = openDrawer,
//            )
//        }
//        composable(AppDestinations.PROFILE) { backStackEntry ->
//            viewModel.setTitleBar(stringResource(R.string.profile_title_bar))
//
//            val viewModel: ProfileViewModel = viewModel(
//                factory = ProfileViewModel.provideFactory()
//            )
//
//            ProfileRoute(
//                navController = navController,
//                navigationActions = navigationActions,
//                profileViewModel = viewModel,
//                openDrawer = openDrawer,
//            )
//        }
//        composable(AppDestinations.SETTINGS) { backStackEntry ->
//            viewModel.setTitleBar(stringResource(R.string.settings_title_bar))
//
//            val viewModel: ProfileViewModel = viewModel(
//                factory = ProfileViewModel.provideFactory()
//            )
//
//            SettingsRoute(
//                navController = navController,
//                navigationActions = navigationActions,
//                profileViewModel = viewModel,
//                openDrawer = openDrawer,
//            )
//        }
//    }
//}