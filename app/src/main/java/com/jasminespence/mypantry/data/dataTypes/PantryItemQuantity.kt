package com.jasminespence.mypantry.data.dataTypes

import androidx.room.ColumnInfo

data class PantryItemQuantity(
    @ColumnInfo(name = "pantry_item") val pantryItemId: Int,
    @ColumnInfo(name = "item_count") val itemCount: Int
)