package com.simbasmart.weatherapp.data.database.dao;

/**
 * Data Access Object for Location data in SQLite database
 * Provides methods for CRUD operations on location data
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u0010H\'J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0015\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u0010H\'J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0011\u0010\u0018\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00102\u0006\u0010\u000e\u001a\u00020\u000bH\'J7\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\"\u001a\u00020\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010&\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\'\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010(\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J!\u0010,\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J\u0019\u00100\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ!\u00101\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00102\u001a\u00020*H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00063"}, d2 = {"Lcom/simbasmart/weatherapp/data/database/dao/LocationDao;", "", "clearCurrentLocation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLocation", "location", "Lcom/simbasmart/weatherapp/data/database/entity/LocationEntity;", "(Lcom/simbasmart/weatherapp/data/database/entity/LocationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLocationById", "locationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLocationsForUser", "userId", "getAllLocations", "Lkotlinx/coroutines/flow/Flow;", "", "getCurrentLocation", "getCurrentLocationCount", "", "getFavoriteLocationCount", "getFavoriteLocations", "getLocationById", "getLocationCount", "getLocationsForUser", "getLocationsInBounds", "minLat", "", "maxLat", "minLng", "maxLng", "(DDDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLocation", "insertLocationList", "locations", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchLocations", "searchQuery", "setCurrentLocation", "updateFavoriteStatus", "isFavorite", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastUpdated", "lastUpdated", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocation", "updateWeatherDataAvailable", "available", "app_release"})
@androidx.room.Dao
public abstract interface LocationDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertLocation(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.LocationEntity location, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertLocationList(@org.jetbrains.annotations.NotNull
    java.util.List<com.simbasmart.weatherapp.data.database.entity.LocationEntity> locations, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM locations WHERE locationId = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLocationById(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.database.entity.LocationEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM locations WHERE is_current_location = 1 LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCurrentLocation(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.database.entity.LocationEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM locations WHERE is_favorite = 1")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.LocationEntity>> getFavoriteLocations();
    
    @androidx.room.Query(value = "SELECT * FROM locations WHERE user_id = :userId")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.LocationEntity>> getLocationsForUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM locations WHERE name LIKE \'%\' || :searchQuery || \'%\' OR city LIKE \'%\' || :searchQuery || \'%\' OR country LIKE \'%\' || :searchQuery || \'%\'")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object searchLocations(@org.jetbrains.annotations.NotNull
    java.lang.String searchQuery, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.simbasmart.weatherapp.data.database.entity.LocationEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM locations ORDER BY last_updated DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.LocationEntity>> getAllLocations();
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateLocation(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.LocationEntity location, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE locations SET is_current_location = 0")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearCurrentLocation(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE locations SET is_current_location = 1 WHERE locationId = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object setCurrentLocation(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE locations SET is_favorite = :isFavorite WHERE locationId = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateFavoriteStatus(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, boolean isFavorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE locations SET last_updated = :lastUpdated WHERE locationId = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateLastUpdated(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.util.Date lastUpdated, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE locations SET weather_data_available = :available WHERE locationId = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateWeatherDataAvailable(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, boolean available, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteLocation(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.LocationEntity location, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM locations WHERE locationId = :locationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteLocationById(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM locations WHERE user_id = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteLocationsForUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM locations")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLocationCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM locations WHERE is_favorite = 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFavoriteLocationCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM locations WHERE is_current_location = 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCurrentLocationCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM locations WHERE latitude BETWEEN :minLat AND :maxLat AND longitude BETWEEN :minLng AND :maxLng")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLocationsInBounds(double minLat, double maxLat, double minLng, double maxLng, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.simbasmart.weatherapp.data.database.entity.LocationEntity>> $completion);
}