package com.jasminespence.mypantry.data.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.data.dataTypes.ItemCategory

// TODO: Consider supporting full-text search through FTS3 or FTS4 (see https://developer.android.com/training/data-storage/room/defining-data)
// TODO: Add brands

@Entity(tableName = "pantry_item")
data class PantryItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val image: Int = R.drawable.unselected_error_icon,
    val category: ItemCategory = ItemCategory.OTHER,
    @ColumnInfo(name = "storage_location") val storageLocation: Int,
    @ColumnInfo(name = "min_stock") val minStock: Int? = null
)