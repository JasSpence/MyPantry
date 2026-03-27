package com.jasminespence.mypantry.ui.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.zIndex
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.ui.compose.components.DeleteRowBox
import com.jasminespence.mypantry.ui.compose.components.SwipeableRow
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun AllItemInstancesScreen(
    modifier: Modifier = Modifier,
    swipedRow: Int?,
    setSwipedRow: (Int?) -> Unit
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
                        height = (Dimensions.BASE_BIG_IMG_SIZE * Dimensions.IMG_ASPECT_RATIO_LONG).dp
                    )
            ) {
                Text("Item Image")
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .height(Dimensions.BASE_FORM_HEIGHT.dp)
            ) {
                Text("Item Name")
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                InstanceList(
                    name = "Instances",
                    listRow = { rowId ->
                        InstanceRow(
                            rowId = rowId,
                            swipedRow = swipedRow,
                            setSwipedRow = setSwipedRow,
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun InstanceList(
    name: String,
    listRow: @Composable (Int) -> Unit,
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
            for (i in 1..7) {
                listRow(i)
            }
        }
    }
}

@Composable
fun InstanceRow(
    modifier: Modifier = Modifier,
    rowId: Int,
    swipedRow: Int?,
    setSwipedRow: (Int?) -> Unit
) {
    val expiry = listOf(0,1,2).random()
    Row (
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.BASE_FORM_HEIGHT.dp),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.SUB_PADDING.dp)
    ) {
        SwipeableRow(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .zIndex(1f),
            hiddenBox = { color ->
                DeleteRowBox(
                    onClick = {},
                    color = color
                )
            },
            hiddenBoxColor = Color.Red,
            isSwipedRow = (swipedRow == rowId),
            setSwipedRow = { setSwipedRow(rowId) },
            resetSwipedRow = { setSwipedRow(null) },
            rounded = true,
        ) {
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondary),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Brand")
                Text("Expiry Date")
            }
        }
        val iconModifier = Modifier
            .fillMaxHeight()
            .padding(Dimensions.SUB_PADDING.dp)
            .zIndex(0f)
        if (expiry == 0) { // expired
            Icon(
                painter = painterResource(R.drawable.cross_icon),
                contentDescription = "you have item",
                tint = Color.Green,
                modifier = iconModifier
            )
        } else if (expiry == 1) { // expires soon
            Icon(
                painter = painterResource(R.drawable.selected_error_icon),
                contentDescription = "you do not have item",
                tint = Color.Yellow,
                modifier = iconModifier
            )
        } else { // doesn't expire soon
            Icon(
                painter = painterResource(R.drawable.tick_icon),
                contentDescription = "you do not have item",
                tint = Color.Red,
                modifier = iconModifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllItemInstancesScreenPreview() {
    AllItemInstancesScreen(
        swipedRow = null,
        setSwipedRow = {}
    )
}