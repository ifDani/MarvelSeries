package com.example.marvelseries.presentation.ui.detail

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelseries.presentation.ui.detail.components.ComicsPage
import com.example.marvelseries.presentation.ui.detail.components.ContentPage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

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

    BackHandler {
        if (state.currentPage == 1){
            coroutineScope.launch {
                state.animateScrollToPage(0)
            }
        } else navController.navigateUp()
    }

    detailViewModel.heroDetail.value?.let {
        VerticalPager(count = 2, state = state) { page ->

            when (page) {
                0 -> ContentPage(coroutineScope, state, heroDetail = it, series = detailViewModel.series)
                1 -> ComicsPage(coroutineScope, state, comics = detailViewModel.comics)
            }

        }
    }


}




        