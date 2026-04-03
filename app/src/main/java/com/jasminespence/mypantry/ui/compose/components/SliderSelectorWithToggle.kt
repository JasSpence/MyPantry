package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.MyPantryThemePreview
import com.jasminespence.mypantry.ui.theme.ColorPalette
import com.jasminespence.mypantry.ui.theme.Contrast
import com.jasminespence.mypantry.ui.theme.Dimensions
import com.jasminespence.mypantry.ui.theme.colorPalettes
import com.jasminespence.mypantry.ui.theme.contrastChoices

@Composable
fun <E : Enum<E>> SliderSelectorWithToggle(
    modifier: Modifier = Modifier,
    colorPalette: ColorPalette,
    isSliderActivated: Boolean,
    onToggle: () -> Unit,
    text: String,
    sliderChoices: List<E>,
    onSlide: (E) -> Unit,
    activatedSliderOption: E?,
    deactivatedSliderOption: E?
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Dimensions.GROUPED_BOX_PADDING.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimensions.BASE_FORM_HEIGHT.dp),
            horizontalArrangement = Arrangement.spacedBy(Dimensions.GROUPED_BOX_PADDING.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ToggleBox(
                colorPalette = colorPalette,
                activated = !isSliderActivated,
                onToggle = onToggle
            )
            Text(
                text = text,
                color = colorPalette.color,
                style = MaterialTheme.typography.titleMedium
            )
        }
        SliderSelector(
            choices = sliderChoices,
            setOption = onSlide,
            activatedOption = activatedSliderOption,
            deactivatedOption = deactivatedSliderOption,
            activatedColorPalette = colorPalette,
            activated = isSliderActivated
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SliderSelectorWithTogglePreview() {
    MyPantryThemePreview() {
        SliderSelectorWithToggle(
            colorPalette = MaterialTheme.colorScheme.colorPalettes.blue,
            isSliderActivated = true,
            onToggle = {},
            text = "Toggle",
            sliderChoices = contrastChoices,
            onSlide = {},
            activatedSliderOption = Contrast.HIGH,
            deactivatedSliderOption = Contrast.STANDARD
        )
    }
}