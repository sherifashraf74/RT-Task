package com.example.restarttask.ui.presentation.common_components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BlurredShape(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Canvas(modifier = Modifier.fillMaxWidth()) {
            // Draw multiple overlapping circles with increasing radius and lower opacity
            drawBlurredRay(centerX = size.width / 2, centerY = size.height / 2, maxRadius = 300f)
        }
    }
}
fun DrawScope.drawBlurredRay(centerX: Float, centerY: Float, maxRadius: Float) {
    val numberOfCircles = 5 // Increased number of circles for a softer effect
    for (i in 0 until numberOfCircles) {
        // Calculate the radius and opacity for each circle
        val radius = maxRadius * (1 + (i / (numberOfCircles.toFloat() - 1))) // Increased spread
        val alpha = (1 - (i / (numberOfCircles.toFloat() - 1))) * 0.03f // Adjusted opacity for more blurriness
        drawCircle(
            color = Color(0xFF00FFFF).copy(alpha = alpha), // Choose the desired color
            radius = radius,
            center = Offset(size.width / 2, size.height)
        )
    }
}


@Preview(showBackground = true)
    @Composable
    fun PreviewEllipseCanvas() {
        BlurredShape()
    }