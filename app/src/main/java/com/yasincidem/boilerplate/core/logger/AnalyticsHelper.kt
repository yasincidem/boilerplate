package com.yasincidem.boilerplate.core.logger

import android.content.Context
import android.os.Bundle
import androidx.core.os.bundleOf
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics

object AnalyticsHelper {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    /**
     * Init analytics  by context
     */
    fun initAnalytics(context: Context) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }

    fun logEvent(eventName: String, params: Bundle) {
        mFirebaseAnalytics?.logEvent(eventName, params)
    }

    fun addScreenTrack(screenName: String) {
        mFirebaseAnalytics?.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundleOf("screenName" to screenName))
    }

    fun setUserId(userId: String) {
        try {
            mFirebaseAnalytics?.setUserId(userId)
            FirebaseCrashlytics.getInstance().setUserId(userId)
        } catch (e: Exception) {
            //log it at the future
        }
    }

    fun removeUserId() {
        try {
            mFirebaseAnalytics?.setUserId(null)
            FirebaseCrashlytics.getInstance().setUserId("")
        } catch (e: Exception) {
            //log it at the future
        }
    }

    object ScreenNames {
        const val HOME = "home"
        const val DASHBOARD = "dashboard"
        const val NOTIFICATIONS = "notifications"
    }

    object Events {

    }

    object Params {
        const val IS_SUCCESS = "is_success"
    }

}