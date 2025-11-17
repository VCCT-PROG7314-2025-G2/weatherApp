package com.simbasmart.weatherapp.data.model

import java.util.Date

/**
 * Weather data model for UI layer
 * Represents weather information displayed to users
 */
data class Weather(
    val id: String,
    val locationId: String,
    val locationName: String = "",
    val temperature: Double,
    val description: String,
    val humidity: Int,
    val windSpeed: Double,
    val pressure: Int,
    val feelsLike: Double = 0.0,
    val visibility: Int = 0,
    val timestamp: Long,
    val date: Date? = null
) {
    
    /**
     * Get formatted temperature string
     */
    fun getFormattedTemperature(): String {
        return "${temperature.toInt()}°"
    }
    
    /**
     * Get formatted humidity
     */
    fun getFormattedHumidity(): String {
        return "$humidity%"
    }
    
    /**
     * Get formatted wind speed
     */
    fun getFormattedWindSpeed(): String {
        return "${windSpeed.toInt()} km/h"
    }
    
    /**
     * Get formatted pressure
     */
    fun getFormattedPressure(): String {
        return "$pressure mbar"
    }
    
    /**
     * Get formatted feels like temperature
     */
    fun getFormattedFeelsLike(): String {
        return "${feelsLike.toInt()}°"
    }
    
    /**
     * Get formatted visibility
     */
    fun getFormattedVisibility(): String {
        return "${visibility / 1000} km"
    }
    
    /**
     * Get weather condition description
     */
    fun getWeatherCondition(): String {
        return when {
            description.contains("clear", ignoreCase = true) -> "Clear"
            description.contains("cloud", ignoreCase = true) -> "Cloudy"
            description.contains("rain", ignoreCase = true) -> "Rainy"
            description.contains("snow", ignoreCase = true) -> "Snowy"
            description.contains("storm", ignoreCase = true) -> "Stormy"
            description.contains("fog", ignoreCase = true) -> "Foggy"
            description.contains("wind", ignoreCase = true) -> "Windy"
            else -> description.replaceFirstChar { it.uppercase() }
        }
    }
    
    /**
     * Get formatted date for display
     */
    fun getFormattedDate(): String {
        return date?.let { 
            val calendar = java.util.Calendar.getInstance()
            calendar.time = it
            val dateFormat = java.text.SimpleDateFormat("EEE", java.util.Locale.getDefault())
            dateFormat.format(it)
        } ?: "Unknown"
    }
}
