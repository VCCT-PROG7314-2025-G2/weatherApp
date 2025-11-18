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
- **Language**: Kotlin
- **UI Framework**: Android Views with Material Design 3
- **Architecture**: MVVM (Model-View-ViewModel)
- **Navigation**: Android Navigation Component
- **Data Binding**: View Binding and Data Binding

### Backend & Infrastructure
- **REST API**: Custom weather API built with Node.js/Express
- **Database**: SQLite with Room for local data persistence
- **Authentication**: Firebase Authentication
- **Hosting**: Heroku/Railway for API deployment
- **CI/CD**: GitHub Actions for automated builds and testing

### Key Libraries
- **Retrofit**: Type-safe HTTP client for REST API communication
- **Room**: SQLite object mapping library for database operations
- **Coroutines**: Asynchronous programming and concurrency
- **Glide**: Efficient image loading and caching
- **MPAndroidChart**: Advanced weather data visualization
- **Google Play Services**: Location services and authentication

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
- Android Studio Arctic Fox or later
- Android SDK 24+ (API level 24)
- Google Play Services
- Firebase project setup
- Java Development Kit (JDK) 11 or higher

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

3. **Configure Firebase**
   - Create a Firebase project at [Firebase Console](https://console.firebase.google.com/)
   - Download `google-services.json`
   - Place it in the `app/` directory
   - Enable Authentication in Firebase Console

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

### Weather Endpoints
- `GET /api/weather/current` - Retrieve current weather conditions
- `GET /api/weather/forecast` - Get weather forecast data
- `GET /api/weather/hourly` - Fetch hourly weather forecast
- `POST /api/weather/location` - Update user location preferences

### Authentication Endpoints
- `POST /api/auth/login` - User authentication
- `POST /api/auth/register` - User registration
- `POST /api/auth/logout` - User session termination

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
  - `WeatherViewModel` tests
  - `AuthManager` tests
  - Repository unit tests
  
- **Instrumented Tests**: `app/src/androidTest/java/com/weatherapp/`
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
   - Configure Firebase for production environment
   - Update API endpoints to production URLs
   - Enable ProGuard/R8 for code obfuscation

### Backend API

1. **Deploy to Hosting Platform**
   - Deploy Node.js API to Heroku or Railway
   - Configure environment variables
   - Set up database connection

2. **Database Setup**
   - Initialize SQLite database with Room persistence
   - Run database migrations
   - Configure backup and recovery

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

## 📄 License

This project is open source and available for use and modification.

## 👤 Contact

**Developer**: ST10082749  
**Email**: helder.s.cruz1@outlook.pt  
**GitHub**: [@VCCT-PROG7314-2025-G2](https://github.com/VCCT-PROG7314-2025-G2/weatherApp)

---

**Built with ❤️ using Kotlin and modern Android development practices**
