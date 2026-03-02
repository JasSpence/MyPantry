package com.example.myPantry.ui.compose

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController


@Composable
fun NavBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        navBarScreens.forEach { screen ->
            val label = stringResource(screen.labelId)
            val isSelected: Boolean = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = if (isSelected) {
                            painterResource(screen.selectedIcon)
                        } else {
                            painterResource(screen.unselectedIcon)
                        },
                        contentDescription = label,
                        modifier = modifier,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                },
                label = {
                    Text(
                        text = label,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 11.sp,
                        fontWeight = if (isSelected) {
                            FontWeight.Bold
                        } else {
                            FontWeight.Normal
                        }
                    )
                },
                selected = false, // to stop highlighting
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

