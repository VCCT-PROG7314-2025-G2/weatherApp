package com.simbasmart.weatherapp.data.database.converter

import androidx.room.TypeConverter
import java.util.Date

/**
 * Type converter for Date objects in Room database
 * Converts Date to/from Long for SQLite storage
 */
class DateConverter {
    
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }
    
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}
