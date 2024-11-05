package com.example.restarttask.ui.presentation.screens.connect_screen_items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restarttask.ui.presentation.theme.RestartTaskTheme

@Composable
fun CardItem(
    name: String,
    lastSeen: String,
    targetingB1: Boolean,
    languages: List<String>,
    location: String,
    gender: Gender,
    age: Int,
    expirationDate: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,

    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = name, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
            Text(text = "Last seen online: $lastSeen")

            if (targetingB1) {
                Box (modifier = Modifier.background(color = MaterialTheme.colorScheme.primary
                    , shape = MaterialTheme.shapes.extraSmall)){
                    Text(text = "Targeting: B1", color = Color.White) }

            }
            Row (   modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween ){
                Text(text = languages.joinToString(", "))
                Text(text = "$location, $gender, $age")
            }

            Text(text = "Expires on: $expirationDate")
        }
    }
}

enum class Gender {
    Male, Female
}

@Preview
@Composable
private fun CardPreview() {
    RestartTaskTheme{
        CardItem(name = "Reem Sayed",
            age = 26,
            gender = Gender.Female,
            lastSeen = "Yesterday",
            location = "Egypt",
            languages = listOf("English","Arabic","French"),
            targetingB1 = true,
            expirationDate = "s" )

    }

}