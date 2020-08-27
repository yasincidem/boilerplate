package com.yasincidem.boilerplate.core.base.view.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.yasincidem.boilerplate.core.base.view.IView

abstract class BaseActivity : AppCompatActivity(), IView {

    @get:LayoutRes
    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
    }
}