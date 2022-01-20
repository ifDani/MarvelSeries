package com.example.marvelseries.presentation.ui.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.marvelseries.R
import com.example.marvelseries.presentation.ui.theme.descHeroDetail
import com.example.marvelseries.presentation.ui.theme.nameHeroDetail
import com.example.marvelseries.presentation.ui.theme.sectionHeroTitle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun ContentPage(coroutineScope: CoroutineScope, state: PagerState) {
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
            painter = painterResource(id = R.drawable.test),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),
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
                )
                .padding(horizontal = 28.dp),
            verticalArrangement = Arrangement.Bottom,

            ) {
            Text(
                text = "SPIDER-MAN",
                style = nameHeroDetail,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
            )
            Text(text = "Descripción", style = sectionHeroTitle, modifier = Modifier.padding(bottom = 10.dp))
            Text(
                text = "Lorem ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since.",
                style = descHeroDetail(),
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(text = "Pelis / Series", style = sectionHeroTitle, modifier = Modifier.padding(bottom = 15.dp))
                Text(text = "Ver más", style = descHeroDetail(Color(0xFFCACACA)))

            }

            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(8) {
                    Image(
                        painter = painterResource(id = R.drawable.test),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(100.dp)
                            .width(65.dp),
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

    }
}