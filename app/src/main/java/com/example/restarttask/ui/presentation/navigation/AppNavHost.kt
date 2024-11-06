package com.example.restarttask.ui.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainApp(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val hideBottomBarRoutes = listOf(
        Routes.Welcome,
        Routes.Tutorial1,
        Routes.Tutorial2,
        Routes.Tutorial3,
        Routes.Tutorial4,
        Routes.Tutorial5
    )

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (currentRoute !in hideBottomBarRoutes) {
                if (currentRoute != null) {
                    MainNavigationBar(navController = navController, currentRoute = currentRoute)
                }
            }
        }
    ) { paddingValues ->
        MainNavGraph(
            navController = navController,
            modifier = Modifier.padding(
                bottom = if (currentRoute !in hideBottomBarRoutes) paddingValues.calculateBottomPadding() else 0.dp
            )
        )
    }
}