package com.lesson_07_pitsunov.presentation

import com.lesson_07_pitsunov.data.model.Bridge

fun interface ItemListener {
    fun onItemClick(item: Bridge)
}