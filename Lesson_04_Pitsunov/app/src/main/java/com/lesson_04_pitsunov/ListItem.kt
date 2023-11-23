package com.lesson_04_pitsunov

data class ListItem (
    val image: Int,
    val title: String,
    val isDetailed: Boolean = false,
    val info: String? = null,
    val isWarning: Boolean = false
)