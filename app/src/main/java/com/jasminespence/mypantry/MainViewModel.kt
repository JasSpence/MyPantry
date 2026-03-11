package com.jasminespence.mypantry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jasminespence.mypantry.data.PantryRepo
import com.jasminespence.mypantry.data.entites.relationships.PantryItemWithInstances
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    pantryRepo: PantryRepo
) : ViewModel() {

    val pantryItemsWithInstances: StateFlow<List<PantryItemWithInstances>> = pantryRepo.pantryItemsWithInstances
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    val pantryItemQuantities: StateFlow<Map<Int, Int>> = pantryRepo.pantryItemQuantities
        .map { list -> list.associate { it.pantryItemId to it.itemCount } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyMap()
        )

    private val _pantryGridViewSelected = MutableStateFlow(true)
    val pantryGridViewSelected: StateFlow<Boolean> = _pantryGridViewSelected

    fun setPantryView (isGrid: Boolean) {
        _pantryGridViewSelected.value = isGrid
    }
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