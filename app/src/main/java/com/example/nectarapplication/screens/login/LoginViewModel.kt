package com.example.nectarapplication.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectarapplication.helper.RetrofitInstance
import com.example.nectarapplication.model.LoginRequest
import com.example.nectarapplication.model.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    // Username y password como estados observables
    var username by mutableStateOf("")
    var password by mutableStateOf("")

    // Estados para la respuesta, error y loading usando MutableLiveData
    val isLoading = MutableLiveData(false)
    val loginResponse = MutableLiveData<LoginResponse?>()
    val loginError = MutableLiveData<String?>()

    // Función para hacer login
    fun login() {
        viewModelScope.launch {
            isLoading.value = true // Muestra el estado de carga
            try {
                val response = RetrofitInstance.api.login(LoginRequest(username, password))
                if (response.isSuccessful) {
                    loginResponse.value = response.body() // Actualiza la respuesta
                    loginError.value = null // Limpia errores anteriores
                } else {
                    loginResponse.value = null
                    loginError.value = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                loginResponse.value = null
                loginError.value = "Exception: ${e.message}"
            }finally {
                isLoading.value = false // Termina el estado de carga
            }
            //isLoading.value = false // Termina el estado de carga
        }
    }
}
/*
class LoginViewModel : ViewModel() {
    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var loginState by mutableStateOf<LoginState>(LoginState.Idle)

    //private val apiService: ApiService
/*
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/") // Reemplaza con la URL de tu API
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }
*/
    fun login() {
        viewModelScope.launch {
            loginState = LoginState.Loading
            try {
                val response = apiService.login(LoginRequest(username, password))
                if (response.token.isNotEmpty()) {
                    loginState = LoginState.Success("Login successful, token: ${response.token}")
                } else {
                    loginState = LoginState.Error("Login failed")
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
    data class Error(val error: String) : LoginState()
}*/