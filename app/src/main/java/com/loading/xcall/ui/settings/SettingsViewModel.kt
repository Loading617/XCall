package com.loading.xcall.ui.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {
    private val _text = MutableStateFlow("This is notifications Fragment")
    val text: StateFlow<String> = _text.asStateFlow()
}