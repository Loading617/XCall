package com.loading.xcall.ui.blockedlog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loading.xcall.data.BlockedCallLogEntry
import com.loading.xcall.data.BlockedCallLogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class BlockedCallLogViewModel @Inject constructor(
    private val repository: BlockedCallLogRepository
) : ViewModel() {

    private val _blockedCalls = MutableStateFlow<List<BlockedCallLogEntry>>(emptyList())
    val blockedCalls: StateFlow<List<BlockedCallLogEntry>> = _blockedCalls.asStateFlow()

    init {
        loadBlockedCalls()
    }

    private fun loadBlockedCalls() {
        viewModelScope.launch {
            _blockedCalls.value = repository.getAll()
        }
    }

    fun addBlockedCall(entry: BlockedCallLogEntry) {
        viewModelScope.launch {
            repository.insert(entry)
            loadBlockedCalls()
        }
    }

    fun removeBlockedCall(entry: BlockedCallLogEntry) {
        viewModelScope.launch {
            repository.delete(entry)
            loadBlockedCalls()
        }
    }
} 