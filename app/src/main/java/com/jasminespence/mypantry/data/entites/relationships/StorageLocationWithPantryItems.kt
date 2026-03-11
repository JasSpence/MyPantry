package com.jasminespence.mypantry.data.entites.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.jasminespence.mypantry.data.entites.PantryItem
import com.jasminespence.mypantry.data.entites.StorageLocation

data class StorageLocationWithPantryItems (
    @Embedded val storageLocation: StorageLocation,
    @Relation(
        parentColumn = "id",
        entityColumn = "pantry_item"
    )
    val items: List<PantryItem>
)