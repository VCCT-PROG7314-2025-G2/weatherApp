package com.simbasmart.weatherapp.data.database.dao

import androidx.room.*
import com.simbasmart.weatherapp.data.database.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

/**
 * Data Access Object for Weather data in SQLite database
 * Provides methods for CRUD operations on weather data
 */
@Dao
interface WeatherDao {
    
    // Insert operations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherList(weatherList: List<WeatherEntity>)
    
    // Query operations
    @Query("SELECT * FROM weather_data WHERE location_id = :locationId AND data_type = 'current' ORDER BY timestamp DESC LIMIT 1")
    suspend fun getCurrentWeather(locationId: String): WeatherEntity?
    
    @Query("SELECT * FROM weather_data WHERE location_id = :locationId AND data_type = 'hourly' AND forecast_date >= :startDate ORDER BY forecast_date ASC")
    fun getHourlyForecast(locationId: String, startDate: Date): Flow<List<WeatherEntity>>
    
    @Query("SELECT * FROM weather_data WHERE location_id = :locationId AND data_type = 'daily' AND forecast_date >= :startDate ORDER BY forecast_date ASC LIMIT 7")
    fun getDailyForecast(locationId: String, startDate: Date): Flow<List<WeatherEntity>>
    
    @Query("SELECT * FROM weather_data WHERE location_id = :locationId ORDER BY timestamp DESC")
    fun getAllWeatherForLocation(locationId: String): Flow<List<WeatherEntity>>
    
    @Query("SELECT * FROM weather_data WHERE is_synced = 0")
    suspend fun getUnsyncedWeather(): List<WeatherEntity>
    
    // Update operations
    @Update
    suspend fun updateWeather(weather: WeatherEntity)
    
    @Query("UPDATE weather_data SET is_synced = 1 WHERE id = :weatherId")
    suspend fun markAsSynced(weatherId: Long)
    
    @Query("UPDATE weather_data SET is_synced = 1 WHERE location_id = :locationId")
    suspend fun markLocationAsSynced(locationId: String)
    
    // Delete operations
    @Delete
    suspend fun deleteWeather(weather: WeatherEntity)
    
    @Query("DELETE FROM weather_data WHERE location_id = :locationId")
    suspend fun deleteWeatherForLocation(locationId: String)
    
    @Query("DELETE FROM weather_data WHERE timestamp < :cutoffDate")
    suspend fun deleteOldWeatherData(cutoffDate: Date)
    
    // Utility queries
    @Query("SELECT COUNT(*) FROM weather_data WHERE location_id = :locationId")
    suspend fun getWeatherCountForLocation(locationId: String): Int
    
    @Query("SELECT MAX(timestamp) FROM weather_data WHERE location_id = :locationId")
    suspend fun getLastUpdateTime(locationId: String): Date?
    
    @Query("SELECT DISTINCT location_id FROM weather_data")
    suspend fun getAllLocationIds(): List<String>
}
