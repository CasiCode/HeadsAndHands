package com.lesson_05_pitsunov

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data (
    var value: String = "value"
) : Parcelable