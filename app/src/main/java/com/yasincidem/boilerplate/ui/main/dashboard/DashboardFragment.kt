package com.yasincidem.boilerplate.ui.main.dashboard

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import com.yasincidem.boilerplate.R
import com.yasincidem.boilerplate.core.base.view.fragment.BaseFragment
import com.yasincidem.boilerplate.core.ext.observe
import com.yasincidem.boilerplate.core.util.ResultOf
import com.yasincidem.boilerplate.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dashboard.*

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel>(
    R.layout.fragment_dashboard
) {

    private val dashboardViewModel: DashboardViewModel by navGraphViewModels(R.id.mobile_navigation) {
        defaultViewModelProviderFactory
    }

    override val viewModel: DashboardViewModel get() = dashboardViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.user) {
            when (it) {
                is ResultOf.Success -> text_dashboard.text = it.data[0].name
                is ResultOf.Failure -> text_dashboard.text = it.error.message
            }
        }
    }
}