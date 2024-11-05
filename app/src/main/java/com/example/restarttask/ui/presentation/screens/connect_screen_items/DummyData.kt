package com.example.restarttask.ui.presentation.screens.connect_screen_items

data class SuggestedStudyPartner(
    val name: String,
    val lastSeen: String,
    val targetingB1: Boolean,
    val languages: List<String>,
    val location: String,
    val gender: Gender,
    val age: Int,
    val expirationDate: String
)

val suggestedStudyPartners = listOf(

    SuggestedStudyPartner(
        name = "Sherif Ashraf",
        lastSeen = "Yesterday",
        targetingB1 = true,
        languages = listOf("English", "Arabic", "French"),
        location = "Egypt",
        gender = Gender.Male,
        age = 23,
        expirationDate = "3 May 2023"
    ),
    SuggestedStudyPartner(
        name = "Reem Sayed",
        lastSeen = "Yesterday",
        targetingB1 = true,
        languages = listOf("English", "Arabic", "French"),
        location = "Egypt",
        gender = Gender.Female,
        age = 26,
        expirationDate = "21 June 2023"
    ),
    SuggestedStudyPartner(
        name = "Mona Ali",
        lastSeen = "Today",
        targetingB1 = true,
        languages = listOf("English", "German", "Arabic"),
        location = "Egypt",
        gender = Gender.Female,
        age = 26,
        expirationDate = "21 Jan 2023"
    ),
    SuggestedStudyPartner(
        name = "Eren Victor",
        lastSeen = "Yesterday",
        targetingB1 = true,
        languages = listOf("English", "Arabic", "French"),
        location = "Egypt",
        gender = Gender.Female,
        age = 30,
        expirationDate = "5 Jun 2023"
    ),
    SuggestedStudyPartner(
        name = "Imam Ali",
        lastSeen = "Today",
        targetingB1 = true,
        languages = listOf("English", "German","Italian"),
        location = "Egypt",
        gender = Gender.Male,
        age = 26,
        expirationDate = "21 Jan 2023"
    ),
)