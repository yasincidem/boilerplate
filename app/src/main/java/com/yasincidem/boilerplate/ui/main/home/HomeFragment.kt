package com.yasincidem.boilerplate.ui.main.home

import androidx.navigation.navGraphViewModels
import com.yasincidem.boilerplate.R
import com.yasincidem.boilerplate.core.base.view.fragment.BaseFragment
import com.yasincidem.boilerplate.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home
) {

    private val homeViewModel: HomeViewModel by navGraphViewModels(R.id.mobile_navigation) {
        defaultViewModelProviderFactory
    }

    override val viewModel: HomeViewModel get() = homeViewModel

}