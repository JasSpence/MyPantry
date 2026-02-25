package com.example.myPantry.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PantryItem::class], version = 1)
abstract class PantryDatabase : RoomDatabase() {
    abstract fun pantryDao() : PantryDao
}