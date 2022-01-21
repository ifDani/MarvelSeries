package com.example.marvelseries.presentation.ui.series.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.example.marvelseries.domain.model.SeriesResponse
import com.example.marvelseries.presentation.ui.theme.comicNameStyle
import com.google.android.material.animation.AnimationUtils.lerp

@SuppressLint("RestrictedApi")
@Composable
fun SeriesItem(serie: SeriesResponse.Data.Result, calculateCurrentOffsetForPage: Float) {
    Column(Modifier.graphicsLayer {
        lerp(0.85f, 1f, 1f - calculateCurrentOffsetForPage.coerceIn(0f, 1f)).also { scale ->
            scaleX = scale
            scaleY = scale
        }
        alpha = lerp(0.5f, 1f, 1f - calculateCurrentOffsetForPage.coerceIn(0f, 1f))
    }) {
        Image(
            painter = rememberImagePainter(data = "${serie.thumbnail.path}.${serie.thumbnail.extension}",
                builder = {
                    transformations(
                        RoundedCornersTransformation(20f)
                    )
                }),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxHeight(0.7f).padding(horizontal = 6.dp, vertical = 20.dp)
            ,
            contentDescription = null
        )

        Text(text = serie.title, style = comicNameStyle,
            textAlign = TextAlign.Center, modifier = Modifier.padding(20.dp))

    }
}