package com.simbasmart.weatherapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.simbasmart.weatherapp.data.database.dao.WeatherDao
import com.simbasmart.weatherapp.data.database.dao.UserDao
import com.simbasmart.weatherapp.data.database.dao.LocationDao
import com.simbasmart.weatherapp.data.database.entity.WeatherEntity
import com.simbasmart.weatherapp.data.database.entity.UserEntity
import com.simbasmart.weatherapp.data.database.entity.LocationEntity
import com.simbasmart.weatherapp.data.database.converter.DateConverter
import com.simbasmart.weatherapp.data.database.converter.WeatherDataConverter

/**
 * SQLite Database for WeatherApp using Room persistence library
 * 
 * Features:
 * - Weather data storage for offline functionality
 * - User preferences and settings
 * - Location history and favorites
 * - Automatic data synchronization
 */
@Database(
    entities = [
        WeatherEntity::class,
        UserEntity::class,
        LocationEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class, WeatherDataConverter::class)
abstract class WeatherDatabase : RoomDatabase() {
    
    // DAOs for database operations
    abstract fun weatherDao(): WeatherDao
    abstract fun userDao(): UserDao
    abstract fun locationDao(): LocationDao
    
    companion object {
        @Volatile
        private var INSTANCE: WeatherDatabase? = null
        
        private const val DATABASE_NAME = "weather_database"
        
        /**
         * Get database instance (Singleton pattern)
         */
        fun getDatabase(context: Context): WeatherDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    DATABASE_NAME
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
