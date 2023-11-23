package com.lesson_07_pitsunov.data.model

import com.google.gson.annotations.SerializedName

data class BridgeApi (
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("name_eng") val nameEng: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("description_eng") val descriptionEng: String?,
    @SerializedName("divorces") val divorces: List<BridgeDivorceApi>?,
    @SerializedName("lat") val lat: Double?,
    @SerializedName("lng") val lng: Double?,
    @SerializedName("photo_close_url") val photoCloseURL: String?,
    @SerializedName("photo_open_url") val photoOpenURL: String?,
    @SerializedName("public") val public: Boolean?
) {
    fun map() = Bridge(this)
}