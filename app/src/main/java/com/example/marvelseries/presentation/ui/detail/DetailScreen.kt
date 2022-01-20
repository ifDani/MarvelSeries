package com.example.marvelseries.presentation.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelseries.R
import com.example.marvelseries.presentation.ui.theme.descHeroDetail
import com.example.marvelseries.presentation.ui.theme.nameHeroDetail
import com.example.marvelseries.presentation.ui.theme.sectionHeroTitle

@Composable
fun DetailScreen(
    navController: NavController,
    detailViewModel: DetailViewModel = hiltViewModel()
) {

//
//    if (!detailViewModel.isLoading.value) {
//        Log.v("miapp","esto pasa ${detailViewModel.heroDetail?.value?.name}")
//        Text(text = detailViewModel.heroDetail?.value?.name ?: "", style = example )
//
//    }
//        Image(painter = ", builder = {transformations(
//            RoundedCornersTransformation(bottomRight = 30f, bottomLeft = 25f, topRight = 30f)
//        )}),contentScale = ContentScale.Crop, modifier = Modifier
//            .padding(bottom = 5.dp, end = 5.dp)
//            .fillMaxSize(), contentDescription = null )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.Black.copy(alpha = 0.5f),
                    Color.Black.copy(alpha = 0.8f),
                )
            )
        )) {

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
            Text(text = "SPIDERMAN", style = nameHeroDetail,textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Text(text = "Descripción", style = sectionHeroTitle)
            Text(text = "Lorem ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since.", style = descHeroDetail(),textAlign = TextAlign.Start)
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom,modifier = Modifier
                .fillMaxWidth()) {
                Text(text = "Pelis / Series", style = sectionHeroTitle)
                Text(text = "Ver más", style = descHeroDetail(Color(0xFFCACACA)))
            }

        }

    }
    


}