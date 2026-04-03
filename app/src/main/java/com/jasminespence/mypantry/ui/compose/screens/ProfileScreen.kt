package com.jasminespence.mypantry.ui.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.MyPantryThemePreview
import com.jasminespence.mypantry.ui.compose.components.SliderSelectorWithToggle
import com.jasminespence.mypantry.ui.theme.ColorPalette
import com.jasminespence.mypantry.ui.theme.Contrast
import com.jasminespence.mypantry.ui.theme.Dimensions
import com.jasminespence.mypantry.ui.theme.contrastChoices
import com.jasminespence.mypantry.ui.theme.getContrast

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    userSetContrast: Contrast?,
    setUserSetContrast: (Contrast?) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(Dimensions.BIG_BORDER.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(Dimensions.DIFF_BOX_PADDING.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .size(
                        width = (Dimensions.BASE_BIG_IMG_SIZE * Dimensions.IMG_ASPECT_RATIO_SHORT).dp,
                        height = (Dimensions.BASE_BIG_IMG_SIZE * Dimensions.IMG_ASPECT_RATIO_LONG).dp
                    )
            ) {
                Text("Profile Picture")
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .height(Dimensions.BASE_FORM_HEIGHT.dp)
            ) {
                Text("User Name")
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .height(Dimensions.BASE_FORM_HEIGHT.dp)
            ) {
                Text("Expires soon time")
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .height(Dimensions.BASE_FORM_HEIGHT.dp)
            ) {
                Text("Contrast/Theme Settings")
            }
            val systemContrast = getContrast(dynamicColor = false)
            val primaryColorPalette = ColorPalette(
                color = MaterialTheme.colorScheme.primary,
                onColor = MaterialTheme.colorScheme.onPrimary,
                surface = MaterialTheme.colorScheme.surfaceVariant,
                onSurface = MaterialTheme.colorScheme.onSurfaceVariant,
                container = MaterialTheme.colorScheme.primaryContainer,
                onContainer = MaterialTheme.colorScheme.onPrimaryContainer
            )
            SliderSelectorWithToggle(
                colorPalette = primaryColorPalette,
                isSliderActivated = userSetContrast != null,
                onToggle = {
                    if (userSetContrast == null) {
                        setUserSetContrast(systemContrast)
                    } else {
                        setUserSetContrast(null)
                    }
                },
                text = "Use System Contrast",
                sliderChoices = contrastChoices,
                onSlide = setUserSetContrast,
                activatedSliderOption = userSetContrast,
                deactivatedSliderOption = systemContrast
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MyPantryThemePreview() {
        ProfileScreen(
            setUserSetContrast = {},
            userSetContrast = Contrast.STANDARD
        )
    }
}