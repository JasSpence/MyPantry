package com.jasminespence.mypantry.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.jasminespence.mypantry.data.dataTypes.PantryItemQuantity
import com.jasminespence.mypantry.data.entites.PantryItem
import com.jasminespence.mypantry.data.entites.PantryItemInstance
import com.jasminespence.mypantry.data.entites.relationships.PantryItemWithInstances
import kotlinx.coroutines.flow.Flow

@Dao
interface PantryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPantryItems(vararg items: PantryItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPantryItemInstances(vararg items: PantryItemInstance)

    @Transaction
    @Query("SELECT * FROM pantry_item")
    fun getAllPantryItemsWithInstances(): Flow<List<PantryItemWithInstances>>

    @Transaction
    @Query("SELECT * FROM pantry_item WHERE id = :pantryItemId")
    fun getPantryItemWithPantryItemInstances(pantryItemId: Int): Flow<List<PantryItemWithInstances>>

    @Query("SELECT COUNT(*) FROM pantry_item_instance WHERE pantry_item = :pantryItemId")
    fun getPantryItemQuantity(pantryItemId: Int): Flow<Int>

    @Query("SELECT pantry_item, COUNT(*) as item_count FROM pantry_item_instance GROUP BY pantry_item")
    fun getAllPantryItemQuantities(): Flow<List<PantryItemQuantity>>
}