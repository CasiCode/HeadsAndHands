package com.lesson_01_pitsunov

class Student(
    private val name: String,
    private val surname: String,
    private val grade: String,
    private val birthYear: String // Could be Int
) {
    var id: Long = System.currentTimeMillis()

    fun fieldsToString(): String {
        return "$name $surname $grade $birthYear"
    }
}