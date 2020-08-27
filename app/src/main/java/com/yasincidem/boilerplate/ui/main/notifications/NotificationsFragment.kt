package com.yasincidem.boilerplate.ui.main.notifications

import androidx.navigation.navGraphViewModels
import com.yasincidem.boilerplate.R
import com.yasincidem.boilerplate.core.base.view.fragment.BaseFragment
import com.yasincidem.boilerplate.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<FragmentNotificationsBinding, NotificationsViewModel>(
    R.layout.fragment_notifications
) {

    private val notificationsViewModel: NotificationsViewModel by navGraphViewModels(R.id.mobile_navigation) {
        defaultViewModelProviderFactory
    }

    override val viewModel: NotificationsViewModel get() = notificationsViewModel

}