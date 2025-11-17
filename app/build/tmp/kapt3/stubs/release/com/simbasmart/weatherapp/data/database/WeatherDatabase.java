package com.simbasmart.weatherapp.data.database;

/**
 * SQLite Database for WeatherApp using Room persistence library
 *
 * Features:
 * - Weather data storage for offline functionality
 * - User preferences and settings
 * - Location history and favorites
 * - Automatic data synchronization
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/simbasmart/weatherapp/data/database/WeatherDatabase;", "Landroidx/room/RoomDatabase;", "()V", "locationDao", "Lcom/simbasmart/weatherapp/data/database/dao/LocationDao;", "userDao", "Lcom/simbasmart/weatherapp/data/database/dao/UserDao;", "weatherDao", "Lcom/simbasmart/weatherapp/data/database/dao/WeatherDao;", "Companion", "app_release"})
@androidx.room.Database(entities = {com.simbasmart.weatherapp.data.database.entity.WeatherEntity.class, com.simbasmart.weatherapp.data.database.entity.UserEntity.class, com.simbasmart.weatherapp.data.database.entity.LocationEntity.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.simbasmart.weatherapp.data.database.converter.DateConverter.class, com.simbasmart.weatherapp.data.database.converter.WeatherDataConverter.class})
public abstract class WeatherDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.simbasmart.weatherapp.data.database.WeatherDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DATABASE_NAME = "weather_database";
    @org.jetbrains.annotations.NotNull
    public static final com.simbasmart.weatherapp.data.database.WeatherDatabase.Companion Companion = null;
    
    public WeatherDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.simbasmart.weatherapp.data.database.dao.WeatherDao weatherDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.simbasmart.weatherapp.data.database.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.simbasmart.weatherapp.data.database.dao.LocationDao locationDao();
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/simbasmart/weatherapp/data/database/WeatherDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "INSTANCE", "Lcom/simbasmart/weatherapp/data/database/WeatherDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Get database instance (Singleton pattern)
         */
        @org.jetbrains.annotations.NotNull
        public final com.simbasmart.weatherapp.data.database.WeatherDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}