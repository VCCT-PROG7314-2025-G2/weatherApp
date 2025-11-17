package com.simbasmart.weatherapp.data.database.dao

import androidx.room.*
import com.simbasmart.weatherapp.data.database.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Location data in SQLite database
 * Provides methods for CRUD operations on location data
 */
@Dao
interface LocationDao {
    
    // Insert operations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: LocationEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocationList(locations: List<LocationEntity>)
    
    // Query operations
    @Query("SELECT * FROM locations WHERE locationId = :locationId")
    suspend fun getLocationById(locationId: String): LocationEntity?
    
    @Query("SELECT * FROM locations WHERE is_current_location = 1 LIMIT 1")
    suspend fun getCurrentLocation(): LocationEntity?
    
    @Query("SELECT * FROM locations WHERE is_favorite = 1")
    fun getFavoriteLocations(): Flow<List<LocationEntity>>
    
    @Query("SELECT * FROM locations WHERE user_id = :userId")
    fun getLocationsForUser(userId: String): Flow<List<LocationEntity>>
    
    @Query("SELECT * FROM locations WHERE name LIKE '%' || :searchQuery || '%' OR city LIKE '%' || :searchQuery || '%' OR country LIKE '%' || :searchQuery || '%'")
    suspend fun searchLocations(searchQuery: String): List<LocationEntity>
    
    @Query("SELECT * FROM locations ORDER BY last_updated DESC")
    fun getAllLocations(): Flow<List<LocationEntity>>
    
    // Update operations
    @Update
    suspend fun updateLocation(location: LocationEntity)
    
    @Query("UPDATE locations SET is_current_location = 0")
    suspend fun clearCurrentLocation()
    
    @Query("UPDATE locations SET is_current_location = 1 WHERE locationId = :locationId")
    suspend fun setCurrentLocation(locationId: String)
    
    @Query("UPDATE locations SET is_favorite = :isFavorite WHERE locationId = :locationId")
    suspend fun updateFavoriteStatus(locationId: String, isFavorite: Boolean)
    
    @Query("UPDATE locations SET last_updated = :lastUpdated WHERE locationId = :locationId")
    suspend fun updateLastUpdated(locationId: String, lastUpdated: java.util.Date)
    
    @Query("UPDATE locations SET weather_data_available = :available WHERE locationId = :locationId")
    suspend fun updateWeatherDataAvailable(locationId: String, available: Boolean)
    
    // Delete operations
    @Delete
    suspend fun deleteLocation(location: LocationEntity)
    
    @Query("DELETE FROM locations WHERE locationId = :locationId")
    suspend fun deleteLocationById(locationId: String)
    
    @Query("DELETE FROM locations WHERE user_id = :userId")
    suspend fun deleteLocationsForUser(userId: String)
    
    // Utility queries
    @Query("SELECT COUNT(*) FROM locations")
    suspend fun getLocationCount(): Int
    
    @Query("SELECT COUNT(*) FROM locations WHERE is_favorite = 1")
    suspend fun getFavoriteLocationCount(): Int
    
    @Query("SELECT COUNT(*) FROM locations WHERE is_current_location = 1")
    suspend fun getCurrentLocationCount(): Int
    
    @Query("SELECT * FROM locations WHERE latitude BETWEEN :minLat AND :maxLat AND longitude BETWEEN :minLng AND :maxLng")
    suspend fun getLocationsInBounds(minLat: Double, maxLat: Double, minLng: Double, maxLng: Double): List<LocationEntity>
}
