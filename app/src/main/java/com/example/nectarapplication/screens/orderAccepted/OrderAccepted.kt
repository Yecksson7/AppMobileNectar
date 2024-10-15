package com.example.nectarapplication.screens.orderAccepted

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.nectarapplication.R

@Composable
fun OrderAcceptedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fondo blanco
    ) {
        // Logo del tildé verde
        Image(
            painter = painterResource(id = R.drawable.tilde_verde), // Reemplaza con el recurso correcto de la imagen
            contentDescription = "Order Accepted",
            modifier = Modifier
                .width(269.08.dp)
                .height(240.31.dp)
                .absoluteOffset(x = 58.46.dp, y = 151.7.dp)
        )

        // Texto "Your Order has been accepted"
        Text(
            text = "Your Order has been\naccepted",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .width(265.dp)
                .height(68.dp)
                .absoluteOffset(x = 74.5.dp, y = 458.67.dp)
        )

        // Texto "Your items has been placed..."
        Text(
            text = "Your items has been placed and is on\nits way to being processed",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier
                .width(278.dp)
                .height(42.dp)
                .absoluteOffset(x = 68.dp, y = 546.67.dp)
        )

        // Botón verde "Track Order"
        Button(
            onClick = { /* Acción para rastrear la orden */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175)),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .width(364.dp)
                .height(67.dp)
                .absoluteOffset(x = 25.01.dp, y = 673.5.dp) // Ajustamos la posición hacia arriba
        ) {
            Text(
                text = "Track Order",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        // Botón blanco "Back to home"
        Button(
            onClick = { /* Acción para regresar a home */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .width(364.dp)
                .height(67.dp)
                .absoluteOffset(x = 25.01.dp, y = 750.5.dp) // Ajustamos la posición hacia arriba
        ) {
            Text(
                text = "Back to home",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderAcceptedScreenPreview() {
    OrderAcceptedScreen()
}
