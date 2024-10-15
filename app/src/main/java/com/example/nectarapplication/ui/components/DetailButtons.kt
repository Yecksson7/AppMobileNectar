package com.example.nectarapplication.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nectarapplication.R
import com.example.nectarapplication.ui.themes.softGreen

@Composable
fun DetailButtons() {
    var number by remember { mutableIntStateOf(1) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(8.dp)

    ) {
        IconButton(
            onClick = {
                if (number > 1) number -= 1
            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.menos),
                contentDescription = "Restar",
                tint = Color.Gray,
            )
        }
        Box(
            modifier = Modifier
                .border(
                    1.5.dp,
                    Color.Gray,
                    RoundedCornerShape(12.dp)
                )
                .height(40.dp)
                .padding(horizontal = 16.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Text(
                color = Color.Black,
                text = number.toString(),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        IconButton(
            onClick = {
                number += 1
            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.mas),
                contentDescription = "Sumar",
                tint = softGreen
            )
        }
    }
}