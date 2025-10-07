package com.simbasmart.weatherapp.ui.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.simbasmart.weatherapp.R
import com.simbasmart.weatherapp.data.model.Weather
import com.simbasmart.weatherapp.databinding.ItemHourlyForecastBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * Adapter for hourly weather forecast
 * Displays weather information for each hour
 */
class HourlyForecastAdapter : ListAdapter<Weather, HourlyForecastAdapter.HourlyViewHolder>(HourlyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val binding = ItemHourlyForecastBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HourlyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    /**
     * ViewHolder for hourly forecast items
     */
    class HourlyViewHolder(
        private val binding: ItemHourlyForecastBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: Weather, position: Int) {
            // Format time (mock data - in real app this would come from API)
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            val currentTime = Calendar.getInstance()
            currentTime.add(Calendar.HOUR, position)
            binding.tvTime.text = timeFormat.format(currentTime.time)

            // Temperature
            binding.tvTemperature.text = "${weather.temperature.toInt()}°"

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

            // Highlight current hour (position 0)
            if (position == 0) {
                binding.root.strokeColor = binding.root.context.getColor(R.color.primary)
                binding.root.strokeWidth = 4
            } else {
                binding.root.strokeWidth = 0
            }
        }
    }

    /**
     * DiffUtil callback for efficient list updates
     */
    private class HourlyDiffCallback : DiffUtil.ItemCallback<Weather>() {
        override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem == newItem
        }
    }
}
