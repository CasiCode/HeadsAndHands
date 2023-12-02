package com.lesson_07_pitsunov.data.model

import com.google.gson.annotations.SerializedName

class BridgeDivorceApi(
    @SerializedName("start") val start: String?,
    @SerializedName("end") val end: String?
) {
    fun map() = BridgeDivorce(this)
}