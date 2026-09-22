package com.example.jualan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jualan.ui.screen.BasicInfoScreen
import com.example.jualan.ui.screen.HubungiKamiScreen
import com.example.jualan.ui.theme.JualanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                JualanNavigation()
            }
        }
    }
}

@Composable
fun JualanNavigation() {
    val navController = rememberNavController()

    Surface(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = "basic_info"
        ) {
            composable("basic_info") {
                BasicInfoScreen(navController = navController)
            }
            composable("form_screen") {
                HubungiKamiScreen(navController = navController)
            }
        }
    }
}
