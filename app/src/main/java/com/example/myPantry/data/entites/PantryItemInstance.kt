package com.example.myPantry.data.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.time.Instant

@Entity(tableName = "pantry_item_instance")
data class PantryItemInstance(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "pantry_item") val pantryItem: Int,
    @ColumnInfo(name = "expiry_date") val expiryDate: Instant? = null
)