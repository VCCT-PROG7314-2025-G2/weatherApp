package com.weatherapp.data.api

/**
 * API Configuration for OpenWeatherMap
 * 
 * To get a FREE API key:
 * 1. Go to https://openweathermap.org/
 * 2. Sign up for a free account
 * 3. Go to "My API Keys" section
 * 4. Copy your API key and replace YOUR_API_KEY_HERE below
 * 
 * Free tier includes:
 * - 60 calls/minute
 * - Current weather data
 * - 5-day forecast
 * - No credit card required
 */
object ApiConfig {
    
    // Replace this with your actual OpenWeatherMap API key
    const val OPENWEATHER_API_KEY = "a6e2b29393cf999a88ebaf4314931f13"
    
    // Base URL for OpenWeatherMap API
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    
    // Default units (metric = Celsius, imperial = Fahrenheit)
    const val DEFAULT_UNITS = "metric"
    
    // Supported cities for demo
    val SUPPORTED_CITIES = mapOf(
        "johannesburg_sa" to "Johannesburg,ZA",
        "cape_town_sa" to "Cape Town,ZA", 
        "durban_sa" to "Durban,ZA",
        "pretoria_sa" to "Pretoria,ZA",
        "bloemfontein_sa" to "Bloemfontein,ZA",
        "port_elizabeth_sa" to "Port Elizabeth,ZA"
    )
    
    /**
     * Check if API key is configured
     * 
     * @return true if API key is set and not the placeholder value, false otherwise
     */
    fun isApiKeyConfigured(): Boolean {
        return OPENWEATHER_API_KEY != "YOUR_API_KEY_HERE" && OPENWEATHER_API_KEY.isNotEmpty()
    }
    
    /**
     * Get API key with validation
     * 
     * Validates that the API key is properly configured before returning it.
     * Returns null if the API key is not configured, preventing API calls with invalid keys.
     * 
     * @return The configured API key, or null if not configured
     */
    fun getApiKey(): String? {
        return if (isApiKeyConfigured()) {
            OPENWEATHER_API_KEY
        } else {
            null
        }
    }
}
