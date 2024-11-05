package com.example.restarttask.ui.presentation.common_components

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restarttask.R
import com.example.restarttask.ui.presentation.theme.RestartTaskTheme


@ExperimentalMaterial3Api
@Composable
fun AppBar(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    titleStyle: TextStyle = MaterialTheme.typography.titleLarge,
    showBackButton: Boolean = true,
    onBackButtonClicked: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                stringResource(title),
                style = titleStyle,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        },
        actions = {
                if (showBackButton) {
                    IconButton(onClick = onBackButtonClicked) {
                        Image(
                            painter = painterResource(R.drawable.notification),
                            contentDescription = "notification_icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        modifier = modifier
    )
}
@ExperimentalMaterial3Api
@Preview
@Composable
private fun PreviewAppBar() {
    RestartTaskTheme{
        AppBar(title = R.string.home) {

        }
    }
}