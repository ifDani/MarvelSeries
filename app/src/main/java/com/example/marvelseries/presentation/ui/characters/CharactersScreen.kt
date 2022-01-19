package com.example.marvelseries.presentation.ui.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelseries.R

@Composable
fun CharactersScreen(
    navController: NavController,
    charactersViewModel: CharactersViewModel = hiltViewModel()
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()

        ) {
            Color(R.color.black)
            Column() {
                charactersViewModel.characterList.forEach {

                    Text(text = it.name)
                }
            }

//            Image(painter = painterResource(id = R.drawable.bg_splash), contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop )
//
//            Image(
//                painter = painterResource(R.drawable.marvel_logo),
//                contentDescription = "Logo"
//            )

        }
    }