package com.example.myPantry.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.myPantry.data.entites.PantryItem
import com.example.myPantry.data.entites.PantryItemInstance
import com.example.myPantry.data.entites.relationships.PantryItemWithInstances
import kotlinx.coroutines.flow.Flow

@Dao
interface PantryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPantryItems(vararg items: PantryItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPantryItemInstances(vararg items: PantryItemInstance)

    @Transaction
    @Query("SELECT * FROM pantry_item")
    fun getAllPantryItemsWithInstances(): Flow<List<PantryItemWithInstances>>

    @Transaction
    @Query("SELECT * FROM pantry_item WHERE id = :pantryItemId")
    fun getPantryItemWithPantryItemInstances(pantryItemId: Int): Flow<List<PantryItemWithInstances>>


}