package com.example.restarttask.ui.presentation.screens.question_screens_items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.restarttask.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TwoColumnCategoriesList() {
    val dummyData = listOf(
        CategoryItem("5 sur 10 Questions", R.drawable.travel, "Voyage", "50%", 0.5f),
        CategoryItem("7 sur 10 Questions", R.drawable.travel, "Immigration", "70%", 0.70f),
        CategoryItem("3 sur 10 Questions", R.drawable.technology, "Technologies", "30%", 0.3f),
        CategoryItem("9 sur 10 Questions", R.drawable.art, "Art et Culture", "90%", 0.9f),
        CategoryItem("1 sur 10 Questions", R.drawable.environment, "Environment", "10%", 0.1f),
        CategoryItem("10 sur 10 Questions", R.drawable.travel, "Travel", "100%", 1f)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dummyData.size) { index ->
            val item = dummyData[index]
            CategoriesCard(
                questionText = item.questionText,
                logo = item.logo,
                categoryTxt = item.categoryTxt,
                progressPrecentage = item.progressPercentage,
                progressBar = item.progress
            )
        }
    }
}

data class CategoryItem(
    val questionText: String,
    val logo: Int,
    val categoryTxt: String,
    val progressPercentage: String,
    val progress: Float
)