package com.example.myPantry.ui.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.RoundedPolygon

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    height: Dp,
    stepHeight: Dp,
    stepLength: Dp,
    curveRadius: Dp = 24.dp,
    color: Color
) {
    val density = LocalDensity.current
    val stepHeightPx = with(density) { stepHeight.toPx() }
    val stepLengthPx = with(density) { stepLength.toPx() }
    val radiusPx = with(density) { curveRadius.toPx() }
    Box(modifier = modifier.height(height)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val totalWidth = size.width
            val totalHeight = size.height
            val baseWidth = totalWidth - stepLengthPx - (2 * radiusPx)
            val baseHeight = totalHeight - stepHeightPx - (2 * radiusPx)

            val path = Path().apply {
                moveTo(0f,0f)
                lineTo(0f, baseHeight)
                lineTo(baseWidth, baseHeight)
                arcTo(
                    rect = Rect(
                        left = baseWidth,
                        top = baseHeight,
                        right = baseWidth + radiusPx,
                        bottom = baseHeight + radiusPx
                    ),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                lineTo(baseWidth + radiusPx, totalHeight - radiusPx)
                arcTo(
                    rect = Rect(
                        left = baseWidth + radiusPx,
                        top = totalHeight - radiusPx,
                        right = baseWidth + (2 * radiusPx),
                        bottom = totalHeight
                    ),
                    startAngleDegrees = -180f,
                    sweepAngleDegrees = -90f,
                    forceMoveTo = false
                )
                lineTo(totalWidth, totalHeight)
                lineTo(totalWidth, 0f)
                close()
            }
            drawPath(path, color = color)
        }
    }
}

// Slanted
//val totalWidth = size.width
//val totalHeight = size.height
//val diagonalWidth = stepHeightPx // ensure 45 degree line
//val baseWidth = totalWidth - stepLengthPx - (2 * radiusPx) - diagonalWidth
//val baseHeight = totalHeight - stepHeightPx - (2 * radiusPx)
//
//val path = Path().apply {
//    moveTo(0f,0f)
//    lineTo(0f, baseHeight)
//    lineTo(baseWidth, baseHeight)
//    arcTo(
//        rect = Rect(
//            left = baseWidth,
//            top = baseHeight,
//            right = baseWidth + radiusPx,
//            bottom = baseHeight + radiusPx
//        ),
//        startAngleDegrees = -90f,
//        sweepAngleDegrees = 45f,
//        forceMoveTo = false
//    )
//    lineTo(baseWidth + radiusPx + diagonalWidth, totalHeight - radiusPx)
//    arcTo(
//        rect = Rect(
//            left = baseWidth + radiusPx + diagonalWidth,
//            top = totalHeight - radiusPx,
//            right = baseWidth + (2 * radiusPx) + diagonalWidth,
//            bottom = totalHeight
//        ),
//        startAngleDegrees = -45f,
//        sweepAngleDegrees = 90f,
//        forceMoveTo = false
//    )
//    lineTo(totalWidth, totalHeight)
//    lineTo(totalWidth, 0f)
//    close()
//}