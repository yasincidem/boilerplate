package com.yasincidem.boilerplate.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yasincidem.boilerplate.R
import com.yasincidem.boilerplate.core.logger.AnalyticsHelper
import com.yasincidem.boilerplate.main.MainActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        AnalyticsHelper.initAnalytics(this)

        activityScope.launch {
            delay(1500)
            finishSplashActivity()
        }
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }

    override fun onRestart() {
        super.onRestart()
        finishSplashActivity()
    }

    private fun finishSplashActivity() {
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
    }
}