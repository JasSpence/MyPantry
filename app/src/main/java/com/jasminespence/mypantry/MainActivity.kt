package com.jasminespence.mypantry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jasminespence.mypantry.data.PantryRepo
import com.jasminespence.mypantry.ui.compose.MainNavHost
import com.jasminespence.mypantry.ui.compose.NavBar
import com.jasminespence.mypantry.ui.compose.TopBar
import com.jasminespence.mypantry.ui.theme.MyPantryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPantryApp()
        }
    }
}

@Composable
fun MyPantryApp() {
    MyPantryTheme(dynamicColor = false) {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val context = LocalContext.current
        val viewModel: MainViewModel = viewModel(
            factory = MainViewModelFactory(
                PantryRepo(context = context)
            )
        )
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar(
                    height = 100.dp,
                    stepHeight = 10.dp,
                    stepLength = 40.dp,
                    color = MaterialTheme.colorScheme.primary,
                    navController = navController,
                    currentDestination = currentDestination
                )
            },
            bottomBar = {
                Box (
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    NavBar(
                        navController = navController,
                        currentDestination = currentDestination,
                        modifier = Modifier.padding(10.dp, 0.dp)
                    )
                }
            }
        ) { innerPadding ->
            MainNavHost(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_5,
)
@Composable
fun TwoTreesAppPreview() {
    MyPantryApp()
}