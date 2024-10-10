package com.example.nectarapplication.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue.Closed
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
import androidx.navigation.compose.rememberNavController
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R
import com.example.nectarapplication.ui.themes.Purple40
import com.example.nectarapplication.ui.themes.WhiteApp
import com.example.nectarapplication.ui.themes.softGreen

@Composable
fun HomeScreen(navigationActions: MainNavActions, innerPadding: PaddingValues, onToggleFavorite: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        LocationBar()
        ExclusiveOfferSection()
        BestSellingSection()
    }
}

@Composable
fun LocationBar() {
    Column {
        Text(
            text = stringResource(R.string.home_screen_title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            color = Color.DarkGray
        )
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Fresh vegetables",
            modifier = Modifier
                .size(400.dp, 150.dp)
                .align(Alignment.CenterHorizontally),
//            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun ExclusiveOfferSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Exclusive Offer", color = Color.Black, style = MaterialTheme.typography.headlineMedium)
            Text(text = "See all", color = softGreen, style = MaterialTheme.typography.bodySmall)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProductCard(name = "Organic Bananas", cant = "7pcs, Priceg", price = "$4.99", image = R.drawable.banana)
            ProductCard(name = "Red Apple", cant = "1kgs, Priceg", price = "$4.99", image = R.drawable.manzanas)
            ProductCard(name = "Red Apple", cant = "250g, Priceg", price = "$4.99", image = R.drawable.jengibre)
        }
    }
}

@Composable
fun ProductCard(name: String, cant: String, price: String, image: Int) {
    Card(
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSystemInDarkTheme()) WhiteApp else Purple40
        ),
        modifier = Modifier
            .size(190.dp, 250.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(8.dp))
//            .clickable { navigationActions.navigateToDetail(.id) }

    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = name,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 12.sp,
                color = Color.Black,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = cant,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 10.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(
                    text = price,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    textAlign = TextAlign.Left,

                    )
                Spacer(modifier = Modifier.size(75.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = softGreen
                    ),
                    onClick = {
                        // navigationActions.navigateToDetail(boot.id)
                    },
                    modifier = Modifier
                        .height(30.dp)
                        .width(32.dp)
                ) {
                    Text(
                        text = "+",
                        style = typography.displayMedium,
                        modifier = Modifier.fillMaxWidth(),  // Asegura que el texto ocupe todo el ancho
                        textAlign = TextAlign.Center,        // Alinea el texto al centro
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun BestSellingSection() {
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
                color = Color.Green,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProductCard(
                name = "Bell Pepper Red",
                cant = "1kg, Priceg",
                price = "$3.99",
                image = R.drawable.morrones
            )
            ProductCard(
                name = "Ginger",
                cant = "250gr, Priceg",
                price = "$1.99",
                image = R.drawable.jengibre
            )
        }
    }
}


@Preview("List Screen", showBackground = true)
@Preview("List Screen (dark)", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = Closed)
    val snackbarHostState = remember { SnackbarHostState() }
    val navigationActions = remember(navController) {
        MainNavActions(navController, scope, drawerState, snackbarHostState)
    }
    val onToggleFavorite: (String) -> Unit = { bootId ->
        println("Added to favourites") // Solo imprime en la consola
    }

    HomeScreen(
        navigationActions,
        PaddingValues(16.dp),
        onToggleFavorite
    )
}