package com.example.restarttask.ui.presentation.navigation

sealed class Screens(val route: String){
    data object Home : Screens("home")
    data object Connect : Screens("connect")
    data object Questions : Screens("questions")
    data object Tools : Screens("tools")
    data object Profile : Screens("profile")
}

