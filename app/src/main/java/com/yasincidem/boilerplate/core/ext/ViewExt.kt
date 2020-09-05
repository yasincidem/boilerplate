package com.yasincidem.boilerplate.core.ext

import android.os.Build
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.yasincidem.boilerplate.R

fun View.errorSnack(text: String, duration: Int = Snackbar.LENGTH_INDEFINITE): Snackbar =
    Snackbar.make(this, text, duration).also {
        val tv = it.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        tv.setPadding(0,0,0,0)
        it.setBackgroundTint(ContextCompat.getColor(context, R.color.colorError))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) tv.textAlignment = View.TEXT_ALIGNMENT_CENTER
        else tv.gravity = Gravity.CENTER_HORIZONTAL
    }


fun View.defaultSnack(text: String, duration: Int = Snackbar.LENGTH_SHORT): Snackbar =
    Snackbar.make(this, text, duration)