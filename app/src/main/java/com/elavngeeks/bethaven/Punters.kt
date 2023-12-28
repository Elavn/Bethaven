package com.elavngeeks.bethaven

import androidx.annotation.DrawableRes

data class Punters(
    @DrawableRes val punterPics: Int,
    val punterName: String,
    val punterNick: String
)
