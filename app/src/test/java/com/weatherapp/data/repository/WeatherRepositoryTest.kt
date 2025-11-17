package com.weatherapp.data.repository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.weatherapp.data.database.WeatherDatabase
import com.weatherapp.data.database.entity.WeatherEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

/**
 * Unit tests for WeatherRepository
 * Tests database operations and data persistence
 * Note: These are instrumented tests that require an Android device/emulator
 */
@RunWith(AndroidJUnit4::class)
class WeatherRepositoryTest {

    private lateinit var database: WeatherDatabase
    private lateinit var repository: WeatherRepository
    private lateinit var context: Context

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        // Use in-memory database for testing
        database = Room.inMemoryDatabaseBuilder(
            context,
            WeatherDatabase::class.java
        ).allowMainThreadQueries().build()
        repository = WeatherRepository(context)
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun `insertWeather should save weather data to database`() = runBlocking {
        // Given
        val weatherEntity = WeatherEntity(
            id = 1,
            locationId = "test_location",
            locationName = "Test City",
            temperature = 25.0,
            description = "Sunny",
            humidity = 60,
            windSpeed = 10.0,
            pressure = 1013,
            feelsLike = 26.0,
            visibility = 10000,
            timestamp = System.currentTimeMillis(),
            date = Date(),
            isSynced = false
        )

        // When
        repository.insertWeather(weatherEntity)

        // Then
        val retrieved = repository.getCurrentWeather("test_location")
        assert(retrieved != null) { "Weather entity should be saved" }
        assert(retrieved?.locationName == "Test City") { "Location name should match" }
    }

    @Test
    fun `getCurrentWeather should return null for non-existent location`() = runBlocking {
        // When
        val result = repository.getCurrentWeather("non_existent")

        // Then
        assert(result == null) { "Should return null for non-existent location" }
    }
}

