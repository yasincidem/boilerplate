package com.yasincidem.boilerplate.core.base.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.yasincidem.boilerplate.BR
import com.yasincidem.boilerplate.core.base.view.IView

abstract class BaseFragment<VB : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutResourceId: Int
) : Fragment(), IView {

    protected abstract val viewModel: VM

    private var _binding: VB? = null

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: VB = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        _binding = binding
        binding.apply {
            lifecycleOwner = this@BaseFragment
            setVariable(BR.viewModel, viewModel)
        }
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}