package com.example.nectarapplication.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectarapplication.ApiService
import com.example.nectarapplication.LoginRequest
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var loginState by mutableStateOf<LoginState>(LoginState.Idle)

    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/") // Reemplaza con la URL de tu API
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun login() {
        viewModelScope.launch {
            loginState = LoginState.Loading
            try {
                val response = apiService.login(LoginRequest(email, password))
                if (response.success) {
                    loginState = LoginState.Success(response.message)
                } else {
                    loginState = LoginState.Error(response.message)
                }
            } catch (e: Exception) {
                loginState = LoginState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class LoginState {

    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val message: String) : LoginState()
    data class Error(val message: String) : LoginState()
}