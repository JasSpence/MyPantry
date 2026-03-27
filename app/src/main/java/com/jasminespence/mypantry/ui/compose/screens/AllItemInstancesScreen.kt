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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.jasminespence.mypantry.ui.compose.components.DeleteRowBox
import com.jasminespence.mypantry.ui.compose.components.ExpiryIcons
import com.jasminespence.mypantry.ui.compose.components.ListOfRows
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
            .padding(Dimensions.BIG_BORDER.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(Dimensions.DIFF_BOX_PADDING.dp),
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
                ListOfRows(
                    title = "Instances"
                ) { rowId ->
                    InstanceRow(
                        rowId = rowId,
                        swipedRow = swipedRow,
                        setSwipedRow = setSwipedRow,
                    )
                }
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
    val expiry = listOf(-1,0,1).random()
    Row (
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.BASE_FORM_HEIGHT.dp),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.SAME_BOX_PADDING.dp)
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
        ExpiryIcons(
            modifier = Modifier
                .zIndex(0f),
            expiry = expiry
        )
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