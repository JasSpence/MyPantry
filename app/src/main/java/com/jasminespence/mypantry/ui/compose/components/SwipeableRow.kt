package com.jasminespence.mypantry.ui.compose.components

import androidx.compose.animation.core.animate
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.jasminespence.mypantry.R
import com.jasminespence.mypantry.ui.theme.Dimensions
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun SwipeableRow(
    modifier: Modifier = Modifier,
    hiddenBox: @Composable (Color) -> Unit,
    hiddenBoxColor: Color,
    isSwipedRow: Boolean,
    setSwipedRow: () -> Unit,
    resetSwipedRow: () -> Unit,
    rounded: Boolean = false,
    rowContent: @Composable () -> Unit
) {
    var offsetX by remember { mutableFloatStateOf(0f) }
    var revealWidth by remember { mutableFloatStateOf(0f) }
    val scope = rememberCoroutineScope()

    val shapeModifier = if (rounded) Modifier.clip(RoundedCornerShape(Dimensions.CORNER_ROUNDING)) else Modifier

    LaunchedEffect(isSwipedRow, revealWidth) {
        if (revealWidth == 0f) return@LaunchedEffect
        val target = if (isSwipedRow) revealWidth else 0f
        animate(offsetX, target) { value, _ -> offsetX = value }
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .then(shapeModifier)
                .background(hiddenBoxColor),
            contentAlignment = Alignment.CenterStart
        ) {
            Box(
                modifier = Modifier
                    .onGloballyPositioned { coordinates ->
                        revealWidth = coordinates.size.width.toFloat()
                    }
            ) {
                hiddenBox(hiddenBoxColor)
            }
        }
        Box(
            modifier = Modifier
                .offset { IntOffset(offsetX.roundToInt(), 0) }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragEnd = {
                            val target = if (offsetX > revealWidth / 2) revealWidth else 0f
                            if (target == 0f) resetSwipedRow() else setSwipedRow()
                            scope.launch {
                                animate(offsetX,target) { value, _ -> offsetX = value }
                            }
                        }
                    ) { _, dragAmount ->
                        offsetX = (offsetX + dragAmount).coerceIn(0f, revealWidth)
                    }
                }
                .then(shapeModifier)
        ) {
            rowContent()
        }
    }
}

@Composable
fun DeleteRowBox(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .clickable(onClick = onClick)
            .background(color)
            .padding(Dimensions.SUB_PADDING.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.delete_label),
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}