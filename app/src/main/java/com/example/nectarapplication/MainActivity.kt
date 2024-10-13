package com.example.nectarapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val navActions = MainNavActions(navController, scope, drawerState)

            MainNavGraph(
                navController = navController,
                startDestination = AppDestinations.SPLASH_ROUTE,
                navigationActions = navActions
            )
        }
    }
}
//class MainActivity : ComponentActivity() {
//
//    private val viewModel: MainActivityViewModel by viewModels { MainActivityViewModel.Factory }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        enableEdgeToEdge()
//
//        setContent {
//
//            val drawerState = rememberDrawerState(initialValue = Closed)
//            val drawerOpen by viewModel.drawerShouldBeOpened.collectAsStateWithLifecycle()
//
//            if (drawerOpen) {
//                LaunchedEffect(Unit) {
//                    try {
//                        drawerState.open()
//                    } finally {
//                        viewModel.resetOpenDrawerAction()
//                    }
//                }
//            }
//
//            val scope = rememberCoroutineScope()
//            if (drawerState.isOpen) {
//                BackHandler {
//                    scope.launch {
//                        viewModel.resetOpenDrawerAction()
//                    }
//                }
//            }
//
//            AppBootShop(viewModel, drawerState)
//        }
//    }
//}