package com.example.marvelseries.presentation.ui.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.marvelseries.R
import com.example.marvelseries.presentation.ui.theme.comicNameStyle

@Composable
fun ComicItem(image: String, name: String) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.tes2),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 6.dp, vertical = 50.dp)
            ,
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 6.dp, vertical = 50.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.5f),
                            Color.Black.copy(alpha = 0.8f),
                        )
                    )
                ),verticalArrangement = Arrangement.Bottom
        ) {
            Text(text = "Spiderman: La saga del clon", style = comicNameStyle,
                textAlign = TextAlign.Center, modifier = Modifier.padding(20.dp))
        }


    }
}