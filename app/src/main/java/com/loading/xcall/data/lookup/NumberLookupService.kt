package com.loading.xcall.data.lookup

import android.content.Context
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NumberLookupService(private val context: Context) {

    private val localSpamNumbers = listOf(
        "+18005551234",
        "+1234567890",
        "+1987654321"
    )

    suspend fun lookupNumber(number: String): LookupResult {
        return withContext(Dispatchers.IO) {
            try {
                if (isInLocalBlacklist(number)) {
                    LookupResult.SPAM
                } else {

                    LookupResult.UNKNOWN
                }
            } catch (e: Exception) {
                Log.e("NumberLookupService", "Lookup failed", e)
                LookupResult.UNKNOWN
            }
        }
    }

    private fun isInLocalBlacklist(number: String): Boolean {
        return localSpamNumbers.contains(number.trim())
    }
}
