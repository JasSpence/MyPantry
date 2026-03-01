package com.example.myPantry.ui.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    height: Dp,
    stepHeight: Dp,
    stepLength: Dp,
    curveRadius: Dp = 24.dp,
    color: Color,
    fontSize: TextUnit,
    navController: NavController,
    currentDestination: NavDestination?
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

        Box(modifier = Modifier
            .height(stepHeight + curveRadius + curveRadius)
            .width(LocalWindowInfo.current.containerSize.width.dp - stepLength - curveRadius)
            .align(Alignment.BottomStart)
            .padding(10.dp)
        ) {
            // TODO: add usernames
            var titleMsg = "Welcome, User!"
            allScreens.forEach { screen ->
                if (currentDestination?.route == screen.route) {
                    titleMsg = stringResource(screen.labelId)
                }
            }
            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.headlineMedium,
                fontSize = fontSize,
                text = titleMsg
            )
        }

        Box(modifier = Modifier
            .height(stepHeight + curveRadius + curveRadius)
            .width(stepLength + curveRadius)
            .align(Alignment.BottomEnd)
            .padding(10.dp)
        ) {
            IconButton(
                onClick = {
                    navController.navigate(Screen.Profile.route) {
                        launchSingleTop = true
                    }
                },
                enabled = true
            ) {
                Icon(
                    painter = painterResource(Screen.Profile.unselectedIcon),
                    contentDescription = stringResource(Screen.Profile.labelId),
                    modifier = Modifier.fillMaxSize(),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
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