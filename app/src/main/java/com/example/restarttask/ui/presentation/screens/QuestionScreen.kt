package com.example.restarttask.ui.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restarttask.R
import com.example.restarttask.ui.presentation.common_components.AppBar
import com.example.restarttask.ui.presentation.common_components.BlurredShape
import com.example.restarttask.ui.presentation.screens.question_screens_items.TwoColumnCategoriesList
import com.example.restarttask.ui.presentation.theme.RestartTaskTheme

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.drawUnderline(): Modifier {
    return Modifier.drawBehind {
        val strokeWidth = 8f
        val underlineOffset = 8.dp.toPx()
        val startX = 0f
        val endX = size.width
        val y = size.height + underlineOffset

        drawLine(
            color = Color(0xFF0F5252),
            start = Offset(startX, y),
            end = Offset(endX, y),
            strokeWidth = strokeWidth
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionScreen(
    modifier: Modifier = Modifier,
) {
    var isWritingActive by remember { mutableStateOf(true) }
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        topBar = {
            AppBar(
                title =(R.string.questions),
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
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = { isWritingActive = true }) {
                            Row{
                                Icon(Icons.Default.Edit, contentDescription = "Writing")
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(
                                    "Writing",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color(0xFF0F5252),
                                    modifier = Modifier
                                        .padding(bottom = 2.dp)
                                        .then(
                                            if (isWritingActive) Modifier.drawUnderline() else Modifier
                                        )
                                )
                            }
                        }

                        }
                        TextButton(onClick = { isWritingActive = false }) {
                            Row{
                                Icon(Icons.Default.Mic, contentDescription = "Oral")
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(
                                    "Oral",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color(0xFF0F5252),
                                    modifier = Modifier
                                        .padding(bottom = 2.dp)
                                        .then(
                                            if (!isWritingActive) Modifier.drawUnderline() else Modifier
                                        )
                                )
                            }
                        }

                    }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(onClick = { /* Task 1 action */ }) {
                        Text(stringResource(R.string.task_1), color = Color.White)
                    }
                    Button(onClick = { /* Task 2 action */ }, colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)) {
                        Text(stringResource(R.string.task_2) , color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Categories List
                if (isWritingActive) {
                    TwoColumnCategoriesList()
                } else {
                    // Placeholder for Oral content
                    Text(
                        "Oral content goes here.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF0F5252),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
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



@Preview
@Composable
private fun QuestionsPrev() {
    RestartTaskTheme {
        QuestionScreen()
    }

}




