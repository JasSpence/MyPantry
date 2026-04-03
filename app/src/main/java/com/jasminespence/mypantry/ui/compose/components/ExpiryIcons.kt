package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jasminespence.mypantry.MyPantryThemePreview

@Composable
fun ExpiryIcons(
    modifier: Modifier = Modifier,
    expiry: Int
) {
    if (expiry < 0) { // expired
        CrossBox(modifier = modifier)
    } else if (expiry == 0) { // expires soon
        WarningBox(modifier = modifier)
    } else { // doesn't expire soon
        TickBox(modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun ExpiryIconsPreview() {
    MyPantryThemePreview() {
        ExpiryIcons(
            expiry = -1
        )
    }
}