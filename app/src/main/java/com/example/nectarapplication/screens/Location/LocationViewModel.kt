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

                val zones = getListaZona()
                _zoneList.value = zones
            } catch (e: Exception) {

                _zoneList.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }


    private suspend fun fetchZonesFromApi(): List<String> {

        delay(2000)
        return listOf("Zone 1", "Zone 2", "Zone 3")
    }
}