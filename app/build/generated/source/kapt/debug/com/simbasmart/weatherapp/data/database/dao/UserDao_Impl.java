package com.simbasmart.weatherapp.data.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.simbasmart.weatherapp.data.database.converter.DateConverter;
import com.simbasmart.weatherapp.data.database.entity.UserEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;

  private final DateConverter __dateConverter = new DateConverter();

  private final EntityDeletionOrUpdateAdapter<UserEntity> __deletionAdapterOfUserEntity;

  private final EntityDeletionOrUpdateAdapter<UserEntity> __updateAdapterOfUserEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLastLogin;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTemperatureUnit;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWindSpeedUnit;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePressureUnit;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLanguage;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNotificationsEnabled;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLocationPermission;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBiometricEnabled;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDarkModeEnabled;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAutoRefreshInterval;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDefaultLocation;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUserById;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `users` (`userId`,`email`,`display_name`,`profile_picture`,`created_at`,`last_login`,`is_active`,`temperature_unit`,`wind_speed_unit`,`pressure_unit`,`language`,`notifications_enabled`,`location_permission_granted`,`biometric_enabled`,`dark_mode_enabled`,`auto_refresh_interval`,`default_location_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final UserEntity entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEmail());
        }
        if (entity.getDisplayName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDisplayName());
        }
        if (entity.getProfilePicture() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getProfilePicture());
        }
        final Long _tmp = __dateConverter.dateToTimestamp(entity.getCreatedAt());
        if (_tmp == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, _tmp);
        }
        final Long _tmp_1 = __dateConverter.dateToTimestamp(entity.getLastLogin());
        if (_tmp_1 == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, _tmp_1);
        }
        final int _tmp_2 = entity.isActive() ? 1 : 0;
        statement.bindLong(7, _tmp_2);
        if (entity.getTemperatureUnit() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTemperatureUnit());
        }
        if (entity.getWindSpeedUnit() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getWindSpeedUnit());
        }
        if (entity.getPressureUnit() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getPressureUnit());
        }
        if (entity.getLanguage() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getLanguage());
        }
        final int _tmp_3 = entity.getNotificationsEnabled() ? 1 : 0;
        statement.bindLong(12, _tmp_3);
        final int _tmp_4 = entity.getLocationPermissionGranted() ? 1 : 0;
        statement.bindLong(13, _tmp_4);
        final int _tmp_5 = entity.getBiometricEnabled() ? 1 : 0;
        statement.bindLong(14, _tmp_5);
        final int _tmp_6 = entity.getDarkModeEnabled() ? 1 : 0;
        statement.bindLong(15, _tmp_6);
        statement.bindLong(16, entity.getAutoRefreshInterval());
        if (entity.getDefaultLocationId() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getDefaultLocationId());
        }
      }
    };
    this.__deletionAdapterOfUserEntity = new EntityDeletionOrUpdateAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `users` WHERE `userId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final UserEntity entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
      }
    };
    this.__updateAdapterOfUserEntity = new EntityDeletionOrUpdateAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `users` SET `userId` = ?,`email` = ?,`display_name` = ?,`profile_picture` = ?,`created_at` = ?,`last_login` = ?,`is_active` = ?,`temperature_unit` = ?,`wind_speed_unit` = ?,`pressure_unit` = ?,`language` = ?,`notifications_enabled` = ?,`location_permission_granted` = ?,`biometric_enabled` = ?,`dark_mode_enabled` = ?,`auto_refresh_interval` = ?,`default_location_id` = ? WHERE `userId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final UserEntity entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEmail());
        }
        if (entity.getDisplayName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDisplayName());
        }
        if (entity.getProfilePicture() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getProfilePicture());
        }
        final Long _tmp = __dateConverter.dateToTimestamp(entity.getCreatedAt());
        if (_tmp == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, _tmp);
        }
        final Long _tmp_1 = __dateConverter.dateToTimestamp(entity.getLastLogin());
        if (_tmp_1 == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, _tmp_1);
        }
        final int _tmp_2 = entity.isActive() ? 1 : 0;
        statement.bindLong(7, _tmp_2);
        if (entity.getTemperatureUnit() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTemperatureUnit());
        }
        if (entity.getWindSpeedUnit() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getWindSpeedUnit());
        }
        if (entity.getPressureUnit() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getPressureUnit());
        }
        if (entity.getLanguage() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getLanguage());
        }
        final int _tmp_3 = entity.getNotificationsEnabled() ? 1 : 0;
        statement.bindLong(12, _tmp_3);
        final int _tmp_4 = entity.getLocationPermissionGranted() ? 1 : 0;
        statement.bindLong(13, _tmp_4);
        final int _tmp_5 = entity.getBiometricEnabled() ? 1 : 0;
        statement.bindLong(14, _tmp_5);
        final int _tmp_6 = entity.getDarkModeEnabled() ? 1 : 0;
        statement.bindLong(15, _tmp_6);
        statement.bindLong(16, entity.getAutoRefreshInterval());
        if (entity.getDefaultLocationId() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getDefaultLocationId());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getUserId());
        }
      }
    };
    this.__preparedStmtOfUpdateLastLogin = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET last_login = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateTemperatureUnit = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET temperature_unit = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateWindSpeedUnit = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET wind_speed_unit = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePressureUnit = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET pressure_unit = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLanguage = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET language = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNotificationsEnabled = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET notifications_enabled = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLocationPermission = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET location_permission_granted = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBiometricEnabled = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET biometric_enabled = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDarkModeEnabled = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET dark_mode_enabled = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAutoRefreshInterval = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET auto_refresh_interval = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDefaultLocation = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET default_location_id = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteUserById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM users WHERE userId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertUser(final UserEntity user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserEntity.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUser(final UserEntity user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUserEntity.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUser(final UserEntity user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserEntity.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLastLogin(final String userId, final Date lastLogin,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLastLogin.acquire();
        int _argIndex = 1;
        final Long _tmp = __dateConverter.dateToTimestamp(lastLogin);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindLong(_argIndex, _tmp);
        }
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateLastLogin.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTemperatureUnit(final String userId, final String unit,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTemperatureUnit.acquire();
        int _argIndex = 1;
        if (unit == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, unit);
        }
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateTemperatureUnit.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateWindSpeedUnit(final String userId, final String unit,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWindSpeedUnit.acquire();
        int _argIndex = 1;
        if (unit == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, unit);
        }
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateWindSpeedUnit.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePressureUnit(final String userId, final String unit,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePressureUnit.acquire();
        int _argIndex = 1;
        if (unit == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, unit);
        }
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdatePressureUnit.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLanguage(final String userId, final String language,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLanguage.acquire();
        int _argIndex = 1;
        if (language == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, language);
        }
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateLanguage.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateNotificationsEnabled(final String userId, final boolean enabled,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNotificationsEnabled.acquire();
        int _argIndex = 1;
        final int _tmp = enabled ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateNotificationsEnabled.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLocationPermission(final String userId, final boolean granted,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLocationPermission.acquire();
        int _argIndex = 1;
        final int _tmp = granted ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateLocationPermission.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateBiometricEnabled(final String userId, final boolean enabled,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBiometricEnabled.acquire();
        int _argIndex = 1;
        final int _tmp = enabled ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateBiometricEnabled.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateDarkModeEnabled(final String userId, final boolean enabled,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDarkModeEnabled.acquire();
        int _argIndex = 1;
        final int _tmp = enabled ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateDarkModeEnabled.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAutoRefreshInterval(final String userId, final int interval,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAutoRefreshInterval.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, interval);
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateAutoRefreshInterval.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateDefaultLocation(final String userId, final String locationId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDefaultLocation.acquire();
        int _argIndex = 1;
        if (locationId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, locationId);
        }
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateDefaultLocation.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUserById(final String userId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUserById.acquire();
        int _argIndex = 1;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteUserById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserById(final String userId,
      final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM users WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_name");
          final int _cursorIndexOfProfilePicture = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_picture");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfLastLogin = CursorUtil.getColumnIndexOrThrow(_cursor, "last_login");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
          final int _cursorIndexOfTemperatureUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_unit");
          final int _cursorIndexOfWindSpeedUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed_unit");
          final int _cursorIndexOfPressureUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure_unit");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfNotificationsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "notifications_enabled");
          final int _cursorIndexOfLocationPermissionGranted = CursorUtil.getColumnIndexOrThrow(_cursor, "location_permission_granted");
          final int _cursorIndexOfBiometricEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "biometric_enabled");
          final int _cursorIndexOfDarkModeEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "dark_mode_enabled");
          final int _cursorIndexOfAutoRefreshInterval = CursorUtil.getColumnIndexOrThrow(_cursor, "auto_refresh_interval");
          final int _cursorIndexOfDefaultLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "default_location_id");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpProfilePicture;
            if (_cursor.isNull(_cursorIndexOfProfilePicture)) {
              _tmpProfilePicture = null;
            } else {
              _tmpProfilePicture = _cursor.getString(_cursorIndexOfProfilePicture);
            }
            final Date _tmpCreatedAt;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp);
            final Date _tmpLastLogin;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLastLogin)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfLastLogin);
            }
            _tmpLastLogin = __dateConverter.fromTimestamp(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            final String _tmpTemperatureUnit;
            if (_cursor.isNull(_cursorIndexOfTemperatureUnit)) {
              _tmpTemperatureUnit = null;
            } else {
              _tmpTemperatureUnit = _cursor.getString(_cursorIndexOfTemperatureUnit);
            }
            final String _tmpWindSpeedUnit;
            if (_cursor.isNull(_cursorIndexOfWindSpeedUnit)) {
              _tmpWindSpeedUnit = null;
            } else {
              _tmpWindSpeedUnit = _cursor.getString(_cursorIndexOfWindSpeedUnit);
            }
            final String _tmpPressureUnit;
            if (_cursor.isNull(_cursorIndexOfPressureUnit)) {
              _tmpPressureUnit = null;
            } else {
              _tmpPressureUnit = _cursor.getString(_cursorIndexOfPressureUnit);
            }
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final boolean _tmpNotificationsEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfNotificationsEnabled);
            _tmpNotificationsEnabled = _tmp_3 != 0;
            final boolean _tmpLocationPermissionGranted;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfLocationPermissionGranted);
            _tmpLocationPermissionGranted = _tmp_4 != 0;
            final boolean _tmpBiometricEnabled;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfBiometricEnabled);
            _tmpBiometricEnabled = _tmp_5 != 0;
            final boolean _tmpDarkModeEnabled;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfDarkModeEnabled);
            _tmpDarkModeEnabled = _tmp_6 != 0;
            final int _tmpAutoRefreshInterval;
            _tmpAutoRefreshInterval = _cursor.getInt(_cursorIndexOfAutoRefreshInterval);
            final String _tmpDefaultLocationId;
            if (_cursor.isNull(_cursorIndexOfDefaultLocationId)) {
              _tmpDefaultLocationId = null;
            } else {
              _tmpDefaultLocationId = _cursor.getString(_cursorIndexOfDefaultLocationId);
            }
            _result = new UserEntity(_tmpUserId,_tmpEmail,_tmpDisplayName,_tmpProfilePicture,_tmpCreatedAt,_tmpLastLogin,_tmpIsActive,_tmpTemperatureUnit,_tmpWindSpeedUnit,_tmpPressureUnit,_tmpLanguage,_tmpNotificationsEnabled,_tmpLocationPermissionGranted,_tmpBiometricEnabled,_tmpDarkModeEnabled,_tmpAutoRefreshInterval,_tmpDefaultLocationId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserByEmail(final String email,
      final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM users WHERE email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_name");
          final int _cursorIndexOfProfilePicture = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_picture");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfLastLogin = CursorUtil.getColumnIndexOrThrow(_cursor, "last_login");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
          final int _cursorIndexOfTemperatureUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_unit");
          final int _cursorIndexOfWindSpeedUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed_unit");
          final int _cursorIndexOfPressureUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure_unit");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfNotificationsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "notifications_enabled");
          final int _cursorIndexOfLocationPermissionGranted = CursorUtil.getColumnIndexOrThrow(_cursor, "location_permission_granted");
          final int _cursorIndexOfBiometricEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "biometric_enabled");
          final int _cursorIndexOfDarkModeEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "dark_mode_enabled");
          final int _cursorIndexOfAutoRefreshInterval = CursorUtil.getColumnIndexOrThrow(_cursor, "auto_refresh_interval");
          final int _cursorIndexOfDefaultLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "default_location_id");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpProfilePicture;
            if (_cursor.isNull(_cursorIndexOfProfilePicture)) {
              _tmpProfilePicture = null;
            } else {
              _tmpProfilePicture = _cursor.getString(_cursorIndexOfProfilePicture);
            }
            final Date _tmpCreatedAt;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp);
            final Date _tmpLastLogin;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLastLogin)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfLastLogin);
            }
            _tmpLastLogin = __dateConverter.fromTimestamp(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            final String _tmpTemperatureUnit;
            if (_cursor.isNull(_cursorIndexOfTemperatureUnit)) {
              _tmpTemperatureUnit = null;
            } else {
              _tmpTemperatureUnit = _cursor.getString(_cursorIndexOfTemperatureUnit);
            }
            final String _tmpWindSpeedUnit;
            if (_cursor.isNull(_cursorIndexOfWindSpeedUnit)) {
              _tmpWindSpeedUnit = null;
            } else {
              _tmpWindSpeedUnit = _cursor.getString(_cursorIndexOfWindSpeedUnit);
            }
            final String _tmpPressureUnit;
            if (_cursor.isNull(_cursorIndexOfPressureUnit)) {
              _tmpPressureUnit = null;
            } else {
              _tmpPressureUnit = _cursor.getString(_cursorIndexOfPressureUnit);
            }
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final boolean _tmpNotificationsEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfNotificationsEnabled);
            _tmpNotificationsEnabled = _tmp_3 != 0;
            final boolean _tmpLocationPermissionGranted;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfLocationPermissionGranted);
            _tmpLocationPermissionGranted = _tmp_4 != 0;
            final boolean _tmpBiometricEnabled;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfBiometricEnabled);
            _tmpBiometricEnabled = _tmp_5 != 0;
            final boolean _tmpDarkModeEnabled;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfDarkModeEnabled);
            _tmpDarkModeEnabled = _tmp_6 != 0;
            final int _tmpAutoRefreshInterval;
            _tmpAutoRefreshInterval = _cursor.getInt(_cursorIndexOfAutoRefreshInterval);
            final String _tmpDefaultLocationId;
            if (_cursor.isNull(_cursorIndexOfDefaultLocationId)) {
              _tmpDefaultLocationId = null;
            } else {
              _tmpDefaultLocationId = _cursor.getString(_cursorIndexOfDefaultLocationId);
            }
            _result = new UserEntity(_tmpUserId,_tmpEmail,_tmpDisplayName,_tmpProfilePicture,_tmpCreatedAt,_tmpLastLogin,_tmpIsActive,_tmpTemperatureUnit,_tmpWindSpeedUnit,_tmpPressureUnit,_tmpLanguage,_tmpNotificationsEnabled,_tmpLocationPermissionGranted,_tmpBiometricEnabled,_tmpDarkModeEnabled,_tmpAutoRefreshInterval,_tmpDefaultLocationId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<UserEntity>> getActiveUsers() {
    final String _sql = "SELECT * FROM users WHERE is_active = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"users"}, new Callable<List<UserEntity>>() {
      @Override
      @NonNull
      public List<UserEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_name");
          final int _cursorIndexOfProfilePicture = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_picture");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfLastLogin = CursorUtil.getColumnIndexOrThrow(_cursor, "last_login");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
          final int _cursorIndexOfTemperatureUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_unit");
          final int _cursorIndexOfWindSpeedUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed_unit");
          final int _cursorIndexOfPressureUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure_unit");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfNotificationsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "notifications_enabled");
          final int _cursorIndexOfLocationPermissionGranted = CursorUtil.getColumnIndexOrThrow(_cursor, "location_permission_granted");
          final int _cursorIndexOfBiometricEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "biometric_enabled");
          final int _cursorIndexOfDarkModeEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "dark_mode_enabled");
          final int _cursorIndexOfAutoRefreshInterval = CursorUtil.getColumnIndexOrThrow(_cursor, "auto_refresh_interval");
          final int _cursorIndexOfDefaultLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "default_location_id");
          final List<UserEntity> _result = new ArrayList<UserEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UserEntity _item;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpProfilePicture;
            if (_cursor.isNull(_cursorIndexOfProfilePicture)) {
              _tmpProfilePicture = null;
            } else {
              _tmpProfilePicture = _cursor.getString(_cursorIndexOfProfilePicture);
            }
            final Date _tmpCreatedAt;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp);
            final Date _tmpLastLogin;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfLastLogin)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfLastLogin);
            }
            _tmpLastLogin = __dateConverter.fromTimestamp(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            final String _tmpTemperatureUnit;
            if (_cursor.isNull(_cursorIndexOfTemperatureUnit)) {
              _tmpTemperatureUnit = null;
            } else {
              _tmpTemperatureUnit = _cursor.getString(_cursorIndexOfTemperatureUnit);
            }
            final String _tmpWindSpeedUnit;
            if (_cursor.isNull(_cursorIndexOfWindSpeedUnit)) {
              _tmpWindSpeedUnit = null;
            } else {
              _tmpWindSpeedUnit = _cursor.getString(_cursorIndexOfWindSpeedUnit);
            }
            final String _tmpPressureUnit;
            if (_cursor.isNull(_cursorIndexOfPressureUnit)) {
              _tmpPressureUnit = null;
            } else {
              _tmpPressureUnit = _cursor.getString(_cursorIndexOfPressureUnit);
            }
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final boolean _tmpNotificationsEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfNotificationsEnabled);
            _tmpNotificationsEnabled = _tmp_3 != 0;
            final boolean _tmpLocationPermissionGranted;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfLocationPermissionGranted);
            _tmpLocationPermissionGranted = _tmp_4 != 0;
            final boolean _tmpBiometricEnabled;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfBiometricEnabled);
            _tmpBiometricEnabled = _tmp_5 != 0;
            final boolean _tmpDarkModeEnabled;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfDarkModeEnabled);
            _tmpDarkModeEnabled = _tmp_6 != 0;
            final int _tmpAutoRefreshInterval;
            _tmpAutoRefreshInterval = _cursor.getInt(_cursorIndexOfAutoRefreshInterval);
            final String _tmpDefaultLocationId;
            if (_cursor.isNull(_cursorIndexOfDefaultLocationId)) {
              _tmpDefaultLocationId = null;
            } else {
              _tmpDefaultLocationId = _cursor.getString(_cursorIndexOfDefaultLocationId);
            }
            _item = new UserEntity(_tmpUserId,_tmpEmail,_tmpDisplayName,_tmpProfilePicture,_tmpCreatedAt,_tmpLastLogin,_tmpIsActive,_tmpTemperatureUnit,_tmpWindSpeedUnit,_tmpPressureUnit,_tmpLanguage,_tmpNotificationsEnabled,_tmpLocationPermissionGranted,_tmpBiometricEnabled,_tmpDarkModeEnabled,_tmpAutoRefreshInterval,_tmpDefaultLocationId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getUserCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getActiveUserCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM users WHERE is_active = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
