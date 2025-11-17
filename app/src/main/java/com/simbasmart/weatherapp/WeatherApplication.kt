package com.simbasmart.weatherapp

import android.app.Application
import android.util.Log

/**
 * WeatherApplication - Main application class
 * Initializes app-wide components and configurations
 */
class WeatherApplication : Application() {
    
    companion object {
        private const val TAG = "WeatherApplication"
    }
    
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "WeatherApplication onCreate: Initializing weather app")
        
        // Initialize any app-wide configurations here
        // Database will be initialized lazily when first accessed
    }
}
