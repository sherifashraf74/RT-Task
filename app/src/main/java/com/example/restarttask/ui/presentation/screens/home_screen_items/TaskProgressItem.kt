package com.example.restarttask.ui.presentation.screens.home_screen_items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskProgressList(
    modifier: Modifier = Modifier,
    items: List<TaskItem> = listOf(
        TaskItem("1", "Unite 1:", "what is examate", true),
        TaskItem("2", "Unite 2:", "what is TCF", false),
        TaskItem("3", "Writing Tasks", "", false),
        TaskItem("4", "Oral Task", "", false)
    ),
    onItemClick: (TaskItem) -> Unit = {} // Callback function for item click
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(items) { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .clickable { onItemClick(item) }
            ) {
                CircularProgress(
                    modifier = Modifier.size(100.dp),
                    text = item.number,
                    color = if (item.isActive) Color(0xFF00FFFF) else Color.LightGray,
                    backgroundColor = if (item.isActive) Color(0xFFEEFDFD) else Color.LightGray.copy(alpha = 0.3f),
                    lineColor = if (item.isActive) Color(0xFFDDFBFB) else Color.LightGray.copy(alpha = 0.3f),
                    textColor = if (item.isActive) Color(0xFF00FFFF) else Color.White
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = item.title,
                        fontWeight = FontWeight.Bold,
                        fontStyle = MaterialTheme.typography.titleSmall.fontStyle,
                        color = if (item.isActive) MaterialTheme.colorScheme.primary else Color.Gray
                    )
                    if (item.subtitle.isNotEmpty()) {
                        Text(
                            text = item.subtitle,
                            fontSize = 14.sp,
                            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                            color = if (item.isActive) MaterialTheme.colorScheme.primary else Color.Gray
                        )
                    }
                }
            }
        }
    }
}

data class TaskItem(
    val number: String,
    val title: String,
    val subtitle: String = "",
    val isActive: Boolean = false
)

@Preview
@Composable
private fun TaskProgressListPreview() {
    TaskProgressList(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
}