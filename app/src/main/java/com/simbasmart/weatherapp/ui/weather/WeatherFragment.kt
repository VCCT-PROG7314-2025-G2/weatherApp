package com.simbasmart.weatherapp.ui.weather

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.simbasmart.weatherapp.databinding.FragmentWeatherBinding
import com.simbasmart.weatherapp.viewmodel.WeatherViewModel
import java.text.SimpleDateFormat
import java.util.*

/**
 * WeatherFragment - Main weather display screen
 * Shows current weather, hourly and daily forecasts
 */
class WeatherFragment : Fragment() {
    
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var hourlyAdapter: HourlyForecastAdapter
    private lateinit var dailyAdapter: DailyForecastAdapter
    
    private val TAG = "WeatherFragment"
    
    // Modern Activity Result API
    private val searchLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            result.data?.getStringExtra("location")?.let { location ->
                Log.d(TAG, "Search result received for location: $location")
                viewModel.loadWeatherDataForLocation(location)
                Toast.makeText(context, "Loading weather for $location", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        Log.d(TAG, "WeatherFragment created")
        
        setupRecyclerViews()
        setupObservers()
        setupClickListeners()
        
        // Load weather data
        viewModel.loadWeatherData()
    }
    
    /**
     * Setup RecyclerViews for hourly and daily forecasts
     */
    private fun setupRecyclerViews() {
        // Hourly forecast
        hourlyAdapter = HourlyForecastAdapter()
        binding.rvHourlyForecast.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = hourlyAdapter
        }
        
        // Daily forecast
        dailyAdapter = DailyForecastAdapter()
        binding.rvDailyForecast.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dailyAdapter
        }
    }
    
    /**
     * Setup observers for LiveData
     */
    private fun setupObservers() {
        // Current weather
        viewModel.currentWeather.observe(viewLifecycleOwner) { weather ->
            weather?.let { 
                Log.d(TAG, "Updating current weather display for: ${it.locationName}")
                updateCurrentWeather(it) 
            }
        }
        
        // Hourly forecast
        viewModel.hourlyForecast.observe(viewLifecycleOwner) { forecast ->
            forecast?.let { 
                Log.d(TAG, "Updating hourly forecast with ${it.size} items")
                hourlyAdapter.submitList(it) 
            }
        }
        
        // Daily forecast
        viewModel.dailyForecast.observe(viewLifecycleOwner) { forecast ->
            forecast?.let { 
                Log.d(TAG, "Updating daily forecast with ${it.size} items")
                dailyAdapter.submitList(it) 
            }
        }
        
        // Loading state
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // Handle loading state if needed
            Log.d(TAG, "Loading state: $isLoading")
        }
        
        // Error state
        viewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let { errorMessage ->
                Log.e(TAG, "Error in WeatherFragment: $errorMessage")
                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
            }
        }
    }
    
    /**
     * Setup click listeners
     */
    private fun setupClickListeners() {
        // Refresh button
        binding.ivRefresh.setOnClickListener {
            viewModel.loadWeatherData()
            Log.d(TAG, "Refreshing weather data...")
        }
        
        // Search button
        binding.ivSearch.setOnClickListener {
            Log.d(TAG, "Search button clicked")
            val intent = Intent(context, SearchActivity::class.java)
            searchLauncher.launch(intent)
        }
        
        // Location text click
        binding.tvLocation.setOnClickListener {
            Log.d(TAG, "Location text clicked")
            val intent = Intent(context, SearchActivity::class.java)
            searchLauncher.launch(intent)
        }
    }
    
    /**
     * Update current weather display
     */
    private fun updateCurrentWeather(weather: com.simbasmart.weatherapp.data.model.Weather) {
        Log.d(TAG, "Updating weather display for: ${weather.locationName}")
        
        // Temperature
        binding.tvTemperatureMain.text = "${weather.temperature.toInt()}°"
        
        // Weather description
        binding.tvWeatherDescription.text = weather.description.replaceFirstChar { it.uppercase() }
        
        // Location name
        binding.tvLocation.text = weather.locationName.ifEmpty { "Current Location" }
        
        // Wind speed
        binding.tvWindSpeed.text = "${weather.windSpeed.toInt()} km/h"
        
        // Humidity
        binding.tvHumidity.text = "${weather.humidity}%"
        
        // Feels like temperature
        binding.tvFeelsLike.text = "Feels like ${weather.getFormattedFeelsLike()}"
        
        // Visibility
        binding.tvVisibility.text = weather.getFormattedVisibility()
        
        // Pressure
        binding.tvPressure.text = weather.getFormattedPressure()
        
        // Update weather icon based on condition
        updateWeatherIcon(weather.description.lowercase())
        
        // Update last updated time
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        binding.tvLastUpdated.text = "Updated at ${timeFormat.format(Date())}"
        
        Log.d(TAG, "Weather display updated successfully")
    }
    
    /**
     * Update weather icon based on weather condition - using beautiful 3D icons
     */
    private fun updateWeatherIcon(description: String) {
        val iconRes = when {
            description.contains("thunder") || description.contains("storm") -> 
                com.simbasmart.weatherapp.R.drawable.ic_weather_thunder_3d
            description.contains("rain") || description.contains("drizzle") -> 
                com.simbasmart.weatherapp.R.drawable.ic_weather_rain_3d
            description.contains("snow") -> 
                com.simbasmart.weatherapp.R.drawable.ic_weather_snow_3d
            description.contains("fog") || description.contains("mist") -> 
                com.simbasmart.weatherapp.R.drawable.ic_weather_fog
            description.contains("clear") || description.contains("sunny") -> 
                com.simbasmart.weatherapp.R.drawable.ic_weather_sunny_3d
            description.contains("cloud") -> 
                com.simbasmart.weatherapp.R.drawable.ic_weather_cloudy_day
            else -> com.simbasmart.weatherapp.R.drawable.ic_weather_sunny_3d
        }
        
        binding.ivWeatherMain.setImageResource(iconRes)
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
