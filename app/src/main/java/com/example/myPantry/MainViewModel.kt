package com.example.myPantry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myPantry.data.PantryItem
import com.example.myPantry.data.PantryRepo
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    pantryRepo: PantryRepo
) : ViewModel() {

    val pantryItems: StateFlow<List<PantryItem>> = pantryRepo.pantryItems
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

}

class MainViewModelFactory(
    private val pantryRepo: PantryRepo
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(pantryRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}