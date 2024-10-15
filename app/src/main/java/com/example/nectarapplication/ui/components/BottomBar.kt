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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

//@Composable
//fun BottomBar(navigationActions: MainNavActions) {
//    // Estado para controlar el ítem seleccionado
//    var selectedItem by remember { mutableStateOf("Shop") }
//
//    BottomAppBar(
//        modifier = Modifier
//            .fillMaxWidth()
//            .shadow(8.dp, RoundedCornerShape(12.dp))
//            .clip(shape = RoundedCornerShape(12.dp)),
//        containerColor = Color.White,
//        tonalElevation = 5.dp
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            BottomBarItem(
//                label = "Shop",
//                iconId = R.drawable.store_1,
//                selected = selectedItem == "Shop",
//                onClick = {
//                    selectedItem = "Shop" // Actualiza el estado del ítem seleccionado
//                    navigationActions.navigateToHome()
//                }
//            )
//
//            BottomBarItem(
//                label = "Explore",
//                iconId = R.drawable.search,
//                selected = selectedItem == "Explore",
//                onClick = {
//                    selectedItem = "Explore" // Actualiza el estado del ítem seleccionado
//                    navigationActions.navigateToExplore()
//                }
//            )
//
//            BottomBarItem(
//                label = "Cart",
//                iconId = R.drawable.cart,
//                selected = selectedItem == "Cart",
//                onClick = {
//                    selectedItem = "Cart" // Actualiza el estado del ítem seleccionado
//                    navigationActions.navigateToMyCart()
//                }
//            )
//
//            BottomBarItem(
//                label = "Favourites",
//                iconId = R.drawable.favourites,
//                selected = selectedItem == "Favourites",
//                onClick = {
//                    selectedItem = "Favourites" // Actualiza el estado del ítem seleccionado
//                    navigationActions.navigateToFavourites()
//                }
//            )
//
//            BottomBarItem(
//                label = "Profile",
//                iconId = R.drawable.profile,
//                selected = selectedItem == "Profile",
//                onClick = {
//                    selectedItem = "Profile" // Actualiza el estado del ítem seleccionado
//                    navigationActions.navigateToAccount()
//                }
//            )
//        }
//    }
//}
//
//@Composable
//fun BottomBarItem(
//    label: String,
//    iconId: Int,
//    selected: Boolean,
//    onClick: () -> Unit
//) {
//    val iconColor = if (selected) Color.Blue else Color.Black
//    val textColor = if (selected) Color.Blue else Color.Black
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .clickable { onClick() } // Se ejecuta el cambio de estado al hacer clic
//    ) {
//        Icon(
//            painter = painterResource(id = iconId),
//            contentDescription = label,
//            tint = iconColor,
//            modifier = Modifier.size(30.dp)
//        )
//        Text(text = label, color = textColor, fontSize = 12.sp)
//    }
//}




@Composable
fun BottomBar(navigationActions: MainNavActions) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(12.dp))
            .clip(shape = RoundedCornerShape(12.dp)
            ),
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
                        .clickable { navigationActions.navigateToExplore()}
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