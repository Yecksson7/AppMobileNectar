package com.example.nectarapplication.screens.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R
import com.example.nectarapplication.ui.components.BottomBar
//import androidx.compose.foundation.layout.Arrangement



//@Preview(showBackground = true)
@Composable
fun AccountScreen(navigationActions: MainNavActions) {
    var isDarkTheme by remember { mutableStateOf(false) }
    MaterialTheme(
        colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Column(verticalArrangement = Arrangement.Top) {
                TopBarWithMenu("Account")

                Row(modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(id = R.drawable.foto_account),
                        contentDescription = "Onboarding Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(10.dp)
                    )

                    descriptionAccount()
                }
                Divider(color = Color(0xFFE2E2E2), thickness = 1.dp)
                barraAccount(icon = painterResource(id = R.drawable.orders_icon), "Orders")
                Divider(color = Color(0xFFE2E2E2), thickness = 1.dp)
                barraAccount(icon = painterResource(id = R.drawable.mydetails), "My Details")
                Divider(color = Color(0xFFE2E2E2), thickness = 1.dp)
                barraAccount(icon = painterResource(id = R.drawable.delicery_address), "Delivery Address")
                Divider(color = Color(0xFFE2E2E2), thickness = 1.dp)
                barraAccount(icon = painterResource(id = R.drawable.payment), "Payment Methods")
                Divider(color = Color(0xFFE2E2E2), thickness = 1.dp)
                barraAccount(icon = painterResource(id = R.drawable.bell_icon), "Notifications")
                Divider(color = Color(0xFFE2E2E2), thickness = 1.dp)
                barraAccount(icon = painterResource(id = R.drawable.help_icon), "Help")
                Divider(color = Color(0xFFE2E2E2), thickness = 1.dp)
                /*Row(
                    modifier = Modifier
                        .padding(vertical = 3.dp)
                        .padding(horizontal = 40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = if (isDarkTheme) "Dark Mode" else "Light Mode")
                    Spacer(modifier = Modifier.weight(1f))
                    Switch(
                        checked = isDarkTheme,
                        onCheckedChange = { isDarkTheme = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color(0xFF53B175)
                        )
                    )
                }*/
                Divider(color = Color(0xFFE2E2E2), thickness = 1.dp)
                SwitchDarkMode(isDarkTheme, onCheckedChange = { isDarkTheme = it })
                Divider(color = Color(0xFFE2E2E2), thickness = 1.dp)
                Spacer(modifier = Modifier.size(50.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.size(width = 300.dp, height = 60.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF2F3F2))
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.icono_logout), // Reemplaza con el ID de tu icono
                                contentDescription = null,
                                modifier = Modifier.size(17.dp) // Ajusta el tamaño del icono según sea necesario
                            )
                            Spacer(modifier = Modifier.size(20.dp)) // Espacio entre el icono y el texto
                            Text(
                                text = "Log Out",
                                color = Color(0xFF53B175),

                            )
                        }
                    }
                }



            }
            Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom){
                BottomBar(navigationActions)
            }

        }
    }

}


@Composable
fun SwitchDarkMode(isDarkTheme: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .padding(vertical = 3.dp)
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = if (isDarkTheme) "Dark Mode" else "Light Mode",
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            fontSize = 15.sp)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isDarkTheme,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF53B175)
            )
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithMenu(title: String) {
    TopAppBar(
        title = { Text(text = title, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center) },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.tree_line_icon),
                    contentDescription = "Menu"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFFCFCFC)
        )
    )
}


//@Preview(showBackground = true)
@Composable
fun descriptionAccount(){
    Column (){
        Row {
            Text(text = "Afsar Hoseen",
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, fontSize = 17.sp)
            Spacer(modifier = Modifier.size(10.dp))
            Image(
                painter = painterResource(id = R.drawable.lapiz), // Reemplaza con el ID de tu icono
                contentDescription = null,
                modifier = Modifier.size(17.dp) // Ajusta el tamaño del icono según sea necesario
            )

        }
        Text(text = "Imshuvo97@gmail.com",
            color = Color.Gray,)
    }

}



//@Preview(showBackground = true)
@Composable
fun barraAccount(icon: Painter, seccion: String){
    Row(modifier = Modifier
        .padding(vertical = 3.dp)
        .padding(horizontal = 16.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){
        Image(painter = icon, contentDescription = null)

        Text(text = seccion, modifier = Modifier
            .padding(16.dp)
            .align(Alignment.CenterVertically),
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)

        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(id =R.drawable.back_arrow), contentDescription = null,
        modifier = Modifier
            .padding(end = 16.dp))

    }
}

