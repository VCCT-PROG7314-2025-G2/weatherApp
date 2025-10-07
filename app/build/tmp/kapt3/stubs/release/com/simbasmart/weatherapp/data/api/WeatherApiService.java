package com.simbasmart.weatherapp.data.api;

/**
 * Real Weather API Service using OpenWeatherMap
 * Provides actual weather data from open source weather service
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/simbasmart/weatherapp/data/api/WeatherApiService;", "", "()V", "BASE_URL", "", "TAG", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "weatherApi", "Lcom/simbasmart/weatherapp/data/api/WeatherApiService$WeatherApi;", "cleanCityName", "cityName", "getAlternativeCityNames", "", "getCurrentWeather", "Lcom/simbasmart/weatherapp/data/model/Weather;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentWeatherByCoordinates", "lat", "", "lon", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDailyForecast", "getHourlyForecast", "WeatherApi", "app_release"})
public final class WeatherApiService {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "WeatherApiService";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private final retrofit2.Retrofit retrofit = null;
    private final com.simbasmart.weatherapp.data.api.WeatherApiService.WeatherApi weatherApi = null;
    
    public WeatherApiService() {
        super();
    }
    
    /**
     * Get current weather for a location by city name
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCurrentWeather(@org.jetbrains.annotations.NotNull
    java.lang.String cityName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.model.Weather> $completion) {
        return null;
    }
    
    /**
     * Clean city name for better API compatibility
     */
    private final java.lang.String cleanCityName(java.lang.String cityName) {
        return null;
    }
    
    /**
     * Get alternative city names to try if the original fails
     */
    private final java.util.List<java.lang.String> getAlternativeCityNames(java.lang.String cityName) {
        return null;
    }
    
    /**
     * Get current weather by coordinates
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCurrentWeatherByCoordinates(double lat, double lon, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.model.Weather> $completion) {
        return null;
    }
    
    /**
     * Get hourly forecast for a location
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getHourlyForecast(@org.jetbrains.annotations.NotNull
    java.lang.String cityName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.simbasmart.weatherapp.data.model.Weather>> $completion) {
        return null;
    }
    
    /**
     * Get daily forecast for a location (5-day forecast from OpenWeatherMap)
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getDailyForecast(@org.jetbrains.annotations.NotNull
    java.lang.String cityName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.simbasmart.weatherapp.data.model.Weather>> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ/\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ9\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ9\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/simbasmart/weatherapp/data/api/WeatherApiService$WeatherApi;", "", "getCurrentWeather", "Lcom/simbasmart/weatherapp/data/api/WeatherResponse;", "city", "", "apiKey", "units", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForecast", "Lcom/simbasmart/weatherapp/data/api/ForecastResponse;", "getForecastByCoordinates", "lat", "", "lon", "(DDLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWeatherByCoordinates", "app_release"})
    public static abstract interface WeatherApi {
        
        @retrofit2.http.GET(value = "weather")
        @org.jetbrains.annotations.Nullable
        public abstract java.lang.Object getCurrentWeather(@retrofit2.http.Query(value = "q")
        @org.jetbrains.annotations.NotNull
        java.lang.String city, @retrofit2.http.Query(value = "appid")
        @org.jetbrains.annotations.NotNull
        java.lang.String apiKey, @retrofit2.http.Query(value = "units")
        @org.jetbrains.annotations.NotNull
        java.lang.String units, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.api.WeatherResponse> $completion);
        
        @retrofit2.http.GET(value = "forecast")
        @org.jetbrains.annotations.Nullable
        public abstract java.lang.Object getForecast(@retrofit2.http.Query(value = "q")
        @org.jetbrains.annotations.NotNull
        java.lang.String city, @retrofit2.http.Query(value = "appid")
        @org.jetbrains.annotations.NotNull
        java.lang.String apiKey, @retrofit2.http.Query(value = "units")
        @org.jetbrains.annotations.NotNull
        java.lang.String units, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.api.ForecastResponse> $completion);
        
        @retrofit2.http.GET(value = "weather")
        @org.jetbrains.annotations.Nullable
        public abstract java.lang.Object getWeatherByCoordinates(@retrofit2.http.Query(value = "lat")
        double lat, @retrofit2.http.Query(value = "lon")
        double lon, @retrofit2.http.Query(value = "appid")
        @org.jetbrains.annotations.NotNull
        java.lang.String apiKey, @retrofit2.http.Query(value = "units")
        @org.jetbrains.annotations.NotNull
        java.lang.String units, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.api.WeatherResponse> $completion);
        
        @retrofit2.http.GET(value = "forecast")
        @org.jetbrains.annotations.Nullable
        public abstract java.lang.Object getForecastByCoordinates(@retrofit2.http.Query(value = "lat")
        double lat, @retrofit2.http.Query(value = "lon")
        double lon, @retrofit2.http.Query(value = "appid")
        @org.jetbrains.annotations.NotNull
        java.lang.String apiKey, @retrofit2.http.Query(value = "units")
        @org.jetbrains.annotations.NotNull
        java.lang.String units, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super com.simbasmart.weatherapp.data.api.ForecastResponse> $completion);
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 3, xi = 48)
        public static final class DefaultImpls {
        }
    }
}