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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restarttask.R
import com.example.restarttask.ui.presentation.common_components.AppBar
import com.example.restarttask.ui.presentation.common_components.BlurredShape
import com.example.restarttask.ui.presentation.screens.home_screen_items.TaskProgressList
import com.example.restarttask.ui.presentation.screens.welcome_screen_items.getFullName

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        topBar = {
            AppBar(
                title = (R.string.connect),
                showBackButton = false
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Main content in a Column












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
private fun ConnectScreenPrev() {
    ConnectScreen()

}
