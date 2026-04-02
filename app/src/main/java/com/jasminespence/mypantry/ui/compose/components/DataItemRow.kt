package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun DataItemRow(
    modifier: Modifier = Modifier,
    title: String,
    hasTick: Boolean,
    onClick: (() -> Unit)? = null,
    bottomLeftText: String,
    bottomLeftIcon: Int,
    bottomLeftIconDescription: String
) {
    PhotoWithRowComposableCard(
        photo = "-",
        onClick = onClick,
        modifier = modifier
            .height(Dimensions.BASE_ROW_VIEW_HEIGHT.dp)
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onTertiary,
            style = MaterialTheme.typography.titleMedium
        )
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimensions.SMALL_ICON_DIMS.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    Dimensions.SAME_BOX_PADDING.dp,
                    Alignment.End
                )
            ) {
                Text(
                    text = bottomLeftText,
                    color = MaterialTheme.colorScheme.onTertiary,
                    style = MaterialTheme.typography.bodySmall
                )
                Icon(
                    painter = painterResource(bottomLeftIcon),
                    contentDescription = bottomLeftIconDescription,
                    tint = MaterialTheme.colorScheme.onTertiary
                )
            }
            if (hasTick) {
                TickBox(
                    modifier = Modifier
                        .size(Dimensions.SMALL_ICON_WITH_SMALL_BORDER_DIMS.dp)
                )
            } else {
                CrossBox(
                    modifier = Modifier
                        .size(Dimensions.SMALL_ICON_WITH_SMALL_BORDER_DIMS.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DataItemRowPreview() {
    DataItemRow(
        title = "Item Name",
        hasTick = false,
        bottomLeftIcon = R.drawable.selected_error_icon,
        bottomLeftIconDescription = "error",
        bottomLeftText = "Text"
    )
}