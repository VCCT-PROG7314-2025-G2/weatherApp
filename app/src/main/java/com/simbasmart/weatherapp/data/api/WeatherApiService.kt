package com.simbasmart.weatherapp.data.api

import android.util.Log
import com.simbasmart.weatherapp.data.model.Weather
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Date

/**
 * Real Weather API Service using OpenWeatherMap
 * Provides actual weather data from open source weather service
 */
class WeatherApiService {
    
    private val TAG = "WeatherApiService"
    
    // OpenWeatherMap API - Free open source weather data
    private val BASE_URL = ApiConfig.BASE_URL
    
    // Retrofit interface for API calls
    interface WeatherApi {
        @GET("weather")
        suspend fun getCurrentWeather(
            @Query("q") city: String,
            @Query("appid") apiKey: String,
            @Query("units") units: String = "metric"
        ): WeatherResponse
        
        @GET("forecast")
        suspend fun getForecast(
            @Query("q") city: String,
            @Query("appid") apiKey: String,
            @Query("units") units: String = "metric"
        ): ForecastResponse
        
        @GET("weather")
        suspend fun getWeatherByCoordinates(
            @Query("lat") lat: Double,
            @Query("lon") lon: Double,
            @Query("appid") apiKey: String,
            @Query("units") units: String = "metric"
        ): WeatherResponse
        
        @GET("forecast")
        suspend fun getForecastByCoordinates(
            @Query("lat") lat: Double,
            @Query("lon") lon: Double,
            @Query("appid") apiKey: String,
            @Query("units") units: String = "metric"
        ): ForecastResponse
    }
    
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    
    private val weatherApi = retrofit.create(WeatherApi::class.java)
    
    /**
     * Get current weather for a location by city name
     */
    suspend fun getCurrentWeather(cityName: String): Weather? {
        return try {
            Log.d(TAG, "Fetching current weather for: $cityName")
            
            // Check if API key is configured
            val apiKey = ApiConfig.getApiKey()
            if (apiKey == null) {
                Log.e(TAG, "API key not configured")
                throw Exception("API key not configured")
            }
            
            // Clean the city name for better API compatibility
            val cleanCityName = cleanCityName(cityName)
            Log.d(TAG, "Cleaned city name: $cleanCityName")
            
            val response = weatherApi.getCurrentWeather(cleanCityName, apiKey)
            
            Log.d(TAG, "API response received for: ${response.name}")
            
            Weather(
                id = response.id.toString(),
                locationId = cleanCityName,
                locationName = response.name,
                temperature = response.main.temp,
                description = response.weather.firstOrNull()?.description ?: "Unknown",
                humidity = response.main.humidity,
                windSpeed = response.wind.speed,
                pressure = response.main.pressure,
                feelsLike = response.main.feels_like,
                visibility = response.visibility,
                timestamp = System.currentTimeMillis(),
                date = Date()
            )
            
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching current weather for $cityName", e)
            
            // Try alternative city names
            val alternatives = getAlternativeCityNames(cityName)
            for (alternative in alternatives) {
                try {
                    Log.d(TAG, "Trying alternative city name: $alternative")
                    val altApiKey = ApiConfig.getApiKey() ?: break
                    val response = weatherApi.getCurrentWeather(alternative, altApiKey)
                    
                    return Weather(
                        id = response.id.toString(),
                        locationId = alternative,
                        locationName = response.name,
                        temperature = response.main.temp,
                        description = response.weather.firstOrNull()?.description ?: "Unknown",
                        humidity = response.main.humidity,
                        windSpeed = response.wind.speed,
                        pressure = response.main.pressure,
                        feelsLike = response.main.feels_like,
                        visibility = response.visibility,
                        timestamp = System.currentTimeMillis(),
                        date = Date()
                    )
                } catch (altException: Exception) {
                    Log.d(TAG, "Alternative city name $alternative also failed: ${altException.message}")
                }
            }
            
            // If all alternatives fail, return null
            Log.e(TAG, "All city name alternatives failed for: $cityName")
            null
        }
    }
    
    /**
     * Clean city name for better API compatibility
     */
    private fun cleanCityName(cityName: String): String {
        return cityName.trim()
            .replace(Regex("\\s+"), " ") // Replace multiple spaces with single space
            .trim()
    }
    
    /**
     * Get alternative city names to try if the original fails
     */
    private fun getAlternativeCityNames(cityName: String): List<String> {
        val alternatives = mutableListOf<String>()
        
        // Try without country code if it exists
        if (cityName.contains(",")) {
            alternatives.add(cityName.split(",")[0].trim())
        }
        
        // Try with common country codes
        val commonCountries = listOf("US", "GB", "CA", "AU", "DE", "FR", "JP", "CN", "IN", "ZA")
        for (country in commonCountries) {
            alternatives.add("$cityName,$country")
        }
        
        // Try just the first word if it's a multi-word city
        val words = cityName.split(" ")
        if (words.size > 1) {
            alternatives.add(words[0])
        }
        
        return alternatives.distinct()
    }
    
    /**
     * Get current weather by coordinates
     */
    suspend fun getCurrentWeatherByCoordinates(lat: Double, lon: Double): Weather? {
        return try {
            Log.d(TAG, "Fetching current weather for coordinates: $lat, $lon")
            
            val apiKey = ApiConfig.getApiKey()
            if (apiKey == null) {
                Log.e(TAG, "API key not configured")
                throw Exception("API key not configured")
            }
            
            val response = weatherApi.getWeatherByCoordinates(lat, lon, apiKey)
            
            Weather(
                id = response.id.toString(),
                locationId = "${lat}_${lon}",
                locationName = response.name,
                temperature = response.main.temp,
                description = response.weather.firstOrNull()?.description ?: "Unknown",
                humidity = response.main.humidity,
                windSpeed = response.wind.speed,
                pressure = response.main.pressure,
                feelsLike = response.main.feels_like,
                visibility = response.visibility,
                timestamp = System.currentTimeMillis(),
                date = Date()
            )
            
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching current weather by coordinates", e)
            null
        }
    }
    
    /**
     * Get hourly forecast for a location
     */
    suspend fun getHourlyForecast(cityName: String): List<Weather>? {
        return try {
            Log.d(TAG, "Fetching hourly forecast for: $cityName")
            
            // Check if API key is configured
            val apiKey = ApiConfig.getApiKey()
            if (apiKey == null) {
                Log.e(TAG, "API key not configured")
                throw Exception("API key not configured")
            }
            
            // Clean the city name for better API compatibility
            val cleanCityName = cleanCityName(cityName)
            Log.d(TAG, "Cleaned city name for forecast: $cleanCityName")
            
            val response = weatherApi.getForecast(cleanCityName, apiKey)
            
            Log.d(TAG, "Forecast API response received for: ${response.city.name}")
            
            // Convert forecast response to list of Weather objects
            response.list.take(24).mapIndexed { index, item ->
                Weather(
                    id = "${response.city.id}_hour_$index",
                    locationId = cleanCityName,
                    locationName = response.city.name,
                    temperature = item.main.temp,
                    description = item.weather.firstOrNull()?.description ?: "Unknown",
                    humidity = item.main.humidity,
                    windSpeed = item.wind.speed,
                    pressure = item.main.pressure,
                    feelsLike = item.main.feels_like,
                    visibility = item.visibility,
                    timestamp = item.dt * 1000, // Convert Unix timestamp to milliseconds
                    date = Date(item.dt * 1000)
                )
            }
            
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching hourly forecast for $cityName", e)
            null
        }
    }
    
    /**
     * Get daily forecast for a location (5-day forecast from OpenWeatherMap)
     */
    suspend fun getDailyForecast(cityName: String): List<Weather>? {
        return try {
            Log.d(TAG, "Fetching daily forecast for: $cityName")
            
            // Check if API key is configured
            val apiKey = ApiConfig.getApiKey()
            if (apiKey == null) {
                Log.e(TAG, "API key not configured")
                throw Exception("API key not configured")
            }
            
            // Clean the city name for better API compatibility
            val cleanCityName = cleanCityName(cityName)
            Log.d(TAG, "Cleaned city name for daily forecast: $cleanCityName")
            
            val response = weatherApi.getForecast(cleanCityName, apiKey)
            
            Log.d(TAG, "Daily forecast API response received for: ${response.city.name}")
            Log.d(TAG, "Total forecast items received: ${response.list.size}")
            
            // Group by day and get daily averages
            val dailyForecasts = response.list.groupBy { item ->
                java.time.Instant.ofEpochSecond(item.dt)
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate()
            }.map { (date, items) ->
                Log.d(TAG, "Processing day: $date with ${items.size} items")
                
                val avgTemp = items.map { it.main.temp }.average()
                val avgHumidity = items.map { it.main.humidity }.average()
                val avgWindSpeed = items.map { it.wind.speed }.average()
                val avgFeelsLike = items.map { it.main.feels_like }.average()
                val mostCommonDescription = items.map { it.weather.firstOrNull()?.description ?: "Unknown" }
                    .groupingBy { it }.eachCount().maxByOrNull { it.value }?.key ?: "Unknown"
                
                Weather(
                    id = "${response.city.id}_day_${date}",
                    locationId = cleanCityName,
                    locationName = response.city.name,
                    temperature = avgTemp,
                    description = mostCommonDescription,
                    humidity = avgHumidity.toInt(),
                    windSpeed = avgWindSpeed,
                    pressure = items.first().main.pressure,
                    feelsLike = avgFeelsLike,
                    visibility = items.first().visibility,
                    timestamp = date.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli(),
                    date = Date(date.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli())
                )
            }.sortedBy { it.date } // Sort by date to ensure proper order
            
            Log.d(TAG, "Generated ${dailyForecasts.size} daily forecasts")
            
            // Return 5 days (OpenWeatherMap free API limit)
            dailyForecasts.take(5)
            
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching daily forecast for $cityName", e)
            null
        }
    }
}

/**
 * Data classes for OpenWeatherMap API response
 */
data class WeatherResponse(
    val id: Int,
    val name: String,
    val main: Main,
    val weather: List<WeatherInfo>,
    val wind: Wind,
    val visibility: Int
)

data class ForecastResponse(
    val city: City,
    val list: List<ForecastItem>
)

data class City(
    val id: Int,
    val name: String,
    val country: String
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int
)

data class WeatherInfo(
    val description: String,
    val icon: String
)

data class Wind(
    val speed: Double
)

data class ForecastItem(
    val dt: Long,
    val main: Main,
    val weather: List<WeatherInfo>,
    val wind: Wind,
    val visibility: Int
)
