package com.example.nectarapplication.screens.Favourites

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R
import com.example.nectarapplication.data.CartProducts
import com.example.nectarapplication.data.FavouritesItems
import com.example.nectarapplication.screens.account.TopBarWithMenu
import com.example.nectarapplication.ui.components.BottomBar
import com.example.nectarapplication.ui.components.ButtonFav
import com.example.nectarapplication.ui.themes.WhiteApp
import com.example.nectarapplication.ui.themes.softGreen

@Composable
fun FavouritesScreen(
    cartProduct: List<CartProducts>,
    navigationActions: MainNavActions,
) {
    val state = rememberLazyListState()
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .background(WhiteApp)
                .fillMaxSize()
        ) {
            TopBarWithMenu(stringResource(id = R.string.favorite_title_bar))
            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(), // Ancho fijo de la línea
                color = Color.LightGray,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    state = state
                ) {
                    items(cartProduct.chunked(4)) { productCart ->
                        productCart.forEachIndexed { index, cartProduct ->
                            CartProduct(
                                cartProduct = cartProduct,
                                navigationActions = navigationActions
                            )
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 40.dp),
                                color = Color.LightGray,
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    ButtonFav("Add All To Cart")
                }

                BottomBar(navigationActions = navigationActions)
            }
        }
    }
}

@Composable
fun CartProduct(cartProduct: CartProducts, navigationActions: MainNavActions) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp, horizontal = 8.dp), // Añadimos espacio entre los elementos
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = cartProduct.image),
            contentDescription = cartProduct.title,
            modifier = Modifier
                .padding(20.dp)
                .size(65.dp) // Tamaño de la imagen ajustado
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f) // Ocupa el espacio restante
        ) {
            Text(
                modifier = Modifier
                    .wrapContentWidth(),
                text = cartProduct.title,
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.size(76.dp, 18.dp),
                text = cartProduct.porcion,
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "$${cartProduct.precio}",
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "go",
                tint = Color.Black,
                modifier = Modifier
                    .size(14.dp)
            )
        }
    }
}


@Composable
fun CartButtons() {
    var number by remember { mutableIntStateOf(1) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(8.dp)

    ) {
        // Botón de restar
        IconButton(
            onClick = {
                if (number > 1) number -= 1
            },
            modifier = Modifier
                .border(1.5.dp, Color.Gray, RoundedCornerShape(12.dp))

        ) {
            Icon(
                painter = painterResource(id = R.drawable.menos), // Icono de "menos"
                contentDescription = "Restar",
                tint = Color.Gray,
            )
        }

        // Número actual
        Text(
            color = Color.Black,
            text = number.toString(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Botón de sumar
        IconButton(
            onClick = {
                number += 1
            },
            modifier = Modifier
                .border(1.5.dp, Color.Gray, RoundedCornerShape(12.dp))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.mas), // Icono de "más"
                contentDescription = "Sumar",
                tint = softGreen
            )
        }
    }
}


@Preview("Explore Screen", showBackground = true)
@Preview("Explore Screen (dark)", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = Closed)
    val snackbarHostState = remember { SnackbarHostState() }
    val navigationActions = remember(navController) {
        MainNavActions(navController, scope, drawerState)
    }
    val onToggleFavorite: (String) -> Unit = { productId ->
        println("Added to favourites") // Solo imprime en la consola
    }

    FavouritesScreen(
        FavouritesItems,
        navigationActions,
    )
}