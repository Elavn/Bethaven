package com.elavngeeks.bethaven

import androidx.annotation.DrawableRes

data class MorePunters(
    @DrawableRes val displayPic: Int,
    val punterName: String,
    val preferredSports: String
)
