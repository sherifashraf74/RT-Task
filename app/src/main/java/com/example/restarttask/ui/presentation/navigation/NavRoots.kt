

package com.example.restarttask.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.restarttask.ui.presentation.common_components.HomeTutorial
import com.example.restarttask.ui.presentation.common_components.TutorialScreen1
import com.example.restarttask.ui.presentation.common_components.TutorialScreen2
import com.example.restarttask.ui.presentation.common_components.TutorialScreen3
import com.example.restarttask.ui.presentation.common_components.TutorialScreen4
import com.example.restarttask.ui.presentation.common_components.TutorialScreen5
import com.example.restarttask.ui.presentation.screens.ConnectScreen
import com.example.restarttask.ui.presentation.screens.HomeScreen
import com.example.restarttask.ui.presentation.screens.NameInputScreen
import com.example.restarttask.ui.presentation.screens.ProfileScreen
import com.example.restarttask.ui.presentation.screens.QuestionScreen
import com.example.restarttask.ui.presentation.screens.ToolsScreen

@Composable
fun MainNavGraph(navController: NavHostController,
                 modifier: Modifier=Modifier) {
    NavHost(
        navController = navController,
        startDestination = Routes.Welcome,
        modifier = modifier
    ) {
        composable(Routes.HomeTutorial) {
            HomeTutorial(navController = navController)
        }
        composable(Routes.Tutorial1) {
            TutorialScreen1(navController = navController)
        }
        composable(Routes.Tutorial2) {
            TutorialScreen2(navController = navController)
        }
        composable(Routes.Tutorial3) {
            TutorialScreen3(navController = navController)
        }
        composable(Routes.Tutorial4) {
            TutorialScreen4(navController = navController)
        }
        composable(Routes.Tutorial5) {
            TutorialScreen5(navController = navController)
        }
        composable(Routes.Welcome) {
            NameInputScreen(navController = navController)
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