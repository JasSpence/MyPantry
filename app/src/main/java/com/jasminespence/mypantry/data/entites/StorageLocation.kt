package com.jasminespence.mypantry.data.entites

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "storage_location")
data class StorageLocation(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val colour: Color
)