package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.CategoryType

object LocalDataCategoryProvider {
    val categories = listOf(
        Category(
            name = R.string.category_parks,
            image = R.drawable.park_category,
            categoryType = CategoryType.Parks
        ),
        Category(
            name = R.string.category_museums,
            image = R.drawable.museum_category,
            categoryType = CategoryType.Museums
        ),
        Category(
            name = R.string.category_establishments,
            image = R.drawable.establishment_category,
            categoryType = CategoryType.Establishments
        )
    )
}