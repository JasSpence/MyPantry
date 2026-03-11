package com.jasminespence.mypantry.data

import androidx.room.TypeConverter
import com.jasminespence.mypantry.data.dataTypes.ItemCategory
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

    @TypeConverter
    fun toItemCategory(value: Int): ItemCategory = enumValues<ItemCategory>()[value]

    @TypeConverter
    fun fromItemCategory(value: ItemCategory): Int = value.ordinal
}