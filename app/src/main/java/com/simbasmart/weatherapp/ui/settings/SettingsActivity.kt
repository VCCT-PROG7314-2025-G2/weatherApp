package com.simbasmart.weatherapp.ui.settings

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.appbar.MaterialToolbar
import com.simbasmart.weatherapp.R
import com.simbasmart.weatherapp.databinding.ActivitySettingsBinding
import com.simbasmart.weatherapp.ui.auth.LoginActivity

/**
 * SettingsActivity - Manages user preferences and app settings
 * Allows users to customize their experience with Material Design 3
 */
class SettingsActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var prefs: SharedPreferences
    private val TAG = "SettingsActivity"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        prefs = getSharedPreferences("WeatherApp", MODE_PRIVATE)
        
        setupToolbar()
        setupUI()
        loadCurrentSettings()
        
        Log.d(TAG, "SettingsActivity created")
    }
    
    /**
     * Setup Material Design 3 toolbar
     */
    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
    
    /**
     * Setup UI components and click listeners
     */
    private fun setupUI() {
        // Setup custom adapters for AutoCompleteTextViews with proper text colors
        setupAutoCompleteAdapters()
        
        // Language selection
        binding.spinnerLanguage.setOnItemClickListener { _, _, position, _ ->
            val languages = arrayOf("English", "Afrikaans", "isiZulu")
            val languageCodes = arrayOf("en", "af", "zu")
            val selectedLanguage = languageCodes[position]
            
            prefs.edit().putString("language", selectedLanguage).apply()
            Log.d(TAG, "Language changed to: $selectedLanguage")
            Toast.makeText(this@SettingsActivity, "Language changed to ${languages[position]}", Toast.LENGTH_SHORT).show()
        }
        
        // Temperature unit selection
        binding.spinnerTemperatureUnit.setOnItemClickListener { _, _, position, _ ->
            val units = arrayOf("Celsius", "Fahrenheit")
            val unitCodes = arrayOf("C", "F")
            val selectedUnit = unitCodes[position]
            
            prefs.edit().putString("temperature_unit", selectedUnit).apply()
            Log.d(TAG, "Temperature unit changed to: $selectedUnit")
            Toast.makeText(this@SettingsActivity, "Temperature unit changed to ${units[position]}", Toast.LENGTH_SHORT).show()
        }
        
        // Wind speed unit selection
        binding.spinnerWindSpeedUnit.setOnItemClickListener { _, _, position, _ ->
            val units = arrayOf("km/h", "m/s", "mph")
            val unitCodes = arrayOf("kmh", "ms", "mph")
            val selectedUnit = unitCodes[position]
            
            prefs.edit().putString("wind_speed_unit", selectedUnit).apply()
            Log.d(TAG, "Wind speed unit changed to: $selectedUnit")
            Toast.makeText(this@SettingsActivity, "Wind speed unit changed to ${units[position]}", Toast.LENGTH_SHORT).show()
        }
        
        // Theme selection
        binding.spinnerTheme.setOnItemClickListener { _, _, position, _ ->
            val themes = arrayOf("System Default", "Light", "Dark")
            val themeModes = arrayOf(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM, AppCompatDelegate.MODE_NIGHT_NO, AppCompatDelegate.MODE_NIGHT_YES)
            val selectedMode = themeModes[position]
            
            prefs.edit().putInt("theme_mode", selectedMode).apply()
            AppCompatDelegate.setDefaultNightMode(selectedMode)
            Log.d(TAG, "Theme changed to: ${themes[position]}")
            Toast.makeText(this@SettingsActivity, "Theme changed to ${themes[position]}", Toast.LENGTH_SHORT).show()
        }
        
        // Location services switch
        binding.switchLocationServices.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean("location_services_enabled", isChecked).apply()
            Log.d(TAG, "Location services ${if (isChecked) "enabled" else "disabled"}")
            Toast.makeText(this@SettingsActivity, "Location services ${if (isChecked) "enabled" else "disabled"}", Toast.LENGTH_SHORT).show()
        }
        
        // Weather alerts switch
        binding.switchWeatherAlerts.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean("weather_alerts_enabled", isChecked).apply()
            Log.d(TAG, "Weather alerts ${if (isChecked) "enabled" else "disabled"}")
            Toast.makeText(this@SettingsActivity, "Weather alerts ${if (isChecked) "enabled" else "disabled"}", Toast.LENGTH_SHORT).show()
        }
        
        // Logout button
        binding.btnLogout.setOnClickListener {
            // Clear user preferences
            prefs.edit().clear().apply()
            
            // Navigate to login screen
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
        
        // About button
        binding.btnAbout.setOnClickListener {
            Toast.makeText(this, "WeatherApp v1.0\nProfessional Weather Application", Toast.LENGTH_LONG).show()
        }
    }
    
    /**
     * Setup custom adapters for AutoCompleteTextViews with proper text colors
     */
    private fun setupAutoCompleteAdapters() {
        // Language adapter
        val languageAdapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            resources.getStringArray(R.array.languages)
        )
        binding.spinnerLanguage.setAdapter(languageAdapter)
        binding.spinnerLanguage.threshold = 0
        binding.spinnerLanguage.isFocusable = true
        binding.spinnerLanguage.isFocusableInTouchMode = true
        binding.spinnerLanguage.setOnClickListener {
            binding.spinnerLanguage.showDropDown()
        }
        
        // Temperature unit adapter
        val temperatureAdapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            resources.getStringArray(R.array.temperature_units)
        )
        binding.spinnerTemperatureUnit.setAdapter(temperatureAdapter)
        binding.spinnerTemperatureUnit.threshold = 0
        binding.spinnerTemperatureUnit.isFocusable = true
        binding.spinnerTemperatureUnit.isFocusableInTouchMode = true
        binding.spinnerTemperatureUnit.setOnClickListener {
            binding.spinnerTemperatureUnit.showDropDown()
        }
        
        // Wind speed unit adapter
        val windSpeedAdapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            resources.getStringArray(R.array.wind_speed_units)
        )
        binding.spinnerWindSpeedUnit.setAdapter(windSpeedAdapter)
        binding.spinnerWindSpeedUnit.threshold = 0
        binding.spinnerWindSpeedUnit.isFocusable = true
        binding.spinnerWindSpeedUnit.isFocusableInTouchMode = true
        binding.spinnerWindSpeedUnit.setOnClickListener {
            binding.spinnerWindSpeedUnit.showDropDown()
        }
        
        // Theme adapter
        val themeAdapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            resources.getStringArray(R.array.themes)
        )
        binding.spinnerTheme.setAdapter(themeAdapter)
        binding.spinnerTheme.threshold = 0
        binding.spinnerTheme.isFocusable = true
        binding.spinnerTheme.isFocusableInTouchMode = true
        binding.spinnerTheme.setOnClickListener {
            binding.spinnerTheme.showDropDown()
        }
    }
    
    /**
     * Load current settings from SharedPreferences
     */
    private fun loadCurrentSettings() {
        // Load language setting
        val currentLanguage = prefs.getString("language", "en") ?: "en"
        val languagePosition = when (currentLanguage) {
            "en" -> 0
            "af" -> 1
            "zu" -> 2
            else -> 0
        }
        binding.spinnerLanguage.setText(resources.getStringArray(R.array.languages)[languagePosition], false)
        
        // Load temperature unit setting
        val currentTempUnit = prefs.getString("temperature_unit", "C") ?: "C"
        val tempUnitPosition = when (currentTempUnit) {
            "C" -> 0
            "F" -> 1
            else -> 0
        }
        binding.spinnerTemperatureUnit.setText(resources.getStringArray(R.array.temperature_units)[tempUnitPosition], false)
        
        // Load wind speed unit setting
        val currentWindUnit = prefs.getString("wind_speed_unit", "kmh") ?: "kmh"
        val windUnitPosition = when (currentWindUnit) {
            "kmh" -> 0
            "ms" -> 1
            "mph" -> 2
            else -> 0
        }
        binding.spinnerWindSpeedUnit.setText(resources.getStringArray(R.array.wind_speed_units)[windUnitPosition], false)
        
        // Load theme setting
        val currentTheme = prefs.getInt("theme_mode", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        val themePosition = when (currentTheme) {
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -> 0
            AppCompatDelegate.MODE_NIGHT_NO -> 1
            AppCompatDelegate.MODE_NIGHT_YES -> 2
            else -> 0
        }
        binding.spinnerTheme.setText(resources.getStringArray(R.array.themes)[themePosition], false)
        
        // Load location services setting
        val locationServicesEnabled = prefs.getBoolean("location_services_enabled", true)
        binding.switchLocationServices.isChecked = locationServicesEnabled
        
        // Load weather alerts setting
        val weatherAlertsEnabled = prefs.getBoolean("weather_alerts_enabled", false)
        binding.switchWeatherAlerts.isChecked = weatherAlertsEnabled
        
        Log.d(TAG, "Current settings loaded")
    }
    
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SettingsActivity destroyed")
    }
}
