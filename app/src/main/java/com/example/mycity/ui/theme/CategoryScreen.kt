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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.LocalDataCategoryProvider
import com.example.mycity.model.Category
import com.example.mycity.model.CategoryType


@Composable
fun CategoryScreen(
    categories: List<Category>,
    onCategoryClicked: (CategoryType) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        categories.forEach {
            CategoryCard(
                category = it,
                onCategoryItemClicked = { type -> onCategoryClicked(type) },
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(
    category: Category,
    onCategoryItemClicked: (CategoryType) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onCategoryItemClicked(category.categoryType) },
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = stringResource(id = category.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(110.dp)
                    .width(110.dp)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = category.name),
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}

@Preview
@Composable
fun CategoryCardPreview() {
    MyCityTheme {
        CategoryCard(
            category = LocalDataCategoryProvider.categories[0],
            onCategoryItemClicked = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    MyCityTheme {
        CategoryScreen(
            categories = LocalDataCategoryProvider.categories,
            onCategoryClicked = {}
        )
    }
}