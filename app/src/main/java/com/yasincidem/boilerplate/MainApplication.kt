package com.yasincidem.boilerplate

import android.app.Application
import com.yasincidem.boilerplate.core.logger.AnalyticsHelper
import com.yasincidem.boilerplate.core.logger.initLogger
import com.yasincidem.theme.data.ThemeRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.GlobalScope
import javax.inject.Inject

@HiltAndroidApp
class MainApplication: Application() {

    @Inject
    lateinit var themeRepository: ThemeRepository

    override fun onCreate() {
        super.onCreate()
        AnalyticsHelper.initAnalytics(this)
        setupTheme()
        initLogger(BuildConfig.DEBUG)
    }

    private fun setupTheme() {
        themeRepository.setTheme(GlobalScope)
    }
}