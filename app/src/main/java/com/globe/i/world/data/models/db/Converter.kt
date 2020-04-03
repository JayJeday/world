package com.globe.i.world.data.models.db

import androidx.room.TypeConverter
import java.util.*

/*
   Converter for the type Date, used when persisting a Match object.
   The latter will convert the Date type to a primitive Long (the timestamp)
 */
    class Converter {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}