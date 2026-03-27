package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun PhotoWithRowComposableCard(
    modifier: Modifier = Modifier,
    photo: String,
    onClick: (() -> Unit)? = null,
    composable: @Composable () -> Unit
) {
    ElevatedCard(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onTertiary,
            disabledContainerColor = MaterialTheme.colorScheme.tertiary,
            disabledContentColor = MaterialTheme.colorScheme.onTertiary,
        ),
        onClick = onClick ?: {},
        enabled = onClick != null
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(Dimensions.MEDIUM_BORDER.dp),
            horizontalArrangement = Arrangement.spacedBy(Dimensions.GROUPED_BOX_PADDING.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(
                        ratio = Dimensions.IMG_ASPECT_RATIO_SHORT.toFloat() / Dimensions.IMG_ASPECT_RATIO_LONG.toFloat(),
                        matchHeightConstraintsFirst = true
                    )
                    .background(MaterialTheme.colorScheme.secondary)
            ) {
                Text("Image")
            }
            composable()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotoWithRowComposableCardPreview() {
    PhotoWithRowComposableCard(
        photo = "",
        composable = {
            Text("Preview")
        }
    )
}