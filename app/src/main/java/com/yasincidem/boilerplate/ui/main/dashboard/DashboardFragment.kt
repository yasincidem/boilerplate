package com.yasincidem.boilerplate.ui.main.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.yasincidem.boilerplate.R
import com.yasincidem.boilerplate.core.base.view.fragment.BaseScreenFragment
import com.yasincidem.boilerplate.core.logger.AnalyticsHelper.ScreenNames.DASHBOARD
import com.yasincidem.boilerplate.core.util.ResultOf
import com.yasincidem.boilerplate.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseScreenFragment<FragmentDashboardBinding, DashboardViewModel>(
    R.layout.fragment_dashboard
) {

    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun viewModel(): DashboardViewModel = dashboardViewModel

    override fun screenName(): String = DASHBOARD

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dashboardViewModel.user.observe(viewLifecycleOwner) {
            when (it) {
                is ResultOf.Success -> binding.textDashboard.text = it.data[0].name
                is ResultOf.Failure -> binding.textDashboard.text = it.error.message
            }
        }
    }
}