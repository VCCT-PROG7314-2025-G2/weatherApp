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
import com.simbasmart.weatherapp.data.database.entity.LocationEntity;
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
public final class LocationDao_Impl implements LocationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LocationEntity> __insertionAdapterOfLocationEntity;

  private final DateConverter __dateConverter = new DateConverter();

  private final EntityDeletionOrUpdateAdapter<LocationEntity> __deletionAdapterOfLocationEntity;

  private final EntityDeletionOrUpdateAdapter<LocationEntity> __updateAdapterOfLocationEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearCurrentLocation;

  private final SharedSQLiteStatement __preparedStmtOfSetCurrentLocation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFavoriteStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLastUpdated;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWeatherDataAvailable;

  private final SharedSQLiteStatement __preparedStmtOfDeleteLocationById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteLocationsForUser;

  public LocationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocationEntity = new EntityInsertionAdapter<LocationEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `locations` (`locationId`,`name`,`latitude`,`longitude`,`country`,`state`,`city`,`timezone`,`is_favorite`,`is_current_location`,`last_updated`,`weather_data_available`,`user_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final LocationEntity entity) {
        if (entity.getLocationId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getLocationId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindDouble(3, entity.getLatitude());
        statement.bindDouble(4, entity.getLongitude());
        if (entity.getCountry() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCountry());
        }
        if (entity.getState() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getState());
        }
        if (entity.getCity() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCity());
        }
        if (entity.getTimezone() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTimezone());
        }
        final int _tmp = entity.isFavorite() ? 1 : 0;
        statement.bindLong(9, _tmp);
        final int _tmp_1 = entity.isCurrentLocation() ? 1 : 0;
        statement.bindLong(10, _tmp_1);
        final Long _tmp_2 = __dateConverter.dateToTimestamp(entity.getLastUpdated());
        if (_tmp_2 == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, _tmp_2);
        }
        final int _tmp_3 = entity.getWeatherDataAvailable() ? 1 : 0;
        statement.bindLong(12, _tmp_3);
        if (entity.getUserId() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getUserId());
        }
      }
    };
    this.__deletionAdapterOfLocationEntity = new EntityDeletionOrUpdateAdapter<LocationEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `locations` WHERE `locationId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final LocationEntity entity) {
        if (entity.getLocationId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getLocationId());
        }
      }
    };
    this.__updateAdapterOfLocationEntity = new EntityDeletionOrUpdateAdapter<LocationEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `locations` SET `locationId` = ?,`name` = ?,`latitude` = ?,`longitude` = ?,`country` = ?,`state` = ?,`city` = ?,`timezone` = ?,`is_favorite` = ?,`is_current_location` = ?,`last_updated` = ?,`weather_data_available` = ?,`user_id` = ? WHERE `locationId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final LocationEntity entity) {
        if (entity.getLocationId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getLocationId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindDouble(3, entity.getLatitude());
        statement.bindDouble(4, entity.getLongitude());
        if (entity.getCountry() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCountry());
        }
        if (entity.getState() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getState());
        }
        if (entity.getCity() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCity());
        }
        if (entity.getTimezone() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTimezone());
        }
        final int _tmp = entity.isFavorite() ? 1 : 0;
        statement.bindLong(9, _tmp);
        final int _tmp_1 = entity.isCurrentLocation() ? 1 : 0;
        statement.bindLong(10, _tmp_1);
        final Long _tmp_2 = __dateConverter.dateToTimestamp(entity.getLastUpdated());
        if (_tmp_2 == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, _tmp_2);
        }
        final int _tmp_3 = entity.getWeatherDataAvailable() ? 1 : 0;
        statement.bindLong(12, _tmp_3);
        if (entity.getUserId() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getUserId());
        }
        if (entity.getLocationId() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getLocationId());
        }
      }
    };
    this.__preparedStmtOfClearCurrentLocation = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE locations SET is_current_location = 0";
        return _query;
      }
    };
    this.__preparedStmtOfSetCurrentLocation = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE locations SET is_current_location = 1 WHERE locationId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFavoriteStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE locations SET is_favorite = ? WHERE locationId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLastUpdated = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE locations SET last_updated = ? WHERE locationId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateWeatherDataAvailable = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE locations SET weather_data_available = ? WHERE locationId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteLocationById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM locations WHERE locationId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteLocationsForUser = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM locations WHERE user_id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertLocation(final LocationEntity location,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocationEntity.insert(location);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertLocationList(final List<LocationEntity> locations,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocationEntity.insert(locations);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteLocation(final LocationEntity location,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfLocationEntity.handle(location);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLocation(final LocationEntity location,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLocationEntity.handle(location);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearCurrentLocation(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearCurrentLocation.acquire();
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
          __preparedStmtOfClearCurrentLocation.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object setCurrentLocation(final String locationId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfSetCurrentLocation.acquire();
        int _argIndex = 1;
        if (locationId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, locationId);
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
          __preparedStmtOfSetCurrentLocation.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateFavoriteStatus(final String locationId, final boolean isFavorite,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFavoriteStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isFavorite ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (locationId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, locationId);
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
          __preparedStmtOfUpdateFavoriteStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLastUpdated(final String locationId, final Date lastUpdated,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLastUpdated.acquire();
        int _argIndex = 1;
        final Long _tmp = __dateConverter.dateToTimestamp(lastUpdated);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindLong(_argIndex, _tmp);
        }
        _argIndex = 2;
        if (locationId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, locationId);
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
          __preparedStmtOfUpdateLastUpdated.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateWeatherDataAvailable(final String locationId, final boolean available,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWeatherDataAvailable.acquire();
        int _argIndex = 1;
        final int _tmp = available ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (locationId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, locationId);
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
          __preparedStmtOfUpdateWeatherDataAvailable.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteLocationById(final String locationId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteLocationById.acquire();
        int _argIndex = 1;
        if (locationId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, locationId);
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
          __preparedStmtOfDeleteLocationById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteLocationsForUser(final String userId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteLocationsForUser.acquire();
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
          __preparedStmtOfDeleteLocationsForUser.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getLocationById(final String locationId,
      final Continuation<? super LocationEntity> $completion) {
    final String _sql = "SELECT * FROM locations WHERE locationId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, locationId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LocationEntity>() {
      @Override
      @Nullable
      public LocationEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "timezone");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfIsCurrentLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "is_current_location");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_updated");
          final int _cursorIndexOfWeatherDataAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "weather_data_available");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final LocationEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpTimezone;
            if (_cursor.isNull(_cursorIndexOfTimezone)) {
              _tmpTimezone = null;
            } else {
              _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsCurrentLocation;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCurrentLocation);
            _tmpIsCurrentLocation = _tmp_1 != 0;
            final Date _tmpLastUpdated;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfLastUpdated)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfLastUpdated);
            }
            _tmpLastUpdated = __dateConverter.fromTimestamp(_tmp_2);
            final boolean _tmpWeatherDataAvailable;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfWeatherDataAvailable);
            _tmpWeatherDataAvailable = _tmp_3 != 0;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            _result = new LocationEntity(_tmpLocationId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpCountry,_tmpState,_tmpCity,_tmpTimezone,_tmpIsFavorite,_tmpIsCurrentLocation,_tmpLastUpdated,_tmpWeatherDataAvailable,_tmpUserId);
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
  public Object getCurrentLocation(final Continuation<? super LocationEntity> $completion) {
    final String _sql = "SELECT * FROM locations WHERE is_current_location = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LocationEntity>() {
      @Override
      @Nullable
      public LocationEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "timezone");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfIsCurrentLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "is_current_location");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_updated");
          final int _cursorIndexOfWeatherDataAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "weather_data_available");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final LocationEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpTimezone;
            if (_cursor.isNull(_cursorIndexOfTimezone)) {
              _tmpTimezone = null;
            } else {
              _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsCurrentLocation;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCurrentLocation);
            _tmpIsCurrentLocation = _tmp_1 != 0;
            final Date _tmpLastUpdated;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfLastUpdated)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfLastUpdated);
            }
            _tmpLastUpdated = __dateConverter.fromTimestamp(_tmp_2);
            final boolean _tmpWeatherDataAvailable;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfWeatherDataAvailable);
            _tmpWeatherDataAvailable = _tmp_3 != 0;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            _result = new LocationEntity(_tmpLocationId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpCountry,_tmpState,_tmpCity,_tmpTimezone,_tmpIsFavorite,_tmpIsCurrentLocation,_tmpLastUpdated,_tmpWeatherDataAvailable,_tmpUserId);
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
  public Flow<List<LocationEntity>> getFavoriteLocations() {
    final String _sql = "SELECT * FROM locations WHERE is_favorite = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"locations"}, new Callable<List<LocationEntity>>() {
      @Override
      @NonNull
      public List<LocationEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "timezone");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfIsCurrentLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "is_current_location");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_updated");
          final int _cursorIndexOfWeatherDataAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "weather_data_available");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final List<LocationEntity> _result = new ArrayList<LocationEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LocationEntity _item;
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpTimezone;
            if (_cursor.isNull(_cursorIndexOfTimezone)) {
              _tmpTimezone = null;
            } else {
              _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsCurrentLocation;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCurrentLocation);
            _tmpIsCurrentLocation = _tmp_1 != 0;
            final Date _tmpLastUpdated;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfLastUpdated)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfLastUpdated);
            }
            _tmpLastUpdated = __dateConverter.fromTimestamp(_tmp_2);
            final boolean _tmpWeatherDataAvailable;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfWeatherDataAvailable);
            _tmpWeatherDataAvailable = _tmp_3 != 0;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            _item = new LocationEntity(_tmpLocationId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpCountry,_tmpState,_tmpCity,_tmpTimezone,_tmpIsFavorite,_tmpIsCurrentLocation,_tmpLastUpdated,_tmpWeatherDataAvailable,_tmpUserId);
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
  public Flow<List<LocationEntity>> getLocationsForUser(final String userId) {
    final String _sql = "SELECT * FROM locations WHERE user_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"locations"}, new Callable<List<LocationEntity>>() {
      @Override
      @NonNull
      public List<LocationEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "timezone");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfIsCurrentLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "is_current_location");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_updated");
          final int _cursorIndexOfWeatherDataAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "weather_data_available");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final List<LocationEntity> _result = new ArrayList<LocationEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LocationEntity _item;
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpTimezone;
            if (_cursor.isNull(_cursorIndexOfTimezone)) {
              _tmpTimezone = null;
            } else {
              _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsCurrentLocation;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCurrentLocation);
            _tmpIsCurrentLocation = _tmp_1 != 0;
            final Date _tmpLastUpdated;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfLastUpdated)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfLastUpdated);
            }
            _tmpLastUpdated = __dateConverter.fromTimestamp(_tmp_2);
            final boolean _tmpWeatherDataAvailable;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfWeatherDataAvailable);
            _tmpWeatherDataAvailable = _tmp_3 != 0;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            _item = new LocationEntity(_tmpLocationId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpCountry,_tmpState,_tmpCity,_tmpTimezone,_tmpIsFavorite,_tmpIsCurrentLocation,_tmpLastUpdated,_tmpWeatherDataAvailable,_tmpUserId);
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
  public Object searchLocations(final String searchQuery,
      final Continuation<? super List<LocationEntity>> $completion) {
    final String _sql = "SELECT * FROM locations WHERE name LIKE '%' || ? || '%' OR city LIKE '%' || ? || '%' OR country LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    _argIndex = 2;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    _argIndex = 3;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<LocationEntity>>() {
      @Override
      @NonNull
      public List<LocationEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "timezone");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfIsCurrentLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "is_current_location");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_updated");
          final int _cursorIndexOfWeatherDataAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "weather_data_available");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final List<LocationEntity> _result = new ArrayList<LocationEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LocationEntity _item;
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpTimezone;
            if (_cursor.isNull(_cursorIndexOfTimezone)) {
              _tmpTimezone = null;
            } else {
              _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsCurrentLocation;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCurrentLocation);
            _tmpIsCurrentLocation = _tmp_1 != 0;
            final Date _tmpLastUpdated;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfLastUpdated)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfLastUpdated);
            }
            _tmpLastUpdated = __dateConverter.fromTimestamp(_tmp_2);
            final boolean _tmpWeatherDataAvailable;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfWeatherDataAvailable);
            _tmpWeatherDataAvailable = _tmp_3 != 0;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            _item = new LocationEntity(_tmpLocationId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpCountry,_tmpState,_tmpCity,_tmpTimezone,_tmpIsFavorite,_tmpIsCurrentLocation,_tmpLastUpdated,_tmpWeatherDataAvailable,_tmpUserId);
            _result.add(_item);
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
  public Flow<List<LocationEntity>> getAllLocations() {
    final String _sql = "SELECT * FROM locations ORDER BY last_updated DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"locations"}, new Callable<List<LocationEntity>>() {
      @Override
      @NonNull
      public List<LocationEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "timezone");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfIsCurrentLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "is_current_location");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_updated");
          final int _cursorIndexOfWeatherDataAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "weather_data_available");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final List<LocationEntity> _result = new ArrayList<LocationEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LocationEntity _item;
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpTimezone;
            if (_cursor.isNull(_cursorIndexOfTimezone)) {
              _tmpTimezone = null;
            } else {
              _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsCurrentLocation;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCurrentLocation);
            _tmpIsCurrentLocation = _tmp_1 != 0;
            final Date _tmpLastUpdated;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfLastUpdated)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfLastUpdated);
            }
            _tmpLastUpdated = __dateConverter.fromTimestamp(_tmp_2);
            final boolean _tmpWeatherDataAvailable;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfWeatherDataAvailable);
            _tmpWeatherDataAvailable = _tmp_3 != 0;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            _item = new LocationEntity(_tmpLocationId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpCountry,_tmpState,_tmpCity,_tmpTimezone,_tmpIsFavorite,_tmpIsCurrentLocation,_tmpLastUpdated,_tmpWeatherDataAvailable,_tmpUserId);
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
  public Object getLocationCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM locations";
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
  public Object getFavoriteLocationCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM locations WHERE is_favorite = 1";
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
  public Object getCurrentLocationCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM locations WHERE is_current_location = 1";
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
  public Object getLocationsInBounds(final double minLat, final double maxLat, final double minLng,
      final double maxLng, final Continuation<? super List<LocationEntity>> $completion) {
    final String _sql = "SELECT * FROM locations WHERE latitude BETWEEN ? AND ? AND longitude BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindDouble(_argIndex, minLat);
    _argIndex = 2;
    _statement.bindDouble(_argIndex, maxLat);
    _argIndex = 3;
    _statement.bindDouble(_argIndex, minLng);
    _argIndex = 4;
    _statement.bindDouble(_argIndex, maxLng);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<LocationEntity>>() {
      @Override
      @NonNull
      public List<LocationEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "timezone");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "is_favorite");
          final int _cursorIndexOfIsCurrentLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "is_current_location");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_updated");
          final int _cursorIndexOfWeatherDataAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "weather_data_available");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final List<LocationEntity> _result = new ArrayList<LocationEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LocationEntity _item;
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpTimezone;
            if (_cursor.isNull(_cursorIndexOfTimezone)) {
              _tmpTimezone = null;
            } else {
              _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsCurrentLocation;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCurrentLocation);
            _tmpIsCurrentLocation = _tmp_1 != 0;
            final Date _tmpLastUpdated;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfLastUpdated)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfLastUpdated);
            }
            _tmpLastUpdated = __dateConverter.fromTimestamp(_tmp_2);
            final boolean _tmpWeatherDataAvailable;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfWeatherDataAvailable);
            _tmpWeatherDataAvailable = _tmp_3 != 0;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            _item = new LocationEntity(_tmpLocationId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpCountry,_tmpState,_tmpCity,_tmpTimezone,_tmpIsFavorite,_tmpIsCurrentLocation,_tmpLastUpdated,_tmpWeatherDataAvailable,_tmpUserId);
            _result.add(_item);
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
