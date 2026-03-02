package com.example.myPantry.data

import android.content.Context
import androidx.compose.ui.res.stringResource
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myPantry.R
import kotlin.concurrent.Volatile

@Database(entities = [PantryItem::class, RecipeItem::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pantryDao() : PantryDao
    abstract fun recipeDao() : RecipeDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context = context,
                        klass = AppDatabase::class.java,
                        name = "my-pantry.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}