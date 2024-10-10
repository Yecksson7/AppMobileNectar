package com.example.nectarapplication.screens.Explore

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R
import com.example.nectarapplication.data.ExploreItems
import com.example.nectarapplication.data.Products


@Composable
fun ExploreScreen(
    exploreItems: List<Products>,
    navigationActions: MainNavActions,
    paddingValues: PaddingValues,
    onToggleFavorite: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        CategoryGrid(exploreItems, navigationActions)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    val searchBar by remember { mutableStateOf("Search Store") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF4F4F4)),
    ) {
        OutlinedTextField(
            shape = RoundedCornerShape(18.dp),
            value = "",
            onValueChange = { },
            modifier = Modifier
                .size(364.dp, 51.57.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray,
                cursorColor = Color.LightGray,
                focusedTextColor = Color.LightGray,
                focusedLabelColor = Color.LightGray,
                unfocusedTextColor = Color.Gray,
            ),
            textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
            singleLine = true,
        )
        IconButton(
            onClick = { /* TODO: Acción del icono de búsqueda */ },
            modifier = Modifier
                .align(Alignment.CenterStart) // Alinear a la izquierda
                .padding(start = 12.dp) // Espaciado para el ícono
        ) {
            Icon(
                painter = painterResource(id = R.drawable.lupa___copia),
                contentDescription = "lupa",
                tint = Color.Black,
                modifier = Modifier.size(18.21.dp, 18.21.dp)
            )
        }

        Text(
            text = searchBar,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.CenterStart) // Alineación a la izquierda
                .padding(start = 60.dp) // Espaciado para evitar superposición con el ícono
                .fillMaxWidth(),
            fontSize = 16.sp
        )

        IconButton(
            onClick = { /* TODO: Acción del icono de configuración */ },
            modifier = Modifier
                .align(Alignment.CenterEnd) // Alinear a la derecha
                .padding(end = 30.dp)

        ) {
            Icon(
                painterResource(id = R.drawable.iconsetting___copia),
                contentDescription = "Settings",
                tint = Color.Black,
                modifier = Modifier.size(16.8.dp,17.85.dp)
            )
        }
    }
}

@Composable
fun CategoryGrid(
    products: List<Products>,
    navigationActions: MainNavActions,
) {
    val state = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = state
    ) {
        items(products.chunked(2)) { productPair ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CategoryCard(
                    products = productPair[0],
                    navigationActions = navigationActions
                )
                if (productPair.isNotEmpty()) {
                    CategoryCard(
                        products = productPair[1],
                        navigationActions = navigationActions
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryCard(products: Products, navigationActions: MainNavActions) {
    Card(
        border = BorderStroke(1.dp, products.borderColor),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSystemInDarkTheme()) products.backgroundColor else products.backgroundColor,

            ),
        modifier = Modifier
            .size(174.5.dp, 189.11.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(12.dp))
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp))
            .clickable {
               // navigationActions.navigateToDetail(products.id)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = products.image),
                contentDescription = products.title,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = products.title,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = Color.Black,
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
        MainNavActions(navController, scope, drawerState, snackbarHostState)
    }
    val onToggleFavorite: (String) -> Unit = { productId ->
        println("Added to favourites") // Solo imprime en la consola
    }

    ExploreScreen(
        ExploreItems,
        navigationActions,
        PaddingValues(16.dp),
        onToggleFavorite
    )
}