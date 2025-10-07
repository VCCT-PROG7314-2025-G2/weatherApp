package com.simbasmart.weatherapp.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.simbasmart.weatherapp.R
import com.simbasmart.weatherapp.databinding.ActivityMainBinding
import com.simbasmart.weatherapp.ui.auth.LoginActivity
import com.simbasmart.weatherapp.ui.settings.SettingsActivity
import com.simbasmart.weatherapp.data.auth.AuthManager

/**
 * MainActivity - Entry point of the Weather App
 * Handles authentication check and main app functionality
 */
class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var authManager: AuthManager
    private val TAG = "MainActivity"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        Log.d(TAG, "MainActivity onCreate: Initializing weather app")
        
        authManager = AuthManager(this)
        
        // Check if user is logged in and session is valid
        if (!authManager.isLoggedIn() || !authManager.isSessionValid()) {
            Log.d(TAG, "User not logged in or session expired, redirecting to login")
            redirectToLogin()
            return
        }
        
        // Initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Setup action bar
        setupActionBar()
        
        Log.d(TAG, "MainActivity onCreate: Weather app initialized successfully")
    }
    

    
    /**
     * Redirect to login activity
     */
    private fun redirectToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
    
    /**
     * Setup action bar with custom styling
     */
    private fun setupActionBar() {
        supportActionBar?.apply {
            title = getString(R.string.app_name)
            setDisplayShowHomeEnabled(true)
        }
        
        // Display welcome message with user name
        val currentUser = authManager.getCurrentUser()
        val userName = currentUser?.name ?: "User"
        Log.d(TAG, "Welcome user: $userName (${currentUser?.authType ?: "unknown"})")
        
        Log.d(TAG, "Action bar setup completed")
    }
    
    /**
     * Create options menu
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    
    /**
     * Handle menu item selection
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Log.d(TAG, "Settings menu item selected")
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_logout -> {
                Log.d(TAG, "Logout menu item selected")
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
    /**
     * Handle user logout
     */
    private fun logout() {
        // Clear user data using AuthManager
        authManager.logout()
        
        Log.d(TAG, "User logged out")
        
        // Navigate to login screen
        redirectToLogin()
    }
    
    /**
     * Handle app lifecycle events
     */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity onResume: App resumed")
    }
    
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity onPause: App paused")
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity onDestroy: App destroyed")
    }
}
