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
import com.example.myPantry.data.PantryItem

@Composable
fun PantryScreen(
    pantryItems: List<PantryItem>,
    modifier: Modifier = Modifier,

) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2)
    ) { items (pantryItems) {
            PantryItemBox(
                item = it
            )
        }
    }
}

@Composable
fun PantryItemBox(
    item: PantryItem,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
    ) {
        Text(item.name)
    }
}

@Preview(showBackground = true)
@Composable
fun PantryScreenPreview() {
    val pantryItems = listOf(
        PantryItem(
            name = "bread",
            quantity = 1
        ),
        PantryItem(
            name = "banana"
        )
    )
    PantryScreen(pantryItems)
}