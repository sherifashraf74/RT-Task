package com.example.restarttask.ui.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.restarttask.R

@Composable
fun MainNavigationBar(
    navController: NavHostController,
    currentRoute: String
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White,
        tonalElevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navItems = listOf(
            NavigationItem(Routes.Home, R.drawable.home_icon_active, R.drawable.home_icon_not_active, "Home"),
            NavigationItem(Routes.Connect, R.drawable.connect_icon_active, R.drawable.connect_icon_not_active, "Connect"),
            NavigationItem(Routes.Questions, R.drawable.question_icon_active, R.drawable.question_icon_not_active, "Question"),
            NavigationItem(Routes.Tools, R.drawable.tool_icon_active, R.drawable.tools_icon_not_active, "Tools"),
            NavigationItem(Routes.Profile, R.drawable.profile_icon_active, R.drawable.profile_icon_not_active, "Profile")
        )


        navItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(Routes.Home) { saveState = true }
                            launchSingleTop = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = if (currentRoute == item.route) item.activeIcon else item.inactiveIcon),
                        contentDescription = item.label
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 10.sp,
                        color = if (currentRoute == item.route) Color(0xFF21B6B6) else Color(0xFF9CA3AF),
                        fontFamily = MaterialTheme.typography.titleSmall.fontFamily
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Unspecified,
                    unselectedIconColor = Color.Unspecified,
                    selectedTextColor = Color(0xFF21B6B6),  // Color when selected
                    unselectedTextColor = Color(0xFF9CA3AF), // Color when not selected
                    indicatorColor = Color.Transparent
                ),
                alwaysShowLabel = true
            )
        }
    }
}

data class NavigationItem(
    val route: String,
    val activeIcon: Int,
    val inactiveIcon: Int,
    val label: String
)