package com.yasincidem.boilerplate.ui.main.notifications

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.yasincidem.boilerplate.R
import com.yasincidem.boilerplate.core.base.view.fragment.BaseScreenFragment
import com.yasincidem.boilerplate.core.logger.AnalyticsHelper.ScreenNames.NOTIFICATIONS
import com.yasincidem.boilerplate.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseScreenFragment<FragmentNotificationsBinding, NotificationsViewModel>(
    R.layout.fragment_notifications
) {

    private val notificationsViewModel: NotificationsViewModel by navGraphViewModels(R.id.notifications) {
        defaultViewModelProviderFactory
    }

    override val viewModel: NotificationsViewModel
        get() = notificationsViewModel

    override val screenName: String
        get() = NOTIFICATIONS

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notifications_to_navigation_notifications_nested)
        }
    }
}