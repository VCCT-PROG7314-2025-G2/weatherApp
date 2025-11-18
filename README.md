# WeatherApp

![Android CI](https://github.com/VCCT-PROG7314-2025-G2/weatherApp/actions/workflows/android-build.yml/badge.svg)

A modern, feature-rich Android weather application built with Kotlin, providing real-time weather information with an intuitive user interface and seamless user experience.

## 🌟 Features

### Core Functionality
- **🔐 Secure Authentication**: Google Sign-In (SSO) integration for seamless user access
- **⚙️ Customizable Settings**: Comprehensive user preferences and app configuration options
- **🌐 REST API Integration**: Custom-built weather API with full database connectivity
- **📱 Modern UI/UX**: Material Design 3 with beautiful, responsive weather graphics
- **💾 Offline Support**: Local data storage with Room database for offline functionality
- **📍 Location Services**: Automatic location detection and manual location selection
- **📊 Data Visualization**: Interactive charts and graphs for weather trends

### Technical Highlights
- **MVVM Architecture**: Clean, maintainable code structure following best practices
- **Asynchronous Operations**: Kotlin Coroutines for smooth, non-blocking operations
- **Error Handling**: Robust input validation and graceful error management
- **Automated Testing**: Comprehensive unit and instrumented tests with CI/CD integration
- **Code Quality**: Well-documented codebase with logging and comprehensive comments

## 🛠️ Technical Stack

### Frontend
- **Language**: Kotlin 1.8.20
- **UI Framework**: Android Views with Material Design 3
- **Architecture**: MVVM (Model-View-ViewModel)
- **Navigation**: Android Navigation Component 2.7.2
- **Data Binding**: View Binding and Data Binding
- **Lifecycle Components**: ViewModel and LiveData (Lifecycle 2.6.2)
- **Target SDK**: Android 34 (API level 34)
- **Min SDK**: Android 8.0 (API level 26)

### Backend & Infrastructure
- **REST API**: OpenWeatherMap API (external weather data service)
- **API Client**: Retrofit 2.9.0 with Gson converter
- **Database**: SQLite with Room 2.6.0 for local data persistence
- **Authentication**: Google Sign-In via Google Play Services Auth 20.7.0
- **CI/CD**: GitHub Actions for automated builds and testing

### Key Libraries
- **Retrofit 2.9.0**: Type-safe HTTP client for REST API communication
- **Gson**: JSON serialization/deserialization
- **OkHttp Logging Interceptor 4.11.0**: HTTP request/response logging
- **Room 2.6.0**: SQLite object mapping library for database operations
- **Kotlin Coroutines 1.7.1**: Asynchronous programming and concurrency
- **Glide 4.16.0**: Efficient image loading and caching
- **MPAndroidChart v3.1.0**: Advanced weather data visualization
- **Google Play Services Location 21.0.1**: Location services
- **Google Play Services Auth 20.7.0**: Google Sign-In authentication
- **SwipeRefreshLayout**: Pull-to-refresh functionality

## 📁 Project Structure

```
app/
├── src/main/
│   ├── java/com/weatherapp/
│   │   ├── data/           # Data layer (API, database, models)
│   │   ├── ui/             # User interface components
│   │   │   ├── auth/       # Authentication screens
│   │   │   ├── weather/    # Weather display screens
│   │   │   └── settings/   # Settings screens
│   │   ├── viewmodel/      # ViewModels for UI logic
│   │   ├── repository/     # Data repositories
│   │   └── utils/          # Utility classes and helpers
│   ├── res/
│   │   ├── layout/         # XML layout files
│   │   ├── values/         # Strings, colors, themes
│   │   ├── drawable/       # Images and graphics
│   │   └── navigation/     # Navigation graphs
│   └── AndroidManifest.xml
├── build.gradle            # App-level dependencies
└── proguard-rules.pro      # Code obfuscation rules
```

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later (recommended: latest version)
- Android SDK 34 (API level 34)
- Minimum SDK: Android 8.0 (API level 26)
- Google Play Services (for authentication and location)
- Java Development Kit (JDK) 17 or higher

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/VCCT-PROG7314-2025-G2/weatherApp.git
   cd weatherApp
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned directory

3. **Configure OpenWeatherMap API**
   - Sign up for a free account at [OpenWeatherMap](https://openweathermap.org/)
   - Configure API settings in `app/src/main/java/com/weatherapp/data/api/ApiConfig.kt`
   - Free tier includes 60 calls/minute, current weather, and 5-day forecast

4. **Build the project**
   ```bash
   ./gradlew build
   ```

5. **Run the application**
   - Connect an Android device or start an emulator
   - Click "Run" in Android Studio or execute:
   ```bash
   ./gradlew installDebug
   ```

## 📡 API Documentation

### OpenWeatherMap API Integration

The app integrates with the [OpenWeatherMap API](https://openweathermap.org/api) to fetch real-time weather data.

**Weather Endpoints Used:**
- `GET /data/2.5/weather` - Retrieve current weather conditions by city name or coordinates
- `GET /data/2.5/forecast` - Get 5-day weather forecast with 3-hour intervals

**API Features:**
- Current weather data (temperature, humidity, wind speed, pressure, visibility)
- 5-day weather forecast
- Support for city name and GPS coordinates
- Metric and imperial unit support
- Automatic city name fallback and error handling

**Authentication:**
- Google Sign-In (SSO) via Google Play Services
- No custom backend authentication server required

## 🧪 Testing

The project includes comprehensive test coverage with both unit and instrumented tests.

### Running Tests

**Unit Tests:**
```bash
./gradlew test
```

**Instrumented Tests:**
```bash
./gradlew connectedAndroidTest
```

**Test Coverage Report:**
```bash
./gradlew jacocoTestReport
```

### Test Structure
- **Unit Tests**: `app/src/test/java/com/weatherapp/`
  - JUnit 4.13.2 for test framework
  - Mockito 5.1.1 with Kotlin support for mocking
  - Coroutines Test 1.7.1 for testing async operations
  - Architecture Components Testing 2.2.0 for ViewModel testing
  - `WeatherViewModel` tests
  - `AuthManager` tests
  - Repository unit tests
  
- **Instrumented Tests**: `app/src/androidTest/java/com/weatherapp/`
  - JUnit Android Extensions 1.1.5
  - Espresso 3.5.1 for UI testing
  - Room Testing 2.6.0 for database tests
  - `WeatherRepository` integration tests
  - UI component tests

## 📦 Deployment

### Android Application

1. **Generate Signed APK/Bundle**
   - Build → Generate Signed Bundle / APK
   - Follow the signing wizard in Android Studio

2. **Google Play Console**
   - Create a new app in Google Play Console
   - Upload the signed bundle
   - Complete store listing and release

3. **Production Configuration**
   - Configure OpenWeatherMap API settings
   - Configure Google Sign-In OAuth credentials
   - Enable ProGuard/R8 for code obfuscation
   - Test on multiple devices and Android versions

### API Configuration

1. **OpenWeatherMap Setup**
   - Ensure API configuration is properly set up
   - Monitor API usage and rate limits (60 calls/minute on free tier)
   - Consider upgrading to paid tier for production use

2. **Database Setup**
   - Room database is automatically initialized on first app launch
   - Database migrations are handled by Room
   - Local data persists across app restarts

## 🎥 Demo Video

**Watch the full demonstration**: [YouTube Video](https://youtu.be/your-video-id)

The demonstration showcases:
- User authentication flow with Google SSO
- Settings management and customization
- REST API integration and real-time data synchronization
- Weather data visualization and navigation
- Offline functionality and data persistence

## 📸 Screenshots

### Key Screens
- **Authentication**: Secure Google Sign-In interface
- **Weather Dashboard**: Real-time weather with beautiful graphics
- **Forecast View**: 7-day weather forecast with detailed information
- **Settings**: Comprehensive user preferences and app configuration

### Features Showcased
- Real-time weather updates
- Location-based weather data
- Customizable temperature units (Celsius/Fahrenheit)
- Interactive weather animations
- Responsive Material Design UI

## 🔧 Development

### Code Quality
- Comprehensive code comments and documentation
- Logging throughout the application for debugging
- Input validation and error handling
- Follows Android development best practices

### Continuous Integration
- Automated builds via GitHub Actions
- Automated testing on every commit
- Build artifacts available for download
- Status badge displayed at the top of this README

### Contributing

We welcome contributions! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

**Guidelines:**
- Write clear, descriptive commit messages
- Add tests for new functionality
- Ensure all tests pass before submitting
- Update documentation as needed

## 📝 Development Timeline

### Phase 1: Research & Planning
- Competitive analysis of existing weather applications
- Comprehensive planning and design documentation
- UI/UX mockups and navigation design
- API architecture and database schema design
- Project timeline and milestone planning

### Phase 2: Development
- Core authentication system implementation
- Weather data integration and API connectivity
- Settings management system
- Modern UI implementation with Material Design 3
- Testing and quality assurance

### Phase 3: POE Features (Latest Updates)
- **Offline Mode Implementation**: 
  - Room database integration for local data persistence
  - Weather data caching with WeatherEntity, LocationEntity, and UserEntity
  - Offline data retrieval and synchronization capabilities
  - Automatic data sync when network connectivity is restored
  - Support for viewing cached weather data without internet connection

- **Multi-Language Support**:
  - Implementation of localization for multiple South African languages
  - Support for English, Afrikaans, and isiZulu
  - Language selection in Settings with persistent user preferences
  - Locale-based date and time formatting throughout the app
  - User language preferences stored in database and SharedPreferences

- **Notifications System**:
  - WeatherNotificationService for weather alerts and daily updates
  - WeatherFirebaseMessagingService for push notifications
  - Notification channels for Android 8.0+ (Weather Alerts and Daily Weather)
  - Support for severe weather warnings, daily weather updates, and custom alerts
  - Configurable notification frequency settings (Never, Daily, Weather Alerts Only, Every 3 hours)
  - User-controlled notification preferences in Settings

## 📄 License

This project is open source and available for use and modification.

## 👤 Contact

**Developer**: ST10082749  
 
**GitHub**: [@VCCT-PROG7314-2025-G2](https://github.com/VCCT-PROG7314-2025-G2/weatherApp)

---

**Built with ❤️ using Kotlin and modern Android development practices**
