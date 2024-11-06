package com.example.restarttask.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restarttask.R
import com.example.restarttask.ui.presentation.common_components.AppBar
import com.example.restarttask.ui.presentation.common_components.BlurredShape
import com.example.restarttask.ui.presentation.screens.connect_screen_items.CardItem
import com.example.restarttask.ui.presentation.screens.connect_screen_items.suggestedStudyPartners
import com.example.restarttask.ui.presentation.theme.RestartTaskTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectScreen(
    modifier: Modifier = Modifier,
    navController: NavController
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(bottom = 25.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = stringResource(R.string.suggested_study_partners), style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(suggestedStudyPartners) { partner ->
                        CardItem(
                            name = partner.name,
                            lastSeen = partner.lastSeen,
                            targetingB1 = partner.targetingB1,
                            languages = partner.languages,
                            location = partner.location,
                            gender = partner.gender,
                            age = partner.age,
                          date = partner.expirationDate
                        )
                    }
                }
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

//
//@Preview
//@Composable
//private fun ConnectScreenPrev() {
//    RestartTaskTheme {
//        ConnectScreen()
//    }
//
//}
