package com.jasminespence.mypantry.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jasminespence.mypantry.MainViewModel

@Composable
fun MainNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val pantryItemsWithInstances by viewModel.pantryItemsWithInstances.collectAsStateWithLifecycle()
    val pantryItemQuantities by viewModel.pantryItemQuantities.collectAsStateWithLifecycle()
    val pantryGridSelected by viewModel.pantryGridViewSelected.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route=Screen.Home.route) {
            HomeScreen()
        }
        composable(route=Screen.Pantry.route) {
            PantryScreen(
                pantryItemsWithInstances = pantryItemsWithInstances,
                pantryItemQuantities = pantryItemQuantities,
                gridSelected = pantryGridSelected,
                changeView = { viewModel.setPantryView(it) },
                onAddItemClick = { navController.navigate(Screen.AddItem.route) }
            )
        }
        composable(route=Screen.Recipes.route) {
            RecipesScreen()
        }
        composable(route=Screen.ShoppingList.route) {
            ShoppingListScreen()
        }
        composable(route=Screen.Profile.route) {
            ProfileScreen()
        }
        composable(route=Screen.AddItem.route) {
            AddItemScreen()
        }
    }
}