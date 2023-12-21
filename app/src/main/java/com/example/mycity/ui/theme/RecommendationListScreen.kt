package com.example.mycity.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.LocalDataRecommendationsProvider
import com.example.mycity.model.CategoryType
import com.example.mycity.model.Recommendation


@Composable
fun RecommendationListScreen(
    uiState: CategoryAndRecommendationsUiState,
    onRecommendationItemClicked: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        uiState.recommendationsList.forEach {
            RecommendationCard(
                recommendation = it,
                onRecommendationItemClicked = { recommendation ->
                    onRecommendationItemClicked(recommendation)
                },
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationCard(
    recommendation: Recommendation,
    onRecommendationItemClicked: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onRecommendationItemClicked(recommendation) },
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = recommendation.image),
                contentDescription = stringResource(id = recommendation.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(110.dp)
                    .width(110.dp)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = recommendation.name),
                style = MaterialTheme.typography.displaySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendationListScreenPreview() {
    MyCityTheme {
        RecommendationListScreen(
            uiState = CategoryAndRecommendationsUiState(
                recommendationsList = LocalDataRecommendationsProvider.recommendationsGroupedByType[CategoryType.Establishments]!!
            ),
            onRecommendationItemClicked = {}
        )
    }
}