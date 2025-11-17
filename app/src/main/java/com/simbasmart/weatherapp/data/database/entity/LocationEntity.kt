package com.simbasmart.weatherapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.util.Date

/**
 * Location Entity for SQLite database storage
 * Stores location information and user favorites
 */
@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey
    val locationId: String,
    
    @ColumnInfo(name = "name")
    val name: String,
    
    @ColumnInfo(name = "latitude")
    val latitude: Double,
    
    @ColumnInfo(name = "longitude")
    val longitude: Double,
    
    @ColumnInfo(name = "country")
    val country: String,
    
    @ColumnInfo(name = "state")
    val state: String? = null,
    
    @ColumnInfo(name = "city")
    val city: String? = null,
    
    @ColumnInfo(name = "timezone")
    val timezone: String,
    
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false,
    
    @ColumnInfo(name = "is_current_location")
    val isCurrentLocation: Boolean = false,
    
    @ColumnInfo(name = "last_updated")
    val lastUpdated: Date,
    
    @ColumnInfo(name = "weather_data_available")
    val weatherDataAvailable: Boolean = true,
    
    @ColumnInfo(name = "user_id")
    val userId: String? = null // For user-specific locations
)
