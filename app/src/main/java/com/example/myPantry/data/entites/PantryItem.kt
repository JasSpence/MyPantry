package com.example.myPantry.data.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO: Consider supporting full-text search through FTS3 or FTS4 (see https://developer.android.com/training/data-storage/room/defining-data)

@Entity(tableName = "pantry_item")
data class PantryItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
)