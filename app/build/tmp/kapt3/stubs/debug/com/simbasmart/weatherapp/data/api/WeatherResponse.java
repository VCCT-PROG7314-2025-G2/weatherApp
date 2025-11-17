package com.simbasmart.weatherapp.data.api;

/**
 * Data classes for OpenWeatherMap API response
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\fH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003JK\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J\t\u0010%\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006&"}, d2 = {"Lcom/simbasmart/weatherapp/data/api/WeatherResponse;", "", "id", "", "name", "", "main", "Lcom/simbasmart/weatherapp/data/api/Main;", "weather", "", "Lcom/simbasmart/weatherapp/data/api/WeatherInfo;", "wind", "Lcom/simbasmart/weatherapp/data/api/Wind;", "visibility", "(ILjava/lang/String;Lcom/simbasmart/weatherapp/data/api/Main;Ljava/util/List;Lcom/simbasmart/weatherapp/data/api/Wind;I)V", "getId", "()I", "getMain", "()Lcom/simbasmart/weatherapp/data/api/Main;", "getName", "()Ljava/lang/String;", "getVisibility", "getWeather", "()Ljava/util/List;", "getWind", "()Lcom/simbasmart/weatherapp/data/api/Wind;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class WeatherResponse {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    private final com.simbasmart.weatherapp.data.api.Main main = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.simbasmart.weatherapp.data.api.WeatherInfo> weather = null;
    @org.jetbrains.annotations.NotNull
    private final com.simbasmart.weatherapp.data.api.Wind wind = null;
    private final int visibility = 0;
    
    public WeatherResponse(int id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.api.Main main, @org.jetbrains.annotations.NotNull
    java.util.List<com.simbasmart.weatherapp.data.api.WeatherInfo> weather, @org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.api.Wind wind, int visibility) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.simbasmart.weatherapp.data.api.Main getMain() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.simbasmart.weatherapp.data.api.WeatherInfo> getWeather() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.simbasmart.weatherapp.data.api.Wind getWind() {
        return null;
    }
    
    public final int getVisibility() {
        return 0;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.simbasmart.weatherapp.data.api.Main component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.simbasmart.weatherapp.data.api.WeatherInfo> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.simbasmart.weatherapp.data.api.Wind component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.simbasmart.weatherapp.data.api.WeatherResponse copy(int id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.api.Main main, @org.jetbrains.annotations.NotNull
    java.util.List<com.simbasmart.weatherapp.data.api.WeatherInfo> weather, @org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.api.Wind wind, int visibility) {
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