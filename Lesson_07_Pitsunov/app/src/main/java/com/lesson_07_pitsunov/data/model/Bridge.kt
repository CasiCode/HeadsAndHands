package com.lesson_07_pitsunov.data.model

import android.os.Parcelable
import com.lesson_07_pitsunov.values.StringConstants.NULL_STRING
import kotlinx.parcelize.Parcelize

@Parcelize
class Bridge (
    val name: String,
    val nameEng: String,
    val description: String,
    val descriptionEng: String,
    val divorces: List<BridgeDivorce>,
    val photoCloseURL: String,
    val photoOpenURL: String,
    var isClosed: Boolean = false,
    var isSoonClosed: Boolean = false,
) : Parcelable {
    constructor(bridgeApi: BridgeApi) : this(
        name = bridgeApi.name?: NULL_STRING,
        nameEng = bridgeApi.nameEng?: NULL_STRING,
        description = bridgeApi.description?: NULL_STRING,
        descriptionEng = bridgeApi.descriptionEng?: NULL_STRING,
        divorces = mutableListOf<BridgeDivorce>().apply {
            bridgeApi.divorces?.forEach {
                this.add(BridgeDivorce(it))
            }
        },
        photoCloseURL = bridgeApi.photoCloseURL?: NULL_STRING,
        photoOpenURL = bridgeApi.photoOpenURL?: NULL_STRING
    )
}