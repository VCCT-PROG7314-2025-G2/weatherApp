package com.simbasmart.weatherapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.util.Date

/**
 * User Entity for SQLite database storage
 * Stores user information, preferences, and settings
 */
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val userId: String,
    
    @ColumnInfo(name = "email")
    val email: String,
    
    @ColumnInfo(name = "display_name")
    val displayName: String,
    
    @ColumnInfo(name = "profile_picture")
    val profilePicture: String? = null,
    
    @ColumnInfo(name = "created_at")
    val createdAt: Date,
    
    @ColumnInfo(name = "last_login")
    val lastLogin: Date,
    
    @ColumnInfo(name = "is_active")
    val isActive: Boolean = true,
    
    // User Preferences
    @ColumnInfo(name = "temperature_unit")
    val temperatureUnit: String = "celsius", // "celsius", "fahrenheit", "kelvin"
    
    @ColumnInfo(name = "wind_speed_unit")
    val windSpeedUnit: String = "kmh", // "kmh", "mph"
    
    @ColumnInfo(name = "pressure_unit")
    val pressureUnit: String = "mbar", // "mbar", "inhg"
    
    @ColumnInfo(name = "language")
    val language: String = "en", // "en", "af", "zu", "xh"
    
    @ColumnInfo(name = "notifications_enabled")
    val notificationsEnabled: Boolean = true,
    
    @ColumnInfo(name = "location_permission_granted")
    val locationPermissionGranted: Boolean = false,
    
    @ColumnInfo(name = "biometric_enabled")
    val biometricEnabled: Boolean = false,
    
    @ColumnInfo(name = "dark_mode_enabled")
    val darkModeEnabled: Boolean = false,
    
    @ColumnInfo(name = "auto_refresh_interval")
    val autoRefreshInterval: Int = 30, // minutes
    
    @ColumnInfo(name = "default_location_id")
    val defaultLocationId: String? = null
)
