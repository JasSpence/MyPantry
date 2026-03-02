package com.example.myPantry.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes")
    fun getAll(): Flow<List<RecipeItem>>

    @Insert
    fun insertAll(vararg items: RecipeItem)
}