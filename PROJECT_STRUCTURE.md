# Project Structure

This document describes the organization of the WeatherApp repository.

## Directory Structure

```
weatherapp_p2/
├── .github/
│   └── workflows/
│       └── android-build.yml          # CI/CD pipeline for automated builds
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/weatherapp/
│   │   │   │   ├── data/              # Data layer
│   │   │   │   │   ├── api/           # REST API integration
│   │   │   │   │   ├── auth/          # Authentication logic
│   │   │   │   │   ├── database/      # Room database (entities, DAOs)
│   │   │   │   │   ├── model/         # Data models
│   │   │   │   │   └── repository/    # Data repositories
│   │   │   │   ├── services/          # Background services
│   │   │   │   ├── ui/                # UI components
│   │   │   │   │   ├── auth/          # Authentication screens
│   │   │   │   │   ├── settings/      # Settings screen
│   │   │   │   │   └── weather/       # Weather display screens
│   │   │   │   ├── viewmodel/         # ViewModels (MVVM architecture)
│   │   │   │   └── WeatherApplication.kt
│   │   │   ├── res/                   # Resources (layouts, drawables, values)
│   │   │   └── AndroidManifest.xml
│   │   └── test/                      # Unit tests
│   │       └── java/com/weatherapp/
│   │           ├── data/
│   │           │   ├── auth/
│   │           │   └── repository/
│   │           └── viewmodel/
│   ├── build.gradle                   # App-level dependencies
│   └── proguard-rules.pro
├── gradle/
│   └── wrapper/                       # Gradle wrapper files
├── .gitignore                         # Git ignore rules
├── build.gradle                       # Project-level build configuration
├── settings.gradle                    # Project settings
├── gradlew                            # Gradle wrapper (Unix)
├── gradlew.bat                        # Gradle wrapper (Windows)
├── README.md                          # Main project documentation
├── CONTRIBUTING.md                    # Contribution guidelines
├── PROJECT_STRUCTURE.md               # This file
├── REQUIREMENTS_COMPLIANCE_REPORT.md  # Requirements compliance analysis
├── PROTOTYPE_SUBMISSION.md            # Prototype submission checklist
├── AI_TOOLS_WRITEUP.md                # AI tools usage documentation
└── RUN_APP.md                         # Quick start guide
```

## Architecture

The app follows **MVVM (Model-View-ViewModel)** architecture:

- **Model**: Data layer (API, Database, Repository)
- **View**: UI components (Activities, Fragments, Layouts)
- **ViewModel**: Business logic and UI state management

## Key Components

### Data Layer
- `WeatherApiService`: Handles REST API calls to OpenWeatherMap
- `WeatherRepository`: Manages data operations (API + Database)
- `WeatherDatabase`: Room database for offline storage
- `AuthManager`: Manages user authentication state

### UI Layer
- `LoginActivity`: User authentication (Google SSO + Email)
- `MainActivity`: Main app container
- `WeatherFragment`: Weather display screen
- `SettingsActivity`: User preferences and settings

### ViewModel Layer
- `WeatherViewModel`: Manages weather data and UI state

## Testing

- Unit tests: `app/src/test/`
- Instrumented tests: `app/src/androidTest/` (to be added)

## Build System

- **Gradle**: Build automation
- **Kotlin**: Programming language
- **Android Gradle Plugin**: 8.1.0
- **Target SDK**: 34
- **Min SDK**: 26

## CI/CD

GitHub Actions workflow automatically:
- Builds the app on push/PR
- Runs unit tests
- Generates APK artifacts

