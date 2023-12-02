package com.lesson_07_pitsunov.data.model

import android.os.Parcelable
import com.lesson_07_pitsunov.values.StringConstants.NULL_STRING
import kotlinx.parcelize.Parcelize

@Parcelize
data class BridgeDivorce(
    val start: String,
    val end: String
) : Parcelable {
    constructor(bridgeDivorceApi: BridgeDivorceApi) : this(
        start = bridgeDivorceApi.start?: NULL_STRING,
        end = bridgeDivorceApi.end?: NULL_STRING
    )
}