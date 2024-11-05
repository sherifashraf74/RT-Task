package com.example.restarttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.restarttask.ui.presentation.screens.ConnectScreen
import com.example.restarttask.ui.presentation.screens.HomeScreen
import com.example.restarttask.ui.presentation.theme.RestartTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestartTaskTheme {
                ConnectScreen()
                }
            }
        }
    }





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RestartTaskTheme {

    }
}