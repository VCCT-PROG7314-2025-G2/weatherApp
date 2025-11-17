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
import com.simbasmart.weatherapp.data.database.entity.WeatherEntity;
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
public final class WeatherDao_Impl implements WeatherDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WeatherEntity> __insertionAdapterOfWeatherEntity;

  private final DateConverter __dateConverter = new DateConverter();

  private final EntityDeletionOrUpdateAdapter<WeatherEntity> __deletionAdapterOfWeatherEntity;

  private final EntityDeletionOrUpdateAdapter<WeatherEntity> __updateAdapterOfWeatherEntity;

  private final SharedSQLiteStatement __preparedStmtOfMarkAsSynced;

  private final SharedSQLiteStatement __preparedStmtOfMarkLocationAsSynced;

  private final SharedSQLiteStatement __preparedStmtOfDeleteWeatherForLocation;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOldWeatherData;

  public WeatherDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeatherEntity = new EntityInsertionAdapter<WeatherEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `weather_data` (`id`,`location_id`,`timestamp`,`temperature`,`feels_like`,`humidity`,`pressure`,`wind_speed`,`wind_direction`,`description`,`icon`,`visibility`,`uv_index`,`sunrise`,`sunset`,`data_type`,`forecast_date`,`is_synced`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final WeatherEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getLocationId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getLocationId());
        }
        final Long _tmp = __dateConverter.dateToTimestamp(entity.getTimestamp());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, _tmp);
        }
        statement.bindDouble(4, entity.getTemperature());
        statement.bindDouble(5, entity.getFeelsLike());
        statement.bindLong(6, entity.getHumidity());
        statement.bindDouble(7, entity.getPressure());
        statement.bindDouble(8, entity.getWindSpeed());
        statement.bindLong(9, entity.getWindDirection());
        if (entity.getDescription() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getDescription());
        }
        if (entity.getIcon() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getIcon());
        }
        statement.bindDouble(12, entity.getVisibility());
        statement.bindDouble(13, entity.getUvIndex());
        final Long _tmp_1 = __dateConverter.dateToTimestamp(entity.getSunrise());
        if (_tmp_1 == null) {
          statement.bindNull(14);
        } else {
          statement.bindLong(14, _tmp_1);
        }
        final Long _tmp_2 = __dateConverter.dateToTimestamp(entity.getSunset());
        if (_tmp_2 == null) {
          statement.bindNull(15);
        } else {
          statement.bindLong(15, _tmp_2);
        }
        if (entity.getDataType() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getDataType());
        }
        final Long _tmp_3 = __dateConverter.dateToTimestamp(entity.getForecastDate());
        if (_tmp_3 == null) {
          statement.bindNull(17);
        } else {
          statement.bindLong(17, _tmp_3);
        }
        final int _tmp_4 = entity.isSynced() ? 1 : 0;
        statement.bindLong(18, _tmp_4);
      }
    };
    this.__deletionAdapterOfWeatherEntity = new EntityDeletionOrUpdateAdapter<WeatherEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `weather_data` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final WeatherEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfWeatherEntity = new EntityDeletionOrUpdateAdapter<WeatherEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `weather_data` SET `id` = ?,`location_id` = ?,`timestamp` = ?,`temperature` = ?,`feels_like` = ?,`humidity` = ?,`pressure` = ?,`wind_speed` = ?,`wind_direction` = ?,`description` = ?,`icon` = ?,`visibility` = ?,`uv_index` = ?,`sunrise` = ?,`sunset` = ?,`data_type` = ?,`forecast_date` = ?,`is_synced` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final WeatherEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getLocationId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getLocationId());
        }
        final Long _tmp = __dateConverter.dateToTimestamp(entity.getTimestamp());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, _tmp);
        }
        statement.bindDouble(4, entity.getTemperature());
        statement.bindDouble(5, entity.getFeelsLike());
        statement.bindLong(6, entity.getHumidity());
        statement.bindDouble(7, entity.getPressure());
        statement.bindDouble(8, entity.getWindSpeed());
        statement.bindLong(9, entity.getWindDirection());
        if (entity.getDescription() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getDescription());
        }
        if (entity.getIcon() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getIcon());
        }
        statement.bindDouble(12, entity.getVisibility());
        statement.bindDouble(13, entity.getUvIndex());
        final Long _tmp_1 = __dateConverter.dateToTimestamp(entity.getSunrise());
        if (_tmp_1 == null) {
          statement.bindNull(14);
        } else {
          statement.bindLong(14, _tmp_1);
        }
        final Long _tmp_2 = __dateConverter.dateToTimestamp(entity.getSunset());
        if (_tmp_2 == null) {
          statement.bindNull(15);
        } else {
          statement.bindLong(15, _tmp_2);
        }
        if (entity.getDataType() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getDataType());
        }
        final Long _tmp_3 = __dateConverter.dateToTimestamp(entity.getForecastDate());
        if (_tmp_3 == null) {
          statement.bindNull(17);
        } else {
          statement.bindLong(17, _tmp_3);
        }
        final int _tmp_4 = entity.isSynced() ? 1 : 0;
        statement.bindLong(18, _tmp_4);
        statement.bindLong(19, entity.getId());
      }
    };
    this.__preparedStmtOfMarkAsSynced = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE weather_data SET is_synced = 1 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfMarkLocationAsSynced = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE weather_data SET is_synced = 1 WHERE location_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteWeatherForLocation = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM weather_data WHERE location_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOldWeatherData = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM weather_data WHERE timestamp < ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertWeather(final WeatherEntity weather,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWeatherEntity.insert(weather);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertWeatherList(final List<WeatherEntity> weatherList,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWeatherEntity.insert(weatherList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteWeather(final WeatherEntity weather,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfWeatherEntity.handle(weather);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateWeather(final WeatherEntity weather,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfWeatherEntity.handle(weather);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object markAsSynced(final long weatherId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkAsSynced.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, weatherId);
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
          __preparedStmtOfMarkAsSynced.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object markLocationAsSynced(final String locationId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkLocationAsSynced.acquire();
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
          __preparedStmtOfMarkLocationAsSynced.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteWeatherForLocation(final String locationId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteWeatherForLocation.acquire();
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
          __preparedStmtOfDeleteWeatherForLocation.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteOldWeatherData(final Date cutoffDate,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOldWeatherData.acquire();
        int _argIndex = 1;
        final Long _tmp = __dateConverter.dateToTimestamp(cutoffDate);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindLong(_argIndex, _tmp);
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
          __preparedStmtOfDeleteOldWeatherData.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getCurrentWeather(final String locationId,
      final Continuation<? super WeatherEntity> $completion) {
    final String _sql = "SELECT * FROM weather_data WHERE location_id = ? AND data_type = 'current' ORDER BY timestamp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, locationId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<WeatherEntity>() {
      @Override
      @Nullable
      public WeatherEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final int _cursorIndexOfFeelsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "feels_like");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
          final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed");
          final int _cursorIndexOfWindDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_direction");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfVisibility = CursorUtil.getColumnIndexOrThrow(_cursor, "visibility");
          final int _cursorIndexOfUvIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "uv_index");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfDataType = CursorUtil.getColumnIndexOrThrow(_cursor, "data_type");
          final int _cursorIndexOfForecastDate = CursorUtil.getColumnIndexOrThrow(_cursor, "forecast_date");
          final int _cursorIndexOfIsSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "is_synced");
          final WeatherEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final Date _tmpTimestamp;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            _tmpTimestamp = __dateConverter.fromTimestamp(_tmp);
            final double _tmpTemperature;
            _tmpTemperature = _cursor.getDouble(_cursorIndexOfTemperature);
            final double _tmpFeelsLike;
            _tmpFeelsLike = _cursor.getDouble(_cursorIndexOfFeelsLike);
            final int _tmpHumidity;
            _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
            final double _tmpPressure;
            _tmpPressure = _cursor.getDouble(_cursorIndexOfPressure);
            final double _tmpWindSpeed;
            _tmpWindSpeed = _cursor.getDouble(_cursorIndexOfWindSpeed);
            final int _tmpWindDirection;
            _tmpWindDirection = _cursor.getInt(_cursorIndexOfWindDirection);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpIcon;
            if (_cursor.isNull(_cursorIndexOfIcon)) {
              _tmpIcon = null;
            } else {
              _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
            }
            final double _tmpVisibility;
            _tmpVisibility = _cursor.getDouble(_cursorIndexOfVisibility);
            final double _tmpUvIndex;
            _tmpUvIndex = _cursor.getDouble(_cursorIndexOfUvIndex);
            final Date _tmpSunrise;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSunrise)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfSunrise);
            }
            _tmpSunrise = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpSunset;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSunset)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfSunset);
            }
            _tmpSunset = __dateConverter.fromTimestamp(_tmp_2);
            final String _tmpDataType;
            if (_cursor.isNull(_cursorIndexOfDataType)) {
              _tmpDataType = null;
            } else {
              _tmpDataType = _cursor.getString(_cursorIndexOfDataType);
            }
            final Date _tmpForecastDate;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfForecastDate)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfForecastDate);
            }
            _tmpForecastDate = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsSynced;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsSynced);
            _tmpIsSynced = _tmp_4 != 0;
            _result = new WeatherEntity(_tmpId,_tmpLocationId,_tmpTimestamp,_tmpTemperature,_tmpFeelsLike,_tmpHumidity,_tmpPressure,_tmpWindSpeed,_tmpWindDirection,_tmpDescription,_tmpIcon,_tmpVisibility,_tmpUvIndex,_tmpSunrise,_tmpSunset,_tmpDataType,_tmpForecastDate,_tmpIsSynced);
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
  public Flow<List<WeatherEntity>> getHourlyForecast(final String locationId,
      final Date startDate) {
    final String _sql = "SELECT * FROM weather_data WHERE location_id = ? AND data_type = 'hourly' AND forecast_date >= ? ORDER BY forecast_date ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, locationId);
    }
    _argIndex = 2;
    final Long _tmp = __dateConverter.dateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"weather_data"}, new Callable<List<WeatherEntity>>() {
      @Override
      @NonNull
      public List<WeatherEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final int _cursorIndexOfFeelsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "feels_like");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
          final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed");
          final int _cursorIndexOfWindDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_direction");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfVisibility = CursorUtil.getColumnIndexOrThrow(_cursor, "visibility");
          final int _cursorIndexOfUvIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "uv_index");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfDataType = CursorUtil.getColumnIndexOrThrow(_cursor, "data_type");
          final int _cursorIndexOfForecastDate = CursorUtil.getColumnIndexOrThrow(_cursor, "forecast_date");
          final int _cursorIndexOfIsSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "is_synced");
          final List<WeatherEntity> _result = new ArrayList<WeatherEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WeatherEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final Date _tmpTimestamp;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            _tmpTimestamp = __dateConverter.fromTimestamp(_tmp_1);
            final double _tmpTemperature;
            _tmpTemperature = _cursor.getDouble(_cursorIndexOfTemperature);
            final double _tmpFeelsLike;
            _tmpFeelsLike = _cursor.getDouble(_cursorIndexOfFeelsLike);
            final int _tmpHumidity;
            _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
            final double _tmpPressure;
            _tmpPressure = _cursor.getDouble(_cursorIndexOfPressure);
            final double _tmpWindSpeed;
            _tmpWindSpeed = _cursor.getDouble(_cursorIndexOfWindSpeed);
            final int _tmpWindDirection;
            _tmpWindDirection = _cursor.getInt(_cursorIndexOfWindDirection);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpIcon;
            if (_cursor.isNull(_cursorIndexOfIcon)) {
              _tmpIcon = null;
            } else {
              _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
            }
            final double _tmpVisibility;
            _tmpVisibility = _cursor.getDouble(_cursorIndexOfVisibility);
            final double _tmpUvIndex;
            _tmpUvIndex = _cursor.getDouble(_cursorIndexOfUvIndex);
            final Date _tmpSunrise;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSunrise)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfSunrise);
            }
            _tmpSunrise = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpSunset;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfSunset)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfSunset);
            }
            _tmpSunset = __dateConverter.fromTimestamp(_tmp_3);
            final String _tmpDataType;
            if (_cursor.isNull(_cursorIndexOfDataType)) {
              _tmpDataType = null;
            } else {
              _tmpDataType = _cursor.getString(_cursorIndexOfDataType);
            }
            final Date _tmpForecastDate;
            final Long _tmp_4;
            if (_cursor.isNull(_cursorIndexOfForecastDate)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getLong(_cursorIndexOfForecastDate);
            }
            _tmpForecastDate = __dateConverter.fromTimestamp(_tmp_4);
            final boolean _tmpIsSynced;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsSynced);
            _tmpIsSynced = _tmp_5 != 0;
            _item = new WeatherEntity(_tmpId,_tmpLocationId,_tmpTimestamp,_tmpTemperature,_tmpFeelsLike,_tmpHumidity,_tmpPressure,_tmpWindSpeed,_tmpWindDirection,_tmpDescription,_tmpIcon,_tmpVisibility,_tmpUvIndex,_tmpSunrise,_tmpSunset,_tmpDataType,_tmpForecastDate,_tmpIsSynced);
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
  public Flow<List<WeatherEntity>> getDailyForecast(final String locationId, final Date startDate) {
    final String _sql = "SELECT * FROM weather_data WHERE location_id = ? AND data_type = 'daily' AND forecast_date >= ? ORDER BY forecast_date ASC LIMIT 7";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, locationId);
    }
    _argIndex = 2;
    final Long _tmp = __dateConverter.dateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"weather_data"}, new Callable<List<WeatherEntity>>() {
      @Override
      @NonNull
      public List<WeatherEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final int _cursorIndexOfFeelsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "feels_like");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
          final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed");
          final int _cursorIndexOfWindDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_direction");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfVisibility = CursorUtil.getColumnIndexOrThrow(_cursor, "visibility");
          final int _cursorIndexOfUvIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "uv_index");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfDataType = CursorUtil.getColumnIndexOrThrow(_cursor, "data_type");
          final int _cursorIndexOfForecastDate = CursorUtil.getColumnIndexOrThrow(_cursor, "forecast_date");
          final int _cursorIndexOfIsSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "is_synced");
          final List<WeatherEntity> _result = new ArrayList<WeatherEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WeatherEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final Date _tmpTimestamp;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            _tmpTimestamp = __dateConverter.fromTimestamp(_tmp_1);
            final double _tmpTemperature;
            _tmpTemperature = _cursor.getDouble(_cursorIndexOfTemperature);
            final double _tmpFeelsLike;
            _tmpFeelsLike = _cursor.getDouble(_cursorIndexOfFeelsLike);
            final int _tmpHumidity;
            _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
            final double _tmpPressure;
            _tmpPressure = _cursor.getDouble(_cursorIndexOfPressure);
            final double _tmpWindSpeed;
            _tmpWindSpeed = _cursor.getDouble(_cursorIndexOfWindSpeed);
            final int _tmpWindDirection;
            _tmpWindDirection = _cursor.getInt(_cursorIndexOfWindDirection);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpIcon;
            if (_cursor.isNull(_cursorIndexOfIcon)) {
              _tmpIcon = null;
            } else {
              _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
            }
            final double _tmpVisibility;
            _tmpVisibility = _cursor.getDouble(_cursorIndexOfVisibility);
            final double _tmpUvIndex;
            _tmpUvIndex = _cursor.getDouble(_cursorIndexOfUvIndex);
            final Date _tmpSunrise;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSunrise)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfSunrise);
            }
            _tmpSunrise = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpSunset;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfSunset)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfSunset);
            }
            _tmpSunset = __dateConverter.fromTimestamp(_tmp_3);
            final String _tmpDataType;
            if (_cursor.isNull(_cursorIndexOfDataType)) {
              _tmpDataType = null;
            } else {
              _tmpDataType = _cursor.getString(_cursorIndexOfDataType);
            }
            final Date _tmpForecastDate;
            final Long _tmp_4;
            if (_cursor.isNull(_cursorIndexOfForecastDate)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getLong(_cursorIndexOfForecastDate);
            }
            _tmpForecastDate = __dateConverter.fromTimestamp(_tmp_4);
            final boolean _tmpIsSynced;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsSynced);
            _tmpIsSynced = _tmp_5 != 0;
            _item = new WeatherEntity(_tmpId,_tmpLocationId,_tmpTimestamp,_tmpTemperature,_tmpFeelsLike,_tmpHumidity,_tmpPressure,_tmpWindSpeed,_tmpWindDirection,_tmpDescription,_tmpIcon,_tmpVisibility,_tmpUvIndex,_tmpSunrise,_tmpSunset,_tmpDataType,_tmpForecastDate,_tmpIsSynced);
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
  public Flow<List<WeatherEntity>> getAllWeatherForLocation(final String locationId) {
    final String _sql = "SELECT * FROM weather_data WHERE location_id = ? ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, locationId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"weather_data"}, new Callable<List<WeatherEntity>>() {
      @Override
      @NonNull
      public List<WeatherEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final int _cursorIndexOfFeelsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "feels_like");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
          final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed");
          final int _cursorIndexOfWindDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_direction");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfVisibility = CursorUtil.getColumnIndexOrThrow(_cursor, "visibility");
          final int _cursorIndexOfUvIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "uv_index");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfDataType = CursorUtil.getColumnIndexOrThrow(_cursor, "data_type");
          final int _cursorIndexOfForecastDate = CursorUtil.getColumnIndexOrThrow(_cursor, "forecast_date");
          final int _cursorIndexOfIsSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "is_synced");
          final List<WeatherEntity> _result = new ArrayList<WeatherEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WeatherEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final Date _tmpTimestamp;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            _tmpTimestamp = __dateConverter.fromTimestamp(_tmp);
            final double _tmpTemperature;
            _tmpTemperature = _cursor.getDouble(_cursorIndexOfTemperature);
            final double _tmpFeelsLike;
            _tmpFeelsLike = _cursor.getDouble(_cursorIndexOfFeelsLike);
            final int _tmpHumidity;
            _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
            final double _tmpPressure;
            _tmpPressure = _cursor.getDouble(_cursorIndexOfPressure);
            final double _tmpWindSpeed;
            _tmpWindSpeed = _cursor.getDouble(_cursorIndexOfWindSpeed);
            final int _tmpWindDirection;
            _tmpWindDirection = _cursor.getInt(_cursorIndexOfWindDirection);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpIcon;
            if (_cursor.isNull(_cursorIndexOfIcon)) {
              _tmpIcon = null;
            } else {
              _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
            }
            final double _tmpVisibility;
            _tmpVisibility = _cursor.getDouble(_cursorIndexOfVisibility);
            final double _tmpUvIndex;
            _tmpUvIndex = _cursor.getDouble(_cursorIndexOfUvIndex);
            final Date _tmpSunrise;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSunrise)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfSunrise);
            }
            _tmpSunrise = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpSunset;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSunset)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfSunset);
            }
            _tmpSunset = __dateConverter.fromTimestamp(_tmp_2);
            final String _tmpDataType;
            if (_cursor.isNull(_cursorIndexOfDataType)) {
              _tmpDataType = null;
            } else {
              _tmpDataType = _cursor.getString(_cursorIndexOfDataType);
            }
            final Date _tmpForecastDate;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfForecastDate)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfForecastDate);
            }
            _tmpForecastDate = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsSynced;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsSynced);
            _tmpIsSynced = _tmp_4 != 0;
            _item = new WeatherEntity(_tmpId,_tmpLocationId,_tmpTimestamp,_tmpTemperature,_tmpFeelsLike,_tmpHumidity,_tmpPressure,_tmpWindSpeed,_tmpWindDirection,_tmpDescription,_tmpIcon,_tmpVisibility,_tmpUvIndex,_tmpSunrise,_tmpSunset,_tmpDataType,_tmpForecastDate,_tmpIsSynced);
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
  public Object getUnsyncedWeather(final Continuation<? super List<WeatherEntity>> $completion) {
    final String _sql = "SELECT * FROM weather_data WHERE is_synced = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<WeatherEntity>>() {
      @Override
      @NonNull
      public List<WeatherEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final int _cursorIndexOfFeelsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "feels_like");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
          final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed");
          final int _cursorIndexOfWindDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_direction");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfVisibility = CursorUtil.getColumnIndexOrThrow(_cursor, "visibility");
          final int _cursorIndexOfUvIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "uv_index");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfDataType = CursorUtil.getColumnIndexOrThrow(_cursor, "data_type");
          final int _cursorIndexOfForecastDate = CursorUtil.getColumnIndexOrThrow(_cursor, "forecast_date");
          final int _cursorIndexOfIsSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "is_synced");
          final List<WeatherEntity> _result = new ArrayList<WeatherEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WeatherEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
            }
            final Date _tmpTimestamp;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            _tmpTimestamp = __dateConverter.fromTimestamp(_tmp);
            final double _tmpTemperature;
            _tmpTemperature = _cursor.getDouble(_cursorIndexOfTemperature);
            final double _tmpFeelsLike;
            _tmpFeelsLike = _cursor.getDouble(_cursorIndexOfFeelsLike);
            final int _tmpHumidity;
            _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
            final double _tmpPressure;
            _tmpPressure = _cursor.getDouble(_cursorIndexOfPressure);
            final double _tmpWindSpeed;
            _tmpWindSpeed = _cursor.getDouble(_cursorIndexOfWindSpeed);
            final int _tmpWindDirection;
            _tmpWindDirection = _cursor.getInt(_cursorIndexOfWindDirection);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpIcon;
            if (_cursor.isNull(_cursorIndexOfIcon)) {
              _tmpIcon = null;
            } else {
              _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
            }
            final double _tmpVisibility;
            _tmpVisibility = _cursor.getDouble(_cursorIndexOfVisibility);
            final double _tmpUvIndex;
            _tmpUvIndex = _cursor.getDouble(_cursorIndexOfUvIndex);
            final Date _tmpSunrise;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSunrise)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfSunrise);
            }
            _tmpSunrise = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpSunset;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSunset)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfSunset);
            }
            _tmpSunset = __dateConverter.fromTimestamp(_tmp_2);
            final String _tmpDataType;
            if (_cursor.isNull(_cursorIndexOfDataType)) {
              _tmpDataType = null;
            } else {
              _tmpDataType = _cursor.getString(_cursorIndexOfDataType);
            }
            final Date _tmpForecastDate;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfForecastDate)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfForecastDate);
            }
            _tmpForecastDate = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsSynced;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsSynced);
            _tmpIsSynced = _tmp_4 != 0;
            _item = new WeatherEntity(_tmpId,_tmpLocationId,_tmpTimestamp,_tmpTemperature,_tmpFeelsLike,_tmpHumidity,_tmpPressure,_tmpWindSpeed,_tmpWindDirection,_tmpDescription,_tmpIcon,_tmpVisibility,_tmpUvIndex,_tmpSunrise,_tmpSunset,_tmpDataType,_tmpForecastDate,_tmpIsSynced);
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
  public Object getWeatherCountForLocation(final String locationId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM weather_data WHERE location_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, locationId);
    }
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
  public Object getLastUpdateTime(final String locationId,
      final Continuation<? super Date> $completion) {
    final String _sql = "SELECT MAX(timestamp) FROM weather_data WHERE location_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, locationId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Date>() {
      @Override
      @Nullable
      public Date call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Date _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = __dateConverter.fromTimestamp(_tmp);
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
  public Object getAllLocationIds(final Continuation<? super List<String>> $completion) {
    final String _sql = "SELECT DISTINCT location_id FROM weather_data";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<String>>() {
      @Override
      @NonNull
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
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
