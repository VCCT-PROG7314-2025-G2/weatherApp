package com.simbasmart.weatherapp.data.database.converter;

/**
 * Type converter for complex weather data objects in Room database
 * Converts objects to/from JSON strings for SQLite storage
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0007J \u0010\t\u001a\u0004\u0018\u00010\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH\u0007J \u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/simbasmart/weatherapp/data/database/converter/WeatherDataConverter;", "", "()V", "gson", "Lcom/google/gson/Gson;", "fromList", "", "list", "", "fromMap", "map", "", "fromString", "value", "fromStringList", "app_release"})
public final class WeatherDataConverter {
    @org.jetbrains.annotations.NotNull
    private final com.google.gson.Gson gson = null;
    
    public WeatherDataConverter() {
        super();
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, java.lang.Object> fromString(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.Nullable
    public final java.lang.String fromMap(@org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, ? extends java.lang.Object> map) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> fromStringList(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.Nullable
    public final java.lang.String fromList(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> list) {
        return null;
    }
}