package com.loading.xcall.ui.whitelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WhitelistViewModel : ViewModel() {

    private val _whitelistedNumbers = MutableLiveData<List<String>>(emptyList())
    val whitelistedNumbers: LiveData<List<String>> = _whitelistedNumbers

    fun addNumber(number: String) {
        val updatedList = _whitelistedNumbers.value.orEmpty().toMutableList()
        updatedList.add(number.trim())
        _whitelistedNumbers.value = updatedList
    }

    fun removeNumber(number: String) {
        val updatedList = _whitelistedNumbers.value.orEmpty().toMutableList()
        updatedList.remove(number)
        _whitelistedNumbers.value = updatedList
    }
}
