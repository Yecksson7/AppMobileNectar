package com.example.nectarapplication

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import java.util.prefs.Preferences

//private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
//    name = "setting"
//)
//
//class NectarApplication: Application() {
//    lateinit var favouritesRepository: FavouritesRepository
//
//    override fun onCreate() {
//        super.onCreate()
//        favouritesRepository = FavouritesRepository(dataStore)
//    }
//
//}