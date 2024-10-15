package com.example.nectarapplication.screens.search


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R
import com.example.nectarapplication.screens.account.TopBarWithMenu
import com.example.nectarapplication.ui.components.BottomBar


@Composable
fun SearchScreen(navActions: MainNavActions) {
    Scaffold(
        topBar = { TopBarWithMenu(stringResource(id = R.string.search_title_bar)) },
        bottomBar = { BottomBar(navActions) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF))
                    .padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(16.dp)) // Espacio para colocar entre la Top App Bar y la barra de búsqueda
                SearchBar()
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(
                        start = 24.dp,
                        end = 24.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                ) {
                    // Cards de productos
                    items(listOf(
                        Product("Egg Chicken Red", "4pcs", "$1.99", R.drawable.huevos),
                        Product("Egg Chicken White", "180g", "$1.50", R.drawable.huevos2),
                        Product("Egg Pasta", "30gm", "$15.99", R.drawable.pasta1),
                        Product("Egg Noodles", "2L", "$15.99", R.drawable.pasta2),
                        Product("Mayonnaise", "500g", "$2.99", R.drawable.mayo),
                        Product("Egg Noodles Package", "1kg", "$3.49", R.drawable.ultima)
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
        }
    )
    HomeIndicator()
}

@Composable
fun SearchTopAppBar() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { /* Acción del botón de menú */ }
            ) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color(0xFF1A1A1A))
            }

            Text(
                text = "Search",
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A),
                modifier = Modifier.align(Alignment.CenterVertically),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.width(48.dp)) // Espacio para mantener el texto centrado
        }
    }
}

@Composable
fun SearchBar() {
    // barra de búsqueda gris con propiedades
    Surface(
        color = Color(0xFFF5F5F5),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 8.dp)
            .height(52.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF5F5F5)) // Color de fondo gris
    ) {
        TextField(
            value = "Egg",
            onValueChange = { /* Actualizar valor */ },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color(0xFF7D7D7D))
            },
            placeholder = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .height(51.57.dp) // Ajustamos la altura a la especificada
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(12.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF5F5F5),
                unfocusedContainerColor = Color(0xFFF5F5F5),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

//@Composable
//fun BottomNavigationBar() {
//    // Barra de navegación inferior con íconos más grandes y sin texto, y sombra en el contorno superior
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(92.dp)
//            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
//            .shadow(4.dp, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)), // Sombra al contorno superior
//        color = Color.White
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp),
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            BottomBarItem(iconRes = R.drawable.shopsearch)
//            BottomBarItem(iconRes = R.drawable.exploreseach, tint = Color(0xFF53B175))
//            BottomBarItem(iconRes = R.drawable.carritosearch)
//            BottomBarItem(iconRes = R.drawable.favourites)
//            BottomBarItem(iconRes = R.drawable.accountsearch)
//        }
//    }
//}
//
//@Composable
//fun BottomBarItem(iconRes: Int, tint: Color = Color.Black) {
//    // Íconos más grandes y sin texto en la Bottom Bar
//    Icon(
//        painter = painterResource(id = iconRes),
//        contentDescription = null, // Quitamos el texto para evitar duplicación
//        tint = tint,
//        modifier = Modifier.size(36.dp) // Aumentamos el tamaño de los íconos
//    )
//}

@Composable
fun HomeIndicator() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp) // Aseguramos espacio en la parte inferior
            .offset(y = (-16).dp), // Movemos la barra ligeramente hacia arriba para que se superponga a la Bottom Bar
        contentAlignment = Alignment.BottomCenter // Centrado en la parte inferior
    ) {
        Box(
            modifier = Modifier
                .width(148.dp)
                .height(5.dp) // Ajustamos la altura
                .background(Color(0xFFBEBEBE), RoundedCornerShape(50)) // Color gris claro y bordes redondeados
        )
    }
}

//  tarjetas de productos
@Composable
fun ProductCard(imageRes: Int, name: String, volume: String, price: String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier
            .width(173.32.dp)
            .height(248.51.dp)
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
                    .size(100.dp)
                    .fillMaxWidth()
            )
            Text(
                text = name,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A),
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "$volume, Price",
                fontFamily = FontFamily.SansSerif,
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
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A)
                )
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFF53B175), RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

data class Product(val name: String, val volume: String, val price: String, val imageRes: Int)

//@Preview(showBackground = true)
//@Composable
//fun SearchScreenPreview() {
//    val navActions = MainNavActions
//    SearchScreen(navActions)
//}


