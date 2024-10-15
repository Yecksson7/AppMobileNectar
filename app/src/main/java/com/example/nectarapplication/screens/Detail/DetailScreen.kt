package com.example.nectarapplication.screens.Detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R
import com.example.nectarapplication.data.DetailProducts
import com.example.nectarapplication.ui.components.ButtonFav
import com.example.nectarapplication.ui.components.DetailButtons
import com.example.nectarapplication.ui.themes.WhiteApp
import com.example.nectarapplication.ui.themes.colorBoxDetail
import com.example.nectarapplication.ui.themes.naranjaEstrellas

@Composable
fun DetailScreen(
    detailProduct: DetailProducts,
    navActions: MainNavActions
) {

    Column(
        modifier = Modifier
            .background(WhiteApp)
            .fillMaxSize()
    )
    {
        TopBarBack(stringResource(id = R.string.detail_title_bar), navActions)

        Box(
            modifier = Modifier
                .background(colorBoxDetail)
                .size(413.6.dp, 280.44.dp)
                .align(Alignment.Start)
        ) {

            Image(
                painterResource(id = detailProduct.image),
                contentDescription = "Detail Product",
                modifier = Modifier
                    .size(300.34.dp, 150.18.dp)
                    .align(Alignment.Center),

                )
            Icon(
                painter = painterResource(id = R.drawable.subir),
                contentDescription = "subir",
                tint = Color.Black,
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
            )
        }
        Row {
            Column {
                Text(
                    text = detailProduct.title,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)

                )
                Text(
                    text = detailProduct.porcion,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )

                DetailButtons()
            }
            Spacer(modifier = Modifier.width(155.dp))
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.corazongris),
                    contentDescription = "fav",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(45.dp)
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    text = "$" + detailProduct.precio,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            color = Color.LightGray,
        )
        Row {

            Text(
                text = "Product Detail",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(6.dp)
            )
            Spacer(modifier = Modifier.width(216.dp))
            Icon(
                painter = painterResource(id = R.drawable.flechitaabajo),
                contentDescription = "flechitaabjo",
                tint = Color.Black,
                modifier = Modifier
                    .size(38.dp)
                    .padding(8.dp)
            )
        }
        Text(
            text = detailProduct.productDetail,
            color = Color.DarkGray,
            fontSize = 12.sp,
            lineHeight = 14.sp,
            modifier = Modifier
                .padding(6.dp)
        )
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            color = Color.LightGray,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(6.dp)
        ) {
            Text(
                text = "Nutritions",
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(165.dp))

            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .background(Color.LightGray, RoundedCornerShape(12.dp))
                    .width(35.dp)
                    .height(30.dp)

            ) {
                Text(
                    color = Color.Black,
                    text = "100gm",
                    fontSize = 7.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.width(33.dp))

            Icon(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "go",
                tint = Color.Black,
                modifier = Modifier
                    .size(38.dp)
                    .padding(8.dp)
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            color = Color.LightGray,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(6.dp)
        ) {
            Text(
                text = "Review",
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(94.dp))
            Icon(
                painter = painterResource(id = R.drawable.cincoestrellasnaranjas),
                contentDescription = "go",
                tint = naranjaEstrellas,
                modifier = Modifier
                    .size(200.dp, 14.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "go",
                tint = Color.Black,
                modifier = Modifier
                    .size(23.dp)

            )
        }
    }
    ButtonFav("Add To Basket")
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarBack(title: String, navActions: MainNavActions) {
    TopAppBar(
        title = { Text(text = title, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center) },
        navigationIcon = {
            IconButton(onClick = { navActions.navigateToHome() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.flechaizquierda),
                    contentDescription = "volver"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFFCFCFC)
        )
    )
}

//@Preview("Explore Screen", showBackground = true)
//@Preview("Explore Screen (dark)", uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun GreetingPreview() {
//
//    DetailScreen(
//        detailProduct = DetailItems[1],
//        navActions = MainNavActions()
//    )
//}