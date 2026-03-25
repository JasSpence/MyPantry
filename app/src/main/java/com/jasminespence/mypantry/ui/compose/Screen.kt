package com.jasminespence.mypantry.ui.compose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jasminespence.mypantry.R

sealed class Screen(
    val route: String,
    @param:StringRes val labelId: Int,
    @param:DrawableRes val unselectedIcon: Int = R.drawable.unselected_error_icon,
    @param:DrawableRes val selectedIcon: Int = R.drawable.selected_error_icon,
) {
    data object Home: Screen("home", R.string.home_label, R.drawable.unselected_home_icon, R.drawable.selected_home_icon)
    data object Pantry: Screen("pantry", R.string.pantry_label, R.drawable.unselected_pantry_icon, R.drawable.selected_pantry_icon)
    data object AllRecipes: Screen("all_recipes", R.string.all_recipes_label, R.drawable.unselected_recipes_icon, R.drawable.selected_recipes_icon)
    data object ShoppingList : Screen("shopping_list", R.string.shopping_list_label, R.drawable.unselected_shopping_list_icon, R.drawable.selected_shopping_list_icon)
    data object Profile: Screen("profile", R.string.profile_label, R.drawable.profile_icon)
    data object AddItem: Screen("add_item", R.string.add_item_label)
    data object AddRecipe: Screen("add_recipe", R.string.add_recipe_label)
    data object Recipe: Screen("recipe", R.string.recipe_label)
}

val navBarScreens = listOf(Screen.Home, Screen.Pantry, Screen.AllRecipes, Screen.ShoppingList)
val allScreens = listOf(
    Screen.Home,
    Screen.Pantry,
    Screen.AllRecipes,
    Screen.ShoppingList,
    Screen.Profile,
    Screen.AddItem,
    Screen.AddRecipe,
    Screen.Recipe
)
