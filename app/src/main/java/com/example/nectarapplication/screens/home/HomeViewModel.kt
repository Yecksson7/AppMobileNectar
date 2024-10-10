package com.example.nectarapplication.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
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

private data class HomeViewModelState(
    val favorites: Set<String> = emptySet(),
    val isLoading: Boolean = false,
) {
    fun toUiState(): ListUiState = ListUiState.init(true)
}

class HomeViewModel: ViewModel() {

    private val viewModelState = MutableStateFlow(
        HomeViewModelState(
            favorites = emptySet(),
            isLoading = true
        )
    )

    val uiState = viewModelState.map(HomeViewModelState::toUiState)
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

    fun refresh() {
        viewModelState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            viewModelState.update {
                it.copy(isLoading = false)
            }
        }
    }

    fun toggleFavourite(bootId: String) {
        viewModelScope.launch { }
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel() as T
            }
        }
    }
}