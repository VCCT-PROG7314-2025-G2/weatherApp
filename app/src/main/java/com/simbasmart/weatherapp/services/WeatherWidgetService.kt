package com.simbasmart.weatherapp.services

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import com.simbasmart.weatherapp.R
import com.simbasmart.weatherapp.data.api.WeatherApiService
import com.simbasmart.weatherapp.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Weather Widget Service
 * Provides home screen widget functionality with real-time weather updates
 */
class WeatherWidgetService : AppWidgetProvider() {
    
    private val TAG = "WeatherWidgetService"
    private val apiService = WeatherApiService()
    
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        Log.d(TAG, "Updating weather widgets: ${appWidgetIds.size} widgets")
        
        for (appWidgetId in appWidgetIds) {
            updateWeatherWidget(context, appWidgetManager, appWidgetId)
        }
    }
    
    /**
     * Update individual weather widget
     */
    private fun updateWeatherWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Get weather data for default location - use proper format for API
                val weather = apiService.getCurrentWeather("Johannesburg,ZA")
                
                withContext(Dispatchers.Main) {
                    val views = RemoteViews(context.packageName, R.layout.widget_weather)
                    
                    if (weather != null) {
                        // Update widget content with real weather data
                        views.setTextViewText(R.id.tv_widget_temperature, "${weather.temperature.toInt()}°")
                        views.setTextViewText(R.id.tv_widget_location, weather.locationName)
                        views.setTextViewText(R.id.tv_widget_description, weather.description.capitalize())
                        Log.d(TAG, "Weather widget updated with real data")
                    } else {
                        // Show error state when weather data is null
                        views.setTextViewText(R.id.tv_widget_temperature, "N/A")
                        views.setTextViewText(R.id.tv_widget_location, "Weather Unavailable")
                        views.setTextViewText(R.id.tv_widget_description, "Tap to refresh")
                        Log.w(TAG, "Weather widget updated with null data")
                    }
                    
                    // Set click intent to open app
                    val intent = Intent(context, MainActivity::class.java)
                    val pendingIntent = PendingIntent.getActivity(
                        context,
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                    )
                    views.setOnClickPendingIntent(R.id.widget_layout, pendingIntent)
                    
                    // Update widget
                    appWidgetManager.updateAppWidget(appWidgetId, views)
                    
                    Log.d(TAG, "Weather widget updated successfully")
                }
                
            } catch (e: Exception) {
                Log.e(TAG, "Error updating weather widget", e)
                
                withContext(Dispatchers.Main) {
                    val views = RemoteViews(context.packageName, R.layout.widget_weather)
                    views.setTextViewText(R.id.tv_widget_temperature, "N/A")
                    views.setTextViewText(R.id.tv_widget_location, "Weather Unavailable")
                    views.setTextViewText(R.id.tv_widget_description, "Tap to refresh")
                    
                    appWidgetManager.updateAppWidget(appWidgetId, views)
                }
            }
        }
    }
    
    override fun onEnabled(context: Context) {
        super.onEnabled(context)
        Log.d(TAG, "Weather widget enabled")
    }
    
    override fun onDisabled(context: Context) {
        super.onDisabled(context)
        Log.d(TAG, "Weather widget disabled")
    }
}
