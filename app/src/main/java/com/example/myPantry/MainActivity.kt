package com.example.myPantry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.myPantry.ui.theme.MyPantryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting("Jasmine")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text("Hello $name!")
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_5,
)
@Composable
fun TwoTreesAppPreview() {
    Greeting("Jasmine")
}