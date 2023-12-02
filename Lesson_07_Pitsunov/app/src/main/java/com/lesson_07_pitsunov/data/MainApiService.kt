package com.lesson_07_pitsunov.data

import com.lesson_07_pitsunov.data.model.BridgeApi
import retrofit2.http.GET

interface MainApiService {
    @GET("bridges")
    suspend fun getBridges(): List<BridgeApi>
}