package com.loading.xcall.ui.blacklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loading.xcall.data.BlacklistEntry
import com.loading.xcall.data.BlacklistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class BlacklistViewModel @Inject constructor(
    private val repository: BlacklistRepository
) : ViewModel() {

    private val _blacklistedNumbers = MutableStateFlow<List<BlacklistEntry>>(emptyList())
    val blacklistedNumbers: StateFlow<List<BlacklistEntry>> = _blacklistedNumbers.asStateFlow()

    init {
        loadBlacklist()
    }

    private fun loadBlacklist() {
        viewModelScope.launch {
            _blacklistedNumbers.value = repository.getAll()
        }
    }

    fun addNumber(name: String?, number: String) {
        viewModelScope.launch {
            repository.insert(BlacklistEntry(name = name, phoneNumber = number.trim()))
            loadBlacklist()
        }
    }

    fun removeNumber(entry: BlacklistEntry) {
        viewModelScope.launch {
            repository.delete(entry)
            loadBlacklist()
        }
    }
}
