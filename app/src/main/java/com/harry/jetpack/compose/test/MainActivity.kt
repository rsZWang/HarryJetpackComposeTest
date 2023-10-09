package com.harry.jetpack.compose.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.harry.jetpack.compose.test.module.MakeAirportListPage
import com.harry.jetpack.compose.test.module.MakeProductDetailPage
import com.harry.jetpack.compose.test.module.MakeTopPage
import com.harry.jetpack.compose.test.ui.theme.HarryJetpackComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarryJetpackComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.Top.route
                    ) {
                        makeRoute(route = Routes.Top.route) {
                            MakeTopPage(navController)
                        }
                        makeRoute(route = Routes.AirportList.route) {
                            MakeAirportListPage(navController)
                        }
                        makeRoute(route = Routes.ProductDetail.route) {
                            MakeProductDetailPage()
                        }
                    }
                }
            }
        }
    }

    private fun NavGraphBuilder.makeRoute(route: String, content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit) {
        composable(
            route = route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                    animationSpec = tween(700)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                    animationSpec = tween(700)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                    animationSpec = tween(700)
                )
            },
            content = content
        )
    }
}

sealed class Routes(val route: String) {
    object Top : Routes("Top")
    object AirportList : Routes("AirportList")
    object ProductDetail : Routes("ProductDetail")
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HarryJetpackComposeTestTheme {
//        Greeting("Android")
//    }
//}