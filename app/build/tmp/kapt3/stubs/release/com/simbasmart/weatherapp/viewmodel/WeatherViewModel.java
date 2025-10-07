package com.simbasmart.weatherapp.viewmodel;

/**
 * WeatherViewModel - Manages weather data and UI state
 * Handles data operations and provides LiveData for UI updates
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u000e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0006J\b\u0010\'\u001a\u00020!H\u0014J\u0006\u0010(\u001a\u00020!J\u0016\u0010)\u001a\u00020!2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010+\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001f\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/simbasmart/weatherapp/viewmodel/WeatherViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "TAG", "", "_currentWeather", "Landroidx/lifecycle/MutableLiveData;", "Lcom/simbasmart/weatherapp/data/model/Weather;", "_dailyForecast", "", "_error", "_hourlyForecast", "_isLoading", "", "apiService", "Lcom/simbasmart/weatherapp/data/api/WeatherApiService;", "currentLocationId", "currentWeather", "Landroidx/lifecycle/LiveData;", "getCurrentWeather", "()Landroidx/lifecycle/LiveData;", "dailyForecast", "getDailyForecast", "error", "getError", "hourlyForecast", "getHourlyForecast", "isLoading", "repository", "Lcom/simbasmart/weatherapp/data/repository/WeatherRepository;", "clearError", "", "loadWeatherData", "loadWeatherDataForLocation", "cityName", "loadWeatherForLocation", "locationId", "onCleared", "refreshWeatherData", "toggleFavoriteLocation", "isFavorite", "updateCurrentLocation", "app_release"})
public final class WeatherViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.simbasmart.weatherapp.data.repository.WeatherRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final com.simbasmart.weatherapp.data.api.WeatherApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "WeatherViewModel";
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.simbasmart.weatherapp.data.model.Weather> _currentWeather = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.simbasmart.weatherapp.data.model.Weather> currentWeather = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.simbasmart.weatherapp.data.model.Weather>> _hourlyForecast = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.simbasmart.weatherapp.data.model.Weather>> hourlyForecast = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.simbasmart.weatherapp.data.model.Weather>> _dailyForecast = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.simbasmart.weatherapp.data.model.Weather>> dailyForecast = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.String> error = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String currentLocationId;
    
    public WeatherViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.simbasmart.weatherapp.data.model.Weather> getCurrentWeather() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.simbasmart.weatherapp.data.model.Weather>> getHourlyForecast() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.simbasmart.weatherapp.data.model.Weather>> getDailyForecast() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getError() {
        return null;
    }
    
    /**
     * Load weather data for current location
     */
    public final void loadWeatherData() {
    }
    
    /**
     * Load weather data for specific location
     */
    public final void loadWeatherForLocation(@org.jetbrains.annotations.NotNull
    java.lang.String locationId) {
    }
    
    /**
     * Load weather data for any location by city name
     */
    public final void loadWeatherDataForLocation(@org.jetbrains.annotations.NotNull
    java.lang.String cityName) {
    }
    
    /**
     * Refresh weather data
     */
    public final void refreshWeatherData() {
    }
    
    /**
     * Update current location
     */
    public final void updateCurrentLocation(@org.jetbrains.annotations.NotNull
    java.lang.String locationId) {
    }
    
    /**
     * Toggle favorite status for location
     */
    public final void toggleFavoriteLocation(@org.jetbrains.annotations.NotNull
    java.lang.String locationId, boolean isFavorite) {
    }
    
    /**
     * Clear error message
     */
    public final void clearError() {
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
}