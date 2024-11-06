package com.example.restarttask.ui.presentation.common_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.restarttask.R
import com.example.restarttask.ui.presentation.navigation.Routes
import com.example.restarttask.ui.presentation.screens.home_screen_items.TaskProgressList
import com.example.restarttask.ui.presentation.screens.welcome_screen_items.getFullName

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTutorial(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    var showTooltip by rememberSaveable { mutableStateOf(false) }
    var showOverlay by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        showTooltip = true
        showOverlay = true
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.White),
            topBar = {
                AppBar(
                    title = R.string.home,
                    showBackButton = true
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Main content in a Column
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.Top
                ) {
                    Row {
                        Text(
                            text = "Hi ", style = MaterialTheme.typography.labelSmall
                                .copy(
                                    color = MaterialTheme.colorScheme.onSecondary,
                                    fontSize = 20.sp,
                                )
                        )
                        val context = LocalContext.current
                        var savedFullName by remember { mutableStateOf("") }
                        LaunchedEffect(Unit) {
                            savedFullName = getFullName(context) ?: "User"
                        }
                        Text(
                            text = savedFullName, style = MaterialTheme.typography.bodyLarge
                                .copy(
                                    color = MaterialTheme.colorScheme.onError,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        stringResource(R.string.study_plan),
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                        color = MaterialTheme.colorScheme.onError
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TaskProgressList(
                        modifier = Modifier
                            .fillMaxSize()
                    )

                }

            }
            if (showOverlay) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.9f))
                        .clickable {
                            navController.navigate(Routes.Tutorial1)
                        }
                        .zIndex(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.intro_txt),
                            color = Color.White,
                            fontFamily = MaterialTheme.typography.titleSmall.fontFamily,
                            fontSize = 12.sp
                        )
                        Text(
                            stringResource(R.string.intro_txt2),
                            color = MaterialTheme.colorScheme.primary,
                            fontFamily = MaterialTheme.typography.titleSmall.fontFamily,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun TutorialScreen1(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(Routes.Tutorial2)
            }
    ) {
        Image(painter = painterResource(id = R.drawable.screen_one), contentDescription = "Tutorial Screen 1", modifier = Modifier.fillMaxSize())
    }
}
@Composable
fun TutorialScreen2(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(Routes.Tutorial3)
            }
    ) {
        Image(painter = painterResource(id = R.drawable.screen_two), contentDescription = "Tutorial Screen 2", modifier = Modifier.fillMaxSize())
    }
}
@Composable
fun TutorialScreen3(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(Routes.Tutorial4)
            }
    ) {
        Image(painter = painterResource(id = R.drawable.screen_three), contentDescription = "Tutorial Screen 3", modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun TutorialScreen4(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(Routes.Tutorial5)
            }
    ) {
        Image(painter = painterResource(id = R.drawable.screen_four), contentDescription = "Tutorial Screen 4", modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun TutorialScreen5(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(Routes.Home) {
                    popUpTo(Routes.Tutorial1) { inclusive = true }
                }
            }
    ) {
        Image(painter = painterResource(id = R.drawable.screen_five), contentDescription = "Tutorial Screen 5", modifier = Modifier.fillMaxSize())
    }
}


















