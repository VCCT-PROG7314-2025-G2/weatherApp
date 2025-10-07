package com.simbasmart.weatherapp.data.repository;

/**
 * Repository for managing weather data operations
 * Provides a clean API for database operations and data synchronization
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00130\u00172\u0006\u0010\u0019\u001a\u00020\u0014J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00130\u00172\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0010J\u0011\u0010 \u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00130\u0017J\"\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00130\u00172\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0010J\u001b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u001b\u0010%\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0011\u0010&\u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u001b\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010-\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u001bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100J\u0019\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020)H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00103J\u0019\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106J\u001f\u00107\u001a\u00020\u000e2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00109J\u0019\u0010:\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010>J\u001f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00132\u0006\u0010@\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010A\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ!\u0010B\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010C\u001a\u00020DH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010EJ!\u0010F\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010C\u001a\u00020DH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010EJ!\u0010G\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010H\u001a\u00020DH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010EJ!\u0010I\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010KJ!\u0010L\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010NJ!\u0010O\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010NJ!\u0010Q\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010C\u001a\u00020DH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010EJ!\u0010R\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010KJ\u0019\u0010T\u001a\u00020\u000e2\u0006\u00102\u001a\u00020)H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00103R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006U"}, d2 = {"Lcom/simbasmart/weatherapp/data/repository/WeatherRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "database", "Lcom/simbasmart/weatherapp/data/database/WeatherDatabase;", "locationDao", "Lcom/simbasmart/weatherapp/data/database/dao/LocationDao;", "userDao", "Lcom/simbasmart/weatherapp/data/database/dao/UserDao;", "weatherDao", "Lcom/simbasmart/weatherapp/data/database/dao/WeatherDao;", "deleteOldWeatherData", "", "cutoffDate", "Ljava/util/Date;", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLocationIds", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWeatherForLocation", "Lkotlinx/coroutines/flow/Flow;", "Lcom/simbasmart/weatherapp/data/database/entity/WeatherEntity;", "locationId", "getCurrentLocation", "Lcom/simbasmart/weatherapp/data/database/entity/LocationEntity;", "getCurrentWeather", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDailyForecast", "startDate", "getFavoriteLocationCount", "", "getFavoriteLocations", "getHourlyForecast", "getLastUpdateTime", "getLocationById", "getLocationCount", "getUnsyncedWeather", "getUserByEmail", "Lcom/simbasmart/weatherapp/data/database/entity/UserEntity;", "email", "getUserById", "userId", "getWeatherCountForLocation", "insertLocation", "location", "(Lcom/simbasmart/weatherapp/data/database/entity/LocationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "user", "(Lcom/simbasmart/weatherapp/data/database/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWeather", "weather", "(Lcom/simbasmart/weatherapp/data/database/entity/WeatherEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWeatherList", "weatherList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markLocationAsSynced", "markWeatherAsSynced", "weatherId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchLocations", "query", "setCurrentLocation", "updateBiometricEnabled", "enabled", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDarkModeEnabled", "updateFavoriteStatus", "isFavorite", "updateLanguage", "language", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastLogin", "lastLogin", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocationLastUpdated", "lastUpdated", "updateNotificationsEnabled", "updateTemperatureUnit", "unit", "updateUser", "app_debug"})
public final class WeatherRepository {
    @org.jetbrains.annotations.NotNull
    private final com.simbasmart.weatherapp.data.database.WeatherDatabase database = null;
    @org.jetbrains.annotations.NotNull
    private final com.simbasmart.weatherapp.data.database.dao.WeatherDao weatherDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.simbasmart.weatherapp.data.database.dao.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.simbasmart.weatherapp.data.database.dao.LocationDao locationDao = null;
    
    public WeatherRepository(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertWeather(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.WeatherEntity weather, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertWeatherList(@org.jetbrains.annotations.NotNull
    java.util.List<com.simbasmart.weatherapp.data.database.entity.WeatherEntity> weatherList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCurrentWeather(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.database.entity.WeatherEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.WeatherEntity>> getHourlyForecast(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.util.Date startDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.WeatherEntity>> getDailyForecast(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.util.Date startDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.WeatherEntity>> getAllWeatherForLocation(@org.jetbrains.annotations.NotNull
    java.lang.String locationId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUnsyncedWeather(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.simbasmart.weatherapp.data.database.entity.WeatherEntity>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object markWeatherAsSynced(long weatherId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object markLocationAsSynced(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteOldWeatherData(@org.jetbrains.annotations.NotNull
    java.util.Date cutoffDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUserById(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.database.entity.UserEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUserByEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.database.entity.UserEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateLastLogin(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.util.Date lastLogin, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateTemperatureUnit(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String unit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateLanguage(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String language, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateNotificationsEnabled(@org.jetbrains.annotations.NotNull
    java.lang.String userId, boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateBiometricEnabled(@org.jetbrains.annotations.NotNull
    java.lang.String userId, boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateDarkModeEnabled(@org.jetbrains.annotations.NotNull
    java.lang.String userId, boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertLocation(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.LocationEntity location, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLocationById(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.database.entity.LocationEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCurrentLocation(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.database.entity.LocationEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.LocationEntity>> getFavoriteLocations() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object searchLocations(@org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.simbasmart.weatherapp.data.database.entity.LocationEntity>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setCurrentLocation(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateFavoriteStatus(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, boolean isFavorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateLocationLastUpdated(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.util.Date lastUpdated, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getWeatherCountForLocation(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLastUpdateTime(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.Date> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllLocationIds(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLocationCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getFavoriteLocationCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
}