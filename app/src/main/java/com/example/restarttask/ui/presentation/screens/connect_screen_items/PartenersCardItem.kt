package com.example.restarttask.ui.presentation.screens.connect_screen_items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
    date: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White) ,
        elevation =  CardDefaults.cardElevation(defaultElevation = 8.dp)


    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Circular badge for the first two letters
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape)
                        .wrapContentSize(Alignment.Center)
                ) {
                    Text(
                        text = name.take(2), // Get the first two letters
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.width(10.dp)) // Space between the badge and name

                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                        text = name,
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.weight(1f)
                    )
                        Spacer(modifier = Modifier.width(10.dp))
                        if (targetingB1) {
                            Box(
                                modifier = Modifier
                                    .background(color = MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.extraSmall)
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "Targeting: B1",
                                    color = Color.White,
                                    style = TextStyle(fontSize = 12.sp)
                                )
                            }
                        }

                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                    text = "Last seen online: $lastSeen",
                    style = TextStyle(fontSize = 12.sp, fontFamily = MaterialTheme.typography.titleSmall.fontFamily , color = Color.Gray)
                )
                    Spacer(modifier = Modifier.width(12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        languages.forEach { language ->
                            // Language Box
                            Row(
                                modifier = Modifier
                                    .background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f), shape = MaterialTheme.shapes.small)
                                    .padding(6.dp), // Inner padding for text
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Language Badge
                                Box(
                                    modifier = Modifier
                                        .wrapContentSize(Alignment.Center)
                                ) {
                                    Text(
                                        text = language,
                                        style = TextStyle(fontSize = 12.sp, fontFamily = MaterialTheme.typography.titleSmall.fontFamily , color = MaterialTheme.colorScheme.onError)
                                    )
                                }

                            }
                        }

                    }
                }

            }
            Text(
                text = "$location, $gender, $age, $date",
                style = TextStyle(fontSize = 12.sp, fontFamily = MaterialTheme.typography.titleSmall.fontFamily , color = Color.Gray)
            )
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
            date = "21 Jun 2023" )

    }

}