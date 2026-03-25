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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
            val baseFormHeight = 40
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .size((baseImageSize * 3).dp, (baseImageSize * 4).dp)
            ) {
                Text("Item Image")
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .height(baseFormHeight.dp)
            ) {
                Text("Item Name")
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .height(baseFormHeight.dp)
            ) {
                Text("Min Item Stock Required")
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                CarouselSelector(
                    name = "Storage Location",
                    options = emptyList()
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                CarouselSelector(
                    name = "Category",
                    options = emptyList()
                )
            }
            // Adds empty space for save button
            Spacer(modifier = Modifier.height(60.dp))
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            ActionBox(
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
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.tertiaryContainer),
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(3) {
                    CarouselItem(
                        CarouselOption(
                            name = "Option Name",
                            image = "-"
                        )
                    )
                }
                item {
                    CarouselItem(
                        CarouselOption(
                            name = "Add new ${name.lowercase()}",
                            image = "-"
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun CarouselItem(
    option: CarouselOption,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxHeight()
            .width(140.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondary)
                ) {
                    Text("Option Image")
                }
            }
            Text(
                text = option.name,
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddItemScreenPreview() {
    AddItemScreen()
}