package com.example.marvelseries.presentation.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelseries.presentation.ui.detail.components.ComicsPage
import com.example.marvelseries.presentation.ui.detail.components.ContentPage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun DetailScreen(
    navController: NavController,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    val state = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

//    LaunchedEffect(key1 = true) {
//        detailViewModel.getDetailHero()
//    }

    VerticalPager(count = 2, state = state) { page ->

        when (page) {
            0 -> ContentPage(coroutineScope, state)
            1 -> ComicsPage(coroutineScope, state)
        }

    }


}




        