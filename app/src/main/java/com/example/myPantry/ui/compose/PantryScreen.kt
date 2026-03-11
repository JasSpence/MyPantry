package com.example.myPantry.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.placeholder
import com.example.myPantry.MainViewModel
import com.example.myPantry.R
import com.example.myPantry.data.entites.PantryItem
import com.example.myPantry.data.entites.PantryItemInstance
import com.example.myPantry.data.entites.relationships.PantryItemWithInstances
import kotlin.time.Instant

@Composable
fun PantryScreen(
    pantryItemsWithInstances: List<PantryItemWithInstances>,
    gridSelected: Boolean,
    changeView: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopMenu(
                gridSelected = gridSelected,
                changeView = changeView
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            columns = if (gridSelected) GridCells.Fixed(2) else GridCells.Fixed(1)
        ) {
            items(pantryItemsWithInstances) {
                if (gridSelected) {
                    PantryItemGridBox(
                        item = it
                    )
                } else {
                    PantryItemRowBox(
                        item = it
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            AddItemBox(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Composable
fun AddItemBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondary)
            .size(50.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.add_icon),
            contentDescription = "add",
            modifier = modifier.fillMaxSize(),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun TopMenu(
    modifier: Modifier = Modifier,
    gridSelected: Boolean,
    changeView: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { changeView(true) }
        ) {
            Icon(
                painter = if (gridSelected) {
                    painterResource(R.drawable.selected_grid_view_icon)
                } else {
                    painterResource(R.drawable.unselected_grid_view_icon)
                },
                contentDescription = "grid view",
                modifier = modifier,
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        IconButton(
            onClick = { changeView(false) }
        ) {
            Icon(
                painter = if (gridSelected) {
                    painterResource(R.drawable.unselected_row_view_icon)
                } else {
                    painterResource(R.drawable.selected_row_view_icon)
                },
                contentDescription = "row view",
                modifier = modifier,
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun PantryItemGridBox(
    item: PantryItemWithInstances,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(10.dp),

        ) {
        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.secondaryContainer)
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

@Composable
fun PantryItemRowBox(
    item: PantryItemWithInstances,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(10.dp, 10.dp)

        ) {
        Row(
            modifier = modifier
                .background(MaterialTheme.colorScheme.secondaryContainer)
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
    val pantryItem1 = PantryItem(
        name = "Bread"
    )
    val pantryItem2 = PantryItem(
        name = "Banana"
    )
    val pantryItemsWithInstances = listOf(
        PantryItemWithInstances(
            pantryItem = pantryItem1,
            instances = listOf(
                PantryItemInstance(
                    pantryItem = pantryItem1.id
                ),
                PantryItemInstance(
                    pantryItem = pantryItem1.id,
                    expiryDate = Instant.DISTANT_FUTURE
                )
            )
        ),
        PantryItemWithInstances(
            pantryItem = pantryItem2,
            instances = listOf(
                PantryItemInstance(
                    pantryItem = pantryItem2.id
                )
            )
        ),
    )
    PantryScreen(
        pantryItemsWithInstances = pantryItemsWithInstances,
        gridSelected = true,
        changeView = {}
    )
}