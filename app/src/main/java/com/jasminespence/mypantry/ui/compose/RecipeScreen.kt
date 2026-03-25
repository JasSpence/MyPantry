package com.jasminespence.mypantry.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val baseImageSize = 50
            val baseInputHeight = 40
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .size((baseImageSize * 3).dp, (baseImageSize * 4).dp)
            ) {
                Text("Recipe Image")
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .height(baseInputHeight.dp)
            ) {
                Text("Recipe Name")
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AddList(
                    name = "Ingredients",
                    listRow = {
                        IngredientRow(
                            baseInputHeight = baseInputHeight,
                            hasItem = false
                        )
                    }
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AddList(
                    name = "Method",
                    listRow = {
                        MethodRow(
                            baseInputHeight
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun List(
    name: String,
    listRow: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium
        )
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            for (i in 1..3) {
                listRow()
            }
        }
    }
}

@Composable
fun IngredientRow(
    baseInputHeight: Int,
    hasItem: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(baseInputHeight.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(baseInputHeight.dp)
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Text("Img")
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(5.dp)
        ) {
            Text("#")
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Text("Ingredient Name")
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(baseInputHeight.dp)
        ) {
            val iconModifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
            if (hasItem) {
                Icon(
                    painter = painterResource(R.drawable.tick_icon),
                    contentDescription = "you have item",
                    tint = Color.Green,
                    modifier = iconModifier
                )
            } else {
                Icon(
                    painter = painterResource(R.drawable.cross_icon),
                    contentDescription = "you do not have item",
                    tint = Color.Red,
                    modifier = iconModifier
                )
            }
        }
    }
}

@Composable
fun MethodRow(
    baseInputHeight: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .defaultMinSize(minHeight = baseInputHeight.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
    ) {
        Text("Step description")
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeScreenPreview() {
    RecipeScreen()
}