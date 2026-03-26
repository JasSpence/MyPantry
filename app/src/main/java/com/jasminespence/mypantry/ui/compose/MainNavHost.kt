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
    val isPantryGridSelected by viewModel.isPantryGridViewSelected.collectAsStateWithLifecycle()
    val selectedPantryItem by viewModel.pantryItemSelected.collectAsStateWithLifecycle()
    val isRecipesGridSelected by viewModel.isRecipesGridViewSelected.collectAsStateWithLifecycle()

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
                isGridSelected = isPantryGridSelected,
                changeView = { viewModel.setPantryView(it) },
                selectedPantryItem = selectedPantryItem,
                onPantryItemClick = { viewModel.setSelectedPantryItem(it) },
                onAddItemClick = { navController.navigate(Screen.AddItem.route) }
            )
        }
        composable(route=Screen.AllRecipes.route) {
            AllRecipesScreen(
                isGridSelected = isRecipesGridSelected,
                changeView = { viewModel.setRecipesView(it) },
                onRecipeBoxClick = { navController.navigate(Screen.Recipe.route)},
                onAddBoxClicked = { navController.navigate(Screen.AddRecipe.route )}
            )
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
        composable(route=Screen.AddRecipe.route) {
            AddRecipeScreen()
        }
        composable(route=Screen.Recipe.route) {
            RecipeScreen()
        }
    }
}