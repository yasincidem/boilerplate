package com.yasincidem.boilerplate.core.base.view.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.yasincidem.boilerplate.core.logger.AnalyticsHelper

abstract class BaseScreenFragment<VB: ViewDataBinding, VM: ViewModel>(
    @LayoutRes
    private val layoutResourceId: Int
): BaseFragment<VB, VM>(layoutResourceId) {

    protected abstract val screenName: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnalyticsHelper.addScreenTrack(screenName)
    }
}
