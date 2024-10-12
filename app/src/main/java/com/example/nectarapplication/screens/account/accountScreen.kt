package com.example.nectarapplication.screens.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectarapplication.R

//@Preview(showBackground = true)
@Composable
fun AccountScreen() {
    Box(modifier = Modifier.fillMaxSize()){
        Column {

            Spacer(modifier = Modifier.size(50.dp))
            Row(modifier = Modifier.padding(16.dp)){




                Image(
                    painter = painterResource(id = R.drawable.foto_account),
                    contentDescription = "Onboarding Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(10.dp) // Ajusta
                )
            }
            Text("Account Screen")
        }
    }

}



