package com.simbasmart.weatherapp.data.api

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
    
    //  OpenWeatherMap API key
    const val OPENWEATHER_API_KEY = "a40a192523f898cf6b963d3bea52b2e8"
    
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
     */
    fun isApiKeyConfigured(): Boolean {
        return OPENWEATHER_API_KEY != "a40a192523f898cf6b963d3bea52b2e8" && OPENWEATHER_API_KEY.isNotEmpty()
    }
    
    /**
     * Get API key with validation
     */
    fun getApiKey(): String? {
        return if (isApiKeyConfigured()) {
            OPENWEATHER_API_KEY
        } else {
            null
        }
    }
}
