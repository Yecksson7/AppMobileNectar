package com.example.nectarapplication

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectarapplication.data.ExploreItems
import com.example.nectarapplication.data.FavouritesItems
import com.example.nectarapplication.data.MyCartItems
import com.example.nectarapplication.screens.Explore.ExploreRoute
import com.example.nectarapplication.screens.Explore.ExploreViewModel
import com.example.nectarapplication.screens.Favourites.FavouritesRoute
import com.example.nectarapplication.screens.Favourites.FavouritesViewModel
import com.example.nectarapplication.screens.MyCart.ListUiState
import com.example.nectarapplication.screens.MyCart.MyCartRoute
import com.example.nectarapplication.screens.MyCart.MyCartViewModel
import com.example.nectarapplication.screens.home.HomeRoute
import com.example.nectarapplication.screens.home.HomeViewModel


@Composable
fun MainRouteNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MainActivityViewModel,
    openDrawer: () -> Unit = {},
    startDestination: String = AppDestinations.HOME_ITEMS_ROUTE,
    navigationActions: MainNavActions,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(
            route = AppDestinations.HOME_ITEMS_ROUTE,
        ) {
            viewModel.setTitleBar(stringResource(R.string.list_title_bar))

            val listViewModel: HomeViewModel = viewModel(
                factory = HomeViewModel.provideFactory()
            )

            HomeRoute(
                listViewModel = listViewModel,
                openDrawer = openDrawer,
                navigationActions = navigationActions
            )
        }
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
        composable(AppDestinations.EXPLORE_ROUTE) { backStackEntry ->
            viewModel.setTitleBar(stringResource(R.string.explore_title_bar))

            val viewModel: ExploreViewModel = viewModel(
                factory = ExploreViewModel.provideFactory()
            )

            ExploreRoute(
                ExploreItems,
                navigationActions = navigationActions,
                exploreViewModel = viewModel,
                openDrawer = openDrawer,
            )
        }
        composable(AppDestinations.MY_CART_ROUTE) { backStackEntry ->
            viewModel.setTitleBar(stringResource(R.string.mycart_title_bar))

            val viewModel: MyCartViewModel = viewModel(
                factory = MyCartViewModel.provideFactory()
            )

            MyCartRoute(
                myCartItems = MyCartItems,
                navigationActions = navigationActions,
                myCartViewModel = viewModel,
            )
        }
        composable(AppDestinations.FAVOURITES) { backStackEntry ->
            viewModel.setTitleBar(stringResource(R.string.favorite_title_bar))

            val viewModel: FavouritesViewModel = viewModel(
                factory = FavouritesViewModel.provideFactory()
            )

            FavouritesRoute(
                FavouritesItems,
                navigationActions = navigationActions,
                favouritesViewModel = viewModel,
                openDrawer = openDrawer,
            )
        }
//        composable(AppDestinations.ACCOUNT) { backStackEntry ->
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
    }
}