package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.ui.theme.Dimensions

@Composable
fun ExpiryIcons(
    modifier: Modifier = Modifier,
    expiry: Int
) {
    if (expiry < 0) { // expired
        Icon(
            painter = painterResource(R.drawable.cross_icon),
            contentDescription = "instance has expired",
            tint = Color.Red,
            modifier = modifier
                .fillMaxHeight()
                .padding(0.dp, Dimensions.SMALL_BORDER.dp)
                .aspectRatio(1f)
        )
    } else if (expiry == 0) { // expires soon
        Icon(
            painter = painterResource(R.drawable.selected_error_icon),
            contentDescription = "instance expires soon",
            tint = Color.Yellow,
            modifier = modifier
                .fillMaxHeight()
                .padding(0.dp, Dimensions.SMALL_BORDER.dp)
                .aspectRatio(1f)
        )
    } else { // doesn't expire soon
        Icon(
            painter = painterResource(R.drawable.tick_icon),
            contentDescription = "instance does not expire soon",
            tint = Color.Green,
            modifier = modifier
                .fillMaxHeight()
                .padding(0.dp, Dimensions.SMALL_BORDER.dp)
                .aspectRatio(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExpiryIconsPreview() {
    ExpiryIcons(
        expiry = -1
    )
}