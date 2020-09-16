package com.yasincidem.boilerplate.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import androidx.navigation.navGraphViewModels
import com.yasincidem.boilerplate.R
import com.yasincidem.boilerplate.api.Errors
import com.yasincidem.boilerplate.core.base.view.fragment.BaseScreenFragment
import com.yasincidem.boilerplate.core.logger.AnalyticsHelper.ScreenNames.HOME
import com.yasincidem.boilerplate.core.util.ResultOf
import com.yasincidem.boilerplate.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseScreenFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home
) {

    private val homeViewModel: HomeViewModel by navGraphViewModels(R.id.home) {
        defaultViewModelProviderFactory
    }

    override fun viewModel(): HomeViewModel = homeViewModel

    override fun screenName(): String = HOME

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.apply {
            user.observe(viewLifecycleOwner) {
                when (it) {
                    is ResultOf.Success -> binding.textHome.text = it.data[0].name
                    is ResultOf.Failure -> binding.textHome.text = when(it.error) {
                        is Errors.NetworkError -> it.error.desc
                        else -> ""
                    }
                }
            }
        }
    }
}