package com.loading.xcall.ui.calllogs

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class CallLogsViewModel @Inject constructor() : ViewModel() {
    private val _text = MutableStateFlow("This is dashboard Fragment")
    val text: StateFlow<String> = _text.asStateFlow()
}