@echo off 
set DIRNAME=%~dp0 
if "%DIRNAME%" == "" set DIRNAME=. 
set APP_HOME=%DIRNAME% 
set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar 
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% "-Dorg.gradle.appname=%APP_BASE_NAME%" -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %* 
