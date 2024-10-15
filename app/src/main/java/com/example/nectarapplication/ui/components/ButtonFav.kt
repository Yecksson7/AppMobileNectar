package com.example.nectarapplication.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.nectarapplication.ui.themes.softGreen

@Composable
fun ButtonFav(text: String) {
    val buttonColor = softGreen

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 24.89.dp)
    ) {
        Button(
            shape = RoundedCornerShape(18.dp),
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = buttonColor
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(364.dp, 67.dp)
        ) {
            Text(
                text = text,
                style = typography.bodySmall,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
}