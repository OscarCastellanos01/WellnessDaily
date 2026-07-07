package com.example.wellnessdaily.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class WellnessDay(
    val id: Int,
    @StringRes val wellnessDay: Int,
    @StringRes val wellnessTitle: Int,
    @DrawableRes val wellnessImage: Int,
    @StringRes val wellnessDescription: Int
)
