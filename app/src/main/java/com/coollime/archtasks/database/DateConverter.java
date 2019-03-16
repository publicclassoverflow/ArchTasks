package com.coollime.archtasks.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    /**
     * This method converts a timestamp into a date
     * Room wil use it when reading from the database
     */
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    /**
     * This method converts a date into a timestamp
     * Room will use it when writing into the database
     */
    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
