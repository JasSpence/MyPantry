package com.example.myPantry.data

import androidx.room.TypeConverter
import kotlin.time.Instant

class Converters {
    @TypeConverter
    fun fromStringList(value: List<String>): String =
        value.joinToString("||")

    @TypeConverter
    fun toStringList(value: String): List<String> =
        if (value.isEmpty()) emptyList() else value.split("||")

    @TypeConverter
    fun fromInstant(value: Instant?): Long? {
        return value?.toEpochMilliseconds()
    }

    @TypeConverter
    fun toInstant(value: Long?): Instant? {
        return value?.let { Instant.fromEpochMilliseconds(it) }
    }
}