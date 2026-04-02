package com.jasminespence.mypantry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jasminespence.mypantry.data.PantryRepo
import com.jasminespence.mypantry.data.entites.relationships.PantryItemWithInstances
import com.jasminespence.mypantry.ui.theme.Contrast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    pantryRepo: PantryRepo
) : ViewModel() {

    private val _isDarkMode = MutableStateFlow<Boolean?>(null)
    val isDarkMode: StateFlow<Boolean?> = _isDarkMode

    fun setIsDarkMode (isDarkMode: Boolean?) {
        _isDarkMode.value = isDarkMode
    }

    private val _contrast = MutableStateFlow<Contrast?>(null)
    val contrast: StateFlow<Contrast?> = _contrast

    fun setContrast (contrast: Contrast?) {
        _contrast.value = contrast
    }

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

    private val _allItemInstancesScreenSwipedRow = MutableStateFlow<Int?>(null)
    val allItemInstancesScreenSwipedRow: StateFlow<Int?> = _allItemInstancesScreenSwipedRow

    fun setAllItemInstancesScreenSwipedRow (rowId: Int?) {
        _allItemInstancesScreenSwipedRow.value = rowId
    }

    private val _isPantryGridViewSelected = MutableStateFlow(true)
    val isPantryGridViewSelected: StateFlow<Boolean> = _isPantryGridViewSelected

    fun setPantryView (isGrid: Boolean) {
        _isPantryGridViewSelected.value = isGrid
    }

    private val _pantryItemSelected: MutableStateFlow<Int?> = MutableStateFlow(null)
    val pantryItemSelected: StateFlow<Int?> = _pantryItemSelected

    fun setSelectedPantryItem (selectedItem: Int?) {
        _pantryItemSelected.value = selectedItem
    }

    private val _isRecipesGridViewSelected = MutableStateFlow(true)
    val isRecipesGridViewSelected: StateFlow<Boolean> = _isRecipesGridViewSelected

    fun setRecipesView (isGrid: Boolean) {
        _isRecipesGridViewSelected.value = isGrid
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