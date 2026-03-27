package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun ActionButton(
    iconId: Int,
    action: String,
    onBoxClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilledIconButton(
        onClick = onBoxClick,
        modifier = modifier
            .size(Dimensions.ACTION_BUTTON_DIMS.dp),
        shape = RoundedCornerShape(Dimensions.CORNER_ROUNDING.dp),
        colors = IconButtonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary,
            disabledContainerColor = MaterialTheme.colorScheme.error,
            disabledContentColor = MaterialTheme.colorScheme.onError,
        )
    ) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = action,
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimensions.BUTTON_PADDING.dp)
        )
    }
}