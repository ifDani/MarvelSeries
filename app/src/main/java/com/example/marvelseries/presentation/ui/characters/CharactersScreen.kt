package com.example.marvelseries.presentation.ui.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelseries.presentation.ui.characters.components.CharacterItem
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
            itemsIndexed(items = charactersViewModel.characterList) { index, item ->
                CharacterItem(item, click = {
                    navController.navigate("detail/${item.id}")
                })

                if (index > charactersViewModel.offset - 6) {
                    charactersViewModel.getCharacters()
                    charactersViewModel.offset += 20
                }

            }
            //TODO: Center CircularProgress in Grid to advise user we are loading more data
//            if (charactersViewModel.isLoading.value) {
//                item {
//                    Box(modifier = Modifier.fillMaxSize()){
//                        CircularProgressIndicator()
//                    }
//                }
//            }

        }
        

    }
}

