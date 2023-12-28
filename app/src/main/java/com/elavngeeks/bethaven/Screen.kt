package com.elavngeeks.bethaven

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Exclusive: Screen(route = "exclusive_screen")
    object Responsible: Screen(route = "responsible_screen")
    object Punter: Screen(route = "punter_screen")
}
