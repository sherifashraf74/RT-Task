package com.example.restarttask.ui.presentation.screens.home_screen_items

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restarttask.ui.presentation.theme.RestartTaskTheme

@Composable
fun CircularProgress(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF00FFFF),
    lineColor: Color = Color(0xFFDDFBFB),
    backgroundColor: Color = Color(0xFFEEFDFD),
    text: String = "1",
    textColor : Color = Color.White
) {
    Box(
        modifier = modifier
            .background(color = Color.Transparent)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val center = this.size.center
                val radius = minOf(center.x, center.y) - 25.dp.toPx()
                val radius2 = minOf(center.x, center.y) - 5.dp.toPx()

                val lineStartY = center.y + radius2
                val lineEndY = lineStartY + 35.dp.toPx()

                drawLine(
                    color = lineColor,
                    start = Offset(center.x, lineStartY),
                    end = Offset(center.x, lineEndY),
                    strokeWidth = 10.dp.toPx()
                )

                drawCircle(
                    color = backgroundColor,
                    radius = radius,
                    center = center,
                )
                drawCircle(
                    color = color,
                    radius = radius,
                    center = center,
                    style = Stroke(width = 2.dp.toPx())
                )

                drawCircle(
                    color = color,
                    radius = radius2,
                    center = center,
                    style = Stroke(width = 8.dp.toPx())
                )
            }

            Text(
                text = text,
                color = textColor,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
private fun DD() {
    RestartTaskTheme {
        CircularProgress(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}