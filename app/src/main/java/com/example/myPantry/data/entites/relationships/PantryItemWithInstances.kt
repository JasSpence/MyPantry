package com.example.myPantry.data.entites.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.example.myPantry.data.entites.PantryItem
import com.example.myPantry.data.entites.PantryItemInstance

data class PantryItemWithInstances(
    @Embedded val pantryItem: PantryItem,
    @Relation(
        parentColumn = "id",
        entityColumn = "pantry_item"
    )
    val instances: List<PantryItemInstance>
)