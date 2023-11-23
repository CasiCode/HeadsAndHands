package com.lesson_06_pitsunov

data class ListItem (
    val image: Int,
    val title: String,
    val barcode: Int,
    val previousValueDay: Int,
    val info: String,
    val isWarning: Boolean,
    val isPrecise: Boolean,
    val previousValuePeak: Int? = null,
    val previousValueNight: Int? = null
)