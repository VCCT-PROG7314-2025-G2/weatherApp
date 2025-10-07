package com.simbasmart.weatherapp.data.database.dao;

/**
 * Data Access Object for Weather data in SQLite database
 * Provides methods for CRUD operations on weather data
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\u00132\u0006\u0010\f\u001a\u00020\rH\'J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ$\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0005H\'J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0005H\'J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u001c\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u001d\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010%\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/simbasmart/weatherapp/data/database/dao/WeatherDao;", "", "deleteOldWeatherData", "", "cutoffDate", "Ljava/util/Date;", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWeather", "weather", "Lcom/simbasmart/weatherapp/data/database/entity/WeatherEntity;", "(Lcom/simbasmart/weatherapp/data/database/entity/WeatherEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWeatherForLocation", "locationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLocationIds", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWeatherForLocation", "Lkotlinx/coroutines/flow/Flow;", "getCurrentWeather", "getDailyForecast", "startDate", "getHourlyForecast", "getLastUpdateTime", "getUnsyncedWeather", "getWeatherCountForLocation", "", "insertWeather", "insertWeatherList", "weatherList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsSynced", "weatherId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markLocationAsSynced", "updateWeather", "app_release"})
@androidx.room.Dao
public abstract interface WeatherDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertWeather(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.WeatherEntity weather, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertWeatherList(@org.jetbrains.annotations.NotNull
    java.util.List<com.simbasmart.weatherapp.data.database.entity.WeatherEntity> weatherList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM weather_data WHERE location_id = :locationId AND data_type = \'current\' ORDER BY timestamp DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCurrentWeather(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.database.entity.WeatherEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM weather_data WHERE location_id = :locationId AND data_type = \'hourly\' AND forecast_date >= :startDate ORDER BY forecast_date ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.WeatherEntity>> getHourlyForecast(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.util.Date startDate);
    
    @androidx.room.Query(value = "SELECT * FROM weather_data WHERE location_id = :locationId AND data_type = \'daily\' AND forecast_date >= :startDate ORDER BY forecast_date ASC LIMIT 7")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.WeatherEntity>> getDailyForecast(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.util.Date startDate);
    
    @androidx.room.Query(value = "SELECT * FROM weather_data WHERE location_id = :locationId ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.WeatherEntity>> getAllWeatherForLocation(@org.jetbrains.annotations.NotNull
    java.lang.String locationId);
    
    @androidx.room.Query(value = "SELECT * FROM weather_data WHERE is_synced = 0")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUnsyncedWeather(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.simbasmart.weatherapp.data.database.entity.WeatherEntity>> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateWeather(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.WeatherEntity weather, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE weather_data SET is_synced = 1 WHERE id = :weatherId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object markAsSynced(long weatherId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE weather_data SET is_synced = 1 WHERE location_id = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object markLocationAsSynced(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteWeather(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.WeatherEntity weather, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM weather_data WHERE location_id = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteWeatherForLocation(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM weather_data WHERE timestamp < :cutoffDate")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteOldWeatherData(@org.jetbrains.annotations.NotNull
    java.util.Date cutoffDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM weather_data WHERE location_id = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getWeatherCountForLocation(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT MAX(timestamp) FROM weather_data WHERE location_id = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLastUpdateTime(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.Date> $completion);
    
    @androidx.room.Query(value = "SELECT DISTINCT location_id FROM weather_data")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllLocationIds(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion);
}