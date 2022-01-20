package com.example.marvelseries.presentation.ui.characters

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelseries.data.repository.MarvelRepository
import com.example.marvelseries.domain.model.CharactersResponse
import com.example.marvelseries.util.DataHolder
import com.example.marvelseries.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val repository: MarvelRepository) : ViewModel() {
    val isLoading: MutableState<Boolean> = mutableStateOf(false)
    var characterList:SnapshotStateList<CharactersResponse.Data.Result> = mutableStateListOf()
    var offset = 20
    init {
        try {
            characterList.addAll(DataHolder.argument as ArrayList<CharactersResponse.Data.Result>)
            DataHolder.argument = null
        } catch (e: Exception) {
            Log.e("Error", "$e" )
        }
    }

    //Called when pagination
    fun getCharacters() {
        isLoading.value = true
        viewModelScope.launch(Dispatchers.Main) {
            repository.getCharacters(offset = offset).collect { result ->
                when (result) {
                    is Resource.Success -> {

                        result.data?.let {
                            characterList.addAll(it)
                        }

                        isLoading.value = false

                    }
                    is Resource.Loading -> {
                        isLoading.value = true
                    }
                    is Resource.Error -> {
                        isLoading.value = false
//                        Toast.makeText(App.instance, "No hay datos", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}