package com.example.nectarapplication.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nectarapplication.MainNavActions
import com.example.nectarapplication.R
import androidx.compose.runtime.livedata.observeAsState

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {


}


//@Preview(showBackground = true)
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel(), navigationActions: MainNavActions) {

    var expandedState by remember { mutableStateOf(false) }



    val isLoading by loginViewModel.isLoading.observeAsState(false)
    val loginResponse by loginViewModel.loginResponse.observeAsState(null)
    val loginError by loginViewModel.loginError.observeAsState(null)


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondologin),
            contentDescription = "Onboarding Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.size(60.dp))

            Image(
                painter = painterResource(id = R.drawable.zanahoria_naranja),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(40.dp)
            )

            Spacer(modifier = Modifier.size(50.dp))

            Text(
                text = "Sign in",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Enter your emails and password",
                fontSize = 13.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.size(40.dp))

            Text(text = "Email", color = Color.Gray)
            EmailTextField(onEmailChange = { loginViewModel.username = it })

            Spacer(modifier = Modifier.size(25.dp))

            Text(text = "Password", color = Color.Gray)
            PasswordTextField(onPasswordChange = { loginViewModel.password = it })

            Text(
                text = "Forgot Password?",
                color = Color.Black,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.End)
            )

            if (expandedState) {
                Text(
                    text = "Error de crendenciales",
                    color = Color.Red
                )
            }

            Spacer(modifier = Modifier.size(30.dp))

            Button(
                onClick = {
                    loginViewModel.login()
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(width = 250.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175))
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        color = Color.White,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Log In", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.size(25.dp))

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "Don't have an account? ",
                    color = Color.Black,
                    fontSize = 10.sp
                )
                Row(Modifier.clickable { navigationActions.navigateToSingUp() }) {
                    GreenText("Sign up")
                }

            }
        }


        loginResponse?.let {
            navigationActions.navigateToLocation()
        }

        loginError?.let {

            expandedState = true
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


@Composable
fun EmailTextField(onEmailChange: (String) -> Unit) {

    var email by remember { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = { email = it
            onEmailChange(it)},
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,   // Color cuando el campo está enfocado
            unfocusedContainerColor = Color.Transparent  // Color cuando el campo no está enfocado
        ),
        modifier = Modifier.fillMaxWidth()
    )
}



@Composable
fun PasswordTextField(onPasswordChange: (String) -> Unit) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = {
            password = it
            onPasswordChange(it)
        },
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
            focusedContainerColor = Color.Transparent,   // Color cuando el campo está enfocado
            unfocusedContainerColor = Color.Transparent  // Color cuando el campo no está enfocado
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

