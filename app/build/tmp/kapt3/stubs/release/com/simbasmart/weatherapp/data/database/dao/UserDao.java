package com.simbasmart.weatherapp.data.database.dao;

/**
 * Data Access Object for User data in SQLite database
 * Provides methods for CRUD operations on user data and preferences
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000fH\'J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u0014\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J!\u0010\u0019\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ#\u0010\u001e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J!\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J!\u0010#\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010$\u001a\u00020%H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J!\u0010\'\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ!\u0010)\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ!\u0010*\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J!\u0010,\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J!\u0010.\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2 = {"Lcom/simbasmart/weatherapp/data/database/dao/UserDao;", "", "deleteUser", "", "user", "Lcom/simbasmart/weatherapp/data/database/entity/UserEntity;", "(Lcom/simbasmart/weatherapp/data/database/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUserById", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveUserCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveUsers", "Lkotlinx/coroutines/flow/Flow;", "", "getUserByEmail", "email", "getUserById", "getUserCount", "insertUser", "updateAutoRefreshInterval", "interval", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBiometricEnabled", "enabled", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDarkModeEnabled", "updateDefaultLocation", "locationId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLanguage", "language", "updateLastLogin", "lastLogin", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocationPermission", "granted", "updateNotificationsEnabled", "updatePressureUnit", "unit", "updateTemperatureUnit", "updateUser", "updateWindSpeedUnit", "app_release"})
@androidx.room.Dao
public abstract interface UserDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserById(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.database.entity.UserEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE email = :email")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserByEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.database.entity.UserEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE is_active = 1")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.simbasmart.weatherapp.data.database.entity.UserEntity>> getActiveUsers();
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET last_login = :lastLogin WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateLastLogin(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.util.Date lastLogin, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET temperature_unit = :unit WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateTemperatureUnit(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String unit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET wind_speed_unit = :unit WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateWindSpeedUnit(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String unit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET pressure_unit = :unit WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updatePressureUnit(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String unit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET language = :language WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateLanguage(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String language, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET notifications_enabled = :enabled WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateNotificationsEnabled(@org.jetbrains.annotations.NotNull
    java.lang.String userId, boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET location_permission_granted = :granted WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateLocationPermission(@org.jetbrains.annotations.NotNull
    java.lang.String userId, boolean granted, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET biometric_enabled = :enabled WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateBiometricEnabled(@org.jetbrains.annotations.NotNull
    java.lang.String userId, boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET dark_mode_enabled = :enabled WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateDarkModeEnabled(@org.jetbrains.annotations.NotNull
    java.lang.String userId, boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET auto_refresh_interval = :interval WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateAutoRefreshInterval(@org.jetbrains.annotations.NotNull
    java.lang.String userId, int interval, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET default_location_id = :locationId WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateDefaultLocation(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.Nullable
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.database.entity.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM users WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteUserById(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM users")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM users WHERE is_active = 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getActiveUserCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}