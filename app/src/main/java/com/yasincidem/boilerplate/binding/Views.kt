package com.yasincidem.boilerplate.binding

import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yasincidem.boilerplate.core.logger.log

fun BottomNavigationView.disableTooltipText() {
    try {
        val menuViewField = this.javaClass.getDeclaredField("menuView")
        menuViewField.isAccessible = true
        val menuView = menuViewField.get(this) as BottomNavigationMenuView
        menuView.forEach {
            it.setOnLongClickListener {
                true
            }
        }
        log { "disableTooltipText$menuView" }

    } catch (e: Exception) {
        log { "disableTooltipText" + e.message.toString() }
    }
}

fun BottomNavigationView.disableTooltip() {
    val content: View = getChildAt(0)
    if (content is ViewGroup) {
        content.forEach {
            it.setOnLongClickListener {
                return@setOnLongClickListener true
            }
            // disable vibration also
            it.isHapticFeedbackEnabled = false
        }
    }
}