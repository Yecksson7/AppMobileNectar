package com.example.nectarapplication.screens

import android.widget.Space
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectarapplication.R


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.fondologin),
            contentDescription = "Onboarding Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.Top){

            Spacer(modifier = Modifier.size(60.dp))

            Image(painter = painterResource(id = R.drawable.zanahoria_naranja),
                contentDescription =null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.size(50.dp))

            Text("Sign in",
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                fontSize = 20.sp
                )
            Spacer(modifier = Modifier.size(10.dp))

            Text(text = "Enter your emails and password", fontSize = 13.sp, color = androidx.compose.ui.graphics.Color.Gray)
            Spacer(modifier = Modifier.size(40.dp))

            Text(text = "Email",color = androidx.compose.ui.graphics.Color.Gray)

            TextField(value = "", onValueChange = {  },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = androidx.compose.ui.graphics.Color.Transparent),
                modifier = Modifier.fillMaxWidth())



            Spacer(modifier = Modifier.size(25.dp))
            Text(text = "Password",color = androidx.compose.ui.graphics.Color.Gray)
            PasswordTextField()
            Text(text = "Forgot Password?",
                color = androidx.compose.ui.graphics.Color.Black, fontSize = 10.sp,
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(modifier = Modifier.size(30.dp))

            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(width = 250.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color(0xFF53B175)))
            {
                Text("Log In",
                    color = androidx.compose.ui.graphics.Color.White)
            }
            Spacer(modifier = Modifier.size(25.dp))


            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "Don't have an account? ",
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontSize = 10.sp)
                GreenText("Sign up")
            }
            Text(
                text = "Don't have an account? Sign up" + GreenText("Singup"),
                color = androidx.compose.ui.graphics.Color.Black, fontSize = 10.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }

}

@Composable
fun GreenText(palabra:String) {
    val greenText = AnnotatedString.Builder().apply {
        withStyle(style = SpanStyle(color = Color(0xFF53B175))) {
            append(palabra)
        }
    }.toAnnotatedString()

    Text(text = greenText, fontSize = 10.sp)
}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible)
                painterResource(id = R.drawable.ic_visibility_icon)
            else
                painterResource(id = R.drawable.ic_off_visibility_icon)

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(painter = image, contentDescription = null)
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = androidx.compose.ui.graphics.Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}