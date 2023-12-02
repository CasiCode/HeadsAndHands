package com.lesson_06_pitsunov

object ItemsList {
    val items = listOf<ListItem>(
        ListItem(
            image = R.drawable.ic_water_cold,
            title = "Холодная вода",
            barcode = 54656553,
            previousValueDay = 35,
            isPrecise = false,
            isWarning = true,
            info = "Необходимо подать показания до 25.11.23"
        ),
        ListItem(
            image = R.drawable.ic_water_hot,
            title = "Горячая вода",
            barcode = 54656553,
            previousValueDay = 35,
            isPrecise = false,
            isWarning = true,
            info = "Необходимо подать показания до 25.11.23"
        ),
        ListItem(
            image = R.drawable.ic_electro,
            title = "Электричество",
            barcode = 54656553,
            previousValuePeak = 35,
            previousValueDay = 35,
            previousValueNight = 35,
            isPrecise = true,
            isWarning = false,
            info = "Показания сданы 16.10.23 и будут учтены при следующем расчете 25.11.23"
        ),
    )
}