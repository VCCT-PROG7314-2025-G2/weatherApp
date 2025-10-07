package com.simbasmart.weatherapp.data.auth;

/**
 * AuthManager - Manages user authentication state and sessions
 * Handles login/logout, session validation, and user data persistence
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/simbasmart/weatherapp/data/auth/AuthManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "prefs", "Landroid/content/SharedPreferences;", "getCurrentUser", "Lcom/simbasmart/weatherapp/data/auth/AuthManager$UserData;", "getGoogleAccount", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "getGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "isGoogleSignedIn", "", "isLoggedIn", "isSessionValid", "isValidEmail", "email", "isValidPassword", "password", "logout", "", "saveUserData", "name", "userId", "authType", "Companion", "UserData", "app_release"})
public final class AuthManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "AuthManager";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_IS_LOGGED_IN = "is_logged_in";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_USER_NAME = "user_name";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_USER_EMAIL = "user_email";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_LOGIN_TIMESTAMP = "login_timestamp";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_AUTH_TYPE = "auth_type";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AUTH_TYPE_GOOGLE = "google";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AUTH_TYPE_EMAIL = "email";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AUTH_TYPE_DEMO = "demo";
    @org.jetbrains.annotations.NotNull
    public static final com.simbasmart.weatherapp.data.auth.AuthManager.Companion Companion = null;
    
    public AuthManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * Check if user is currently logged in
     */
    public final boolean isLoggedIn() {
        return false;
    }
    
    /**
     * Get current user data
     */
    @org.jetbrains.annotations.Nullable
    public final com.simbasmart.weatherapp.data.auth.AuthManager.UserData getCurrentUser() {
        return null;
    }
    
    /**
     * Save user authentication data
     */
    public final void saveUserData(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String authType) {
    }
    
    /**
     * Clear user authentication data (logout)
     */
    public final void logout() {
    }
    
    /**
     * Check if current session is valid
     */
    public final boolean isSessionValid() {
        return false;
    }
    
    /**
     * Get Google Sign-In client
     */
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient getGoogleSignInClient() {
        return null;
    }
    
    /**
     * Check if user is signed in with Google
     */
    public final boolean isGoogleSignedIn() {
        return false;
    }
    
    /**
     * Get current Google account
     */
    @org.jetbrains.annotations.Nullable
    public final com.google.android.gms.auth.api.signin.GoogleSignInAccount getGoogleAccount() {
        return null;
    }
    
    /**
     * Validate email format
     */
    public final boolean isValidEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email) {
        return false;
    }
    
    /**
     * Validate password strength
     */
    public final boolean isValidPassword(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/simbasmart/weatherapp/data/auth/AuthManager$Companion;", "", "()V", "AUTH_TYPE_DEMO", "", "AUTH_TYPE_EMAIL", "AUTH_TYPE_GOOGLE", "KEY_AUTH_TYPE", "KEY_IS_LOGGED_IN", "KEY_LOGIN_TIMESTAMP", "KEY_USER_EMAIL", "KEY_USER_ID", "KEY_USER_NAME", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    /**
     * Data class for user information
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/simbasmart/weatherapp/data/auth/AuthManager$UserData;", "", "name", "", "email", "userId", "authType", "loginTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAuthType", "()Ljava/lang/String;", "getEmail", "getLoginTimestamp", "()J", "getName", "getUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
    public static final class UserData {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String email = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String userId = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String authType = null;
        private final long loginTimestamp = 0L;
        
        public UserData(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String email, @org.jetbrains.annotations.NotNull
        java.lang.String userId, @org.jetbrains.annotations.NotNull
        java.lang.String authType, long loginTimestamp) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getEmail() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUserId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getAuthType() {
            return null;
        }
        
        public final long getLoginTimestamp() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component4() {
            return null;
        }
        
        public final long component5() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.simbasmart.weatherapp.data.auth.AuthManager.UserData copy(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String email, @org.jetbrains.annotations.NotNull
        java.lang.String userId, @org.jetbrains.annotations.NotNull
        java.lang.String authType, long loginTimestamp) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}