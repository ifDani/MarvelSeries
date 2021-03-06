package com.example.marvelseries.presentation.ui.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.marvelseries.R
import com.example.marvelseries.domain.model.ComicsResponse
import com.example.marvelseries.presentation.ui.theme.nameHeroDetail
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Composable
fun ComicsPage(comics: SnapshotStateList<ComicsResponse.Data.Result>) {
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
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth

            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = stringResource(R.string.comics), style = nameHeroDetail, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.dp, start = 32.dp)
                )

                HorizontalPager(
                    count = comics.count(),
                    state = stateHorizontal,
                    contentPadding = PaddingValues(horizontal = 32.dp)
                ) { page ->

                    //TODO: call list element index using currentPage
                    ComicItem(comic = comics[page], calculateCurrentOffsetForPage(page).absoluteValue)

                }
            }


        }
    }
}