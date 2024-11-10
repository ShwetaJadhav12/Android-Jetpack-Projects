package com.example.locationappjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.locationappjetpack.ui.theme.LocationAppJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Enables edge-to-edge display

        setContent {
            val viewModel: LocationViewModel by viewModels()

            LocationAppJetpackTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MyApp(Modifier.padding(innerPadding), viewModel)
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier, viewModel: LocationViewModel) {
    val context = LocalContext.current
    val locationUtils = LocationUtils(context)  // Instance of LocationUtils with app context

    // Pass the viewModel to the DisplayLocation function
    DisplayLocation(
        locationUtils = locationUtils,
        viewModel = viewModel // Pass the viewModel here
    )
}
