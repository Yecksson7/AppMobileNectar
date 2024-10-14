package com.example.nectarapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R

@Composable
fun BottomBar(navigationActions: MainNavActions) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(12.dp))
            .clip(shape = RoundedCornerShape(12.dp),),
        containerColor = Color.White,
        tonalElevation = 5.dp,

        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.store_1),
                    contentDescription = "Shop",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                        .weight(1f)
                        .clickable { navigationActions.navigateToHome()}
                )
                Text(text = "Shop", color = Color.Black, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Explore",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                        .weight(1f)
                        .clickable { navigationActions.navigateToSearch()}
                )
                Text(text = "Explore", color = Color.Black, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = "Cart",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                        .weight(1f)
                        .clickable { navigationActions.navigateToMyCart()}
                )
                Text(text = "Cart", color = Color.Black, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.favourites),
                    contentDescription = "Favourites",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                        .weight(1f)
                        .clickable { navigationActions.navigateToFavourites()}
                )
                Text(text = "Favourites", color = Color.Black, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                        .weight(1f)
                        .clickable { navigationActions.navigateToAccount()}
                )
                Text(text = "Profile", color = Color.Black, fontSize = 12.sp)
            }
        }
    }
}