package com.simbasmart.weatherapp.data.model;

/**
 * Weather data model for UI layer
 * Represents weather information displayed to users
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\nH\u00c6\u0003J\t\u0010\'\u001a\u00020\u0010H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\nH\u00c6\u0003J\t\u0010.\u001a\u00020\u0007H\u00c6\u0003J\t\u0010/\u001a\u00020\nH\u00c6\u0003J\t\u00100\u001a\u00020\u0007H\u00c6\u0003J\u0083\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00c6\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u00105\u001a\u00020\u0003J\u0006\u00106\u001a\u00020\u0003J\u0006\u00107\u001a\u00020\u0003J\u0006\u00108\u001a\u00020\u0003J\u0006\u00109\u001a\u00020\u0003J\u0006\u0010:\u001a\u00020\u0003J\u0006\u0010;\u001a\u00020\u0003J\u0006\u0010<\u001a\u00020\u0003J\t\u0010=\u001a\u00020\nH\u00d6\u0001J\t\u0010>\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019\u00a8\u0006?"}, d2 = {"Lcom/simbasmart/weatherapp/data/model/Weather;", "", "id", "", "locationId", "locationName", "temperature", "", "description", "humidity", "", "windSpeed", "pressure", "feelsLike", "visibility", "timestamp", "", "date", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;IDIDIJLjava/util/Date;)V", "getDate", "()Ljava/util/Date;", "getDescription", "()Ljava/lang/String;", "getFeelsLike", "()D", "getHumidity", "()I", "getId", "getLocationId", "getLocationName", "getPressure", "getTemperature", "getTimestamp", "()J", "getVisibility", "getWindSpeed", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getFormattedDate", "getFormattedFeelsLike", "getFormattedHumidity", "getFormattedPressure", "getFormattedTemperature", "getFormattedVisibility", "getFormattedWindSpeed", "getWeatherCondition", "hashCode", "toString", "app_debug"})
public final class Weather {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String locationId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String locationName = null;
    private final double temperature = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    private final int humidity = 0;
    private final double windSpeed = 0.0;
    private final int pressure = 0;
    private final double feelsLike = 0.0;
    private final int visibility = 0;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.Nullable
    private final java.util.Date date = null;
    
    public Weather(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.lang.String locationName, double temperature, @org.jetbrains.annotations.NotNull
    java.lang.String description, int humidity, double windSpeed, int pressure, double feelsLike, int visibility, long timestamp, @org.jetbrains.annotations.Nullable
    java.util.Date date) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationName() {
        return null;
    }
    
    public final double getTemperature() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final int getHumidity() {
        return 0;
    }
    
    public final double getWindSpeed() {
        return 0.0;
    }
    
    public final int getPressure() {
        return 0;
    }
    
    public final double getFeelsLike() {
        return 0.0;
    }
    
    public final int getVisibility() {
        return 0;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date getDate() {
        return null;
    }
    
    /**
     * Get formatted temperature string
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedTemperature() {
        return null;
    }
    
    /**
     * Get formatted humidity
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedHumidity() {
        return null;
    }
    
    /**
     * Get formatted wind speed
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedWindSpeed() {
        return null;
    }
    
    /**
     * Get formatted pressure
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedPressure() {
        return null;
    }
    
    /**
     * Get formatted feels like temperature
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedFeelsLike() {
        return null;
    }
    
    /**
     * Get formatted visibility
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedVisibility() {
        return null;
    }
    
    /**
     * Get weather condition description
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getWeatherCondition() {
        return null;
    }
    
    /**
     * Get formatted date for display
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final long component11() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date component12() {
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
    
    public final double component4() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.simbasmart.weatherapp.data.model.Weather copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String locationId, @org.jetbrains.annotations.NotNull
    java.lang.String locationName, double temperature, @org.jetbrains.annotations.NotNull
    java.lang.String description, int humidity, double windSpeed, int pressure, double feelsLike, int visibility, long timestamp, @org.jetbrains.annotations.Nullable
    java.util.Date date) {
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