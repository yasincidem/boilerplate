package com.yasincidem.boilerplate.ui.main.notifications

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.yasincidem.boilerplate.R
import com.yasincidem.boilerplate.core.base.view.fragment.BaseScreenFragment
import com.yasincidem.boilerplate.core.logger.AnalyticsHelper.ScreenNames.NOTIFICATIONS
import com.yasincidem.boilerplate.databinding.FragmentNotificationsBinding
import com.yasincidem.theme.ui.ThemeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class NotificationsFragment : BaseScreenFragment<FragmentNotificationsBinding, NotificationsViewModel>(
    R.layout.fragment_notifications
) {

    private val notificationsViewModel: NotificationsViewModel by navGraphViewModels(R.id.notifications) {
        defaultViewModelProviderFactory
    }

    private val themeViewModel: ThemeViewModel by activityViewModels()


    override fun viewModel(): NotificationsViewModel = notificationsViewModel

    override fun screenName(): String = NOTIFICATIONS

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notifications_to_navigation_notifications_nested)
        }
        binding.button.setOnClickListener {
            lifecycleScope.launch {
                val theme = themeViewModel.theme.first()
                withContext(Dispatchers.Main) {
                    findNavController().navigate(NotificationsFragmentDirections.infoToTheme(theme))
                }
            }
        }
    }
}