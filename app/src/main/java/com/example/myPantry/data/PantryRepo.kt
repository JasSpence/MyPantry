package com.example.myPantry.data

import android.content.Context
import com.example.myPantry.data.entites.relationships.PantryItemWithInstances
import kotlinx.coroutines.flow.Flow

class PantryRepo(context: Context) {
    private val dao = AppDatabase.getDatabase(context).pantryDao()
    val pantryItemsWithInstances: Flow<List<PantryItemWithInstances>> = dao.getAllPantryItemsWithInstances()
}