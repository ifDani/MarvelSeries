package com.example.marvelseries.presentation.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.marvelseries.presentation.ui.characters.CharactersScreen
import com.example.marvelseries.presentation.ui.detail.DetailScreen
import com.example.marvelseries.presentation.ui.splash.SplashScreen
import com.example.marvelseries.presentation.ui.theme.MarvelSeriesTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

//To enable dependency Injection in all hierarchy of the activity
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelSeriesTheme {
                ProvideWindowInsets {
                    val navController = rememberNavController()

                    //Parent Layout, vertical and horizontal size entire screen
                    Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {
                        Navigation(navController = navController)
                    }
                }

            }
        }
    }


}

//Handle Navigation
@ExperimentalPagerApi
@ExperimentalFoundationApi
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
        composable("detail/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )) {

            DetailScreen(navController = navController)
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