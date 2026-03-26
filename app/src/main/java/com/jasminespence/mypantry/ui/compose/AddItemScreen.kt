package com.jasminespence.mypantry.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.ui.theme.Dimensions
import kotlin.collections.emptyList

data class CarouselOption(
    val name: String,
    val image: String
)

@Composable
fun AddItemScreen(modifier: Modifier = Modifier) {
//    val pickMedia = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {}
//    pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    Box (
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
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .height(Dimensions.BASE_FORM_HEIGHT.dp)
            ) {
                Text("Min Item Stock Required")
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                CarouselSelector(
                    name = "Storage Location",
                    options = emptyList()
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                CarouselSelector(
                    name = "Category",
                    options = emptyList()
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
fun CarouselSelector(
    name: String,
    options: List<CarouselOption>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .height(Dimensions.BASE_GRID_VIEW_HEIGHT.dp),
        verticalArrangement = Arrangement.spacedBy(Dimensions.SUB_PADDING.dp),
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(Dimensions.CORNER_ROUNDING.dp))
                .background(MaterialTheme.colorScheme.tertiaryContainer),
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimensions.MAIN_PADDING.dp),
                horizontalArrangement = Arrangement.spacedBy(Dimensions.MAIN_PADDING.dp)
            ) {
                items(3) {
                    PhotoWithColComposableCard(
                        photo = "-",
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(Dimensions.BASE_GRID_VIEW_WIDTH.dp),
                        composable = {
                            Text(
                                text = "Option Name",
                                color = MaterialTheme.colorScheme.onTertiary,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        }
                    )
                }
                item {
                    PhotoWithColComposableCard(
                        photo = "-",
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(Dimensions.BASE_GRID_VIEW_WIDTH.dp),
                        composable = {
                            Text(
                                text = "Add new ${name.lowercase()}",
                                color = MaterialTheme.colorScheme.onTertiary,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddItemScreenPreview() {
    AddItemScreen()
}