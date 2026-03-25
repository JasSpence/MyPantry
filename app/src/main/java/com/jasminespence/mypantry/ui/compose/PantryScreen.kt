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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.placeholder
import com.jasminespence.mypantry.data.entites.PantryItem
import com.jasminespence.mypantry.data.entites.PantryItemInstance
import com.jasminespence.mypantry.data.entites.StorageLocation
import com.jasminespence.mypantry.data.entites.relationships.PantryItemWithInstances
import kotlin.time.Instant
import com.jasminespence.mypantry.R

@Composable
fun PantryScreen(
    pantryItemsWithInstances: List<PantryItemWithInstances>,
    pantryItemQuantities: Map<Int, Int>,
    gridSelected: Boolean,
    changeView: (Boolean) -> Unit,
    onAddItemClick: () -> Unit,
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
            PantryTopMenu(
                gridSelected = gridSelected,
                changeView = changeView
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .weight(1f),
                columns = if (gridSelected) GridCells.Fixed(2) else GridCells.Fixed(1)
            ) {
//            items(pantryItemsWithInstances) {
//                if (gridSelected) {
//                    PantryItemGridBox(
//                        item = it,
//                        pantryItemQuantities = pantryItemQuantities
//                    )
//                } else {
//                    PantryItemRowBox(
//                        item = it
//                    )
//                }
//            }
                items(8) {
                    if (gridSelected) {
                        PantryItemGridBoxPlaceholder()
                    } else {
                        PantryItemRowBoxPlaceholder()
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
                action = "add item",
                onBoxClick = onAddItemClick
            )
        }
    }
}

@Composable
fun PantryTopMenu(
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
fun PantryItemGridBoxPlaceholder(
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp, 75.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Pantry Item Placeholder")
        }
    }
}

@Composable
fun PantryItemRowBoxPlaceholder(
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(10.dp, 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 40.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Pantry Item Placeholder")
        }
    }
}

@Composable
fun PantryItemGridBox(
    item: PantryItemWithInstances,
    pantryItemQuantities: Map<Int, Int>,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.pantryItem.image)
                    .placeholder(R.drawable.unselected_error_icon)
                    .crossfade(true)
                    .build(),
                contentDescription = item.pantryItem.name,
                contentScale = ContentScale.Fit
            )
            Text(
                text = item.pantryItem.name,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = pantryItemQuantities
                    .getValue(item.pantryItem.id)
                    .toString(),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun PantryItemRowBox(
    item: PantryItemWithInstances,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(10.dp, 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(100.dp)) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.pantryItem.image)
                        .placeholder(R.drawable.unselected_error_icon)
                        .crossfade(true)
                        .build(),
                    contentDescription = item.pantryItem.name,
                    contentScale = ContentScale.Fit
                )
            }
            Text(
                text = item.pantryItem.name,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantryScreenPreview() {
    val storageLocation = StorageLocation(
        name = "Pantry",
        colour = Color.Blue
    )
    val pantryItem1 = PantryItem(
        id = 0,
        name = "Bread",
        storageLocation = storageLocation.id
    )
    val pantryItem2 = PantryItem(
        id = 1,
        name = "Banana",
        storageLocation = storageLocation.id
    )
    val pantryWithInstances1 = PantryItemWithInstances(
        pantryItem = pantryItem1,
        instances = listOf(
            PantryItemInstance(
                id = 0,
                pantryItem = pantryItem1.id
            ),
            PantryItemInstance(
                id = 1,
                pantryItem = pantryItem1.id,
                expiryDate = Instant.DISTANT_FUTURE
            )
        )
    )
    val pantryWithInstances2 = PantryItemWithInstances(
        pantryItem = pantryItem2,
        instances = listOf(
            PantryItemInstance(
                id = 3,
                pantryItem = pantryItem2.id
            )
        )
    )
    val pantryItemsWithInstances = listOf(pantryWithInstances1, pantryWithInstances2)
    PantryScreen(
        pantryItemsWithInstances = pantryItemsWithInstances,
        pantryItemQuantities = mapOf(pantryItem1.id to 2, pantryItem2.id to 1),
        gridSelected = true,
        changeView = {},
        onAddItemClick = {},
    )
}