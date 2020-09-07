package com.yasincidem.boilerplate.core.base.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.yasincidem.boilerplate.BR
import com.yasincidem.boilerplate.core.base.view.IView
import com.yasincidem.boilerplate.core.logger.AnalyticsHelper
import com.yasincidem.boilerplate.core.util.AutoClearedValue

abstract class BaseFragment<VB : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutResourceId: Int
) : Fragment(), IView {

    protected abstract val viewModel: VM

    protected var binding by AutoClearedValue<VB>()

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<VB>(inflater, layoutResourceId, container, false).also {
            binding = it
        }.root

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, viewModel)
        }
    }

    fun sendEvent(eventName: String, eventParams: Bundle = bundleOf()) {
        AnalyticsHelper.logEvent(eventName, eventParams)
    }
}