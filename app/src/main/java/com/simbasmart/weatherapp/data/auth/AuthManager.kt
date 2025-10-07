package com.simbasmart.weatherapp.data.auth

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

/**
 * AuthManager - Manages user authentication state and sessions
 * Handles login/logout, session validation, and user data persistence
 */
class AuthManager(private val context: Context) {
    
    private val prefs: SharedPreferences = context.getSharedPreferences("WeatherApp", Context.MODE_PRIVATE)
    private val TAG = "AuthManager"
    
    companion object {
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_USER_NAME = "user_name"
        private const val KEY_USER_EMAIL = "user_email"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_LOGIN_TIMESTAMP = "login_timestamp"
        private const val KEY_AUTH_TYPE = "auth_type"
        
        const val AUTH_TYPE_GOOGLE = "google"
        const val AUTH_TYPE_EMAIL = "email"
        const val AUTH_TYPE_DEMO = "demo"
    }
    
    /**
     * Check if user is currently logged in
     */
    fun isLoggedIn(): Boolean {
        val loggedIn = prefs.getBoolean(KEY_IS_LOGGED_IN, false)
        Log.d(TAG, "User logged in: $loggedIn")
        return loggedIn
    }
    
    /**
     * Get current user data
     */
    fun getCurrentUser(): UserData? {
        if (!isLoggedIn()) {
            return null
        }
        
        return UserData(
            name = prefs.getString(KEY_USER_NAME, "") ?: "",
            email = prefs.getString(KEY_USER_EMAIL, "") ?: "",
            userId = prefs.getString(KEY_USER_ID, "") ?: "",
            authType = prefs.getString(KEY_AUTH_TYPE, "") ?: "",
            loginTimestamp = prefs.getLong(KEY_LOGIN_TIMESTAMP, 0L)
        )
    }
    
    /**
     * Save user authentication data
     */
    fun saveUserData(name: String, email: String, userId: String, authType: String) {
        prefs.edit().apply {
            putString(KEY_USER_NAME, name)
            putString(KEY_USER_EMAIL, email)
            putString(KEY_USER_ID, userId)
            putString(KEY_AUTH_TYPE, authType)
            putBoolean(KEY_IS_LOGGED_IN, true)
            putLong(KEY_LOGIN_TIMESTAMP, System.currentTimeMillis())
            apply()
        }
        Log.d(TAG, "User data saved: $name ($email) via $authType")
    }
    
    /**
     * Clear user authentication data (logout)
     */
    fun logout() {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, false)
            remove(KEY_USER_NAME)
            remove(KEY_USER_EMAIL)
            remove(KEY_USER_ID)
            remove(KEY_AUTH_TYPE)
            remove(KEY_LOGIN_TIMESTAMP)
            apply()
        }
        Log.d(TAG, "User logged out")
    }
    
    /**
     * Check if current session is valid
     */
    fun isSessionValid(): Boolean {
        if (!isLoggedIn()) {
            return false
        }
        
        val loginTimestamp = prefs.getLong(KEY_LOGIN_TIMESTAMP, 0L)
        val currentTime = System.currentTimeMillis()
        val sessionDuration = 24 * 60 * 60 * 1000 // 24 hours in milliseconds
        
        val isValid = (currentTime - loginTimestamp) < sessionDuration
        Log.d(TAG, "Session valid: $isValid")
        
        return isValid
    }
    
    /**
     * Get Google Sign-In client
     */
    fun getGoogleSignInClient(): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestId()
            .requestProfile()
            .requestIdToken("123456789000-abcdefghijklmnop.apps.googleusercontent.com") // Use the client ID from google-services.json
            .build()
        
        return GoogleSignIn.getClient(context, gso)
    }
    
    /**
     * Check if user is signed in with Google
     */
    fun isGoogleSignedIn(): Boolean {
        val account = GoogleSignIn.getLastSignedInAccount(context)
        val isSignedIn = account != null
        Log.d(TAG, "Google signed in: $isSignedIn")
        return isSignedIn
    }
    
    /**
     * Get current Google account
     */
    fun getGoogleAccount(): GoogleSignInAccount? {
        return GoogleSignIn.getLastSignedInAccount(context)
    }
    
    /**
     * Validate email format
     */
    fun isValidEmail(email: String): Boolean {
        val emailPattern = android.util.Patterns.EMAIL_ADDRESS
        return emailPattern.matcher(email).matches()
    }
    
    /**
     * Validate password strength
     */
    fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }
    
    /**
     * Data class for user information
     */
    data class UserData(
        val name: String,
        val email: String,
        val userId: String,
        val authType: String,
        val loginTimestamp: Long
    )
}
