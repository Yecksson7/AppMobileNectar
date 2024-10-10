package com.example.nectarapplication.data

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences
//import androidx.datastore.preferences.core.stringPreferencesKey
//
//class FavouriteRepository(private val dataStore: DataStore<Preferences>) {
//    private companion object {
//        val FAVORITES = stringPreferencesKey("store_favourites")
//    }
//
//    val getFavourites: Flow<String> =
//        dataStore.data.map { preferences ->
//            preferences[FAVORITES] ?: "[]"
//        }
//
//    suspend fun saveFavourites(serializeList: String) {
//        dataStore.edit { preferences ->
//            preferences[FAVORITES] = serializeList
//        }
//    }