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

        val selectedColor = Color(0xFF21B6B6)
        val unselectedColor = Color(0xFF9CA3AF)

        val navItems = listOf(
            NavigationItem(
                route = Routes.Home,
                icon = R.drawable.home_icon_not_active,
                label = "Home"
            ),
            NavigationItem(
                route = Routes.Connect,
                icon = R.drawable.connect_icon_not_active,
                label = "Connect"
            ),
            NavigationItem(
                route = Routes.Questions,
                icon = R.drawable.question_icon_not_active,
                label = "Question"
            ),
            NavigationItem(
                route = Routes.Tools,
                icon = R.drawable.tools_icon_not_active,
                label = "Tools"
            ),
            NavigationItem(
                route = Routes.Profile,
                icon = R.drawable.profile_icon_not_active,
                label = "Profile"
            )
        )

        navItems.forEach { item ->
            val isSelected = currentRoute == item.route
            NavigationBarItem(
                selected = isSelected,
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
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        tint = if (isSelected) selectedColor else unselectedColor
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 10.sp,
                        color = if (isSelected) selectedColor else unselectedColor,
                        fontFamily = MaterialTheme.typography.titleSmall.fontFamily
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Unspecified,
                    unselectedIconColor = Color.Unspecified,
                    selectedTextColor = selectedColor,
                    unselectedTextColor = unselectedColor,
                    indicatorColor = Color.Transparent
                ),
                alwaysShowLabel = true
            )
        }
    }
}

data class NavigationItem(
    val route: String,
    val icon: Int,
    val label: String
)