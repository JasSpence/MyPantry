package com.jasminespence.mypantry.ui.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.ui.compose.components.ActionButton
import com.jasminespence.mypantry.ui.compose.components.CarouselSelector
import com.jasminespence.mypantry.ui.theme.Dimensions
import kotlin.collections.emptyList

@Composable
fun AddItemScreen(modifier: Modifier = Modifier) {
//    val pickMedia = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {}
//    pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    Box (
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
                    name = "Storage Location"
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                CarouselSelector(
                    name = "Category"
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

@Preview(showBackground = true)
@Composable
fun AddItemScreenPreview() {
    AddItemScreen()
}