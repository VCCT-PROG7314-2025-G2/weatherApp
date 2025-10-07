package com.simbasmart.weatherapp.ui.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.simbasmart.weatherapp.R
import com.simbasmart.weatherapp.data.model.Weather
import com.simbasmart.weatherapp.databinding.ItemDailyForecastBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * Adapter for daily weather forecast
 * Displays weather information for each day
 */
class DailyForecastAdapter : ListAdapter<Weather, DailyForecastAdapter.DailyViewHolder>(DailyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val binding = ItemDailyForecastBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DailyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    /**
     * ViewHolder for daily forecast items
     */
    class DailyViewHolder(
        private val binding: ItemDailyForecastBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: Weather, position: Int) {
            // Use actual date from weather object if available, otherwise calculate based on current date
            val displayName = if (weather.date != null) {
                // Use the actual date from the API
                if (position == 0) "Tomorrow" else weather.getFormattedDate()
            } else {
                // Calculate date based on current date (fallback)
                val calendar = Calendar.getInstance()
                calendar.add(Calendar.DAY_OF_YEAR, position + 1) // Start from tomorrow (position + 1)
                
                val dateFormat = SimpleDateFormat("EEE", Locale.getDefault())
                val dayName = dateFormat.format(calendar.time)
                
                // Special case for tomorrow
                if (position == 0) "Tomorrow" else dayName
            }
            binding.tvDay.text = displayName

            // Use real temperature data from API
            val temperature = weather.temperature.toInt()
            binding.tvTemperatureRange.text = "${temperature}°"

            // Weather description
            val description = when {
                weather.description.lowercase().contains("thunder") || 
                weather.description.lowercase().contains("storm") -> "Storm"
                weather.description.lowercase().contains("rain") || 
                weather.description.lowercase().contains("drizzle") -> "Rainy"
                weather.description.lowercase().contains("snow") -> "Snowy"
                weather.description.lowercase().contains("fog") || 
                weather.description.lowercase().contains("mist") -> "Foggy"
                weather.description.lowercase().contains("clear") || 
                weather.description.lowercase().contains("sunny") -> "Clear"
                weather.description.lowercase().contains("cloud") -> "Cloudy"
                else -> "Clear"
            }
            binding.tvWeatherDescription.text = description

            // Weather icon based on description - using beautiful 3D icons
            val iconRes = when {
                weather.description.lowercase().contains("thunder") || 
                weather.description.lowercase().contains("storm") -> 
                    R.drawable.ic_weather_thunder_3d
                weather.description.lowercase().contains("rain") || 
                weather.description.lowercase().contains("drizzle") -> 
                    R.drawable.ic_weather_rain_3d
                weather.description.lowercase().contains("snow") -> 
                    R.drawable.ic_weather_snow_3d
                weather.description.lowercase().contains("fog") || 
                weather.description.lowercase().contains("mist") -> 
                    R.drawable.ic_weather_fog
                weather.description.lowercase().contains("clear") || 
                weather.description.lowercase().contains("sunny") -> 
                    R.drawable.ic_weather_sunny_3d
                weather.description.lowercase().contains("cloud") -> 
                    R.drawable.ic_weather_cloudy_day
                else -> R.drawable.ic_weather_sunny_3d
            }
            binding.ivWeatherIcon.setImageResource(iconRes)
        }
    }

    /**
     * DiffUtil callback for efficient list updates
     */
    private class DailyDiffCallback : DiffUtil.ItemCallback<Weather>() {
        override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem == newItem
        }
    }
}
