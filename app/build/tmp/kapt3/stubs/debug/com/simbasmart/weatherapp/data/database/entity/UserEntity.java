package com.simbasmart.weatherapp.data.database.entity;

/**
 * User Entity for SQLite database storage
 * Stores user information, preferences, and settings
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b-\b\u0087\b\u0018\u00002\u00020\u0001B\u00a9\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0017J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u000bH\u00c6\u0003J\t\u00100\u001a\u00020\u000bH\u00c6\u0003J\t\u00101\u001a\u00020\u000bH\u00c6\u0003J\t\u00102\u001a\u00020\u000bH\u00c6\u0003J\t\u00103\u001a\u00020\u0015H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\bH\u00c6\u0003J\t\u00109\u001a\u00020\bH\u00c6\u0003J\t\u0010:\u001a\u00020\u000bH\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\u00b7\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010@\u001a\u00020\u0015H\u00d6\u0001J\t\u0010A\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0012\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001bR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0016\u0010\u0011\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010 \u00a8\u0006B"}, d2 = {"Lcom/simbasmart/weatherapp/data/database/entity/UserEntity;", "", "userId", "", "email", "displayName", "profilePicture", "createdAt", "Ljava/util/Date;", "lastLogin", "isActive", "", "temperatureUnit", "windSpeedUnit", "pressureUnit", "language", "notificationsEnabled", "locationPermissionGranted", "biometricEnabled", "darkModeEnabled", "autoRefreshInterval", "", "defaultLocationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZILjava/lang/String;)V", "getAutoRefreshInterval", "()I", "getBiometricEnabled", "()Z", "getCreatedAt", "()Ljava/util/Date;", "getDarkModeEnabled", "getDefaultLocationId", "()Ljava/lang/String;", "getDisplayName", "getEmail", "getLanguage", "getLastLogin", "getLocationPermissionGranted", "getNotificationsEnabled", "getPressureUnit", "getProfilePicture", "getTemperatureUnit", "getUserId", "getWindSpeedUnit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "users")
public final class UserEntity {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.lang.String userId = null;
    @androidx.room.ColumnInfo(name = "email")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String email = null;
    @androidx.room.ColumnInfo(name = "display_name")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String displayName = null;
    @androidx.room.ColumnInfo(name = "profile_picture")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String profilePicture = null;
    @androidx.room.ColumnInfo(name = "created_at")
    @org.jetbrains.annotations.NotNull
    private final java.util.Date createdAt = null;
    @androidx.room.ColumnInfo(name = "last_login")
    @org.jetbrains.annotations.NotNull
    private final java.util.Date lastLogin = null;
    @androidx.room.ColumnInfo(name = "is_active")
    private final boolean isActive = false;
    @androidx.room.ColumnInfo(name = "temperature_unit")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String temperatureUnit = null;
    @androidx.room.ColumnInfo(name = "wind_speed_unit")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String windSpeedUnit = null;
    @androidx.room.ColumnInfo(name = "pressure_unit")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String pressureUnit = null;
    @androidx.room.ColumnInfo(name = "language")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String language = null;
    @androidx.room.ColumnInfo(name = "notifications_enabled")
    private final boolean notificationsEnabled = false;
    @androidx.room.ColumnInfo(name = "location_permission_granted")
    private final boolean locationPermissionGranted = false;
    @androidx.room.ColumnInfo(name = "biometric_enabled")
    private final boolean biometricEnabled = false;
    @androidx.room.ColumnInfo(name = "dark_mode_enabled")
    private final boolean darkModeEnabled = false;
    @androidx.room.ColumnInfo(name = "auto_refresh_interval")
    private final int autoRefreshInterval = 0;
    @androidx.room.ColumnInfo(name = "default_location_id")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String defaultLocationId = null;
    
    public UserEntity(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String displayName, @org.jetbrains.annotations.Nullable
    java.lang.String profilePicture, @org.jetbrains.annotations.NotNull
    java.util.Date createdAt, @org.jetbrains.annotations.NotNull
    java.util.Date lastLogin, boolean isActive, @org.jetbrains.annotations.NotNull
    java.lang.String temperatureUnit, @org.jetbrains.annotations.NotNull
    java.lang.String windSpeedUnit, @org.jetbrains.annotations.NotNull
    java.lang.String pressureUnit, @org.jetbrains.annotations.NotNull
    java.lang.String language, boolean notificationsEnabled, boolean locationPermissionGranted, boolean biometricEnabled, boolean darkModeEnabled, int autoRefreshInterval, @org.jetbrains.annotations.Nullable
    java.lang.String defaultLocationId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getProfilePicture() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getLastLogin() {
        return null;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTemperatureUnit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getWindSpeedUnit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPressureUnit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final boolean getNotificationsEnabled() {
        return false;
    }
    
    public final boolean getLocationPermissionGranted() {
        return false;
    }
    
    public final boolean getBiometricEnabled() {
        return false;
    }
    
    public final boolean getDarkModeEnabled() {
        return false;
    }
    
    public final int getAutoRefreshInterval() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDefaultLocationId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final int component16() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.simbasmart.weatherapp.data.database.entity.UserEntity copy(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String displayName, @org.jetbrains.annotations.Nullable
    java.lang.String profilePicture, @org.jetbrains.annotations.NotNull
    java.util.Date createdAt, @org.jetbrains.annotations.NotNull
    java.util.Date lastLogin, boolean isActive, @org.jetbrains.annotations.NotNull
    java.lang.String temperatureUnit, @org.jetbrains.annotations.NotNull
    java.lang.String windSpeedUnit, @org.jetbrains.annotations.NotNull
    java.lang.String pressureUnit, @org.jetbrains.annotations.NotNull
    java.lang.String language, boolean notificationsEnabled, boolean locationPermissionGranted, boolean biometricEnabled, boolean darkModeEnabled, int autoRefreshInterval, @org.jetbrains.annotations.Nullable
    java.lang.String defaultLocationId) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}