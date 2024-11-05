package com.example.restarttask.ui.presentation.screens.welcome_screen_items

import android.content.Context
import android.content.SharedPreferences

fun Context.getPreferences(): SharedPreferences =
    getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

fun saveFullName(context: Context, fullName: String) {
    context.getPreferences().edit().putString("full_name", fullName).apply()
}

fun getFullName(context: Context): String? =
    context.getPreferences().getString("full_name", null)