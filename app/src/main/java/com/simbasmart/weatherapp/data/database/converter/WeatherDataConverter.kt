package com.simbasmart.weatherapp.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Type converter for complex weather data objects in Room database
 * Converts objects to/from JSON strings for SQLite storage
 */
class WeatherDataConverter {
    
    private val gson = Gson()
    
    @TypeConverter
    fun fromString(value: String?): Map<String, Any>? {
        if (value == null) return null
        val type = object : TypeToken<Map<String, Any>>() {}.type
        return gson.fromJson(value, type)
    }
    
    @TypeConverter
    fun fromMap(map: Map<String, Any>?): String? {
        if (map == null) return null
        return gson.toJson(map)
    }
    
    @TypeConverter
    fun fromStringList(value: String?): List<String>? {
        if (value == null) return null
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }
    
    @TypeConverter
    fun fromList(list: List<String>?): String? {
        if (list == null) return null
        return gson.toJson(list)
    }
}
