package com.example.marvelseries.presentation.ui.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelseries.data.repository.MarvelRepository
import com.example.marvelseries.domain.model.CharactersResponse
import com.example.marvelseries.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: MarvelRepository) : ViewModel() {
    val somethingLoading: MutableState<Boolean> = mutableStateOf(true)

    //To recompose when elements changed: SnapshotStateList
    val characterList: ArrayList<CharactersResponse.Data.Result> = arrayListOf()
    init {
        try {
            getCharacters()
        } catch (e: Exception) {
            somethingLoading.value = false
        }
    }


    fun getCharacters() {

        viewModelScope.launch(Dispatchers.Main) {
            repository.getCharacters(orderBy = "name").collect { result ->
                when (result) {
                    is Resource.Success -> {

                        result.data?.let {
                            characterList.clear()
                            characterList.addAll(it)
                        }
                        somethingLoading.value = false

                    }
                    is Resource.Loading -> {
                        somethingLoading.value = true
                    }
                    is Resource.Error -> {
                        somethingLoading.value = false
//                        Toast.makeText(App.instance, "No hay datos", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}