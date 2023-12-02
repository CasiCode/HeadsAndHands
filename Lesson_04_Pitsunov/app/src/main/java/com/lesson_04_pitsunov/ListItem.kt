package com.lesson_04_pitsunov

<<<<<<< HEAD
data class ListItem (
    val image: Int,
    val title: String,
    val isDetailed: Boolean = false,
    val info: String? = null,
    val isWarning: Boolean = false
)
=======
sealed class ListItem {
    data class DetailedInfoListItem(val item: com.lesson_04_pitsunov.DetailedInfoItem) : ListItem()
    data class BaseInfoListItem(val item: com.lesson_04_pitsunov.BaseInfoItem) : ListItem()
}
>>>>>>> 855f3571098986938cf7f2ea51174b925e10a1f3
