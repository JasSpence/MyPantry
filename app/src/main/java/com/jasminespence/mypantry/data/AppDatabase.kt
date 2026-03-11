package com.jasminespence.mypantry.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jasminespence.mypantry.data.entites.PantryItem
import com.jasminespence.mypantry.data.entites.PantryItemInstance
import com.jasminespence.mypantry.data.entites.RecipeItem
import kotlin.concurrent.Volatile

@Database(
    version = 3,
    entities = [
        PantryItem::class,
        PantryItemInstance::class,
        RecipeItem::class],
    exportSchema = false
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
                    )
                        .fallbackToDestructiveMigration(false)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}