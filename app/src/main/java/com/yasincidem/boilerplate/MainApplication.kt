package com.yasincidem.boilerplate

import android.app.Application
import com.yasincidem.boilerplate.core.logger.initLogger
import dagger.hilt.android.HiltAndroidApp
import leakcanary.AppWatcher
import leakcanary.LeakCanary
import timber.log.Timber

@HiltAndroidApp
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger(BuildConfig.DEBUG)
    }

}