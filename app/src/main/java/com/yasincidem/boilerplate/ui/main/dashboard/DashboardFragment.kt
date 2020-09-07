package com.yasincidem.boilerplate.ui.main.dashboard

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import com.yasincidem.boilerplate.R
import com.yasincidem.boilerplate.core.base.view.fragment.BaseScreenFragment
import com.yasincidem.boilerplate.core.logger.AnalyticsHelper
import com.yasincidem.boilerplate.core.logger.AnalyticsHelper.ScreenNames.DASHBOARD
import com.yasincidem.boilerplate.core.logger.log
import com.yasincidem.boilerplate.core.util.ResultOf
import com.yasincidem.boilerplate.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseScreenFragment<FragmentDashboardBinding, DashboardViewModel>(
    R.layout.fragment_dashboard
) {

    private val dashboardViewModel: DashboardViewModel by navGraphViewModels(R.id.dashboard) {
        defaultViewModelProviderFactory
    }

    override val viewModel: DashboardViewModel
        get() = dashboardViewModel

    override val screenName: String
        get() = DASHBOARD

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {
            when (it) {
                is ResultOf.Success -> binding.textDashboard.text = it.data[0].name
                is ResultOf.Failure -> binding.textDashboard.text = it.error.message
            }
        }
    }
}