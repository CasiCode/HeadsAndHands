package com.lesson_04_pitsunov

object ItemsList {
    var items = listOf<ListItem>(
        ListItem.DetailedInfoListItem(
            DetailedInfoItem(R.drawable.ic_bill, "Квитанции", "-40 080,55 ₽", true)
        ),
        ListItem.DetailedInfoListItem(
            DetailedInfoItem(R.drawable.ic_counter, "Счетчики", "Подайте показания", true)
        ),
        ListItem.DetailedInfoListItem(
            DetailedInfoItem(R.drawable.ic_installment, "Рассрочка", "Сл. платеж 25.02.2024", false)
        ),
        ListItem.DetailedInfoListItem(
            DetailedInfoItem(R.drawable.ic_insurance, "Страхование", "Полис до 12.01.2025", false)
        ),
        ListItem.DetailedInfoListItem(
            DetailedInfoItem(R.drawable.ic_tv, "Интернет и ТВ", "Баланс 350 ₽", false)
        ),
        ListItem.DetailedInfoListItem(
            DetailedInfoItem(R.drawable.ic_homephone, "Домофон", "Подключен", false)
        ),
        ListItem.BaseInfoListItem(
            BaseInfoItem(R.drawable.group_2, "Охрана", "Нет")
        ),
        ListItem.BaseInfoListItem(
            BaseInfoItem(R.drawable.group_26, "Контакты УК и служб")
        ),
        ListItem.BaseInfoListItem(
            BaseInfoItem(R.drawable.group_23, "Мои заявки")
        ),
        ListItem.BaseInfoListItem(
            BaseInfoItem(R.drawable.group_62, "Памятка жителя А101")
        )
    )
}