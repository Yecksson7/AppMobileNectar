package com.example.nectarapplication.screens.MyCart

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R
import com.example.nectarapplication.data.CartProducts
import com.example.nectarapplication.data.MyCartItems
import com.example.nectarapplication.ui.components.ButtonCart
import com.example.nectarapplication.ui.components.CartButtons
import com.example.nectarapplication.ui.themes.WhiteApp
import com.example.nectarapplication.ui.themes.softGreen

@Composable
fun MyCartScreen(
    cartProduct: List<CartProducts>,
    navigationActions: MainNavActions,
) {
    val state = rememberLazyListState()
    val totalPrice = cartProduct.sumOf { it.precio }

    Column(modifier = Modifier
        .background(WhiteApp)
        .fillMaxSize()) {

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(), // Ancho fijo de la línea
            color = Color.LightGray,
        )
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
                    if (index != productCart.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp),
                            color = Color.LightGray,
                        )
                    }
                }
            }
        }
    }
    ButtonCart(totalPrice)
}

@Composable
fun CartProduct(cartProduct: CartProducts, navigationActions: MainNavActions) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp, horizontal = 16.dp), // Añadimos espacio entre los elementos
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen del producto
        Image(
            painter = painterResource(id = cartProduct.image),
            contentDescription = cartProduct.title,
            modifier = Modifier
                .padding(20.dp)
                .size(70.dp) // Tamaño de la imagen ajustado
        )

        Spacer(modifier = Modifier.width(6.dp)) // Espacio entre imagen y texto

        // Columna con título, porción y botones
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f) // Ocupa el espacio restante
        ) {
            Text(text = cartProduct.title, color = Color.Black, style = MaterialTheme.typography.bodyMedium)
            Text(text = cartProduct.porcion, color = Color.Gray, style = MaterialTheme.typography.bodySmall)
            CartButtons() // Botones de aumentar/disminuir cantidad
        }

        // Columna con icono de cierre y precio
        Column(
            horizontalAlignment = Alignment.End, // Alineamos al final (derecha)
            verticalArrangement = Arrangement.SpaceBetween, // Espacio entre icono y precio
        ) {
            Icon(
                painter = painterResource(id = R.drawable.equis),
                contentDescription = "close",
                tint = Color.Gray,
                modifier = Modifier
                    .size(14.dp)
            )
            Spacer(modifier = Modifier.height(50.dp)) // Separación entre icono y precio
            Text(
                text = "$${cartProduct.precio}",
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
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
    val navigationActions = remember(navController) {
        MainNavActions(navController, scope, drawerState)
    }

    MyCartScreen(
        MyCartItems,
        navigationActions,
    )
}
