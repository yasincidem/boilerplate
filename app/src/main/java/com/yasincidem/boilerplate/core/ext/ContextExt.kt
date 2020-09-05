package com.yasincidem.boilerplate.core.ext

import android.content.Context
import androidx.annotation.StringRes

fun Context.string(@StringRes stringResId: Int): String = this.resources.getString(stringResId)
