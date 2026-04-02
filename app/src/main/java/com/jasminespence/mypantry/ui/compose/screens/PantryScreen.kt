package com.jasminespence.mypantry.ui.compose.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.data.entites.PantryItem
import com.jasminespence.mypantry.data.entites.PantryItemInstance
import com.jasminespence.mypantry.data.entites.StorageLocation
import com.jasminespence.mypantry.data.entites.relationships.PantryItemWithInstances
import kotlin.time.Instant
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.ui.compose.components.ActionButton
import com.jasminespence.mypantry.ui.compose.components.DataItemGrid
import com.jasminespence.mypantry.ui.compose.components.DataItemRow
import com.jasminespence.mypantry.ui.theme.ColorPalette
import com.jasminespence.mypantry.ui.theme.Dimensions
import com.jasminespence.mypantry.ui.theme.green
import com.jasminespence.mypantry.ui.theme.grey
import com.jasminespence.mypantry.ui.theme.red

@Composable
fun PantryScreen(
    pantryItemsWithInstances: List<PantryItemWithInstances>,
    pantryItemQuantities: Map<Int, Int>,
    isGridSelected: Boolean,
    changeView: (Boolean) -> Unit,
    selectedPantryItem: Int?,
    onPantryItemClick: (Int?) -> Unit,
    onAddItemClick: () -> Unit,
    onAddNewInstancesClick: (Int) -> Unit,
    onViewInstancesClick: (Int) -> Unit,
    onDeleteInstanceClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val placeholders = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(Dimensions.BIG_BORDER.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.DIFF_BOX_PADDING.dp)
        ) {
            PantryTopMenu(
                isGridSelected = isGridSelected,
                changeView = changeView
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .weight(1f),
                columns = if (isGridSelected) GridCells.Fixed(2) else GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(Dimensions.DIFF_BOX_PADDING.dp),
                horizontalArrangement = Arrangement.spacedBy(Dimensions.DIFF_BOX_PADDING.dp),
            ) {
//                items(pantryItemsWithInstances) {
//                if (isGridSelected) {
//                    PantryItemGridBox(
//                        item = it,
//                        pantryItemQuantities = pantryItemQuantities
//                    )
//                } else {
//                    PantryItemRowBox(
//                        item = it
//                    )
//                }
                items(placeholders) { placeholder ->
                    PantryItemBox(
                        itemId = placeholder,
                        isItemSelected = selectedPantryItem == placeholder,
                        isGridSelected = isGridSelected,
                        onBoxClick = onPantryItemClick,
                        onAddNewInstancesClick = onAddNewInstancesClick,
                        onViewInstancesClick = onViewInstancesClick,
                        onDeleteInstanceClick = onDeleteInstanceClick
                    )
                }
                item(span = { GridItemSpan(maxLineSpan) }) {
                    // Adds empty space for save button
                    Spacer(modifier = Modifier.height(Dimensions.ACTION_BUTTON_DIMS.dp))
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            ActionButton(
                iconId = R.drawable.add_icon,
                action = "add item",
                onBoxClick = onAddItemClick
            )
        }
    }
}

@Composable
fun PantryTopMenu(
    modifier: Modifier = Modifier,
    isGridSelected: Boolean,
    changeView: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.TOP_MENU_HEIGHT.dp),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.GROUPED_BOX_PADDING.dp, Alignment.End),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { changeView(true) },
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
        ) {
            Icon(
                painter = if (isGridSelected) {
                    painterResource(R.drawable.selected_grid_view_icon)
                } else {
                    painterResource(R.drawable.unselected_grid_view_icon)
                },
                contentDescription = "grid view",
                modifier = Modifier.fillMaxSize(),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        IconButton(
            onClick = { changeView(false) },
            modifier = Modifier.fillMaxHeight()
        ) {
            Icon(
                painter = if (isGridSelected) {
                    painterResource(R.drawable.unselected_row_view_icon)
                } else {
                    painterResource(R.drawable.selected_row_view_icon)
                },
                contentDescription = "row view",
                modifier = Modifier.fillMaxSize(),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun PantryItemBox(
    isGridSelected: Boolean,
    itemId: Int,
    isItemSelected: Boolean,
    onBoxClick: (Int?) -> Unit,
    onAddNewInstancesClick: (Int) -> Unit,
    onViewInstancesClick: (Int) -> Unit,
    onDeleteInstanceClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Column {
            if (isGridSelected) {
                PantryItemGridPlaceholder(
                    onClick = {
                        if (isItemSelected) {
                            onBoxClick(null)
                        } else {
                            onBoxClick(itemId)
                        }
                    }
                )
            } else {
                PantryItemRowPlaceholder(
                    onClick = {
                        if (isItemSelected) {
                            onBoxClick(null)
                        } else {
                            onBoxClick(itemId)
                        }
                    }
                )
            }
            if (isItemSelected) {
                ItemSelectedOption(
                    text = "Add new Instance",
                    colorPalette = MaterialTheme.colorScheme.green,
                    onClick = { onAddNewInstancesClick(itemId) }
                )
                ItemSelectedOption(
                    text = "View Instances",
                    colorPalette = MaterialTheme.colorScheme.grey,
                    onClick = { onViewInstancesClick(itemId) }
                )
                ItemSelectedOption(
                    text = "Delete Instance",
                    colorPalette = MaterialTheme.colorScheme.red,
                    onClick = { onDeleteInstanceClick(itemId) }
                )
            }
        }
    }
}

@Composable
fun ItemSelectedOption(
    text: String,
    colorPalette: ColorPalette,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(colorPalette.container)
            .clickable(onClick = onClick)
            .padding(Dimensions.BUTTON_PADDING.dp)
    ) {
        Text(
            text = text,
            color = colorPalette.onContainer,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
fun PantryItemGridPlaceholder(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val hasEnoughInstances = listOf(true,false).random()
    DataItemGrid(
        modifier = modifier,
        title = "Pantry Item Name",
        hasTick = hasEnoughInstances,
        onClick = onClick,
        bottomLeftText = "Next Expiry",
        bottomLeftIcon = R.drawable.calendar_icon,
        bottomLeftIconDescription = "next expiry date"
    )
}

@Composable
fun PantryItemRowPlaceholder(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val hasEnoughInstances = listOf(true,false).random()
    DataItemRow(
        modifier = modifier,
        title = "Pantry Item Name",
        hasTick = hasEnoughInstances,
        onClick = onClick,
        bottomLeftText = "Next Expiry",
        bottomLeftIcon = R.drawable.calendar_icon,
        bottomLeftIconDescription = "next expiry date"
    )
}

//@Composable
//fun PantryItemGridBox(
//    item: PantryItemWithInstances,
//    pantryItemQuantities: Map<Int, Int>,
//    modifier: Modifier = Modifier
//) {
//    ElevatedCard(
//        modifier = modifier
//            .padding(Dimensions.MAIN_PADDING.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.secondaryContainer
//        )
//    ) {
//        Column(
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(item.pantryItem.image)
//                    .placeholder(R.drawable.unselected_error_icon)
//                    .crossfade(true)
//                    .build(),
//                contentDescription = item.pantryItem.name,
//                contentScale = ContentScale.Fit
//            )
//            Text(
//                text = item.pantryItem.name,
//                style = MaterialTheme.typography.headlineSmall
//            )
//            Text(
//                text = pantryItemQuantities
//                    .getValue(item.pantryItem.id)
//                    .toString(),
//                style = MaterialTheme.typography.headlineSmall
//            )
//        }
//    }
//}
//
//@Composable
//fun PantryItemRowBox(
//    item: PantryItemWithInstances,
//    modifier: Modifier = Modifier
//) {
//    ElevatedCard(
//        modifier = modifier
//            .padding(10.dp, 10.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.secondaryContainer
//        )
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp),
//            horizontalArrangement = Arrangement.Start,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Box(modifier = Modifier.size(100.dp)) {
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(item.pantryItem.image)
//                        .placeholder(R.drawable.unselected_error_icon)
//                        .crossfade(true)
//                        .build(),
//                    contentDescription = item.pantryItem.name,
//                    contentScale = ContentScale.Fit
//                )
//            }
//            Text(
//                text = item.pantryItem.name,
//                style = MaterialTheme.typography.headlineSmall,
//                textAlign = TextAlign.Center
//            )
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun PantryScreenPreview() {
    val storageLocation = StorageLocation(
        name = "Pantry",
        colour = Color.Blue
    )
    val pantryItem1 = PantryItem(
        id = 0,
        name = "Bread",
        storageLocation = storageLocation.id
    )
    val pantryItem2 = PantryItem(
        id = 1,
        name = "Banana",
        storageLocation = storageLocation.id
    )
    val pantryWithInstances1 = PantryItemWithInstances(
        pantryItem = pantryItem1,
        instances = listOf(
            PantryItemInstance(
                id = 0,
                pantryItem = pantryItem1.id
            ),
            PantryItemInstance(
                id = 1,
                pantryItem = pantryItem1.id,
                expiryDate = Instant.DISTANT_FUTURE
            )
        )
    )
    val pantryWithInstances2 = PantryItemWithInstances(
        pantryItem = pantryItem2,
        instances = listOf(
            PantryItemInstance(
                id = 3,
                pantryItem = pantryItem2.id
            )
        )
    )
    val pantryItemsWithInstances = listOf(pantryWithInstances1, pantryWithInstances2)
    PantryScreen(
        pantryItemsWithInstances = pantryItemsWithInstances,
        pantryItemQuantities = mapOf(pantryItem1.id to 2, pantryItem2.id to 1),
        isGridSelected = true,
        changeView = {},
        selectedPantryItem = null,
        onPantryItemClick = {},
        onAddItemClick = {},
        onAddNewInstancesClick = {},
        onViewInstancesClick = {},
        onDeleteInstanceClick = {}
    )
}