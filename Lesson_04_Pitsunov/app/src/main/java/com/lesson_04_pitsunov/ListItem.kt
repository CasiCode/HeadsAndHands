package com.lesson_04_pitsunov

sealed class ListItem {
    data class DetailedInfoListItem(val item: com.lesson_04_pitsunov.DetailedInfoItem) : ListItem()
    data class BaseInfoListItem(val item: com.lesson_04_pitsunov.BaseInfoItem) : ListItem()
}