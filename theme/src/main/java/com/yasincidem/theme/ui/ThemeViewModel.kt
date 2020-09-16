package com.yasincidem.theme.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasincidem.theme.data.ThemeRepository
import com.yasincidem.theme.model.Theme

class ThemeViewModel @ViewModelInject constructor(private val repository: ThemeRepository) : ViewModel() {

    val theme = repository.getTheme()

    fun getThemes() = repository.getThemes()

    fun setTheme(theme: Theme) = repository.setTheme(theme, viewModelScope)
}