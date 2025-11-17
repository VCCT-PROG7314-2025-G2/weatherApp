package com.simbasmart.weatherapp.services;

/**
 * Weather Notification Service
 * Handles weather alerts and daily weather notifications
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/simbasmart/weatherapp/services/WeatherNotificationService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "notificationManager", "Landroid/app/NotificationManager;", "cancelAllNotifications", "", "cancelNotification", "notificationId", "", "createNotificationChannels", "showDailyWeatherNotification", "weather", "Lcom/simbasmart/weatherapp/data/model/Weather;", "showSevereWeatherWarning", "warning", "showWeatherAlert", "alert", "Lcom/simbasmart/weatherapp/data/model/WeatherAlert;", "Companion", "app_release"})
public final class WeatherNotificationService {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "WeatherNotificationService";
    @org.jetbrains.annotations.NotNull
    private final android.app.NotificationManager notificationManager = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CHANNEL_ID_WEATHER_ALERTS = "weather_alerts";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CHANNEL_ID_DAILY_WEATHER = "daily_weather";
    public static final int NOTIFICATION_ID_ALERT = 1001;
    public static final int NOTIFICATION_ID_DAILY = 1002;
    @org.jetbrains.annotations.NotNull
    public static final com.simbasmart.weatherapp.services.WeatherNotificationService.Companion Companion = null;
    
    public WeatherNotificationService(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * Create notification channels for Android 8.0+
     */
    private final void createNotificationChannels() {
    }
    
    /**
     * Show weather alert notification
     */
    public final void showWeatherAlert(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.model.WeatherAlert alert) {
    }
    
    /**
     * Show daily weather notification
     */
    public final void showDailyWeatherNotification(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.model.Weather weather) {
    }
    
    /**
     * Show severe weather warning
     */
    public final void showSevereWeatherWarning(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.data.model.Weather weather, @org.jetbrains.annotations.NotNull
    java.lang.String warning) {
    }
    
    /**
     * Cancel all weather notifications
     */
    public final void cancelAllNotifications() {
    }
    
    /**
     * Cancel specific notification
     */
    public final void cancelNotification(int notificationId) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/simbasmart/weatherapp/services/WeatherNotificationService$Companion;", "", "()V", "CHANNEL_ID_DAILY_WEATHER", "", "CHANNEL_ID_WEATHER_ALERTS", "NOTIFICATION_ID_ALERT", "", "NOTIFICATION_ID_DAILY", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}