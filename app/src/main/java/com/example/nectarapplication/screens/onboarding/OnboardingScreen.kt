package com.example.nectarapplication.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R


@Composable
fun OnboardingScreen(navigationActions: MainNavActions) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.backgrounonb),
            contentDescription = "Onboarding Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Image(painter = painterResource(id = R.drawable.zanahoria_blanca),
            contentDescription =null,
            modifier = Modifier
                .absoluteOffset(x = 180.dp, y = 460.dp)
                .size(50.dp)
        )
        Column(modifier = Modifier.absoluteOffset(x=80.dp, y = 540.dp),
            horizontalAlignment = CenterHorizontally){

            Text("Welcome",
                color = androidx.compose.ui.graphics.Color.White,
                fontSize = 46.sp)
            Text(" to our store",
                color = androidx.compose.ui.graphics.Color.White,
                fontSize = 46.sp,)

            Text(text = "Get your groceries in as gast as one hour",
                color = androidx.compose.ui.graphics.Color.White)
                Spacer(modifier = Modifier.size(20.dp))
            Button(onClick = { navigationActions.navigateToLogin() },
                modifier = Modifier.size(width = 250.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color(0xFF53B175))) {
                Text("Get Started",
                    color = androidx.compose.ui.graphics.Color.White)
            }
        }
    }
}









