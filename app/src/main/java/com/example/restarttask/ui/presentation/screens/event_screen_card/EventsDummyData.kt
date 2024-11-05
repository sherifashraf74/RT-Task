package com.example.restarttask.ui.presentation.screens.event_screen_card

import java.util.Date

data class Event(
    val event: String,
    val task: String,
    val topic: String,
    val answers: Int,
    val date: Date
)

