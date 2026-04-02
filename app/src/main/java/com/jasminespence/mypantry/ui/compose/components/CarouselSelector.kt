package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun CarouselSelector(
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .height(Dimensions.BASE_GRID_VIEW_HEIGHT.dp),
        verticalArrangement = Arrangement.spacedBy(Dimensions.GROUPED_BOX_PADDING.dp),
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
                    .padding(Dimensions.MEDIUM_BORDER.dp),
                horizontalArrangement = Arrangement.spacedBy(Dimensions.GROUPED_BOX_PADDING.dp)
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
                                style = MaterialTheme.typography.bodyMedium
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
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    )
                }
            }
        }
    }
}