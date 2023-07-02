package com.akmal.androidtask.data.repository.impl

import com.akmal.androidtask.data.mapper.toOfferViews
import com.akmal.androidtask.data.remote.apiService.ApiService
import com.akmal.androidtask.data.repository.OfferRepository
import com.akmal.androidtask.ui.main.model.OfferViewData
import com.akmal.androidtask.utils.ResultData
import com.akmal.androidtask.utils.SafeApiCall
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfferRepositoryImpl @Inject constructor(private val apiService: ApiService) : OfferRepository, SafeApiCall {

    override suspend fun getOffers(): Flow<ResultData<List<OfferViewData>>> = safeApiCall(
        request = { apiService.getOffers() },
        onSuccess = { it.toOfferViews() }
    )
}