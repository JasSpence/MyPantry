package com.jasminespence.mypantry.ui.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.ui.compose.components.ExpiryIcons
import com.jasminespence.mypantry.ui.compose.components.ListOfRows
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun DeleteItemInstanceScreen(
    modifier: Modifier = Modifier
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
                    .fillMaxWidth()
            ) {
                ListOfRows(
                    title = "Instances to be deleted:"
                ) { rowId ->
                    InstanceToDeleteRow(
                        rowId = rowId,
                        toDelete = true
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Row(
                    modifier = Modifier
                        .height(Dimensions.BASE_FORM_HEIGHT.dp)
                        .clip(RoundedCornerShape(Dimensions.CORNER_ROUNDING.dp))
                        .background(MaterialTheme.colorScheme.secondary)
                        .padding(Dimensions.MEDIUM_BORDER.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.SAME_BOX_PADDING.dp)
                ) {
                    Text(
                        text = "Submit",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                    Icon(
                        painter = painterResource(R.drawable.right_arrow_icon),
                        contentDescription = "submit",
                        tint = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ListOfRows(
                    title = "Instances to keep:"
                ) { rowId ->
                    InstanceToDeleteRow(
                        rowId = rowId,
                        toDelete = false
                    )
                }
            }
        }
    }
}

@Composable
fun InstanceToDeleteRow(
    modifier: Modifier = Modifier,
    rowId: Int,
    toDelete: Boolean
) {
    val expiry = listOf(-1,0,1).random()
    val rowColor: Color
    val buttonColor: Color
    val iconModifier = Modifier
        .fillMaxHeight()
        .padding(Dimensions.SMALL_BORDER.dp)
        .aspectRatio(1f)
    val icon: @Composable () -> Unit

    if (toDelete) {
        rowColor = Color.Red
        buttonColor = Color.Gray
        icon = {
            Icon(
                painter = painterResource(R.drawable.save_icon),
                contentDescription = "keep instance",
                tint = Color.DarkGray,
                modifier = iconModifier
            )
        }
    } else {
        rowColor = MaterialTheme.colorScheme.secondary
        buttonColor = Color.Red
        icon = {
            Icon(
                painter = painterResource(R.drawable.delete_icon),
                contentDescription = "delete instance",
                tint = Color.White,
                modifier = iconModifier
            )
        }
    }

    Row (
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.BASE_FORM_HEIGHT.dp),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.GROUPED_BOX_PADDING.dp)
    ) {
        ExpiryIcons(
            expiry = expiry
        )
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .clip(RoundedCornerShape(Dimensions.CORNER_ROUNDING.dp))
                .background(rowColor)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Brand")
                Text("Expiry Date")
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(buttonColor),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                icon()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DeleteItemInstanceScreenPreview() {
    DeleteItemInstanceScreen()
}