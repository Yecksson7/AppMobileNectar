package com.example.nectarapplication.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R
import com.example.nectarapplication.data.CartProducts
import com.example.nectarapplication.data.HomeProducts
import com.example.nectarapplication.screens.account.TopBarWithMenu
import com.example.nectarapplication.ui.components.BottomBar
import com.example.nectarapplication.ui.themes.Purple40
import com.example.nectarapplication.ui.themes.WhiteApp
import com.example.nectarapplication.ui.themes.softGreen

@Composable
fun HomeScreen(navController: NavHostController, cartProducts: List<CartProducts>, navigationActions: MainNavActions) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        TopBarWithMenu(stringResource(id = R.string.list_title_bar))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(WhiteApp)
                .verticalScroll(rememberScrollState())
        ) {
            LocationBar()
            ExclusiveOfferSection(cartProducts, navigationActions, navController)
            BestSellingSection(cartProducts, navigationActions, navController)
        }
        BottomBar(navigationActions)
    }
}

@Composable
fun LocationBar() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(R.string.home_screen_title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            color = Color.DarkGray
        )
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Fresh vegetables",
            modifier = Modifier
                .size(368.2.dp, 114.99.dp)
                .align(Alignment.CenterHorizontally),
        )
    }
}


@Composable
fun ExclusiveOfferSection(cartProducts: List<CartProducts>, navigationActions: MainNavActions, navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Text(
                text = "Exclusive Offer",
                color = Color.Black,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "See all",
                color = softGreen,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow( // Cambia a LazyRow para mostrar los productos en fila
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(cartProducts) { product ->  // Cambié 'cartProducts' a 'product'
                ProductCard(
                    cartProducts = product,
                    navigationActions = navigationActions,
                    navController = navController,
                )
            }
        }
    }
}

@Composable
fun ProductCard(cartProducts: CartProducts, navigationActions: MainNavActions, navController: NavHostController) {
    Card(
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSystemInDarkTheme()) WhiteApp else Purple40
        ),
        modifier = Modifier
            .size(175.dp, 235.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(8.dp))
            .clickable { navController.navigate("Detail/${cartProducts.id}") },
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = cartProducts.image), // Cambié 'cartProducts.id' a 'cartProducts.imageResId'
                contentDescription = cartProducts.title,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = cartProducts.title,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = cartProducts.porcion,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 10.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(
                    text = "$${cartProducts.precio}", // Agregué el signo de dólar para el precio
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    textAlign = TextAlign.Justify,
                )
                Spacer(modifier = Modifier.size(45.dp))

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(15.dp)
                        .background(softGreen, shape = RoundedCornerShape(18.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.mas),
                        contentDescription = "Sumar",
                        tint = Color.White
                    )
                }

            }
        }
    }
}

@Composable
fun BestSellingSection(cartProducts: List<CartProducts>, navigationActions: MainNavActions, navController: NavHostController) {
    val startingPosition = 2
    val itemsToDisplay = cartProducts.drop(startingPosition) + cartProducts.take(startingPosition)


    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Best Selling",
                color = Color.Black,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "See all",
                color = softGreen,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(itemsToDisplay) { product ->
                    ProductCard(
                        cartProducts = product,
                        navigationActions = navigationActions,
                        navController = navController
                    )
                }
            }
        }
    }
}


@Preview("Home Screen", showBackground = true)
@Preview("Home Screen (dark)", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = Closed)
    val snackbarHostState = remember { SnackbarHostState() }
    val navigationActions = remember(navController) {
        MainNavActions(navController, scope, drawerState)
    }

    HomeScreen(
        navController,
        HomeProducts,
        navigationActions,

    )
}