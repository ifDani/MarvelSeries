package com.example.marvelseries.presentation.ui.characters

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.marvelseries.domain.model.CharactersResponse

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
        Text(text = "Menu", style = MaterialTheme.typography.body1, modifier = Modifier.padding(top = 48.dp, bottom = 10.dp))

        LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(vertical = 8.dp, horizontal = 5.dp)) {

            items(items = charactersViewModel.characterList) { item ->
                CharacterItem(item)
            }
        }
        

    }
}

@Composable
fun CharacterItem(character: CharactersResponse.Data.Result) {
    Log.v("miapp","${character.thumbnail.path}.${character.thumbnail.extension}")

    Box(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .aspectRatio(1f)) {
//        Spacer(modifier = Modifier.background(Color.Red))
        Image(painter = rememberImagePainter(data = "${character.thumbnail.path}.${character.thumbnail.extension}"),contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize(), contentDescription = null )
    }
}