package com.yasincidem.boilerplate.ui.main.notifications

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.yasincidem.boilerplate.R
import com.yasincidem.boilerplate.core.base.view.fragment.BaseFragment
import com.yasincidem.boilerplate.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<FragmentNotificationsBinding, NotificationsViewModel>(
    R.layout.fragment_notifications
) {

    private val notificationsViewModel: NotificationsViewModel by navGraphViewModels(R.id.notifications) {
        defaultViewModelProviderFactory
    }

    override val viewModel: NotificationsViewModel get() = notificationsViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notifications_to_navigation_notifications_nested)
        }
    }
}