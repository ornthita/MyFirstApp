package com.example.myfirstapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(AppUIState())
    val uiState: StateFlow<AppUIState> = _uiState.asStateFlow()

    private var currentIndex = 0

    fun updateChar(i: Int) {
        currentIndex += i
        if (currentIndex < firstIndex) {
            currentIndex = lastIndex
        } else if (currentIndex > lastIndex) {
            currentIndex = firstIndex
        }
        _uiState.update { currentState ->
            currentState.copy(
                currentCharShow = letter[currentIndex].toString()
                ) }
    }

    fun updateText(ch: String) {
        _uiState.update { currentState ->
            currentState.copy(
                currentTextShow = currentState.currentTextShow + ch
            ) }
    }
}