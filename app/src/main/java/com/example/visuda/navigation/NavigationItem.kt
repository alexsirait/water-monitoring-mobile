package com.example.visuda.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val icon : ImageVector,
    val screen : Routes,
    val title : String
)