package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.animation.core.animate
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.ui.theme.ColorPalette
import com.jasminespence.mypantry.ui.theme.Contrast
import com.jasminespence.mypantry.ui.theme.Dimensions
import com.jasminespence.mypantry.ui.theme.contrastChoices
import com.jasminespence.mypantry.ui.theme.grey
import kotlinx.coroutines.launch
import kotlin.Enum


@Composable
fun <E : Enum<E>> RowSelector(
    modifier: Modifier = Modifier,
    choices: List<E>,
    setOption: (E) -> Unit,
    currentOption: E?,
    colorPalette: ColorPalette
) {
    val currentOptionState = rememberUpdatedState(currentOption)
    var selectorOffset by remember { mutableFloatStateOf(0f) }
    var optionBoxWidth by remember { mutableFloatStateOf(0f) }
    val optionBoxOffsets = remember { mutableStateListOf(*Array(choices.size) { 0f } ) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(currentOption, optionBoxOffsets.toList()) {
        val index = currentOption?.ordinal ?: -1
        if (index != -1) {
            animate(
                initialValue = selectorOffset,
                targetValue = optionBoxOffsets[index]
            ) { value, _ ->
                selectorOffset = value
            }
        }
    }

    fun changeOption(
        option: E
    ) {
        setOption(option)
        val target = optionBoxOffsets[option.ordinal]
        scope.launch {
            animate(
                initialValue = selectorOffset,
                targetValue = target
            ) { value, _ ->
                selectorOffset = value
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.ACTION_BUTTON_DIMS.dp)
            .clip(RoundedCornerShape(Dimensions.CORNER_ROUNDING.dp))
            .background(colorPalette.surface)
            .pointerInput(Unit) {
                var totalDrag = 0f
                detectHorizontalDragGestures(
                    onDragEnd = {
                        val currentOption = currentOptionState.value
                        val canMoveRight = currentOption != null && currentOption.ordinal < choices.size - 1
                        val canMoveLeft = currentOption != null && currentOption.ordinal > 0
                        if (totalDrag > 0) {
                            if (canMoveRight) changeOption(choices[currentOption.ordinal + 1])
                        } else if (totalDrag < 0) {
                            if (canMoveLeft) changeOption(choices[currentOption.ordinal - 1])
                        }
                        totalDrag = 0f
                    }
                ) { _, dragAmount ->
                    totalDrag += dragAmount
                }
            }
    ) {
        val density = LocalDensity.current
        RowSelectorSelectionBox(
            modifier = Modifier
                .width(with(density) { optionBoxWidth.toDp() })
                .offset(with(density) { selectorOffset.toDp() }),
            colorPalette = colorPalette
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            choices.forEach { contrast ->
                val isCurrentContrast = currentOption == contrast
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable(
                            onClick = {
                                changeOption(contrast)
                            }
                        )
                        .onGloballyPositioned { coordinates ->
                            optionBoxOffsets[contrast.ordinal] = coordinates.positionInParent().x
                            optionBoxWidth = coordinates.size.width.toFloat()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    val label = contrast.name.lowercase().replaceFirstChar(Char::titlecase)
                    Text(
                        text = label,
                        style = MaterialTheme.typography.titleMedium,
                        color = if (isCurrentContrast) colorPalette.onColor else colorPalette.onSurface
                    )
                }
            }
        }
    }
}

@Composable
fun RowSelectorSelectionBox(
    modifier: Modifier = Modifier,
    colorPalette: ColorPalette
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(Dimensions.CORNER_ROUNDING.dp))
            .background(colorPalette.color)
    )
}

@Preview(showBackground = true)
@Composable
fun RowSelectorPreview() {
    RowSelector(
        setOption = {},
        choices = contrastChoices,
        currentOption = Contrast.HIGH,
        colorPalette = MaterialTheme.colorScheme.grey
    )
}