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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.CircleShape
import com.example.nectarapplication.R

// Definimos las fuentes utilizando fuentes disponibles por defecto
val DefaultBold = FontFamily.SansSerif
val DefaultMedium = FontFamily.SansSerif
val DefaultRoboto = FontFamily.Default

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(title: String, onBackClick: () -> Unit) {
    // TopAppBar con color gris claro
    Surface(
        color = Color(0xFFF1F1F1), // Color gris claro solo para la Top App Bar
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp) // Tamaño limitado
    ) {
        Box(
            modifier = Modifier.fillMaxSize() // Caja contenedora para manejar la alineación
        ) {
            // Botón de retroceso alineado a la izquierda (Start)
            IconButton(
                onClick = { onBackClick() },
                modifier = Modifier.align(Alignment.CenterStart) // Alineación dentro del Box
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color(0xFF1A1A1A))
            }

            // Título centrado
            Text(
                text = title,
                fontFamily = DefaultRoboto,
                fontSize = 20.sp, // Tamaño ajustado
                fontWeight = FontWeight.Normal,
                color = Color(0xFF1A1A1A),  // Color del texto
                modifier = Modifier.align(Alignment.Center) // Centramos el texto
            )
        }
    }
}

@Composable
fun ProductCard(imageRes: Int, name: String, volume: String, price: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)), // Color del fondo de las cards
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp), // Reducimos la sombra
        modifier = Modifier
            .width(160.dp) // Ancho reducido
            .height(220.dp) // Alto ajustado
            .padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start, // Alineado a la izquierda
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight()
        ) {
            // Imagen del producto
            Image(
                painter = painterResource(imageRes),
                contentDescription = name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(90.dp) // Tamaño ajustado
                    .fillMaxWidth()
            )
            // Nombre del producto
            Text(
                text = name,
                fontFamily = DefaultBold,
                fontSize = 14.sp, // Tamaño reducido
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A),
                modifier = Modifier.padding(top = 8.dp)
            )
            // Volumen y texto "Price"
            Text(
                text = "$volume, Price",
                fontFamily = DefaultMedium,
                fontSize = 12.sp, // Tamaño reducido
                fontWeight = FontWeight.Medium,
                color = Color(0xFF7D7D7D),
                modifier = Modifier.padding(top = 4.dp)
            )
            // Alineamos el precio y el botón "+" en la parte inferior de la tarjeta
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween, // Precio a la izquierda, botón a la derecha
                verticalAlignment = Alignment.Bottom
            ) {
                // Precio alineado a la izquierda
                Text(
                    text = price,
                    fontFamily = DefaultBold,
                    fontSize = 16.sp, // Tamaño ajustado
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A)
                )
                // Botón "+"
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFF53B175), RoundedCornerShape(4.dp)) // Botón cuadrado
                        .align(Alignment.Bottom) // Alineado abajo
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeveragesScreen() {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Beverages",
                onBackClick = { /* Acción al hacer clic en el botón de retroceso */ }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF)) // Color de fondo igual al de las cards
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
            HomeIndicator() // Agregamos el Home Indicator
        }
    )
}

// Definimos el Home Indicator con sus propiedades
@Composable
fun HomeIndicator() {
    Column( // Usamos Column para poder centrar el Home Indicator
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .width(134.dp)
                .height(5.dp)
                .background(Color.Black, shape = RoundedCornerShape(topStart = 100.dp)) // Fondo negro y bordes redondeados en la parte superior
                .border(
                    width = 1.dp,
                    color = Color(0xFFE5E5E5), // Borde gris claro
                    shape = RoundedCornerShape(topStart = 100.dp)
                )
        )
    }
}

data class Product(val name: String, val volume: String, val price: String, val imageRes: Int)

@Preview(showBackground = true)
@Composable
fun BeveragesScreenPreview() {
    BeveragesScreen()
}
