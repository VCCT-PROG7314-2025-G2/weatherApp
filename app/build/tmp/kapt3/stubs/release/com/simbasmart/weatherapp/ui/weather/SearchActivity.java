package com.simbasmart.weatherapp.ui.weather;

/**
 * SearchActivity - Location search functionality
 * Allows users to search for any location and get weather data
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/simbasmart/weatherapp/ui/weather/SearchActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "binding", "Lcom/simbasmart/weatherapp/databinding/ActivitySearchBinding;", "popularCities", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSupportNavigateUp", "", "searchLocation", "location", "setupListeners", "setupObservers", "setupPopularCities", "setupUI", "showPopularCitiesDialog", "app_release"})
public final class SearchActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.simbasmart.weatherapp.databinding.ActivitySearchBinding binding;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "SearchActivity";
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> popularCities = null;
    
    public SearchActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Setup UI components
     */
    private final void setupUI() {
    }
    
    /**
     * Setup popular cities for quick access
     */
    private final void setupPopularCities() {
    }
    
    /**
     * Setup click listeners
     */
    private final void setupListeners() {
    }
    
    /**
     * Setup LiveData observers
     */
    private final void setupObservers() {
    }
    
    /**
     * Search for weather data by location
     */
    private final void searchLocation(java.lang.String location) {
    }
    
    /**
     * Show popular cities dialog
     */
    private final void showPopularCitiesDialog() {
    }
    
    @java.lang.Override
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
}