package com.myowin.eastypeasy.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton
import androidx.datastore.preferences.core.Preferences

@Singleton
class DataStoreManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        val IS_FIRST_LAUNCH = booleanPreferencesKey("is_first_launch")
    }

    val isFirstLaunch: Flow<Boolean> = dataStore.data
        .map { prefs -> prefs[IS_FIRST_LAUNCH] ?: false }

    suspend fun saveIsFirstLaunch(isFirstLaunch: Boolean) {
        dataStore.edit { prefs ->
            prefs[IS_FIRST_LAUNCH] = isFirstLaunch
        }
    }

}
