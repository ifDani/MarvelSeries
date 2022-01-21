package com.example.marvelseries.presentation.ui.detail.components

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.example.marvelseries.R
import com.example.marvelseries.domain.model.CharacterDetailResponse
import com.example.marvelseries.domain.model.SeriesResponse
import com.example.marvelseries.presentation.ui.theme.descHeroDetail
import com.example.marvelseries.presentation.ui.theme.nameHeroDetail
import com.example.marvelseries.presentation.ui.theme.sectionHeroTitle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun ContentPage(
    coroutineScope: CoroutineScope,
    state: PagerState,
    heroDetail: CharacterDetailResponse.Data.Result,
    series: SnapshotStateList<SeriesResponse.Data.Result>,
    id:Number,
    navController: NavController
) {
    val interactionSource2 = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.5f),
                        Color.Black.copy(alpha = 0.8f),
                    )
                )
            )
    ) {

        Image(
            painter = rememberImagePainter(data = heroDetail.thumbnail.path + "." + heroDetail.thumbnail.extension),
            contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.93f),
                            Color.Black.copy(alpha = 1f),
                        )
                    )
                ),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Column(modifier = Modifier.padding(horizontal = 28.dp)) {
                Text(
                    text = heroDetail.name,
                    style = nameHeroDetail,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                )
                Text(
                    text = stringResource(R.string.description),
                    style = sectionHeroTitle,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text( //I could hide the description field, but I put no description
                    text = if (heroDetail.description.isEmpty()) stringResource(R.string.no_desc) else heroDetail.description,
                    style = descHeroDetail(),
                    textAlign = TextAlign.Start, color = Color.White,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(R.string.movies_series), style = sectionHeroTitle)

                    Text(text = stringResource(R.string.see_more),
                        style = descHeroDetail(Color(0xFFCACACA)),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .clickable(interactionSource = interactionSource2, indication = null) {
                                navController.navigate("series/$id")
                            })
                }
            }


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()).padding(horizontal = 10.dp)
            ) {
                series.forEach { item ->
                    Image(
                        painter = rememberImagePainter(data = "${item.thumbnail.path}.${item.thumbnail.extension}",
                            builder = {
                                transformations(
                                    RoundedCornersTransformation(20f)
                                )
                            }),

                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(100.dp)
                            .width(65.dp)
                            .padding(horizontal = 4.dp),
                        contentDescription = null
                    )
                }
            }

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .clickable(interactionSource = interactionSource2, indication = null) {
                    coroutineScope.launch {
                        state.animateScrollToPage(1)
                    }
                }) {
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color.White)
            }
        }
        IconButton(onClick = { navController.navigateUp()}, modifier = Modifier.padding(top = 50.dp)) {
            Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White, modifier = Modifier
                .padding(10.dp))
        }
    }
}