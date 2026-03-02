package com.example.myPantry.ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myPantry.data.entites.PantryItem
import com.example.myPantry.data.entites.PantryItemInstance
import com.example.myPantry.data.entites.relationships.PantryItemWithInstances
import kotlin.time.Instant

@Composable
fun PantryScreen(
    pantryItemsWithInstances: List<PantryItemWithInstances>,
    modifier: Modifier = Modifier,

    ) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2)
    ) { items (pantryItemsWithInstances) {
            PantryItemBox(
                item = it
            )
        }
    }
}

@Composable
fun PantryItemBox(
    item: PantryItemWithInstances,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
    ) {
        Text(item.pantryItem.name)
    }
}

@Preview(showBackground = true)
@Composable
fun PantryScreenPreview() {
    val pantryItem1 = PantryItem(
        name = "bread"
    )
    val pantryItem2 = PantryItem(
        name = "banana"
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
    PantryScreen(pantryItemsWithInstances)
}