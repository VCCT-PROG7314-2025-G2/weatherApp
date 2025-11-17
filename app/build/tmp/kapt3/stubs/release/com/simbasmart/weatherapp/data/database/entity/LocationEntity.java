package com.simbasmart.weatherapp.data.database.entity;

/**
 * Location Entity for SQLite database storage
 * Stores location information and user favorites
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\rH\u00c6\u0003J\t\u0010%\u001a\u00020\u0010H\u00c6\u0003J\t\u0010&\u001a\u00020\rH\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0006H\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\rH\u00c6\u0003J\u0091\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u000204H\u00d6\u0001J\t\u00105\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0017R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017\u00a8\u00066"}, d2 = {"Lcom/simbasmart/weatherapp/data/database/entity/LocationEntity;", "", "locationId", "", "name", "latitude", "", "longitude", "country", "state", "city", "timezone", "isFavorite", "", "isCurrentLocation", "lastUpdated", "Ljava/util/Date;", "weatherDataAvailable", "userId", "(Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Date;ZLjava/lang/String;)V", "getCity", "()Ljava/lang/String;", "getCountry", "()Z", "getLastUpdated", "()Ljava/util/Date;", "getLatitude", "()D", "getLocationId", "getLongitude", "getName", "getState", "getTimezone", "getUserId", "getWeatherDataAvailable", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"})
@androidx.room.Entity(tableName = "locations")
public final class LocationEntity {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.lang.String locationId = null;
    @androidx.room.ColumnInfo(name = "name")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @androidx.room.ColumnInfo(name = "latitude")
    private final double latitude = 0.0;
    @androidx.room.ColumnInfo(name = "longitude")
    private final double longitude = 0.0;
    @androidx.room.ColumnInfo(name = "country")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String country = null;
    @androidx.room.ColumnInfo(name = "state")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String state = null;
    @androidx.room.ColumnInfo(name = "city")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String city = null;
    @androidx.room.ColumnInfo(name = "timezone")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String timezone = null;
    @androidx.room.ColumnInfo(name = "is_favorite")
    private final boolean isFavorite = false;
    @androidx.room.ColumnInfo(name = "is_current_location")
    private final boolean isCurrentLocation = false;
    @androidx.room.ColumnInfo(name = "last_updated")
    @org.jetbrains.annotations.NotNull
    private final java.util.Date lastUpdated = null;
    @androidx.room.ColumnInfo(name = "weather_data_available")
    private final boolean weatherDataAvailable = false;
    @androidx.room.ColumnInfo(name = "user_id")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String userId = null;
    
    public LocationEntity(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.lang.String name, double latitude, double longitude, @org.jetbrains.annotations.NotNull
    java.lang.String country, @org.jetbrains.annotations.Nullable
    java.lang.String state, @org.jetbrains.annotations.Nullable
    java.lang.String city, @org.jetbrains.annotations.NotNull
    java.lang.String timezone, boolean isFavorite, boolean isCurrentLocation, @org.jetbrains.annotations.NotNull
    java.util.Date lastUpdated, boolean weatherDataAvailable, @org.jetbrains.annotations.Nullable
    java.lang.String userId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final double getLatitude() {
        return 0.0;
    }
    
    public final double getLongitude() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCountry() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTimezone() {
        return null;
    }
    
    public final boolean isFavorite() {
        return false;
    }
    
    public final boolean isCurrentLocation() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getLastUpdated() {
        return null;
    }
    
    public final boolean getWeatherDataAvailable() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component11() {
        return null;
    }
    
    public final boolean component12() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.simbasmart.weatherapp.data.database.entity.LocationEntity copy(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.lang.String name, double latitude, double longitude, @org.jetbrains.annotations.NotNull
    java.lang.String country, @org.jetbrains.annotations.Nullable
    java.lang.String state, @org.jetbrains.annotations.Nullable
    java.lang.String city, @org.jetbrains.annotations.NotNull
    java.lang.String timezone, boolean isFavorite, boolean isCurrentLocation, @org.jetbrains.annotations.NotNull
    java.util.Date lastUpdated, boolean weatherDataAvailable, @org.jetbrains.annotations.Nullable
    java.lang.String userId) {
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