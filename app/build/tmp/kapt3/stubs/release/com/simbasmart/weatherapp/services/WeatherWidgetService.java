package com.simbasmart.weatherapp.services;

/**
 * Weather Widget Service
 * Provides home screen widget functionality with real-time weather updates
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/simbasmart/weatherapp/services/WeatherWidgetService;", "Landroid/appwidget/AppWidgetProvider;", "()V", "TAG", "", "apiService", "Lcom/simbasmart/weatherapp/data/api/WeatherApiService;", "onDisabled", "", "context", "Landroid/content/Context;", "onEnabled", "onUpdate", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "updateWeatherWidget", "appWidgetId", "", "app_release"})
public final class WeatherWidgetService extends android.appwidget.AppWidgetProvider {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "WeatherWidgetService";
    @org.jetbrains.annotations.NotNull
    private final com.simbasmart.weatherapp.data.api.WeatherApiService apiService = null;
    
    public WeatherWidgetService() {
        super();
    }
    
    @java.lang.Override
    public void onUpdate(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.appwidget.AppWidgetManager appWidgetManager, @org.jetbrains.annotations.NotNull
    int[] appWidgetIds) {
    }
    
    /**
     * Update individual weather widget
     */
    private final void updateWeatherWidget(android.content.Context context, android.appwidget.AppWidgetManager appWidgetManager, int appWidgetId) {
    }
    
    @java.lang.Override
    public void onEnabled(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    public void onDisabled(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
}