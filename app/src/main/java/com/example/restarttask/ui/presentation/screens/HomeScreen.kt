package com.example.restarttask.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restarttask.R
import com.example.restarttask.ui.presentation.common_components.AppBar
import com.example.restarttask.ui.presentation.common_components.BlurredShape
import com.example.restarttask.ui.presentation.screens.home_screen_items.TaskProgressList
import com.example.restarttask.ui.presentation.screens.welcome_screen_items.getFullName
import com.example.restarttask.ui.presentation.theme.RestartTaskTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
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
                    "Study Plan",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                    color = MaterialTheme.colorScheme.onError
                )
                Spacer(modifier = Modifier.height(8.dp))
                TaskProgressList(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            // BlurredShape positioned at the top end corner
            BlurredShape(
                modifier = Modifier
                    .offset(y = (-20).dp, x = 150.dp)
                    .height(500.dp)
                    .align(Alignment.TopEnd) // Align to top end
            )
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    RestartTaskTheme {
        HomeScreen()
    }

}