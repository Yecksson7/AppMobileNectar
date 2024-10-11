package com.example.nectarapplication.screens.MyCartScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.nectarapplication.data.CartProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface ListUiState {

    val isLoading: Boolean

    data class init(
        override val isLoading: Boolean,
    ) : ListUiState
}

private data class MyCartViewModelState(
    val favorites: Set<String> = emptySet(),
    val isLoading: Boolean = false,
) {
    fun toUiState(): ListUiState = ListUiState.init(true)
}

class MyCartViewModel: ViewModel() {
    private var _items = MutableLiveData<List<CartProducts>>()

    private val viewModelState = MutableStateFlow(
        MyCartViewModelState(
            favorites = emptySet(),
            isLoading = true
        )
    )

    val uiState = viewModelState.map(MyCartViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        refresh()

        viewModelScope.launch {
            /*observeFavorites().collect { favorites ->
                viewModelState.update { it.copy(favorites = favorites) }
            }*/
        }
    }

    fun getItems(): List<CartProducts>? = _items.value

    fun setItems(items: List<CartProducts>) {
        _items.value = items
    }

    fun refresh() {
        viewModelState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            viewModelState.update {
                it.copy(isLoading = false)
            }
        }
    }

    fun toggleFavourite(productId: String) {
        viewModelScope.launch {
            //toggleFavorite(prosuctId)
        }
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MyCartViewModel() as T
            }
        }
    }
}