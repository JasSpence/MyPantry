package com.example.myPantry.ui.compose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.myPantry.R

sealed class Screen(
    val route: String,
    @param:StringRes val labelId: Int,
    @param:DrawableRes val unselectedIcon: Int = R.drawable.unselected_error_icon,
    @param:DrawableRes val selectedIcon: Int = R.drawable.selected_error_icon
) {
    data object Home: Screen("home", R.string.home_label, R.drawable.unselected_home_icon, R.drawable.selected_home_icon)
    data object Pantry: Screen("pantry", R.string.pantry_label, R.drawable.unselected_pantry_icon, R.drawable.selected_pantry_icon)
    data object Recipes: Screen("recipes", R.string.recipes_label, R.drawable.unselected_recipes_icon, R.drawable.selected_recipes_icon)
    data object ShoppingList : Screen("shopping_list", R.string.shopping_list_label, R.drawable.unselected_shopping_list_icon, R.drawable.selected_shopping_list_icon)
}

val navBarScreens = listOf(Screen.Home, Screen.Pantry, Screen.Recipes, Screen.ShoppingList)