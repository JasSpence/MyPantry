package com.jasminespence.mypantry.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R

@Composable
fun AddRecipeScreen(
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
                        AddIngredientRow(
                            baseInputHeight
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
                        AddMethodRow(
                            baseInputHeight
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun AddList(
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
fun AddIngredientRow(
    baseInputHeight: Int,
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
//        Box(
//            modifier = Modifier
//                .fillMaxHeight()
//                .width(baseInputHeight.dp)
//                .background(MaterialTheme.colorScheme.secondary)
//        ) {
//            Text("y/n")
//        }
    }
}

@Composable
fun AddMethodRow(
    baseInputHeight: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = baseInputHeight.dp)
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Text("Step description")
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(baseInputHeight.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.reorder_icon),
                contentDescription = "re-order",
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddRecipeScreenPreview() {
    AddRecipeScreen()
}