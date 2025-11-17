package com.simbasmart.weatherapp.data.database.dao

import androidx.room.*
import com.simbasmart.weatherapp.data.database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for User data in SQLite database
 * Provides methods for CRUD operations on user data and preferences
 */
@Dao
interface UserDao {
    
    // Insert operations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)
    
    // Query operations
    @Query("SELECT * FROM users WHERE userId = :userId")
    suspend fun getUserById(userId: String): UserEntity?
    
    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): UserEntity?
    
    @Query("SELECT * FROM users WHERE is_active = 1")
    fun getActiveUsers(): Flow<List<UserEntity>>
    
    // Update operations
    @Update
    suspend fun updateUser(user: UserEntity)
    
    @Query("UPDATE users SET last_login = :lastLogin WHERE userId = :userId")
    suspend fun updateLastLogin(userId: String, lastLogin: java.util.Date)
    
    @Query("UPDATE users SET temperature_unit = :unit WHERE userId = :userId")
    suspend fun updateTemperatureUnit(userId: String, unit: String)
    
    @Query("UPDATE users SET wind_speed_unit = :unit WHERE userId = :userId")
    suspend fun updateWindSpeedUnit(userId: String, unit: String)
    
    @Query("UPDATE users SET pressure_unit = :unit WHERE userId = :userId")
    suspend fun updatePressureUnit(userId: String, unit: String)
    
    @Query("UPDATE users SET language = :language WHERE userId = :userId")
    suspend fun updateLanguage(userId: String, language: String)
    
    @Query("UPDATE users SET notifications_enabled = :enabled WHERE userId = :userId")
    suspend fun updateNotificationsEnabled(userId: String, enabled: Boolean)
    
    @Query("UPDATE users SET location_permission_granted = :granted WHERE userId = :userId")
    suspend fun updateLocationPermission(userId: String, granted: Boolean)
    
    @Query("UPDATE users SET biometric_enabled = :enabled WHERE userId = :userId")
    suspend fun updateBiometricEnabled(userId: String, enabled: Boolean)
    
    @Query("UPDATE users SET dark_mode_enabled = :enabled WHERE userId = :userId")
    suspend fun updateDarkModeEnabled(userId: String, enabled: Boolean)
    
    @Query("UPDATE users SET auto_refresh_interval = :interval WHERE userId = :userId")
    suspend fun updateAutoRefreshInterval(userId: String, interval: Int)
    
    @Query("UPDATE users SET default_location_id = :locationId WHERE userId = :userId")
    suspend fun updateDefaultLocation(userId: String, locationId: String?)
    
    // Delete operations
    @Delete
    suspend fun deleteUser(user: UserEntity)
    
    @Query("DELETE FROM users WHERE userId = :userId")
    suspend fun deleteUserById(userId: String)
    
    // Utility queries
    @Query("SELECT COUNT(*) FROM users")
    suspend fun getUserCount(): Int
    
    @Query("SELECT COUNT(*) FROM users WHERE is_active = 1")
    suspend fun getActiveUserCount(): Int
}
