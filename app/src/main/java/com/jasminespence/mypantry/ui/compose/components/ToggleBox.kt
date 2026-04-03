package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.ui.theme.ColorPalette
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun ToggleBox(
    modifier: Modifier = Modifier,
    colorPalette: ColorPalette,
    activated: Boolean,
    onToggle: () -> Unit
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(Dimensions.CORNER_ROUNDING.dp))
            .clickable(
                onClick = onToggle
            )
            .then(
                if (activated) {
                    Modifier
                        .background(colorPalette.color)
                } else {
                    Modifier
                        .border(
                            width = Dimensions.OUTLINE_WIDTH.dp,
                            color = colorPalette.color,
                            shape = RoundedCornerShape(Dimensions.CORNER_ROUNDING.dp)
                        )
                }
            )
            .padding(Dimensions.SMALL_BORDER.dp)
    ) {
        if (activated) {
            Icon(
                painter = painterResource(R.drawable.no_circle_tick_icon),
                contentDescription = "tick",
                tint = colorPalette.onColor,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
            )
        }
    }
}