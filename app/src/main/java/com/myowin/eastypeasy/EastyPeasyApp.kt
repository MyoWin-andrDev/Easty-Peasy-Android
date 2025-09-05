package com.myowin.eastypeasy

import android.annotation.SuppressLint
import android.app.Application
import android.viewbinding.library.BuildConfig
import cat.ereza.customactivityoncrash.CustomActivityOnCrash
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class EastyPeasyApp : Application() {

    @SuppressLint("RestrictedApi")
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree()) // Logs only in debug builds
        }
        CustomActivityOnCrash.install(this)

    }
}

