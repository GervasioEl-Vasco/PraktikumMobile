package com.example.jualan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jualan.ui.screen.DaftarProdukScreen
import com.example.jualan.ui.screen.DetailProductScreen
import com.example.jualan.ui.screen.HubungiKamiScreen
import com.example.jualan.ui.theme.JualanTheme
import com.example.jualan.ui.viewmodel.ProductViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                HomeNavigation()
            }
        }
    }
}

@Composable
fun HomeNavigation() {
    val navController = rememberNavController()
    val productViewModel: ProductViewModel = viewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(
            navController = navController,
            startDestination = "daftar_produk"
        ) {
            composable("daftar_produk") {
                DaftarProdukScreen(
                    navController = navController,
                    viewModel = productViewModel
                )
            }
            composable(
                route = "detail/{productId}",
                arguments = listOf(navArgument("productId") { type = NavType.IntType })
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                DetailProductScreen(
                    productId = productId,
                    navController = navController,
                    viewModel = productViewModel
                )
            }
            composable("form_screen") {
                HubungiKamiScreen(navController = navController)
            }
        }
    }
}
