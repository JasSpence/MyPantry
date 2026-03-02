package com.example.myPantry.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO: Consider supporting full-text search through FTS3 or FTS4 (see https://developer.android.com/training/data-storage/room/defining-data)

@Entity(tableName = "recipes")
data class RecipeItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val ingredients: List<String>,
    val steps: List<String>
)