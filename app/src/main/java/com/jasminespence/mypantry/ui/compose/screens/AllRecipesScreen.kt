package com.jasminespence.mypantry.ui.compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.MyPantryThemePreview
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.ui.compose.components.ActionButton
import com.jasminespence.mypantry.ui.compose.components.DataItemGrid
import com.jasminespence.mypantry.ui.compose.components.DataItemRow
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun AllRecipesScreen(
    isGridSelected: Boolean,
    changeView: (Boolean) -> Unit,
    onRecipeBoxClick: () -> Unit,
    onAddBoxClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(Dimensions.BIG_BORDER.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.DIFF_BOX_PADDING.dp)
        ) {
            RecipesTopMenu(
                isGridSelected = isGridSelected,
                changeView = changeView
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .weight(1f),
                columns = if (isGridSelected) GridCells.Fixed(2) else GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(Dimensions.DIFF_BOX_PADDING.dp),
                horizontalArrangement = Arrangement.spacedBy(Dimensions.DIFF_BOX_PADDING.dp),
            ) {
                items(8) {
                    if (isGridSelected) {
                        RecipeGridBoxPlaceholder(
                            hasIngredients = listOf(true, false).random(),
                            onRecipeBoxClick = onRecipeBoxClick
                        )
                    } else {
                        RecipeRowBoxPlaceholder(
                            hasIngredients = listOf(true, false).random(),
                            onRecipeBoxClick = onRecipeBoxClick
                        )
                    }
                }
                item(span = { GridItemSpan(maxLineSpan) }) {
                    // Adds empty space for save button
                    Spacer(modifier = Modifier.height(Dimensions.ACTION_BUTTON_DIMS.dp))
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            ActionButton(
                iconId = R.drawable.add_icon,
                action = "add recipe",
                onBoxClick = onAddBoxClicked
            )
        }
    }
}

@Composable
fun RecipesTopMenu(
    modifier: Modifier = Modifier,
    isGridSelected: Boolean,
    changeView: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.TOP_MENU_HEIGHT.dp),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.GROUPED_BOX_PADDING.dp, Alignment.End),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { changeView(true) },
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
        ) {
            Icon(
                painter = if (isGridSelected) {
                    painterResource(R.drawable.selected_grid_view_icon)
                } else {
                    painterResource(R.drawable.unselected_grid_view_icon)
                },
                contentDescription = "grid view",
                modifier = Modifier.fillMaxSize(),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        IconButton(
            onClick = { changeView(false) },
            modifier = Modifier.fillMaxHeight()
        ) {
            Icon(
                painter = if (isGridSelected) {
                    painterResource(R.drawable.unselected_row_view_icon)
                } else {
                    painterResource(R.drawable.selected_row_view_icon)
                },
                contentDescription = "row view",
                modifier = Modifier.fillMaxSize(),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun RecipeGridBoxPlaceholder(
    hasIngredients: Boolean,
    onRecipeBoxClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    DataItemGrid(
        modifier = modifier,
        title = "Recipe Name",
        hasTick = hasIngredients,
        onClick = onRecipeBoxClick,
        bottomLeftText = "Time",
        bottomLeftIcon = R.drawable.timer_icon,
        bottomLeftIconDescription = "recipe duration"
    )
}

@Composable
fun RecipeRowBoxPlaceholder(
    hasIngredients: Boolean,
    onRecipeBoxClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    DataItemRow(
        modifier = modifier,
        title = "Recipe Name",
        hasTick = hasIngredients,
        onClick = onRecipeBoxClick,
        bottomLeftText = "Time",
        bottomLeftIcon = R.drawable.timer_icon,
        bottomLeftIconDescription = "recipe duration"
    )
}

@Preview(showBackground = true)
@Composable
fun AllRecipesScreenPreview() {
    MyPantryThemePreview() {
        AllRecipesScreen(
            isGridSelected = true,
            changeView = {},
            onRecipeBoxClick = {},
            onAddBoxClicked = {}
        )
    }
}