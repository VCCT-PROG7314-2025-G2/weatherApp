package com.weatherapp.data.auth

import android.content.Context
import android.content.SharedPreferences
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

/**
 * Unit tests for AuthManager
 * Tests authentication state management, session validation, and user data persistence
 */
@RunWith(MockitoJUnitRunner::class)
class AuthManagerTest {

    @Mock
    private lateinit var mockContext: Context

    @Mock
    private lateinit var mockSharedPreferences: SharedPreferences

    @Mock
    private lateinit var mockEditor: SharedPreferences.Editor

    private lateinit var authManager: AuthManager

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        whenever(mockContext.getSharedPreferences(any(), any())).thenReturn(mockSharedPreferences)
        whenever(mockSharedPreferences.edit()).thenReturn(mockEditor)
        whenever(mockEditor.putString(any(), any())).thenReturn(mockEditor)
        whenever(mockEditor.putBoolean(any(), any())).thenReturn(mockEditor)
        whenever(mockEditor.putLong(any(), any())).thenReturn(mockEditor)
        whenever(mockEditor.remove(any())).thenReturn(mockEditor)
        whenever(mockEditor.apply()).then { }
        
        authManager = AuthManager(mockContext)
    }

    @Test
    fun `saveUserData should persist user information`() {
        // Given
        val name = "Test User"
        val email = "test@example.com"
        val userId = "user123"
        val authType = AuthManager.AUTH_TYPE_GOOGLE

        // When
        authManager.saveUserData(name, email, userId, authType)

        // Then
        verify(mockEditor).putString("user_name", name)
        verify(mockEditor).putString("user_email", email)
        verify(mockEditor).putString("user_id", userId)
        verify(mockEditor).putString("auth_type", authType)
        verify(mockEditor).putBoolean("is_logged_in", true)
        verify(mockEditor).apply()
    }

    @Test
    fun `logout should clear user data`() {
        // When
        authManager.logout()

        // Then
        verify(mockEditor).putBoolean("is_logged_in", false)
        verify(mockEditor).remove("user_name")
        verify(mockEditor).remove("user_email")
        verify(mockEditor).remove("user_id")
        verify(mockEditor).remove("auth_type")
        verify(mockEditor).remove("login_timestamp")
        verify(mockEditor).apply()
    }

    @Test
    fun `isValidEmail should return true for valid email`() {
        // Given
        val validEmail = "test@example.com"

        // When
        val result = authManager.isValidEmail(validEmail)

        // Then
        assert(result) { "Valid email should return true" }
    }

    @Test
    fun `isValidEmail should return false for invalid email`() {
        // Given
        val invalidEmail = "invalid-email"

        // When
        val result = authManager.isValidEmail(invalidEmail)

        // Then
        assert(!result) { "Invalid email should return false" }
    }

    @Test
    fun `isValidPassword should return true for password with 6 or more characters`() {
        // Given
        val validPassword = "password123"

        // When
        val result = authManager.isValidPassword(validPassword)

        // Then
        assert(result) { "Password with 6+ characters should return true" }
    }

    @Test
    fun `isValidPassword should return false for password with less than 6 characters`() {
        // Given
        val invalidPassword = "12345"

        // When
        val result = authManager.isValidPassword(invalidPassword)

        // Then
        assert(!result) { "Password with less than 6 characters should return false" }
    }
}

