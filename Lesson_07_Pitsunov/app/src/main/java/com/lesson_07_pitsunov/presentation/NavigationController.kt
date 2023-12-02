package com.lesson_07_pitsunov.presentation

import androidx.fragment.app.Fragment

interface NavigationController {
    fun navigate(fragment: Fragment)
    fun back()
}