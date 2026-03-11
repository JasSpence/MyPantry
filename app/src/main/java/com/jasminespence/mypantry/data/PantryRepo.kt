package com.jasminespence.mypantry.data

import android.content.Context
import com.jasminespence.mypantry.data.dataTypes.PantryItemQuantity
import com.jasminespence.mypantry.data.entites.relationships.PantryItemWithInstances
import kotlinx.coroutines.flow.Flow

class PantryRepo(context: Context) {
    private val dao = AppDatabase.getDatabase(context).pantryDao()
    val pantryItemsWithInstances: Flow<List<PantryItemWithInstances>> = dao.getAllPantryItemsWithInstances()
    val pantryItemQuantities: Flow<List<PantryItemQuantity>> = dao.getAllPantryItemQuantities()
}