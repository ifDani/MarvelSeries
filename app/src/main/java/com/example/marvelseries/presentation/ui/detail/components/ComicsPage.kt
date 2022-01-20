package com.example.marvelseries.presentation.ui.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.marvelseries.R
import com.example.marvelseries.presentation.ui.theme.nameHeroDetail
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope

@ExperimentalPagerApi
@Composable
fun ComicsPage(coroutineScope: CoroutineScope, state: PagerState) {
    val stateHorizontal = rememberPagerState()
    val coroutineScopeHorizontal = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 1f),
                        Color.Black.copy(alpha = 0.93f),
                        Color.Transparent,
                    )
                )
            ),
        verticalArrangement = Arrangement.Center,

        ) {
        Box {

            Image(
                painter = painterResource(id = R.drawable.bg_comics),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "COMICS", style = nameHeroDetail, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.dp)
                )

                HorizontalPager(
                    count = 6,
                    state = stateHorizontal,
                    contentPadding = PaddingValues(horizontal = 32.dp)
                ) { page ->

                    //TODO: call list element index using currentPage
                    ComicItem(image = "", name = "")

                }
            }


        }
    }
}