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

    var username by mutableStateOf("")
    var password by mutableStateOf("")


    val isLoading = MutableLiveData(false)
    val loginResponse = MutableLiveData<LoginResponse?>()
    val loginError = MutableLiveData<String?>()


    fun login() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = RetrofitInstance.api.login(LoginRequest(username, password))
                if (response.isSuccessful) {
                    loginResponse.value = response.body()
                    loginError.value = null
                } else {
                    loginResponse.value = null
                    loginError.value = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                loginResponse.value = null
                loginError.value = "Exception: ${e.message}"
            }finally {
                isLoading.value = false
            }

        }
    }
}
