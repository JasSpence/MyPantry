package com.jasminespence.mypantry.ui.compose

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R
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
            .padding(Dimensions.MAIN_PADDING.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.MAIN_PADDING.dp)
        ) {
            RecipesTopMenu(
                isGridSelected = isGridSelected,
                changeView = changeView
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .weight(1f),
                columns = if (isGridSelected) GridCells.Fixed(2) else GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(Dimensions.MAIN_PADDING.dp),
                horizontalArrangement = Arrangement.spacedBy(Dimensions.MAIN_PADDING.dp),
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
        horizontalArrangement = Arrangement.spacedBy(Dimensions.MAIN_PADDING.dp, Alignment.End),
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
    PhotoWithColComposableCard(
        photo = "-",
        onClick = onRecipeBoxClick,
        modifier = modifier
            .height(Dimensions.BASE_GRID_VIEW_HEIGHT.dp),
        composable = {
            Text(
                text = "Recipe Name",
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.SUB_PADDING.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.timer_icon),
                        contentDescription = "recipe time",
                        tint = MaterialTheme.colorScheme.onTertiary
                    )
                    Text(
                        text = "Time",
                        color = MaterialTheme.colorScheme.onTertiary,
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center
                    )
                }
                if (hasIngredients) {
                    Icon(
                        painter = painterResource(R.drawable.tick_icon),
                        contentDescription = "you have all ingredients",
                        tint = Color.Green
                    )
                } else {
                    Icon(
                        painter = painterResource(R.drawable.cross_icon),
                        contentDescription = "you do not have all ingredients",
                        tint = Color.Red
                    )
                }
            }
        }
    )
}

@Composable
fun RecipeRowBoxPlaceholder(
    hasIngredients: Boolean,
    onRecipeBoxClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    PhotoWithRowComposableCard(
        photo = "-",
        onClick = onRecipeBoxClick,
        modifier = modifier
            .height(Dimensions.BASE_ROW_VIEW_HEIGHT.dp),
        composable = {
            Text(
                text = "Recipe Name",
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        Dimensions.SUB_PADDING.dp,
                        Alignment.End
                    )
                ) {
                    Text(
                        text = "Time",
                        color = MaterialTheme.colorScheme.onTertiary,
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        painter = painterResource(R.drawable.timer_icon),
                        contentDescription = "recipe time",
                        tint = MaterialTheme.colorScheme.onTertiary
                    )
                }
                if (hasIngredients) {
                    Icon(
                        painter = painterResource(R.drawable.tick_icon),
                        contentDescription = "you have all ingredients",
                        tint = Color.Green
                    )
                } else {
                    Icon(
                        painter = painterResource(R.drawable.cross_icon),
                        contentDescription = "you do not have all ingredients",
                        tint = Color.Red
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AllRecipesScreenPreview() {
    AllRecipesScreen(
        isGridSelected = false,
        changeView = {},
        onRecipeBoxClick = {},
        onAddBoxClicked = {}
    )
}