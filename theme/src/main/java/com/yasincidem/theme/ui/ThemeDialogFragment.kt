package com.yasincidem.theme.ui

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yasincidem.theme.R
import com.yasincidem.theme.model.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThemeDialogFragment : DialogFragment() {

    private val args: ThemeDialogFragmentArgs by navArgs()

    private val theme: Theme by lazy { args.theme }

    private val themeViewModel: ThemeViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val themes = themeViewModel.getThemes()
        val themeTitles = themes.map { theme -> getString(theme.titleResId) }.toTypedArray()
        val checkedItem = themes.indexOf(theme)
        return MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.choose_theme)
            .setSingleChoiceItems(themeTitles, checkedItem) { _, which ->
                val whichTheme = themes[which]
                themeViewModel.setTheme(whichTheme)
                dismiss()
            }
            .create()
    }
}