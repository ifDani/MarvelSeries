package com.example.marvelseries.presentation.ui.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.marvelseries.domain.model.CharactersResponse
import com.example.marvelseries.presentation.ui.theme.attrCharList
import com.example.marvelseries.presentation.ui.theme.nameCharacter
import com.example.marvelseries.presentation.ui.theme.titleStyle

@ExperimentalFoundationApi
@Composable
fun CharactersScreen(
    navController: NavController,
    charactersViewModel: CharactersViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 15.dp)
    ) {
        Text(text = "Menu", style = titleStyle, modifier = Modifier.padding(top = 48.dp, bottom = 10.dp))

        LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(vertical = 8.dp, horizontal = 5.dp)) {

            items(items = charactersViewModel.characterList) { item ->
                CharacterItem(item)
            }
        }
        

    }
}

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