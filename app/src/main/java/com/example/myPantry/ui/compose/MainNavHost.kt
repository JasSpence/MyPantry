package com.example.myPantry.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myPantry.MainViewModel

@Composable
fun MainNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val pantryItemsWithInstances by viewModel.pantryItemsWithInstances.collectAsStateWithLifecycle()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route=Screen.Home.route) {
            HomeScreen()
        }
        composable(route=Screen.Pantry.route) {
            PantryScreen(pantryItemsWithInstances)
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
    }
}