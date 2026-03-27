package com.jasminespence.mypantry.ui.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.jasminespence.mypantry.ui.compose.components.ActionButton
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun AddRecipeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(Dimensions.MAIN_PADDING.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(Dimensions.MAIN_PADDING.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .size(
                        width = (Dimensions.BASE_BIG_IMG_SIZE * Dimensions.IMG_ASPECT_RATIO_SHORT).dp,
                        height =(Dimensions.BASE_BIG_IMG_SIZE * Dimensions.IMG_ASPECT_RATIO_LONG).dp
                    )
            ) {
                Text("Recipe Image")
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .height(Dimensions.BASE_FORM_HEIGHT.dp)
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
                        AddIngredientRow()
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
                        AddMethodRow()
                    }
                )
            }
            // Adds empty space for save button
            Spacer(modifier = Modifier.height(Dimensions.ACTION_BUTTON_DIMS.dp))
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            ActionButton(
                iconId = R.drawable.save_icon,
                action = "save",
                onBoxClick = {}
            )
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
        verticalArrangement = Arrangement.spacedBy(Dimensions.SUB_PADDING.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium
        )
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.MAIN_PADDING.dp)
        ) {
            for (i in 1..3) {
                listRow()
            }
        }
    }
}

@Composable
fun AddIngredientRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.BASE_FORM_HEIGHT.dp),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.SUB_PADDING.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .height(Dimensions.BASE_FORM_HEIGHT.dp)
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
    }
}

@Composable
fun AddMethodRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = Dimensions.BASE_FORM_HEIGHT.dp)
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.SUB_PADDING.dp)
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
                .width(Dimensions.BASE_FORM_HEIGHT.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.reorder_icon),
                contentDescription = "re-order",
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimensions.SUB_PADDING.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddRecipeScreenPreview() {
    AddRecipeScreen()
}