package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val id: Long,
    @StringRes val description: Int,
    @StringRes val workTime: Int? = null,
    val type: CategoryType,
    val location: Location
)
