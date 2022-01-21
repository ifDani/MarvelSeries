package com.example.marvelseries.presentation.ui.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val items = listOf(
        "Sort By",
        "Name A-Z",
        "Name Z-A",
        "Last Modified",
        "First Modified",
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "Menu", style = titleStyle)

            Box(modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .clickable(onClick = { expanded = true })
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xff261858))
                        .padding(vertical = 10.dp, horizontal = 8.dp)
                ) {

                    Text(
                        items[selectedIndex],
                        maxLines = 1,
                        modifier = Modifier.weight(1f),
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 13.sp
                    )
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "", modifier = if (expanded) Modifier.rotate(180f) else Modifier)

                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.background(Color(0xff261858))
                ) {
                    items.drop(1).forEachIndexed { index, s ->
                        DropdownMenuItem(onClick = {
                            selectedIndex = index + 1
                            expanded = false
                            charactersViewModel.offset = 0
                            charactersViewModel.getCharacters(true, index = index)
                        }) {
                            Text(
                                text = s,
                                color = Color.White, fontSize = 13.sp
                            )
                        }
                    }
                }
            }
        }


        LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(vertical = 8.dp, horizontal = 5.dp)) {
            itemsIndexed(items = charactersViewModel.characterList) { index, item ->
                CharacterItem(item, click = {
                    navController.navigate("detail/${item.id}")
                })

                if (index > charactersViewModel.offset - 6) {
                    charactersViewModel.getCharacters(false, if (selectedIndex <= 0) 0 else (selectedIndex -1))
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

