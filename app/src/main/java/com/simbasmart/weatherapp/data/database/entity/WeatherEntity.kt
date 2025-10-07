package com.simbasmart.weatherapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.util.Date

/**
 * Weather Entity for SQLite database storage
 * Stores current weather and forecast data for offline access
 */
@Entity(tableName = "weather_data")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "location_id")
    val locationId: String,
    
    @ColumnInfo(name = "timestamp")
    val timestamp: Date,
    
    @ColumnInfo(name = "temperature")
    val temperature: Double,
    
    @ColumnInfo(name = "feels_like")
    val feelsLike: Double,
    
    @ColumnInfo(name = "humidity")
    val humidity: Int,
    
    @ColumnInfo(name = "pressure")
    val pressure: Double,
    
    @ColumnInfo(name = "wind_speed")
    val windSpeed: Double,
    
    @ColumnInfo(name = "wind_direction")
    val windDirection: Int,
    
    @ColumnInfo(name = "description")
    val description: String,
    
    @ColumnInfo(name = "icon")
    val icon: String,
    
    @ColumnInfo(name = "visibility")
    val visibility: Double,
    
    @ColumnInfo(name = "uv_index")
    val uvIndex: Double,
    
    @ColumnInfo(name = "sunrise")
    val sunrise: Date?,
    
    @ColumnInfo(name = "sunset")
    val sunset: Date?,
    
    @ColumnInfo(name = "data_type")
    val dataType: String, // "current", "hourly", "daily"
    
    @ColumnInfo(name = "forecast_date")
    val forecastDate: Date? = null,
    
    @ColumnInfo(name = "is_synced")
    val isSynced: Boolean = false
)
