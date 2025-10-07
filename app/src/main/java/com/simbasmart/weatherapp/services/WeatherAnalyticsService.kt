package com.simbasmart.weatherapp.services

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.simbasmart.weatherapp.data.model.Weather
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

/**
 * Weather Analytics Service
 * Tracks weather patterns and provides insights
 */
class WeatherAnalyticsService(context: Context) {
    
    private val TAG = "WeatherAnalyticsService"
    private val prefs: SharedPreferences = context.getSharedPreferences("weather_analytics", Context.MODE_PRIVATE)
    private val gson = Gson()
    
    companion object {
        private const val KEY_WEATHER_HISTORY = "weather_history"
        private const val KEY_FAVORITE_LOCATIONS = "favorite_locations"
        private const val KEY_WEATHER_STATS = "weather_stats"
        private const val MAX_HISTORY_SIZE = 100
    }
    
    /**
     * Save weather data to history
     */
    fun saveWeatherToHistory(weather: Weather) {
        try {
            val history = getWeatherHistory().toMutableList()
            
            // Add new weather data
            history.add(weather)
            
            // Keep only recent data
            if (history.size > MAX_HISTORY_SIZE) {
                history.removeAt(0)
            }
            
            // Save to preferences
            val historyJson = gson.toJson(history)
            prefs.edit().putString(KEY_WEATHER_HISTORY, historyJson).apply()
            
            Log.d(TAG, "Weather data saved to history: ${weather.locationName}")
            
        } catch (e: Exception) {
            Log.e(TAG, "Error saving weather to history", e)
        }
    }
    
    /**
     * Get weather history
     */
    fun getWeatherHistory(): List<Weather> {
        return try {
            val historyJson = prefs.getString(KEY_WEATHER_HISTORY, "[]")
            val type = object : TypeToken<List<Weather>>() {}.type
            gson.fromJson(historyJson, type) ?: emptyList()
        } catch (e: Exception) {
            Log.e(TAG, "Error getting weather history", e)
            emptyList()
        }
    }
    
    /**
     * Get weather statistics
     */
    fun getWeatherStats(): WeatherStats {
        val history = getWeatherHistory()
        
        if (history.isEmpty()) {
            return WeatherStats()
        }
        
        val temperatures = history.map { it.temperature }
        val humidities = history.map { it.humidity }
        val windSpeeds = history.map { it.windSpeed }
        
        return WeatherStats(
            averageTemperature = temperatures.average(),
            minTemperature = temperatures.minOrNull() ?: 0.0,
            maxTemperature = temperatures.maxOrNull() ?: 0.0,
            averageHumidity = humidities.average(),
            averageWindSpeed = windSpeeds.average(),
            totalRecords = history.size,
            mostCommonCondition = getMostCommonWeatherCondition(history),
            lastUpdated = Date()
        )
    }
    
    /**
     * Get most common weather condition
     */
    private fun getMostCommonWeatherCondition(history: List<Weather>): String {
        return history.map { it.description }
            .groupingBy { it }
            .eachCount()
            .maxByOrNull { it.value }
            ?.key ?: "Unknown"
    }
    
    /**
     * Get temperature trend
     */
    fun getTemperatureTrend(): TemperatureTrend {
        val history = getWeatherHistory()
        
        if (history.size < 2) {
            return TemperatureTrend.STABLE
        }
        
        val recent = history.takeLast(5).map { it.temperature }.average()
        val older = history.take(5).map { it.temperature }.average()
        
        return when {
            recent > older + 2 -> TemperatureTrend.RISING
            recent < older - 2 -> TemperatureTrend.FALLING
            else -> TemperatureTrend.STABLE
        }
    }
    
    /**
     * Add favorite location
     */
    fun addFavoriteLocation(location: String) {
        val favorites = getFavoriteLocations().toMutableSet()
        favorites.add(location)
        
        val favoritesJson = gson.toJson(favorites.toList())
        prefs.edit().putString(KEY_FAVORITE_LOCATIONS, favoritesJson).apply()
        
        Log.d(TAG, "Added favorite location: $location")
    }
    
    /**
     * Remove favorite location
     */
    fun removeFavoriteLocation(location: String) {
        val favorites = getFavoriteLocations().toMutableSet()
        favorites.remove(location)
        
        val favoritesJson = gson.toJson(favorites.toList())
        prefs.edit().putString(KEY_FAVORITE_LOCATIONS, favoritesJson).apply()
        
        Log.d(TAG, "Removed favorite location: $location")
    }
    
    /**
     * Get favorite locations
     */
    fun getFavoriteLocations(): Set<String> {
        return try {
            val favoritesJson = prefs.getString(KEY_FAVORITE_LOCATIONS, "[]")
            val type = object : TypeToken<List<String>>() {}.type
            val list: List<String> = gson.fromJson(favoritesJson, type) ?: emptyList()
            list.toSet()
        } catch (e: Exception) {
            Log.e(TAG, "Error getting favorite locations", e)
            emptySet()
        }
    }
    
    /**
     * Get weather insights
     */
    fun getWeatherInsights(): List<String> {
        val insights = mutableListOf<String>()
        val stats = getWeatherStats()
        val trend = getTemperatureTrend()
        
        // Temperature insights
        when (trend) {
            TemperatureTrend.RISING -> insights.add("Temperature is trending upward")
            TemperatureTrend.FALLING -> insights.add("Temperature is trending downward")
            TemperatureTrend.STABLE -> insights.add("Temperature is stable")
        }
        
        // Humidity insights
        when {
            stats.averageHumidity > 70 -> insights.add("High humidity conditions")
            stats.averageHumidity < 30 -> insights.add("Low humidity conditions")
            else -> insights.add("Moderate humidity levels")
        }
        
        // Wind insights
        when {
            stats.averageWindSpeed > 20 -> insights.add("Windy conditions")
            stats.averageWindSpeed < 5 -> insights.add("Calm wind conditions")
            else -> insights.add("Moderate wind conditions")
        }
        
        return insights
    }
    
    /**
     * Clear all analytics data
     */
    fun clearAnalyticsData() {
        prefs.edit().clear().apply()
        Log.d(TAG, "Analytics data cleared")
    }
}

/**
 * Weather statistics data class
 */
data class WeatherStats(
    val averageTemperature: Double = 0.0,
    val minTemperature: Double = 0.0,
    val maxTemperature: Double = 0.0,
    val averageHumidity: Double = 0.0,
    val averageWindSpeed: Double = 0.0,
    val totalRecords: Int = 0,
    val mostCommonCondition: String = "",
    val lastUpdated: Date = Date()
)

/**
 * Temperature trend enum
 */
enum class TemperatureTrend {
    RISING,
    FALLING,
    STABLE
}
