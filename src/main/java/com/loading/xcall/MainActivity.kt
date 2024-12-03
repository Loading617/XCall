package com.loading.xcall

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.loading.xcall.databinding.ActivityMainBinding
import android.telephony.TelephonyManager
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
// Request permissions
requestPermissions(arrayOf(android.Manifest.permission.READ_CALL_LOG,
android.Manifest.permission.READ_PHONE_STATE),
101)
     }

override fun
        onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if (requestCode == 101 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

       // Initialize Telephony Manager
          val telephonyManager = getSystemService(TELEPHONY_SERVICE) as
                  TelephonyManager

        // Set call state listener
        telephonyManager.listen(object :
        PhoneStateListener() {
           override fun
       onCallStateChanged(state: Int, phoneNumber: String?) {
               super.onCallStateChanged(state, phoneNumber)

               // Check if spam number
               if (isSpamNumber(phoneNumber)) {

                   // Block call
                   Toast.makeText(this@MainActivity, "Spam call blocked", Toast.LENGTH_SHORT).show()
               }
           }, PhoneStateListener.LISTEN_CALL_STATE)
               }
             }
             private fun isSpamNumber(phoneNumber: String?): Boolean {
                 // Implement spam number checking logic
                 // Return true if spam, false otherwise
                 return false
             }
        }

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