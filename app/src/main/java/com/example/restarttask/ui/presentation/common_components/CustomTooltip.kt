package com.example.restarttask.ui.presentation.common_components

//@Composable
//fun CustomTooltip(
//    text: String,
//    modifier: Modifier = Modifier,
//    offsetX: Float =
//        0.dp, // Custom horizontal offset
//    offsetY: Float = 0.dp, // Custom vertical offset
//    show: Boolean = true
//) {
//    var isVisible by remember { mutableStateOf(show) }
//
//    // Use LaunchedEffect to show/hide tooltip based on the `show` state
//    LaunchedEffect(show) {
//        isVisible = show
//    }
//
//    // Animate the alpha for fade-in and fade-out effect
//    val alpha by animateFloatAsState(
//        targetValue = if (isVisible) 1f else 0f,
//        animationSpec = tween(durationMillis = 300)
//    )
//
//    // Show tooltip with an offset for position control
//    if (isVisible) {
//        Popup(
//            onDismissRequest = { isVisible = false } // Dismiss tooltip on tap outside
//        ) {
//            Surface(
//                modifier = Modifier
//                    .alpha(alpha)
//                    .padding(8.dp)
//                    .offset(x = offsetX, y = offsetY), // Apply custom offsets
//                shape = RoundedCornerShape(8.dp),
//                color = Color(0xFF1F2937),
//                shadowElevation = 4.dp
//            ) {
//                Column(
//                    modifier = Modifier.padding(16.dp)
//                ) {
//                    Text(
//                        text = text,
//                        style = TextStyle(
//                            color = Color.White,
//                            fontSize = 16.sp
//                        )
//                    )
//                }
//            }
//        }
//    }
//}
