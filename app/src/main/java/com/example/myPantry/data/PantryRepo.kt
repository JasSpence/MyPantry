package com.example.myPantry.data

import android.content.Context
import kotlinx.coroutines.flow.Flow

class PantryRepo(private val context: Context) {
    private val dao = AppDatabase.getDatabase(context).pantryDao()
    val pantryItems: Flow<List<PantryItem>> = dao.getAll()
}