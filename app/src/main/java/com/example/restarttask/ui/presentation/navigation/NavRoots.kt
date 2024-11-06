

package com.example.restarttask.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.restarttask.ui.presentation.screens.ConnectScreen
import com.example.restarttask.ui.presentation.screens.HomeScreen
import com.example.restarttask.ui.presentation.screens.NameInputScreen
import com.example.restarttask.ui.presentation.screens.ProfileScreen
import com.example.restarttask.ui.presentation.screens.QuestionScreen
import com.example.restarttask.ui.presentation.screens.ToolsScreen


@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Welcome
    ) {
        composable(Routes.Welcome) {
            NameInputScreen(navController)
        }
        composable(Routes.Home) {
            HomeScreen(navController = navController)
        }
        composable(Routes.Connect) {
            ConnectScreen(navController = navController)
        }
        composable(Routes.Questions) {
            QuestionScreen(navController = navController)
        }
        composable(Routes.Tools) {
            ToolsScreen(navController = navController)
        }
        composable(Routes.Profile) {
            ProfileScreen(navController = navController)
        }
    }
}
