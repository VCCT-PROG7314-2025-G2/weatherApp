package com.simbasmart.weatherapp.data.database.entity;

/**
 * Weather Entity for SQLite database storage
 * Stores current weather and forecast data for offline access
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b0\b\u0087\b\u0018\u00002\u00020\u0001B\u00a1\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\u0002\u0010\u001aJ\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\tH\u00c6\u0003J\t\u00106\u001a\u00020\tH\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u00109\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010;\u001a\u00020\u0019H\u00c6\u0003J\t\u0010<\u001a\u00020\u0005H\u00c6\u0003J\t\u0010=\u001a\u00020\u0007H\u00c6\u0003J\t\u0010>\u001a\u00020\tH\u00c6\u0003J\t\u0010?\u001a\u00020\tH\u00c6\u0003J\t\u0010@\u001a\u00020\fH\u00c6\u0003J\t\u0010A\u001a\u00020\tH\u00c6\u0003J\t\u0010B\u001a\u00020\tH\u00c6\u0003J\t\u0010C\u001a\u00020\fH\u00c6\u0003J\u00c3\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u00c6\u0001J\u0013\u0010E\u001a\u00020\u00192\b\u0010F\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010G\u001a\u00020\fH\u00d6\u0001J\t\u0010H\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\'R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0016\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0016\u0010\u0013\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0016\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001f\u00a8\u0006I"}, d2 = {"Lcom/simbasmart/weatherapp/data/database/entity/WeatherEntity;", "", "id", "", "locationId", "", "timestamp", "Ljava/util/Date;", "temperature", "", "feelsLike", "humidity", "", "pressure", "windSpeed", "windDirection", "description", "icon", "visibility", "uvIndex", "sunrise", "sunset", "dataType", "forecastDate", "isSynced", "", "(JLjava/lang/String;Ljava/util/Date;DDIDDILjava/lang/String;Ljava/lang/String;DDLjava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Z)V", "getDataType", "()Ljava/lang/String;", "getDescription", "getFeelsLike", "()D", "getForecastDate", "()Ljava/util/Date;", "getHumidity", "()I", "getIcon", "getId", "()J", "()Z", "getLocationId", "getPressure", "getSunrise", "getSunset", "getTemperature", "getTimestamp", "getUvIndex", "getVisibility", "getWindDirection", "getWindSpeed", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"})
@androidx.room.Entity(tableName = "weather_data")
public final class WeatherEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @androidx.room.ColumnInfo(name = "location_id")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String locationId = null;
    @androidx.room.ColumnInfo(name = "timestamp")
    @org.jetbrains.annotations.NotNull
    private final java.util.Date timestamp = null;
    @androidx.room.ColumnInfo(name = "temperature")
    private final double temperature = 0.0;
    @androidx.room.ColumnInfo(name = "feels_like")
    private final double feelsLike = 0.0;
    @androidx.room.ColumnInfo(name = "humidity")
    private final int humidity = 0;
    @androidx.room.ColumnInfo(name = "pressure")
    private final double pressure = 0.0;
    @androidx.room.ColumnInfo(name = "wind_speed")
    private final double windSpeed = 0.0;
    @androidx.room.ColumnInfo(name = "wind_direction")
    private final int windDirection = 0;
    @androidx.room.ColumnInfo(name = "description")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    @androidx.room.ColumnInfo(name = "icon")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String icon = null;
    @androidx.room.ColumnInfo(name = "visibility")
    private final double visibility = 0.0;
    @androidx.room.ColumnInfo(name = "uv_index")
    private final double uvIndex = 0.0;
    @androidx.room.ColumnInfo(name = "sunrise")
    @org.jetbrains.annotations.Nullable
    private final java.util.Date sunrise = null;
    @androidx.room.ColumnInfo(name = "sunset")
    @org.jetbrains.annotations.Nullable
    private final java.util.Date sunset = null;
    @androidx.room.ColumnInfo(name = "data_type")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String dataType = null;
    @androidx.room.ColumnInfo(name = "forecast_date")
    @org.jetbrains.annotations.Nullable
    private final java.util.Date forecastDate = null;
    @androidx.room.ColumnInfo(name = "is_synced")
    private final boolean isSynced = false;
    
    public WeatherEntity(long id, @org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.util.Date timestamp, double temperature, double feelsLike, int humidity, double pressure, double windSpeed, int windDirection, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String icon, double visibility, double uvIndex, @org.jetbrains.annotations.Nullable
    java.util.Date sunrise, @org.jetbrains.annotations.Nullable
    java.util.Date sunset, @org.jetbrains.annotations.NotNull
    java.lang.String dataType, @org.jetbrains.annotations.Nullable
    java.util.Date forecastDate, boolean isSynced) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getTimestamp() {
        return null;
    }
    
    public final double getTemperature() {
        return 0.0;
    }
    
    public final double getFeelsLike() {
        return 0.0;
    }
    
    public final int getHumidity() {
        return 0;
    }
    
    public final double getPressure() {
        return 0.0;
    }
    
    public final double getWindSpeed() {
        return 0.0;
    }
    
    public final int getWindDirection() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIcon() {
        return null;
    }
    
    public final double getVisibility() {
        return 0.0;
    }
    
    public final double getUvIndex() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date getSunrise() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date getSunset() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDataType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date getForecastDate() {
        return null;
    }
    
    public final boolean isSynced() {
        return false;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    public final double component12() {
        return 0.0;
    }
    
    public final double component13() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date component17() {
        return null;
    }
    
    public final boolean component18() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component3() {
        return null;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.simbasmart.weatherapp.data.database.entity.WeatherEntity copy(long id, @org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.util.Date timestamp, double temperature, double feelsLike, int humidity, double pressure, double windSpeed, int windDirection, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String icon, double visibility, double uvIndex, @org.jetbrains.annotations.Nullable
    java.util.Date sunrise, @org.jetbrains.annotations.Nullable
    java.util.Date sunset, @org.jetbrains.annotations.NotNull
    java.lang.String dataType, @org.jetbrains.annotations.Nullable
    java.util.Date forecastDate, boolean isSynced) {
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