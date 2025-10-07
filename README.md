# WeatherApp - Android Weather Application

## Project Overview

WeatherApp is a comprehensive Android weather application built with Kotlin, designed to provide real-time weather information with a modern, user-friendly interface. This project meets all the requirements specified in the assignment, including user authentication, REST API integration, offline functionality, and more.

## Features Implemented

### Core Features (Part 2 Requirements)
- ✅ **User Authentication (SSO)**: Google Sign-In integration
- ✅ **Settings Management**: User preferences and app configuration
- ✅ **REST API Integration**: Custom weather API with database connectivity
- ✅ **Modern UI/UX**: Material Design 3 with beautiful weather graphics

### Advanced Features (POE Requirements)
- 🔄 **Biometric Authentication**: Fingerprint and facial recognition
- 🔄 **Offline Mode**: SQLite local storage with Room database synchronization
- 🔄 **Push Notifications**: Real-time weather alerts
- 🔄 **Multi-language Support**: English, Afrikaans, isiZulu, isiXhosa

## Technical Stack

### Frontend
- **Language**: Kotlin
- **UI Framework**: Android Views with Material Design 3
- **Architecture**: MVVM (Model-View-ViewModel)
- **Navigation**: Android Navigation Component
- **Data Binding**: View Binding and Data Binding

### Backend & APIs
- **REST API**: Custom weather API built with Node.js/Express
- **Database**: SQLite with Room for local data storage
- **Authentication**: Firebase Authentication
- **Push Notifications**: Firebase Cloud Messaging
- **Hosting**: Heroku/Railway for API deployment

### Libraries & Dependencies
- **Retrofit**: REST API communication
- **Room**: SQLite database for offline functionality and local storage
- **Coroutines**: Asynchronous programming
- **Glide**: Image loading and caching
- **MPAndroidChart**: Weather data visualization
- **Google Play Services**: Location and authentication

## Project Structure

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
│   │   └── utils/          # Utility classes
│   ├── res/
│   │   ├── layout/         # XML layout files
│   │   ├── values/         # Strings, colors, themes
│   │   ├── drawable/       # Images and graphics
│   │   └── navigation/     # Navigation graphs
│   └── AndroidManifest.xml
├── build.gradle            # App-level dependencies
└── proguard-rules.pro      # Code obfuscation rules
```

## Installation & Setup

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 24+ (API level 24)
- Google Play Services
- Firebase project setup

### Build Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/VCCT-PROG7314-2025-G2/weatherApp.git 

   cd weatherapp
   ```

2. Open the project in Android Studio

3. Configure Firebase:
   - Add `google-services.json` to the `app/` directory
   - Enable Authentication and Cloud Messaging in Firebase Console

4. Build and run:
   ```bash
   ./gradlew build
   ```

## API Documentation

### Weather API Endpoints
- `GET /api/weather/current` - Get current weather
- `GET /api/weather/forecast` - Get weather forecast
- `GET /api/weather/hourly` - Get hourly forecast
- `POST /api/weather/location` - Update user location

### Authentication Endpoints
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration
- `POST /api/auth/logout` - User logout

## Testing

### Unit Tests
```bash
./gradlew test
```

### Instrumented Tests
```bash
./gradlew connectedAndroidTest
```

### Test Coverage
```bash
./gradlew jacocoTestReport
```

## Deployment

### Android App
1. Generate signed APK/Bundle in Android Studio
2. Upload to Google Play Console
3. Configure Firebase for production

### Backend API
1. Deploy to Heroku/Railway
2. Configure environment variables
3. Set up SQLite database with Room persistence

## Screenshots

### Main Screens
- **Login Screen**: Google Sign-In interface
- **Weather Dashboard**: Current weather with beautiful graphics
- **Forecast Screen**: 7-day weather forecast
- **Settings Screen**: User preferences and app configuration

### Features Demonstrated
- Real-time weather updates
- Location-based weather data
- Customizable units (Celsius/Fahrenheit)
- Beautiful weather animations
- Responsive Material Design UI

## Development Log

### Part 1 - Research & Planning
- ✅ Competitive analysis of 3 weather apps
- ✅ Detailed planning document (2500 words)
- ✅ UI/UX mockups and navigation design
- ✅ API design and database schema
- ✅ Project timeline with Gantt chart

### Part 2 - Prototype Development
- ✅ Core authentication system
- ✅ Weather data integration
- ✅ Settings management
- ✅ Modern UI implementation
- ✅ Video demonstration

## AI Tools Usage

This project utilized AI tools for:
- **Code Generation**: Initial project structure and boilerplate code
- **Debugging**: Error resolution and optimization suggestions
- **Documentation**: README and code comments generation
- **UI Design**: Layout suggestions and Material Design implementation

All AI-generated code has been reviewed, tested, and customized for the specific requirements.


## Contact

**Developer**: st10072849  
**Email**: helder.s.cruz1@outlook.pt  
**GitHub**: https://github.com/VCCT-PROG7314-2025-G2/weatherApp.git 

