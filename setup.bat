@echo off
echo Setting up Weather App project...
echo.

echo Downloading Gradle wrapper...
powershell -Command "Invoke-WebRequest -Uri 'https://services.gradle.org/distributions/gradle-8.0-bin.zip' -OutFile 'gradle-8.0-bin.zip'"

echo Extracting Gradle...
powershell -Command "Expand-Archive -Path 'gradle-8.0-bin.zip' -DestinationPath '.' -Force"

echo Creating gradle wrapper...
echo @echo off > gradlew.bat
echo set DIRNAME=%%~dp0 >> gradlew.bat
echo if "%%DIRNAME%%" == "" set DIRNAME=. >> gradlew.bat
echo set APP_HOME=%%DIRNAME%% >> gradlew.bat
echo set CLASSPATH=%%APP_HOME%%\gradle\wrapper\gradle-wrapper.jar >> gradlew.bat
echo "%%JAVA_EXE%%" %%DEFAULT_JVM_OPTS%% %%JAVA_OPTS%% %%GRADLE_OPTS%% "-Dorg.gradle.appname=%%APP_BASE_NAME%%" -classpath "%%CLASSPATH%%" org.gradle.wrapper.GradleWrapperMain %%* >> gradlew.bat

echo.
echo Setup complete! You can now:
echo 1. Open Android Studio
echo 2. Open the weather_app folder as a project
echo 3. Wait for Gradle sync to complete
echo 4. Run the app on your device or emulator
echo.
pause
