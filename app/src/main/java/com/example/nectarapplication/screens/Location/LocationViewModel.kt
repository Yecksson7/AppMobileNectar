package com.example.nectarapplication.screens.Location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectarapplication.data.getListaZona
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {
    // Lista de zonas
    private val _zoneList = MutableLiveData<List<String>>()
    val zoneList: LiveData<List<String>> get() = _zoneList

    // Estado de carga
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    // Función para cargar la lista de zonas
    fun loadZones() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // Aquí deberías reemplazar esto con tu llamada a la API para obtener la lista de zonas
                val zones = getListaZona() // Supón que tienes una función para obtener datos
                _zoneList.value = zones
            } catch (e: Exception) {
                // Manejo de errores
                _zoneList.value = emptyList() // O puedes manejar errores de otra manera
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Simulación de carga de zonas (reemplazar con la llamada real)
    private suspend fun fetchZonesFromApi(): List<String> {
        // Simula un retraso para la carga
        delay(2000) // Simulación de tiempo de carga
        return listOf("Zone 1", "Zone 2", "Zone 3") // Devuelve una lista simulada
    }
}