package com.simbasmart.weatherapp.data.model

/**
 * WeatherAlert data model for weather warnings and alerts
 * Represents severe weather conditions and warnings
 */
data class WeatherAlert(
    val id: String,
    val event: String,
    val description: String,
    val severity: AlertSeverity,
    val startTime: Long,
    val endTime: Long,
    val location: String,
    val instructions: String = ""
) {
    
    /**
     * Get formatted alert time
     */
    fun getFormattedTime(): String {
        val timeFormat = java.text.SimpleDateFormat("MMM dd, HH:mm", java.util.Locale.getDefault())
        return timeFormat.format(java.util.Date(startTime))
    }
    
    /**
     * Check if alert is currently active
     */
    fun isActive(): Boolean {
        val currentTime = System.currentTimeMillis()
        return currentTime >= startTime && currentTime <= endTime
    }
    
    /**
     * Get alert severity color
     */
    fun getSeverityColor(): Int {
        return when (severity) {
            AlertSeverity.MINOR -> android.graphics.Color.parseColor("#FFA500") // Orange
            AlertSeverity.MODERATE -> android.graphics.Color.parseColor("#FF8C00") // Dark Orange
            AlertSeverity.SEVERE -> android.graphics.Color.parseColor("#FF4500") // Orange Red
            AlertSeverity.EXTREME -> android.graphics.Color.parseColor("#DC143C") // Crimson
        }
    }
    
    /**
     * Get alert severity icon
     */
    fun getSeverityIcon(): Int {
        return when (severity) {
            AlertSeverity.MINOR -> com.simbasmart.weatherapp.R.drawable.ic_alert_minor
            AlertSeverity.MODERATE -> com.simbasmart.weatherapp.R.drawable.ic_alert_moderate
            AlertSeverity.SEVERE -> com.simbasmart.weatherapp.R.drawable.ic_alert_severe
            AlertSeverity.EXTREME -> com.simbasmart.weatherapp.R.drawable.ic_alert_extreme
        }
    }
}

/**
 * Alert severity levels
 */
enum class AlertSeverity {
    MINOR,
    MODERATE,
    SEVERE,
    EXTREME
}
