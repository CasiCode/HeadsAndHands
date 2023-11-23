package com.lesson_04_pitsunov

object ItemsList {
    var items = listOf<ListItem>(
        ListItem(
            R.drawable.ic_bill,
            "Квитанции",
            true,
            "-40 080,55 ₽",
            true
        ),
        ListItem(
            R.drawable.ic_counter,
            "Счетчики",
            true,
            "Подайте показания"
        ),
        ListItem(
            R.drawable.ic_installment,
            "Рассрочка",
            true,
            "Сл. платеж 25.02.2024"
        ),
        ListItem(
            R.drawable.ic_insurance,
            "Страхование",
            true,
            "Полис до 12.01.2025"
        ),
        ListItem(
            R.drawable.ic_tv,
            "Интернет и ТВ",
            true,
            "Баланс 350 ₽"
        ),
        ListItem(
            R.drawable.ic_homephone,
            "Домофон",
            true,
            "Подключен"
        ),
        ListItem(
            R.drawable.group_2,
            "Охрана",
            false,
            "Нет"
        ),
        ListItem(
            R.drawable.group_26, "Контакты УК и служб"
        ),
        ListItem(
            R.drawable.group_23, "Мои заявки"
        ),
        ListItem(
            R.drawable.group_62, "Памятка жителя А101"
        )
    )
}