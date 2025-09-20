package com.example.artspace.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ArtPiece(
    @DrawableRes val imageResId: Int,
    var title: String? = null,
)
