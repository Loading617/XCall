package com.loading.xcall.ui.whitelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loading.xcall.data.WhitelistEntry
import com.loading.xcall.data.WhitelistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class WhitelistViewModel @Inject constructor(
    private val repository: WhitelistRepository
) : ViewModel() {

    private val _whitelistedNumbers = MutableStateFlow<List<WhitelistEntry>>(emptyList())
    val whitelistedNumbers: StateFlow<List<WhitelistEntry>> = _whitelistedNumbers.asStateFlow()

    init {
        loadWhitelist()
    }

    private fun loadWhitelist() {
        viewModelScope.launch {
            _whitelistedNumbers.value = repository.getAll()
        }
    }

    fun addNumber(number: String) {
        viewModelScope.launch {
            repository.insert(WhitelistEntry(phoneNumber = number.trim()))
            loadWhitelist()
        }
    }

    fun removeNumber(entry: WhitelistEntry) {
        viewModelScope.launch {
            repository.delete(entry)
            loadWhitelist()
        }
    }
}
