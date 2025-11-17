package com.simbasmart.weatherapp.ui.weather;

/**
 * Adapter for daily weather forecast
 * Displays weather information for each day
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/simbasmart/weatherapp/ui/weather/DailyForecastAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/simbasmart/weatherapp/data/model/Weather;", "Lcom/simbasmart/weatherapp/ui/weather/DailyForecastAdapter$DailyViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DailyDiffCallback", "DailyViewHolder", "app_release"})
public final class DailyForecastAdapter extends androidx.recyclerview.widget.ListAdapter<com.simbasmart.weatherapp.data.model.Weather, com.simbasmart.weatherapp.ui.weather.DailyForecastAdapter.DailyViewHolder> {
    
    public DailyForecastAdapter() {
        super(null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.simbasmart.weatherapp.ui.weather.DailyForecastAdapter.DailyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.simbasmart.weatherapp.ui.weather.DailyForecastAdapter.DailyViewHolder holder, int position) {
    }
    
    /**
     * DiffUtil callback for efficient list updates
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/simbasmart/weatherapp/ui/weather/DailyForecastAdapter$DailyDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/simbasmart/weatherapp/data/model/Weather;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    static final class DailyDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.simbasmart.weatherapp.data.model.Weather> {
        
        public DailyDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.simbasmart.weatherapp.data.model.Weather oldItem, @org.jetbrains.annotations.NotNull
        com.simbasmart.weatherapp.data.model.Weather newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.simbasmart.weatherapp.data.model.Weather oldItem, @org.jetbrains.annotations.NotNull
        com.simbasmart.weatherapp.data.model.Weather newItem) {
            return false;
        }
    }
    
    /**
     * ViewHolder for daily forecast items
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/simbasmart/weatherapp/ui/weather/DailyForecastAdapter$DailyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/simbasmart/weatherapp/databinding/ItemDailyForecastBinding;", "(Lcom/simbasmart/weatherapp/databinding/ItemDailyForecastBinding;)V", "bind", "", "weather", "Lcom/simbasmart/weatherapp/data/model/Weather;", "position", "", "app_release"})
    public static final class DailyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.simbasmart.weatherapp.databinding.ItemDailyForecastBinding binding = null;
        
        public DailyViewHolder(@org.jetbrains.annotations.NotNull
        com.simbasmart.weatherapp.databinding.ItemDailyForecastBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.simbasmart.weatherapp.data.model.Weather weather, int position) {
        }
    }
}