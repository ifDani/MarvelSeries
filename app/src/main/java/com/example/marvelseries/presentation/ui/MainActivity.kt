package com.example.marvelseries.presentation.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvelseries.presentation.ui.characters.CharactersScreen
import com.example.marvelseries.presentation.ui.splash.SplashScreen
import com.example.marvelseries.presentation.ui.theme.MarvelSeriesTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

//To enable dependency Injection in all hierarchy of the activity
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelSeriesTheme {
                ProvideWindowInsets {
                    val systemUiController = rememberSystemUiController()
                    SideEffect {
                        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
                    }

                    val navController = rememberNavController()
                    val currentRoute =
                        navController.currentBackStackEntryFlow.collectAsState(initial = navController.currentBackStackEntry)

                    //Parent Layout, vertical and horizontal size entire screen
                    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
                        Navigation(navController = navController)
                    }
                }

            }
        }
    }


}

//Handle Navigation
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("characters_screen") {
            CharactersScreen(
                navController = navController,
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MarvelSeriesTheme {
        Greeting("Android")
    }
}