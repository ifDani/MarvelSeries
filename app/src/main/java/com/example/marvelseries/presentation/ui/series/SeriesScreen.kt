package com.example.marvelseries.presentation.ui.series

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelseries.R
import com.example.marvelseries.presentation.ui.series.components.SeriesItem
import com.google.accompanist.pager.*
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Composable
fun SeriesScreen(
    navController: NavController,
    seriesViewModel: SeriesViewModel = hiltViewModel()
) {
    val state = rememberPagerState()
//    val coroutineScope = rememberCoroutineScope()
//
//    BackHandler {
//        if (state.currentPage == 1){
//            coroutineScope.launch {
//                state.animateScrollToPage(0)
//            }
//        } else navController.navigateUp()
//    }
//

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg_series),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )

        Column(modifier = Modifier.fillMaxSize()) {
            IconButton(onClick = { navController.navigateUp()}, modifier = Modifier.padding(top = 50.dp)) {
                Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White, modifier = Modifier
                    .padding(10.dp))
            }


            HorizontalPager(
                count = seriesViewModel.series.count(),
                state = state,
                contentPadding = PaddingValues(horizontal = 32.dp), modifier =
                Modifier.weight(1f)
            ) { page ->

                SeriesItem(serie = seriesViewModel.series[page], calculateCurrentOffsetForPage(page).absoluteValue)

            }
            HorizontalPagerIndicator(
                activeColor = Color.Red, inactiveColor = Color.White, pagerState = state,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 10.dp)
            )
        }



    }
}