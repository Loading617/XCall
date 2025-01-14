package com.loading.xcall

import android.telecom.Call
import android.telecom.CallScreeningService

class CallBlockingService : CallScreeningService() {

    private val spamNumbers = listOf("+1234567890", "+1987654321")

    override fun onScreenCall(callDetails: Call.Details) {
        val incomingNumber = callDetails.handle.schemeSpecificPart
        if (isSpam(incomingNumber)) {
            
            val response = CallResponse.Builder()
                .setDisallowCall(true)
                .setRejectCall(true)
                .setSkipCallLog(true)
                .setSkipNotification(true)
                .build()
            respondToCall(callDetails, response)
        }
    }

    private fun isSpam(phoneNumber: String?): Boolean {
        return phoneNumber != null && spamNumbers.contains(phoneNumber)
    }
}
