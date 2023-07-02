package com.akmal.androidtask.data.remote.apiService

import com.akmal.androidtask.data.remote.model.response.OffersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("hh/test/api/v1/offers")
    suspend fun getOffers(): Response<OffersResponse>
}