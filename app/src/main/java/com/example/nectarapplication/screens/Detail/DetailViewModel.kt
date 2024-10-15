package com.example.nectarapplication.screens.Detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.nectarapplication.data.DetailProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface DetailUiState {

    val isLoading: Boolean

    data class init(
        override val isLoading: Boolean,
    ) : DetailUiState
}

private data class DetailViewModelState(
    val favorites: Set<String> = emptySet(),
    val isLoading: Boolean = false,
) {
    fun toUiState(): DetailUiState = DetailUiState.init(true)
}

class DetailViewModel: ViewModel() {
    private var _items = MutableLiveData<List<DetailProducts>>()

    private val viewModelState = MutableStateFlow(
        DetailViewModelState(
            favorites = emptySet(),
            isLoading = true
        )
    )

    init {
        refresh()

        viewModelScope.launch {

        }
    }

    fun refresh() {
        viewModelState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            viewModelState.update {
                it.copy(isLoading = false)
            }
        }
    }


    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DetailViewModel() as T
            }
        }
    }
}