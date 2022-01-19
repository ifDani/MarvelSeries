package com.example.marvelseries.presentation.ui.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor() : ViewModel() {
    val somethingLoading: MutableState<Boolean> = mutableStateOf(true)

    init {
        try {

        } catch (e: Exception) {
            somethingLoading.value = false
        }
    }
}