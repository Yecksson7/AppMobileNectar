package com.example.nectarapplication.screens.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R


@Composable
fun CheckoutPopupScreen(navigationActions: MainNavActions) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Fondo con mayor oscurecimiento
        Image(
            painter = painterResource(id = R.drawable.fondo_check_out), // Reemplaza con tu imagen de fondo
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    alpha = 0.5f // Oscurecemos un poco más la imagen de fondo
                }
        )

        // Box que contiene el PopUp y permite posicionar el botón con .align
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Pop-up con fondo blanco y mayor separación entre los elementos
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp) // Ajustamos el tamaño del pop-up
                    .absoluteOffset(y = 200.dp) // Alineamos el pop-up más arriba
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(16.dp)
            ) {
                Column {
                    // Título y botón de cerrar más arriba
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Checkout", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        IconButton(onClick = { /* Acción para cerrar */ }) {
                            Icon(Icons.Default.Close, contentDescription = "Close")
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp)) // Espacio reducido entre el título y los items


                    CheckoutOptionWithArrow(label = "Delivery", value = "Select Method")
                    Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
                    CheckoutOptionWithArrow(label = "Payment", value = "", iconRes = R.drawable.payment_checkout)
                    Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
                    CheckoutOptionWithArrow(label = "Promo Code", value = "Pick discount")
                    Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
                    CheckoutOptionWithArrow(label = "Total Cost", value = "$13.97")

                    Spacer(modifier = Modifier.height(16.dp)) // Espacio reducido entre los elementos y el texto

                    // Texto de términos y condiciones con "Terms" y "Conditions" en negrita
                    Text(
                        text = "By placing an order you agree to our\n",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Row {
                        Text(text = "Terms ", fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                        Text(text = "And ", fontSize = 12.sp, color = Color.Gray)
                        Text(text = "Conditions", fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(16.dp)) // Espacio reducido entre el texto y el botón
                }
            }

            // Botón "Place Order" superpuesto al botón de fondo
            Button(
                onClick = { /* Acción de Place Order */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(67.dp)
                    .align(Alignment.BottomCenter) // Alineamos el botón en la parte inferior
                    .absoluteOffset(y = (-25).dp), // Subimos un poco el botón para que coincida con el de fondo
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175)) // Color hsla(142, 38%, 51%, 1)
            ) {
                Text(text = "Place Order", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun CheckoutOptionWithArrow(label: String, value: String, iconRes: Int? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, fontSize = 16.sp, color = Color.Gray)
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (iconRes != null) {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            } else {
                Text(text = value, fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(8.dp))


            Icon(
                painter = painterResource(id = R.drawable.close_check_out), // Reemplaza con el ícono de flecha correcto
                contentDescription = "Back Arrow",
                modifier = Modifier.size(8.4.dp, 14.dp) // Tamaño de la flecha
            )
        }
    }
}
