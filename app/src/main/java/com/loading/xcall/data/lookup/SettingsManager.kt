package com.loading.xcall.data.lookup

import android.content.Context
import android.content.SharedPreferences

class SettingsManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "spam_blocker_settings"

        private const val KEY_BLOCK_UNKNOWN_CALLERS = "block_unknown_callers"
        private const val KEY_BLOCK_PRIVATE_NUMBERS = "block_private_numbers"
        private const val KEY_NOTIFICATIONS_ENABLED = "notifications_enabled"
    }

    var blockUnknownCallers: Boolean
        get() = prefs.getBoolean(KEY_BLOCK_UNKNOWN_CALLERS, false)
        set(value) = prefs.edit().putBoolean(KEY_BLOCK_UNKNOWN_CALLERS, value).apply()

    var blockPrivateNumbers: Boolean
        get() = prefs.getBoolean(KEY_BLOCK_PRIVATE_NUMBERS, false)
        set(value) = prefs.edit().putBoolean(KEY_BLOCK_PRIVATE_NUMBERS, value).apply()

    var notificationsEnabled: Boolean
        get() = prefs.getBoolean(KEY_NOTIFICATIONS_ENABLED, true)
        set(value) = prefs.edit().putBoolean(KEY_NOTIFICATIONS_ENABLED, value).apply()

    fun clearSettings() {
        prefs.edit().clear().apply()
    }
}
