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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R

@Composable
fun AllRecipesScreen(
    gridSelected: Boolean,
    changeView: (Boolean) -> Unit,
    onRecipeBoxClick: () -> Unit,
    onAddBoxClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            RecipesTopMenu(
                gridSelected = gridSelected,
                changeView = changeView
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .weight(1f),
                columns = if (gridSelected) GridCells.Fixed(2) else GridCells.Fixed(1)
            ) {
                items(8) {
                    if (gridSelected) {
                        RecipeGridBoxPlaceholder(
                            onRecipeBoxClick
                        )
                    } else {
                        RecipeRowBoxPlaceholder(
                            onRecipeBoxClick
                        )
                    }
                }
                item(span = { GridItemSpan(maxLineSpan) }) {
                    // Adds empty space for save button
                    Spacer(modifier = Modifier.height(60.dp))
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            ActionBox(
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
    gridSelected: Boolean,
    changeView: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(30.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.End),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { changeView(true) },
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
        ) {
            Icon(
                painter = if (gridSelected) {
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
                painter = if (gridSelected) {
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
    onRecipeBoxClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        onClick = onRecipeBoxClick
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp, 75.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Recipe Placeholder")
        }
    }
}

@Composable
fun RecipeRowBoxPlaceholder(
    onRecipeBoxClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(10.dp, 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        onClick = onRecipeBoxClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 40.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Recipe Placeholder")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllRecipesScreenPreview() {
    AllRecipesScreen(
        gridSelected = true,
        changeView = {},
        onRecipeBoxClick = {},
        onAddBoxClicked = {}
    )
}