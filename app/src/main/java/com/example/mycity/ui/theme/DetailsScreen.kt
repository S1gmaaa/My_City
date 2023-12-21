package com.example.mycity.ui.theme

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.mycity.R
import com.example.mycity.data.LocalDataRecommendationsProvider
import com.example.mycity.model.CategoryType

@Composable
fun DetailsScreen(
    uiState: CategoryAndRecommendationsUiState,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box {
            Image(
                painter = painterResource(
                    id = uiState.recommendation!!.image
                ),
                contentDescription = stringResource(id = uiState.recommendation.name),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp)
                    .sizeIn(32.dp, 32.dp)
                    .background(MaterialTheme.colorScheme.surface, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.navigate_back_arrow)
                )
            }
        }
        Text(
            text = stringResource(id = uiState.recommendation!!.name),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )
        Text(
            text = stringResource(id = uiState.recommendation.description),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (uiState.recommendation.workTime != null) {
            Text(
                text = stringResource(
                    id = R.string.work_time,
                    stringResource(id = uiState.recommendation.workTime)
                ),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        TextButton(
            onClick = {
                openMap(
                    context = context,
                    latitude = uiState.recommendation.location.latitude,
                    longitude = uiState.recommendation.location.longitude
                )
            },
            modifier = Modifier.padding(start = 4.dp)) {
            Text(text = stringResource(id = R.string.where_is_located))
        }
    }
}

fun openMap(context: Context, latitude: Double, longitude: Double) {
    val geoUri = Uri.parse("geo:$latitude,$longitude")
    val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
    try {
        startActivity(context, mapIntent, null)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "No application can handle this action.", Toast.LENGTH_LONG).show()
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    MyCityTheme {
        DetailsScreen(
            uiState = CategoryAndRecommendationsUiState(
                recommendation = LocalDataRecommendationsProvider
                    .recommendationsGroupedByType[CategoryType.Establishments]!!.first()
            ),
            onBackClick = {}
        )
    }
}