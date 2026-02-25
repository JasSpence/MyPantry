package com.example.myPantry.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PantryDao {
    @Query("SELECT * FROM pantry")
    fun getAll(): List<PantryItem>

    @Insert
    fun insertAll(vararg items: PantryItem)
}