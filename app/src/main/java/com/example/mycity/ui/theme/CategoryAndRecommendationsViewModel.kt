package com.example.mycity.ui.theme

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalDataRecommendationsProvider
import com.example.mycity.model.CategoryType
import com.example.mycity.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CategoryAndRecommendationsUiState(
    val recommendationsList: List<Recommendation> = emptyList(),
    val recommendation: Recommendation? = null
)

class CategoryAndRecommendationsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CategoryAndRecommendationsUiState())
    val uiState: StateFlow<CategoryAndRecommendationsUiState> = _uiState.asStateFlow()

    fun updateRecommendationsList(type: CategoryType) {
        val list = LocalDataRecommendationsProvider.recommendationsGroupedByType[type]
        _uiState.update { currentState ->
            currentState.copy(
                recommendationsList = list ?: emptyList()
            )
        }
    }

    fun updateRecommendation(recommendation: Recommendation) {
        _uiState.update { currentState ->
            currentState.copy(
                recommendation = recommendation
            )
        }
    }

}