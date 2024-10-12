package com.example.nectarapplication.screens.Favourites

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

sealed interface FavouritesUiState {

    val isLoading: Boolean

    data class init(
        override val isLoading: Boolean,
    ) : FavouritesUiState
}

private data class FavouritesModelState(
    val favorites: Set<String> = emptySet(),
    val isLoading: Boolean = false,
) {
    fun toUiState(): FavouritesUiState = FavouritesUiState.init(true)
}

class FavouritesViewModel: ViewModel() {
    private var _items = MutableLiveData<List<CartProducts>>()

    private val viewModelState = MutableStateFlow(
        FavouritesModelState(
            favorites = emptySet(),
            isLoading = true
        )
    )

    val uiState = viewModelState.map(FavouritesModelState::toUiState)
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
                return FavouritesViewModel() as T
            }
        }
    }
}