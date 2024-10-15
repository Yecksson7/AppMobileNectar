package com.example.nectarapplication.screens.filters


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.nectarapplication.MainNavActions


@Composable
fun CustomCheckbox(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF53B175), // Color verde cuando está seleccionado
                uncheckedColor = Color.Gray,      // Color gris cuando no está seleccionado
                checkmarkColor = Color.White      // Checkmark blanco
            )
        )
        Spacer(modifier = Modifier.width(8.dp)) // Espacio entre el checkbox y el texto
        Text(text = text, fontSize = 16.sp, color = Color.Black)
    }
}

@Preview
@Composable
fun FiltersPopup(navigationActions: MainNavActions) {
    var categoryEggs by remember { mutableStateOf(true) }
    var categoryNoodles by remember { mutableStateOf(false) }
    var categoryChips by remember { mutableStateOf(false) }
    var categoryFastFood by remember { mutableStateOf(false) }

    var brandIndividual by remember { mutableStateOf(false) }
    var brandCocola by remember { mutableStateOf(true) }
    var brandIfad by remember { mutableStateOf(false) }
    var brandKazi by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Full screen white background
    ) {
        // White top bar with close icon and "Filters" text
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White) // White header
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Close Button
                IconButton(onClick = { /* Acción para cerrar */ }) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }

                // Centered Filters text
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Filters",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }

        // Grey background filter section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 80.dp) // Add space from the top to start below the white header
                .background(Color(0xFFF5F5F5)) // Grey background for filter section
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // Categories Section
                    Text(
                        text = "Categories",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Column {
                        CustomCheckbox(
                            text = "Eggs",
                            checked = categoryEggs,
                            onCheckedChange = { categoryEggs = it })
                        CustomCheckbox(
                            text = "Noodles & Pasta",
                            checked = categoryNoodles,
                            onCheckedChange = { categoryNoodles = it })
                        CustomCheckbox(
                            text = "Chips & Crisps",
                            checked = categoryChips,
                            onCheckedChange = { categoryChips = it })
                        CustomCheckbox(
                            text = "Fast Food",
                            checked = categoryFastFood,
                            onCheckedChange = { categoryFastFood = it })
                    }

                    // Brand Section
                    Text(
                        text = "Brand",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    )

                    Column {
                        CustomCheckbox(
                            text = "Individual Collection",
                            checked = brandIndividual,
                            onCheckedChange = { brandIndividual = it })
                        CustomCheckbox(
                            text = "Cocola",
                            checked = brandCocola,
                            onCheckedChange = { brandCocola = it })
                        CustomCheckbox(
                            text = "Ifad",
                            checked = brandIfad,
                            onCheckedChange = { brandIfad = it })
                        CustomCheckbox(
                            text = "Kazi Farmas",
                            checked = brandKazi,
                            onCheckedChange = { brandKazi = it })
                    }

                    // Apply Filter Button
                    Button(
                        onClick = { /* Acción para aplicar filtros */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175))
                    ) {
                        Text(
                            text = "Apply Filter",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}
