package com.example.nectarapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels


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