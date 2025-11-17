package com.simbasmart.weatherapp.data.repository

import android.content.Context
import com.simbasmart.weatherapp.data.database.WeatherDatabase
import com.simbasmart.weatherapp.data.database.dao.WeatherDao
import com.simbasmart.weatherapp.data.database.dao.UserDao
import com.simbasmart.weatherapp.data.database.dao.LocationDao
import com.simbasmart.weatherapp.data.database.entity.WeatherEntity
import com.simbasmart.weatherapp.data.database.entity.UserEntity
import com.simbasmart.weatherapp.data.database.entity.LocationEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

/**
 * Repository for managing weather data operations
 * Provides a clean API for database operations and data synchronization
 */
class WeatherRepository(context: Context) {
    
    private val database = WeatherDatabase.getDatabase(context)
    private val weatherDao = database.weatherDao()
    private val userDao = database.userDao()
    private val locationDao = database.locationDao()
    
    // Weather Data Operations
    suspend fun insertWeather(weather: WeatherEntity) {
        weatherDao.insertWeather(weather)
    }
    
    suspend fun insertWeatherList(weatherList: List<WeatherEntity>) {
        weatherDao.insertWeatherList(weatherList)
    }
    
    suspend fun getCurrentWeather(locationId: String): WeatherEntity? {
        return weatherDao.getCurrentWeather(locationId)
    }
    
    fun getHourlyForecast(locationId: String, startDate: Date): Flow<List<WeatherEntity>> {
        return weatherDao.getHourlyForecast(locationId, startDate)
    }
    
    fun getDailyForecast(locationId: String, startDate: Date): Flow<List<WeatherEntity>> {
        return weatherDao.getDailyForecast(locationId, startDate)
    }
    
    fun getAllWeatherForLocation(locationId: String): Flow<List<WeatherEntity>> {
        return weatherDao.getAllWeatherForLocation(locationId)
    }
    
    suspend fun getUnsyncedWeather(): List<WeatherEntity> {
        return weatherDao.getUnsyncedWeather()
    }
    
    suspend fun markWeatherAsSynced(weatherId: Long) {
        weatherDao.markAsSynced(weatherId)
    }
    
    suspend fun markLocationAsSynced(locationId: String) {
        weatherDao.markLocationAsSynced(locationId)
    }
    
    suspend fun deleteOldWeatherData(cutoffDate: Date) {
        weatherDao.deleteOldWeatherData(cutoffDate)
    }
    
    // User Data Operations
    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }
    
    suspend fun getUserById(userId: String): UserEntity? {
        return userDao.getUserById(userId)
    }
    
    suspend fun getUserByEmail(email: String): UserEntity? {
        return userDao.getUserByEmail(email)
    }
    
    suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }
    
    suspend fun updateLastLogin(userId: String, lastLogin: Date) {
        userDao.updateLastLogin(userId, lastLogin)
    }
    
    suspend fun updateTemperatureUnit(userId: String, unit: String) {
        userDao.updateTemperatureUnit(userId, unit)
    }
    
    suspend fun updateLanguage(userId: String, language: String) {
        userDao.updateLanguage(userId, language)
    }
    
    suspend fun updateNotificationsEnabled(userId: String, enabled: Boolean) {
        userDao.updateNotificationsEnabled(userId, enabled)
    }
    
    suspend fun updateBiometricEnabled(userId: String, enabled: Boolean) {
        userDao.updateBiometricEnabled(userId, enabled)
    }
    
    suspend fun updateDarkModeEnabled(userId: String, enabled: Boolean) {
        userDao.updateDarkModeEnabled(userId, enabled)
    }
    
    // Location Data Operations
    suspend fun insertLocation(location: LocationEntity) {
        locationDao.insertLocation(location)
    }
    
    suspend fun getLocationById(locationId: String): LocationEntity? {
        return locationDao.getLocationById(locationId)
    }
    
    suspend fun getCurrentLocation(): LocationEntity? {
        return locationDao.getCurrentLocation()
    }
    
    fun getFavoriteLocations(): Flow<List<LocationEntity>> {
        return locationDao.getFavoriteLocations()
    }
    
    suspend fun searchLocations(query: String): List<LocationEntity> {
        return locationDao.searchLocations(query)
    }
    
    suspend fun setCurrentLocation(locationId: String) {
        locationDao.clearCurrentLocation()
        locationDao.setCurrentLocation(locationId)
    }
    
    suspend fun updateFavoriteStatus(locationId: String, isFavorite: Boolean) {
        locationDao.updateFavoriteStatus(locationId, isFavorite)
    }
    
    suspend fun updateLocationLastUpdated(locationId: String, lastUpdated: Date) {
        locationDao.updateLastUpdated(locationId, lastUpdated)
    }
    
    // Utility Operations
    suspend fun getWeatherCountForLocation(locationId: String): Int {
        return weatherDao.getWeatherCountForLocation(locationId)
    }
    
    suspend fun getLastUpdateTime(locationId: String): Date? {
        return weatherDao.getLastUpdateTime(locationId)
    }
    
    suspend fun getAllLocationIds(): List<String> {
        return weatherDao.getAllLocationIds()
    }
    
    suspend fun getLocationCount(): Int {
        return locationDao.getLocationCount()
    }
    
    suspend fun getFavoriteLocationCount(): Int {
        return locationDao.getFavoriteLocationCount()
    }
}
