package com.jasminespence.mypantry.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jasminespence.mypantry.MainViewModel
import com.jasminespence.mypantry.ui.compose.screens.AddItemInstanceScreen
import com.jasminespence.mypantry.ui.compose.screens.AddItemScreen
import com.jasminespence.mypantry.ui.compose.screens.AddRecipeScreen
import com.jasminespence.mypantry.ui.compose.screens.AllItemInstancesScreen
import com.jasminespence.mypantry.ui.compose.screens.AllRecipesScreen
import com.jasminespence.mypantry.ui.compose.screens.DeleteItemInstanceScreen
import com.jasminespence.mypantry.ui.compose.screens.HomeScreen
import com.jasminespence.mypantry.ui.compose.screens.PantryScreen
import com.jasminespence.mypantry.ui.compose.screens.ProfileScreen
import com.jasminespence.mypantry.ui.compose.screens.RecipeScreen
import com.jasminespence.mypantry.ui.compose.screens.ShoppingListScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val pantryItemsWithInstances by viewModel.pantryItemsWithInstances.collectAsStateWithLifecycle()
    val pantryItemQuantities by viewModel.pantryItemQuantities.collectAsStateWithLifecycle()
    val swipedRow by viewModel.allItemInstancesScreenSwipedRow.collectAsStateWithLifecycle()
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
                onAddItemClick = { navController.navigate(Screen.AddItem.route) },
                onAddNewInstancesClick = { navController.navigate(Screen.AddItemInstance.route) },
                onViewInstancesClick = { navController.navigate(Screen.AllItemInstances.route) },
                onDeleteInstanceClick = { navController.navigate(Screen.DeleteItemInstance.route) }
            )
        }
        composable(route=Screen.AllRecipes.route) {
            AllRecipesScreen(
                isGridSelected = isRecipesGridSelected,
                changeView = { viewModel.setRecipesView(it) },
                onRecipeBoxClick = { navController.navigate(Screen.Recipe.route) },
                onAddBoxClicked = { navController.navigate(Screen.AddRecipe.route) }
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
        composable(route=Screen.AddItemInstance.route) {
            AddItemInstanceScreen()
        }
        composable(route=Screen.AllItemInstances.route) {
            AllItemInstancesScreen(
                swipedRow = swipedRow,
                setSwipedRow = { viewModel.setAllItemInstancesScreenSwipedRow(it) }
            )
        }
        composable(route=Screen.DeleteItemInstance.route) {
            DeleteItemInstanceScreen()
        }
    }
}