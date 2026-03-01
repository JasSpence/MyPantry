package com.example.myPantry

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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myPantry.ui.compose.MainNavHost
import com.example.myPantry.ui.compose.NavBar
import com.example.myPantry.ui.compose.TopBar
import com.example.myPantry.ui.theme.MyPantryTheme

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
    MyPantryTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
//        val viewModel: MainViewModel = viewModel<MainViewModel>()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar(
                    height = 100.dp,
                    stepHeight = 10.dp,
                    stepLength = 40.dp,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 30.sp,
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