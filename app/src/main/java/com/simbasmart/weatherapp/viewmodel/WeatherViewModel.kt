package com.simbasmart.weatherapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.simbasmart.weatherapp.data.model.Weather
import com.simbasmart.weatherapp.data.repository.WeatherRepository
import com.simbasmart.weatherapp.data.api.WeatherApiService
import kotlinx.coroutines.launch
import java.util.Date

/**
 * WeatherViewModel - Manages weather data and UI state
 * Handles data operations and provides LiveData for UI updates
 */
class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository = WeatherRepository(application)
    private val apiService = WeatherApiService()
    private val TAG = "WeatherViewModel"
    
    // LiveData for UI state
    private val _currentWeather = MutableLiveData<Weather?>()
    val currentWeather: LiveData<Weather?> = _currentWeather
    
    private val _hourlyForecast = MutableLiveData<List<Weather>?>()
    val hourlyForecast: LiveData<List<Weather>?> = _hourlyForecast
    
    private val _dailyForecast = MutableLiveData<List<Weather>?>()
    val dailyForecast: LiveData<List<Weather>?> = _dailyForecast
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    // Current location
    private var currentLocationId: String? = null
    
    init {
        Log.d(TAG, "WeatherViewModel initialized")
        loadWeatherData()
    }
    
    /**
     * Load weather data for current location
     */
    fun loadWeatherData() {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Loading weather data")
                _isLoading.value = true
                _error.value = null
                
                // Get current location
                val location = repository.getCurrentLocation()
                if (location != null) {
                    currentLocationId = location.locationId
                    loadWeatherForLocation(location.locationId)
                } else {
                    // Use default location (Johannesburg for South Africa) - proper format for API
                    currentLocationId = "Johannesburg,ZA"
                    loadWeatherForLocation(currentLocationId!!)
                }
                
            } catch (e: Exception) {
                Log.e(TAG, "Error loading weather data", e)
                _error.value = "Failed to load weather data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Load weather data for specific location
     */
    fun loadWeatherForLocation(locationId: String) {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Loading weather data for location: $locationId")
                _isLoading.value = true
                _error.value = null
                
                // Load current weather from API
                val currentWeather = apiService.getCurrentWeather(locationId)
                if (currentWeather != null) {
                    _currentWeather.value = currentWeather
                    Log.d(TAG, "Current weather loaded: ${currentWeather.locationName}")
                } else {
                    _error.value = "Failed to load current weather for $locationId"
                    _currentWeather.value = null
                }
                
                // Load hourly forecast from API
                val hourlyForecast = apiService.getHourlyForecast(locationId)
                if (hourlyForecast != null) {
                    _hourlyForecast.value = hourlyForecast
                    Log.d(TAG, "Hourly forecast loaded: ${hourlyForecast.size} items")
                } else {
                    _hourlyForecast.value = emptyList()
                    Log.w(TAG, "Failed to load hourly forecast for $locationId")
                }
                
                // Load daily forecast from API
                val dailyForecast = apiService.getDailyForecast(locationId)
                if (dailyForecast != null) {
                    _dailyForecast.value = dailyForecast
                    Log.d(TAG, "Daily forecast loaded: ${dailyForecast.size} items")
                } else {
                    _dailyForecast.value = emptyList()
                    Log.w(TAG, "Failed to load daily forecast for $locationId")
                }
                
            } catch (e: Exception) {
                Log.e(TAG, "Error loading weather for location: $locationId", e)
                _error.value = "Failed to load weather for location: ${e.message}"
                _currentWeather.value = null
                _hourlyForecast.value = emptyList()
                _dailyForecast.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Load weather data for any location by city name
     */
    fun loadWeatherDataForLocation(cityName: String) {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Loading weather data for city: $cityName")
                _isLoading.value = true
                _error.value = null
                
                // Load current weather from API
                Log.d(TAG, "Fetching current weather for: $cityName")
                val currentWeather = apiService.getCurrentWeather(cityName)
                if (currentWeather != null) {
                    _currentWeather.value = currentWeather
                    Log.d(TAG, "Current weather received: ${currentWeather.locationName}")
                } else {
                    _error.value = "City not found: $cityName. Please try a different spelling or city name."
                    _currentWeather.value = null
                    _hourlyForecast.value = emptyList()
                    _dailyForecast.value = emptyList()
                    return@launch
                }
                
                // Load hourly forecast from API
                Log.d(TAG, "Fetching hourly forecast for: $cityName")
                val hourlyForecast = apiService.getHourlyForecast(cityName)
                if (hourlyForecast != null) {
                    _hourlyForecast.value = hourlyForecast
                    Log.d(TAG, "Hourly forecast received: ${hourlyForecast.size} items")
                } else {
                    _hourlyForecast.value = emptyList()
                    Log.w(TAG, "Failed to load hourly forecast for $cityName")
                }
                
                // Load daily forecast from API
                Log.d(TAG, "Fetching daily forecast for: $cityName")
                val dailyForecast = apiService.getDailyForecast(cityName)
                if (dailyForecast != null) {
                    _dailyForecast.value = dailyForecast
                    Log.d(TAG, "Daily forecast received: ${dailyForecast.size} items")
                } else {
                    _dailyForecast.value = emptyList()
                    Log.w(TAG, "Failed to load daily forecast for $cityName")
                }
                
                // Update current location
                currentLocationId = cityName
                Log.d(TAG, "Weather data successfully loaded for: $cityName")
                
                // Clear any previous errors
                _error.value = null
                
            } catch (e: Exception) {
                Log.e(TAG, "Error loading weather for city: $cityName", e)
                val errorMessage = when {
                    e.message?.contains("404") == true -> "City not found: $cityName. Please try a different spelling or city name."
                    e.message?.contains("401") == true -> "API key error. Please check configuration."
                    e.message?.contains("network") == true -> "Network error. Please check your internet connection and try again."
                    e.message?.contains("timeout") == true -> "Request timeout. Please check your internet connection and try again."
                    else -> "Failed to load weather for $cityName. Please try again or check your internet connection."
                }
                _error.value = errorMessage
                
                // Clear weather data on error
                _currentWeather.value = null
                _hourlyForecast.value = emptyList()
                _dailyForecast.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Refresh weather data
     */
    fun refreshWeatherData() {
        currentLocationId?.let { locationId ->
            loadWeatherForLocation(locationId)
        }
    }
    
    /**
     * Update current location
     */
    fun updateCurrentLocation(locationId: String) {
        viewModelScope.launch {
            try {
                repository.setCurrentLocation(locationId)
                currentLocationId = locationId
                loadWeatherForLocation(locationId)
                Log.d(TAG, "Current location updated to: $locationId")
            } catch (e: Exception) {
                Log.e(TAG, "Error updating current location", e)
                _error.value = "Failed to update location: ${e.message}"
            }
        }
    }
    
    /**
     * Toggle favorite status for location
     */
    fun toggleFavoriteLocation(locationId: String, isFavorite: Boolean) {
        viewModelScope.launch {
            try {
                repository.updateFavoriteStatus(locationId, isFavorite)
                Log.d(TAG, "Favorite status updated for location: $locationId")
            } catch (e: Exception) {
                Log.e(TAG, "Error updating favorite status", e)
                _error.value = "Failed to update favorite status: ${e.message}"
            }
        }
    }
    
    /**
     * Clear error message
     */
    fun clearError() {
        _error.value = null
    }
    
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "WeatherViewModel cleared")
    }
}
