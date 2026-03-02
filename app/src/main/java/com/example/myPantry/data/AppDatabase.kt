package com.example.myPantry.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myPantry.data.entites.PantryItem
import com.example.myPantry.data.entites.PantryItemInstance
import com.example.myPantry.data.entites.RecipeItem
import kotlin.concurrent.Volatile

@Database(
    entities = [
        PantryItem::class,
        PantryItemInstance::class,
        RecipeItem::class],
    version = 1
)
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