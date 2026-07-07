package com.example.wellnessdaily.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wellnessdaily.ui.state.WellnessUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class WellnessViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(WellnessUiState())
    val uiState: StateFlow<WellnessUiState> = _uiState.asStateFlow()

    fun toggleExpanded(id: Int) {

        val expandedItems = _uiState.value.expandedItems

        _uiState.value =
            if (id in expandedItems) {

                _uiState.value.copy(
                    expandedItems = expandedItems - id
                )

            } else {

                _uiState.value.copy(
                    expandedItems = expandedItems + id
                )
            }
    }
}