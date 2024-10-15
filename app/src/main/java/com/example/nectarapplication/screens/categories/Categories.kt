package com.example.nectarapplication.screens.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R


val DefaultBold = FontFamily.SansSerif
val DefaultMedium = FontFamily.SansSerif
val DefaultRoboto = FontFamily.Default


@Composable
fun CustomTopAppBar(title: String, onBackClick: () -> Unit) {
    // TopAppBar con color gris claro
    Surface(
        color = Color(0xFFF1F1F1),
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            IconButton(
                onClick = { onBackClick() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color(0xFF1A1A1A))
            }


            Text(
                text = title,
                fontFamily = DefaultRoboto,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF1A1A1A),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun ProductCard(imageRes: Int, name: String, volume: String, price: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier
            .width(160.dp)
            .height(220.dp)
            .padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight()
        ) {

            Image(
                painter = painterResource(imageRes),
                contentDescription = name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth()
            )

            Text(
                text = name,
                fontFamily = DefaultBold,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A),
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "$volume, Price",
                fontFamily = DefaultMedium,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF7D7D7D),
                modifier = Modifier.padding(top = 4.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {

                Text(
                    text = price,
                    fontFamily = DefaultBold,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A)
                )

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFF53B175), RoundedCornerShape(4.dp))
                        .align(Alignment.Bottom)
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}


@Composable
fun BeveragesScreen(navigationActions: MainNavActions) {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Beverages",
                onBackClick = { navigationActions.navigateToExplore() }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF))
                    .padding(paddingValues)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                ) {
                    items(listOf(
                        Product("Diet Coke", "355ml", "$1.99", R.drawable.cocalight),
                        Product("Sprite Can", "325ml", "$1.50", R.drawable.sprite),
                        Product("Apple & Grape Juice", "2L", "$15.99", R.drawable.jugo_manzana1),
                        Product("Orange Juice", "2L", "$15.99", R.drawable.jugo_naranja1),
                        Product("Coca Cola Can", "325ml", "$4.99", R.drawable.coca),
                        Product("Pepsi Can", "330ml", "$4.99", R.drawable.pepsi)
                    )) { product ->
                        ProductCard(
                            imageRes = product.imageRes,
                            name = product.name,
                            volume = product.volume,
                            price = product.price
                        )
                    }
                }
            }
        },
        bottomBar = {
            HomeIndicator()
        }
    )
}


@Composable
fun HomeIndicator() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .width(134.dp)
                .height(5.dp)
                .background(Color.Black, shape = RoundedCornerShape(topStart = 100.dp))
                .border(
                    width = 1.dp,
                    color = Color(0xFFE5E5E5),
                    shape = RoundedCornerShape(topStart = 100.dp)
                )
        )
    }
}

data class Product(val name: String, val volume: String, val price: String, val imageRes: Int)


@Composable
fun BeveragesScreenPreview(navigationActions: MainNavActions) {
    BeveragesScreen(navigationActions)
}
