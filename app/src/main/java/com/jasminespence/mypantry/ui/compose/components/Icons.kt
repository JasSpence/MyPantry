package com.jasminespence.mypantry.ui.compose.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.ui.theme.ColorPalette
import com.jasminespence.mypantry.ui.theme.Dimensions
import com.jasminespence.mypantry.ui.theme.green
import com.jasminespence.mypantry.ui.theme.red
import com.jasminespence.mypantry.ui.theme.yellow

@Composable
fun IconBox(
    modifier: Modifier = Modifier,
    colorPalette: ColorPalette,
    @DrawableRes iconId: Int,
    contentDestination: String
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .border(
                width = Dimensions.OUTLINE_WIDTH.dp,
                color = colorPalette.color,
                shape = RoundedCornerShape(Dimensions.CORNER_ROUNDING.dp)
            )
            .clip(RoundedCornerShape(Dimensions.CORNER_ROUNDING.dp))
            .background(colorPalette.surface)
            .padding(Dimensions.SMALL_BORDER.dp)
    ) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = contentDestination,
            tint = colorPalette.color,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
    }
}

@Composable
fun TickBox(
    modifier: Modifier = Modifier
) {
    IconBox(
        modifier = modifier,
        colorPalette = MaterialTheme.colorScheme.green,
        iconId = R.drawable.tick_icon,
        contentDestination = "tick"
    )
}

@Composable
fun WarningBox(
    modifier: Modifier = Modifier
) {
    IconBox(
        modifier = modifier,
        colorPalette = MaterialTheme.colorScheme.yellow,
        iconId = R.drawable.selected_error_icon,
        contentDestination = "warning"
    )
}

@Composable
fun CrossBox(
    modifier: Modifier = Modifier
) {
    IconBox(
        modifier = modifier,
        colorPalette = MaterialTheme.colorScheme.red,
        iconId = R.drawable.cross_icon,
        contentDestination = "cross"
    )
}