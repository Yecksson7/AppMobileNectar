package com.example.nectarapplication

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.nectarapplication.ui.components.BottomBar
import com.example.nectarapplication.ui.components.TopBar
import com.example.nectarapplication.ui.themes.NectarApplicationTheme
import com.example.nectarapplication.ui.themes.WhiteApp
import kotlinx.coroutines.launch



//@Composable
//fun AppNectarShop(
//    viewModel: MainActivityViewModel = viewModel(factory = MainActivityViewModel.Factory),
//    drawerState: DrawerState
//) {
//    NectarApplicationTheme {
//
//        val navController = rememberNavController()
//        val scope = rememberCoroutineScope()
//        val snackbarHostState = remember { SnackbarHostState() }
//        val title: String by viewModel.titleBar.observeAsState(stringResource(R.string.title_bar_default))
//
//
//        val navigationActions = remember(navController) {
//            MainNavActions(navController, scope, drawerState, snackbarHostState)
//        }
//
//        if (drawerState.isOpen) {
//            BackHandler {
//                scope.launch {
//                    drawerState.close()
//                }
//            }
//        }
//
//            Scaffold(
//
//                containerColor = WhiteApp,
//                topBar = {
//                    TopBar(title, scope, drawerState, snackbarHostState, viewModel)
//                },
//                bottomBar = {
//                    BottomBar(navController)
//                },
//                modifier = Modifier.fillMaxSize()
//            ) { innerPadding ->
//                MainRouteNavGraph(
//                    modifier = Modifier.padding(innerPadding),
//                    navController = navController,
//                    viewModel = viewModel,
//                    openDrawer = {
//                        scope.launch {
//                            drawerState.open()
//                        }
//                    },
//                    navigationActions = navigationActions
//                )
//            }
//        }
//    }
//
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    val drawerState = rememberDrawerState(initialValue = Closed)
//    AppNectarShop(drawerState = drawerState)
//}