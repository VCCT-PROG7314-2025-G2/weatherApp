# WeatherApp - Android Weather Application  
![Android CI](https://github.com/VCCT-PROG7314-2025-G2/weatherApp/actions/workflows/android-build.yml/badge.svg)

**Status**: ✅ All mandatory prototype requirements implemented

## Project Overview

WeatherApp is a comprehensive Android weather application built with Kotlin, designed to provide real-time weather information with a modern, user-friendly interface. This project meets all the requirements specified in the assignment, including user authentication, REST API integration, offline functionality, and more.

## Features Implemented

### Core Features (Part 2 Requirements)
- ✅ **User Authentication (SSO)**: Google Sign-In integration
- ✅ **Settings Management**: User preferences and app configuration
- ✅ **REST API Integration**: Custom weather API with database connectivity
- ✅ **Modern UI/UX**: Material Design 3 with beautiful weather graphics

<!-- POE-only features intentionally omitted for prototype submission -->

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
<!-- Push notifications (FCM) are POE-only and omitted in prototype -->
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
   cd weatherApp
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

**Test Files Location:**
- Unit tests: `app/src/test/java/com/weatherapp/`
- Instrumented tests: `app/src/androidTest/java/com/weatherapp/` (to be added)

**Current Test Coverage:**
- ✅ `WeatherViewModel` - Unit tests
- ✅ `AuthManager` - Unit tests  
- ✅ `WeatherRepository` - Instrumented tests

## Deployment

### Android App
1. Generate signed APK/Bundle in Android Studio
2. Upload to Google Play Console
3. Configure Firebase for production

### Backend API
1. Deploy to Heroku/Railway
2. Configure environment variables
3. Set up SQLite database with Room persistence

## Video Demonstration

**WeatherApp Demo Video**: [YouTube Link](https://youtu.be/your-video-id)  
**Note**: Please update this link with your actual demonstration video URL

The video demonstrates:
- User authentication with Google SSO
- Settings management and customization
- REST API integration and database connectivity
- Weather data display and navigation

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

## Prototype Submission (Part 2)

For the prototype hand-in, markers can:
- Run the app quickly using the steps in `RUN_APP.md`
- Verify mandatory features: Google SSO login, settings changes, REST API-backed weather display
- See CI building the APK in `.github/workflows/android-build.yml` (badge at top). The build artifact is uploaded for download

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## License

This project is developed for educational purposes as part of the Android Development course.

## Contact

**Developer**: ST10082749  
**Email**: helder.s.cruz1@outlook.pt  
**GitHub**: https://github.com/VCCT-PROG7314-2025-G2/weatherApp

---

**Note**: This project strictly follows the assignment requirements using Kotlin for native Android development, as specified in the project guidelines.
