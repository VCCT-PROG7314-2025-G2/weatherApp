package com.simbasmart.weatherapp.data.api;

/**
 * API Configuration for OpenWeatherMap
 *
 * To get a FREE API key:
 * 1. Go to https://openweathermap.org/
 * 2. Sign up for a free account
 * 3. Go to "My API Keys" section
 * 4. Copy your API key and replace YOUR_API_KEY_HERE below
 *
 * Free tier includes:
 * - 60 calls/minute
 * - Current weather data
 * - 5-day forecast
 * - No credit card required
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/simbasmart/weatherapp/data/api/ApiConfig;", "", "()V", "BASE_URL", "", "DEFAULT_UNITS", "OPENWEATHER_API_KEY", "SUPPORTED_CITIES", "", "getSUPPORTED_CITIES", "()Ljava/util/Map;", "getApiKey", "isApiKeyConfigured", "", "app_debug"})
public final class ApiConfig {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String OPENWEATHER_API_KEY = "a6e2b29393cf999a88ebaf4314931f13";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEFAULT_UNITS = "metric";
    @org.jetbrains.annotations.NotNull
    private static final java.util.Map<java.lang.String, java.lang.String> SUPPORTED_CITIES = null;
    @org.jetbrains.annotations.NotNull
    public static final com.simbasmart.weatherapp.data.api.ApiConfig INSTANCE = null;
    
    private ApiConfig() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.String> getSUPPORTED_CITIES() {
        return null;
    }
    
    /**
     * Check if API key is configured
     */
    public final boolean isApiKeyConfigured() {
        return false;
    }
    
    /**
     * Get API key with validation
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getApiKey() {
        return null;
    }
}