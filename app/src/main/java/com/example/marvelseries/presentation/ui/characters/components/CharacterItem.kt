package com.example.marvelseries.presentation.ui.characters.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.marvelseries.domain.model.CharactersResponse
import com.example.marvelseries.presentation.ui.theme.attrCharList
import com.example.marvelseries.presentation.ui.theme.nameCharacter

@Composable
fun CharacterItem(character: CharactersResponse.Data.Result) {

    Box(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .aspectRatio(1f)) {

        Image(painter = rememberImagePainter(data = "${character.thumbnail.path}.${character.thumbnail.extension}"),contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize(), contentDescription = null )

        Column(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.5f),
                        Color.Black.copy(alpha = 0.8f),
                    )
                )
            ).padding(horizontal = 10.dp).padding(bottom = 5.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom, modifier = Modifier.weight(1f).fillMaxWidth()) {
                Text(text = "Pelis: ${character.series.items.size}", style = attrCharList)
                Text(text = "Comics: ${character.comics.items.size}", style = attrCharList)

            }
            Text(text = character.name, style = nameCharacter)
        }
    }
}