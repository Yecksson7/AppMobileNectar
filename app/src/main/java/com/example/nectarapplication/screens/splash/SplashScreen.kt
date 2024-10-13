package com.example.nectarapplication.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectarapplication.R
import androidx.compose.ui.graphics.Color
import com.example.nectarapplication.MainNavActions


//@Preview(showBackground = true)
@Composable
fun SplashScreen(navigationActions: MainNavActions) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF53B175))
        .clickable { navigationActions.navigateToOnboarding()})//agrege la ruta de onboarding y el parametro que recibe la funcion
    {
        Column (modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center)
        {
            Image(painter = painterResource(id = R.drawable.logo_splash),
                contentDescription =null,
                modifier = Modifier
                    .size(190.dp)
            )


        }



    }
}