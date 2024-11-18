package com.loading.xcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set theme
        val theme = getSharedPreferences("theme", MODE_PRIVATE)
        val isDarkTheme = theme.getBoolean("isDarkTheme", false)

        if (isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        // Switch theme button
        val switchThemeButton = findViewById<Button>(R.id.switchThemeButton)
        switchThemeButton.setOnClickListener {
            val editor = theme.edit()
            isDarkTheme = !isDarkTheme
            editor.putBoolean("isDarkTheme", isDarkTheme)
            editor.apply()

            if (isDarkTheme) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}