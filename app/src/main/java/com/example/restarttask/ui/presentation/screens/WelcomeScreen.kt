package com.example.restarttask.ui.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.restarttask.ui.presentation.navigation.Routes
import com.example.restarttask.ui.presentation.screens.welcome_screen_items.saveFullName

@Composable
fun NameInputScreen(
    navController: NavHostController,
) {
    val context = LocalContext.current

    var firstName by remember { mutableStateOf(TextFieldValue("")) }
    var lastName by remember { mutableStateOf(TextFieldValue("")) }
    var fullName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(textStyle = TextStyle(fontStyle = MaterialTheme.typography.titleSmall.fontStyle,
            color = MaterialTheme.colorScheme.primary),
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(textStyle = TextStyle(fontStyle = MaterialTheme.typography.titleSmall.fontStyle,
            color = MaterialTheme.colorScheme.primary),
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(colors = ButtonColors(containerColor = MaterialTheme.colorScheme.primary, contentColor = Color.White, disabledContentColor = MaterialTheme.colorScheme.primary, disabledContainerColor = MaterialTheme.colorScheme.primary),
            onClick = {
                // Concatenate first name and last name
                val concatenatedName = "${firstName.text} ${lastName.text}"
                // Save the full name in SharedPreferences
                saveFullName(context, concatenatedName)
                fullName = concatenatedName
                navController.navigate(Routes.Home)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue",)
        }

        Spacer(modifier = Modifier.height(24.dp))

    }
}

