package com.example.marvelseries.presentation.ui.detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelseries.data.repository.MarvelRepository
import com.example.marvelseries.domain.model.CharacterDetailResponse
import com.example.marvelseries.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MarvelRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val isLoading: MutableState<Boolean> = mutableStateOf(false)
    var characterDetail: SnapshotStateList<CharacterDetailResponse.Data.Result> = mutableStateListOf()

    var heroDetail: MutableState<CharacterDetailResponse.Data.Result>? = null

    private val id: Int = savedStateHandle.get("id") ?: 0

    init {
        try {
//            getDetailHero()

        } catch (e: Exception) {
            Log.e("Error", "$e")
        }
    }

    fun getDetailHero() {
        isLoading.value = true
        viewModelScope.launch(Dispatchers.Main) {
            repository.getDetailHero(characterId = id).collect { result ->
                when (result) {
                    is Resource.Success -> {

                        result.data?.let {
                            heroDetail?.value = it[0]
                            Log.v("miapp","el detalle ${it[0].name}") //Esto si devuelve un dato
                            Log.v("miapp","el detalle ${heroDetail?.value?.name}")//Esto no devuelve nada
//                            characterDetail.addAll(it)
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