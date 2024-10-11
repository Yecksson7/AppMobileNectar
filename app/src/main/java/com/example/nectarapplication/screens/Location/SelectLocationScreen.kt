package com.example.nectarapplication.screens.Location

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectarapplication.R
import com.example.nectarapplication.data.getListaArea
import com.example.nectarapplication.data.getListaZona

@Preview(showBackground = true)
@Composable
fun SelectLocationScreen() {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.fondologin),
            contentDescription = "Onboarding Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Top) {

            Spacer(modifier = Modifier.size(100.dp))
            Image(
                painter = painterResource(id = R.drawable.image_location),
                contentDescription = "Onboarding Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )
            Spacer(modifier = Modifier.size(50.dp) )
            Text(text = "Select your location",
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.size(20.dp) )
            Text(text = "Switch on your location to stay in tune with",
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally))

            Text(text = "what's happening in your area",
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.size(50.dp) )

            AddressDropdownMenu("Your Zone",getListaZona())
            Spacer(modifier = Modifier.size(20.dp) )
            AddressDropdownMenu("Your area",getListaArea())

            Spacer(modifier = Modifier.size(60.dp) )
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(width = 250.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175)))
            {
                Text("Submit",
                    color = Color.White)
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressDropdownMenu(mensaje:String, listado: List<String>) {
    val addresses = listado
    var expanded by remember { mutableStateOf(false) }
    var selectedAddress by remember { mutableStateOf(addresses[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.background(Color.White)
    ) {
        TextField(
            value = selectedAddress,
            onValueChange = { },
            readOnly = true,
            label = { Text(mensaje) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,   // Color cuando el campo está enfocado
                unfocusedContainerColor = Color.Transparent  // Color cuando el campo no está enfocado
            )
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            addresses.forEach { address ->
                DropdownMenuItem(
                    text = { Text(address) },
                    onClick = {
                        selectedAddress = address
                        expanded = false
                    }
                )
            }
        }
    }
}