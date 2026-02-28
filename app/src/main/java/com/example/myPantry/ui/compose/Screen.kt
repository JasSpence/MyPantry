package com.example.myPantry.ui.compose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myPantry.R

sealed class Screen(
    val route: String,
    @StringRes val labelId: Int,
    @DrawableRes val icon: Int = R.drawable.error_40px
) {
    data object Home: Screen("home", R.string.home_label, R.drawable.home_40px)
    data object Pantry: Screen("pantry", R.string.pantry_label)
    data object Recipes: Screen("recipes", R.string.recipes_label)
    data object ShoppingList : Screen("shopping_list", R.string.shopping_list_label)
}

val navBarScreens = listOf(Screen.Home, Screen.Pantry, Screen.Recipes, Screen.ShoppingList)