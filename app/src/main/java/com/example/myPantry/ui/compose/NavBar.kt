package com.example.myPantry.ui.compose

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.myPantry.MainViewModel


@Composable
fun NavBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        navBarScreens.forEach { screen ->
            val label = stringResource(screen.labelId)
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(screen.icon),
                        contentDescription = label,
                        modifier = modifier,
                        tint = Color.Unspecified
                    )
                },
                label = {
                    Text(label)
                },
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
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