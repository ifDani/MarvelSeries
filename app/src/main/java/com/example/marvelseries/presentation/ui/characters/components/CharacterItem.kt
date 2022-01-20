package com.example.marvelseries.presentation.ui.characters.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import coil.transform.RoundedCornersTransformation
import com.example.marvelseries.domain.model.CharactersResponse
import com.example.marvelseries.presentation.ui.theme.attrCharList
import com.example.marvelseries.presentation.ui.theme.nameCharacter
import java.util.*

@Composable
fun CharacterItem(character: CharactersResponse.Data.Result, click: () -> Unit) {

    Box(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .aspectRatio(1f)
        .clickable {
            click()
        }) {

        //Shadow Card
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 3.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(getRandomColor()))
        )

        //Main Hero image
        Image(painter = rememberImagePainter(data = "${character.thumbnail.path}.${character.thumbnail.extension}", builder = {transformations(RoundedCornersTransformation(bottomRight = 30f, bottomLeft = 25f, topRight = 30f))}),contentScale = ContentScale.Crop, modifier = Modifier
            .padding(bottom = 5.dp, end = 5.dp)
            .fillMaxSize(), contentDescription = null )

        //Content info
        Column(modifier = Modifier
            .padding(bottom = 5.dp, end = 5.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.5f),
                        Color.Black.copy(alpha = 0.8f),
                    )
                )
            )
            .padding(horizontal = 10.dp)
            .padding(bottom = 5.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom, modifier = Modifier
                .weight(1f)
                .fillMaxWidth()) {
                Text(text = "Pelis: ${character.series.items.size}", style = attrCharList)
                Text(text = "Comics: ${character.comics.items.size}", style = attrCharList)

            }
            Text(text = character.name, style = nameCharacter)
        }
    }

}
fun getRandomColor(): Int {
    val rnd = Random()
    return android.graphics.Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
}