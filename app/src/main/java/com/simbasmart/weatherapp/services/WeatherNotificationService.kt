package com.simbasmart.weatherapp.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.simbasmart.weatherapp.R
import com.simbasmart.weatherapp.data.model.Weather
import com.simbasmart.weatherapp.data.model.WeatherAlert
import com.simbasmart.weatherapp.ui.MainActivity

/**
 * Weather Notification Service
 * Handles weather alerts and daily weather notifications
 */
class WeatherNotificationService(private val context: Context) {
    
    private val TAG = "WeatherNotificationService"
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    
    companion object {
        const val CHANNEL_ID_WEATHER_ALERTS = "weather_alerts"
        const val CHANNEL_ID_DAILY_WEATHER = "daily_weather"
        const val NOTIFICATION_ID_ALERT = 1001
        const val NOTIFICATION_ID_DAILY = 1002
    }
    
    init {
        createNotificationChannels()
    }
    
    /**
     * Create notification channels for Android 8.0+
     */
    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Weather Alerts Channel
            val alertChannel = NotificationChannel(
                CHANNEL_ID_WEATHER_ALERTS,
                "Weather Alerts",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Important weather warnings and alerts"
                enableVibration(true)
                enableLights(true)
            }
            
            // Daily Weather Channel
            val dailyChannel = NotificationChannel(
                CHANNEL_ID_DAILY_WEATHER,
                "Daily Weather",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Daily weather updates and forecasts"
                enableVibration(false)
                enableLights(false)
            }
            
            notificationManager.createNotificationChannels(listOf(alertChannel, dailyChannel))
            Log.d(TAG, "Notification channels created")
        }
    }
    
    /**
     * Show weather alert notification
     */
    fun showWeatherAlert(alert: WeatherAlert) {
        Log.d(TAG, "Showing weather alert: ${alert.event}")
        
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val notification = NotificationCompat.Builder(context, CHANNEL_ID_WEATHER_ALERTS)
            .setSmallIcon(R.drawable.ic_weather_alert)
            .setContentTitle("Weather Alert: ${alert.event}")
            .setContentText(alert.description)
            .setStyle(NotificationCompat.BigTextStyle().bigText(alert.description))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()
        
        notificationManager.notify(NOTIFICATION_ID_ALERT, notification)
    }
    
    /**
     * Show daily weather notification
     */
    fun showDailyWeatherNotification(weather: Weather) {
        Log.d(TAG, "Showing daily weather notification for ${weather.locationName}")
        
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val message = "Today's weather: ${weather.temperature.toInt()}° - ${weather.description}"
        
        val notification = NotificationCompat.Builder(context, CHANNEL_ID_DAILY_WEATHER)
            .setSmallIcon(R.drawable.ic_weather_sunny_3d)
            .setContentTitle("Weather Update: ${weather.locationName}")
            .setContentText(message)
            .setStyle(NotificationCompat.BigTextStyle().bigText(message))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setCategory(NotificationCompat.CATEGORY_STATUS)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()
        
        notificationManager.notify(NOTIFICATION_ID_DAILY, notification)
    }
    
    /**
     * Show severe weather warning
     */
    fun showSevereWeatherWarning(weather: Weather, warning: String) {
        Log.d(TAG, "Showing severe weather warning: $warning")
        
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val notification = NotificationCompat.Builder(context, CHANNEL_ID_WEATHER_ALERTS)
            .setSmallIcon(R.drawable.ic_weather_thunder_3d)
            .setContentTitle("Severe Weather Warning")
            .setContentText(warning)
            .setStyle(NotificationCompat.BigTextStyle().bigText(warning))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()
        
        notificationManager.notify(NOTIFICATION_ID_ALERT + 1, notification)
    }
    
    /**
     * Cancel all weather notifications
     */
    fun cancelAllNotifications() {
        notificationManager.cancelAll()
        Log.d(TAG, "All weather notifications cancelled")
    }
    
    /**
     * Cancel specific notification
     */
    fun cancelNotification(notificationId: Int) {
        notificationManager.cancel(notificationId)
        Log.d(TAG, "Notification cancelled: $notificationId")
    }
}
