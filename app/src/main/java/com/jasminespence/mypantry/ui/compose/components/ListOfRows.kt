package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun ListOfRows(
    modifier: Modifier = Modifier,
    title: String? = null,
    titleStyle: TextStyle = MaterialTheme.typography.titleMedium,
    rowContent: @Composable (Int) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Dimensions.GROUPED_BOX_PADDING.dp)
    ) {
        if (!title.isNullOrBlank()) {
            Text(
                text = title,
                style = titleStyle
            )
        }
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.GROUPED_BOX_PADDING.dp)
        ) {
            for (i in 1..7) {
                rowContent(i)
            }
        }
    }
}