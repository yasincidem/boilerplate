package com.yasincidem.boilerplate.core.logger

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.yasincidem.boilerplate.core.constants.Crashlytics.CRASHLYTICS_KEY_MESSAGE
import com.yasincidem.boilerplate.core.constants.Crashlytics.CRASHLYTICS_KEY_PRIORITY
import com.yasincidem.boilerplate.core.constants.Crashlytics.CRASHLYTICS_KEY_TAG
import com.yasincidem.boilerplate.core.constants.Crashlytics.FIREBASE_CRASHLYTICS_DEFAULT_TAG
import timber.log.Timber


class CrashReportingTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }

        val crashlytics = FirebaseCrashlytics.getInstance()
        crashlytics.apply {
            setCustomKey(CRASHLYTICS_KEY_PRIORITY, priority)
            setCustomKey(CRASHLYTICS_KEY_TAG, tag ?: FIREBASE_CRASHLYTICS_DEFAULT_TAG)
            setCustomKey(CRASHLYTICS_KEY_MESSAGE, message)
            t?.let { this.recordException(Exception(message)) } ?: t?.let {
                this.recordException(it)
            }
        }
    }
}
