package com.example.nectarapplication.screens

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectarapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SignUpScreen() {
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

            Spacer(modifier = Modifier.size(70.dp))

            Image(painter = painterResource(id = R.drawable.zanahoria_naranja),
                contentDescription =null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.size(50.dp))

            Text("Sign Up",
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.size(10.dp))

            Text(text = "Enter your credentials to continue", fontSize = 13.sp, color = androidx.compose.ui.graphics.Color.Gray)
            Spacer(modifier = Modifier.size(40.dp))

            Text(text = "Username",color = androidx.compose.ui.graphics.Color.Gray)
            TextField(value = "", onValueChange = {  },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = androidx.compose.ui.graphics.Color.Transparent),
                modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.size(25.dp))

            Text(text = "Email",color = androidx.compose.ui.graphics.Color.Gray)

            EmailTextField()
            Spacer(modifier = Modifier.size(25.dp))
            Text(text = "Password",color = androidx.compose.ui.graphics.Color.Gray)
            PasswordTextField()

            Spacer(modifier = Modifier.size(5.dp))
            Row(modifier = Modifier.align(Alignment.Start)) {
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "By continuing you agree to our ",color = androidx.compose.ui.graphics.Color.Black, fontSize = 10.sp)
                GreenText("Terms and Conditions")
            }
            Row(modifier = Modifier.align(Alignment.Start)) {
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "and ",color = androidx.compose.ui.graphics.Color.Black, fontSize = 10.sp)
                GreenText("Privacy Policy")
            }


            Spacer(modifier = Modifier.size(35.dp))

            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(width = 280.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color(0xFF53B175)))
            {
                Text("Sing Up",
                    color = androidx.compose.ui.graphics.Color.White)
            }
            Spacer(modifier = Modifier.size(25.dp))

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Already have an account? ",color = androidx.compose.ui.graphics.Color.Black, fontSize = 10.sp)
                GreenText("Log in")
            }


            // Text(text = "Don't have an account? Sign up"+GreenText(),
            //   color = androidx.compose.ui.graphics.Color.Black, fontSize = 10.sp,
            // modifier = Modifier.align(Alignment.CenterHorizontally)
            //)
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField() {
    var email by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return emailRegex.matches(email)
    }

    TextField(
        value = email,
        onValueChange = {
            email = it
            errorMessage = if (isValidEmail(it)) "" else "Invalid email address"
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = androidx.compose.ui.graphics.Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.fillMaxWidth()
    )

    if (errorMessage.isNotEmpty()) {
        Text(
            text = errorMessage,
            color = androidx.compose.ui.graphics.Color.Red,
            fontSize = 12.sp
        )
    }
}
