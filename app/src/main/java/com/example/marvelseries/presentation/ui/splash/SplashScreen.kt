package com.example.marvelseries.presentation.ui.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelseries.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashScreenViewModel = hiltViewModel()
    ) {
        val scale = remember { androidx.compose.animation.core.Animatable(0f) }
        //Scale effect on load splash
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 1.1f,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = { OvershootInterpolator(4f).getInterpolation(it) })
            )

            while (splashViewModel.somethingLoading.value) {
                delay(300)
            }
            navController.navigate("account_stats_screen")
        }

        // Image
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()

        ) {
            Image(painter = painterResource(id = R.drawable.bg_splash), contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop )

            Image(
                painter = painterResource(R.drawable.marvel_logo),
                contentDescription = "Logo", modifier = Modifier.scale(scale.value)
            )

        }
    }