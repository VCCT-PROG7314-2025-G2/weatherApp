package com.simbasmart.weatherapp.ui.weather

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.simbasmart.weatherapp.R
import com.simbasmart.weatherapp.databinding.ActivitySearchBinding
import com.simbasmart.weatherapp.viewmodel.WeatherViewModel

/**
 * SearchActivity - Location search functionality
 * Allows users to search for any location and get weather data
 */
class SearchActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivitySearchBinding
    private val TAG = "SearchActivity"
    
    // Popular cities for quick access
    private val popularCities = listOf(
        "New York, US",
        "London, GB",
        "Tokyo, JP",
        "Paris, FR",
        "Sydney, AU",
        "Toronto, CA",
        "Berlin, DE",
        "Moscow, RU",
        "Beijing, CN",
        "Mumbai, IN",
        "Cape Town, ZA",
        "Johannesburg, ZA",
        "Durban, ZA",
        "Pretoria, ZA"
    )
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        Log.d(TAG, "SearchActivity created")
        
        setupUI()
        setupListeners()
        setupObservers()
    }
    
    /**
     * Setup UI components
     */
    private fun setupUI() {
        // Setup action bar
        supportActionBar?.apply {
            title = "Search Location"
            setDisplayHomeAsUpEnabled(true)
        }
        
        // Setup search suggestions
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, popularCities)
        binding.etSearch.setAdapter(adapter)
        binding.etSearch.threshold = 1
        
        // Setup popular cities grid
        setupPopularCities()
        
        // Enable search button initially
        binding.btnSearch.isEnabled = true
    }
    
    /**
     * Setup popular cities for quick access
     */
    private fun setupPopularCities() {
        // Create a more user-friendly display of popular cities
        val popularCitiesText = buildString {
            appendLine("🌍 Popular Cities:")
            appendLine()
            popularCities.forEach { city ->
                appendLine("• $city")
            }
            appendLine()
            appendLine("💡 Tip: You can search for any city worldwide!")
        }
        binding.tvPopularCities.text = popularCitiesText
    }
    
    /**
     * Setup click listeners
     */
    private fun setupListeners() {
        // Search button
        binding.btnSearch.setOnClickListener {
            val location = binding.etSearch.text.toString().trim()
            
            if (location.isEmpty()) {
                Toast.makeText(this, "Please enter a city name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            Log.d(TAG, "Searching for location: $location")
            
            // Return the searched location
            val intent = Intent()
            intent.putExtra("location", location)
            setResult(RESULT_OK, intent)
            finish()
        }
        
        // Search text change listener
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val isEmpty = s.isNullOrEmpty()
                binding.btnSearch.isEnabled = !isEmpty
                if (!isEmpty) {
                    binding.btnSearch.text = "Search Weather"
                }
            }
        })
        
        // Enter key listener
        binding.etSearch.setOnEditorActionListener { _, _, _ ->
            val query = binding.etSearch.text.toString().trim()
            if (query.isNotEmpty()) {
                Log.d(TAG, "Enter key pressed for: $query")
                searchLocation(query)
            }
            true
        }
        
        // Popular city click listener (simplified)
        binding.tvPopularCities.setOnClickListener {
            // Show popular cities dialog or expand list
            showPopularCitiesDialog()
        }
    }
    
    /**
     * Setup LiveData observers
     */
    private fun setupObservers() {
        // No observers needed since we're not loading weather data here
        // The main activity will handle weather loading
    }
    
    /**
     * Search for weather data by location
     */
    private fun searchLocation(location: String) {
        Log.d(TAG, "Searching for location: $location")
        
        // Show loading message
        Toast.makeText(this, "🔍 Searching for $location...", Toast.LENGTH_SHORT).show()
        
        // Return the searched location to the main activity
        val intent = Intent()
        intent.putExtra("location", location)
        setResult(RESULT_OK, intent)
        Toast.makeText(this, "✅ Returning to load weather for $location", Toast.LENGTH_SHORT).show()
        finish()
    }
    
    /**
     * Show popular cities dialog
     */
    private fun showPopularCitiesDialog() {
        val items = popularCities.toTypedArray()
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("🌍 Popular Cities")
            .setMessage("Select a city to get weather information:")
            .setItems(items) { _, which ->
                val selectedCity = items[which]
                Log.d(TAG, "Popular city selected: $selectedCity")
                binding.etSearch.setText(selectedCity)
                searchLocation(selectedCity)
            }
            .setNegativeButton("Cancel", null)
            .setPositiveButton("Search Any City") { _, _ ->
                binding.etSearch.requestFocus()
            }
            .show()
    }
    
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SearchActivity destroyed")
    }
}
