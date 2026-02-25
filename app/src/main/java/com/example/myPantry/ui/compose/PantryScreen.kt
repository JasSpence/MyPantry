package com.example.myPantry.ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PantryScreen(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(3)
    ) { item {
            Text("Hi")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantryScreenPreview() {
    PantryScreen()
}