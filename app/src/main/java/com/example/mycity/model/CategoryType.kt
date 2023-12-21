package com.example.mycity.model

import androidx.annotation.StringRes
import com.example.mycity.R

enum class CategoryType(@StringRes val title: Int) {
    Parks(R.string.category_parks),
    Museums(R.string.category_museums),
    Establishments(R.string.category_establishments)
}