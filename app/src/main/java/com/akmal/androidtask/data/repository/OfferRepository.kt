package com.akmal.androidtask.data.repository

import com.akmal.androidtask.ui.main.model.OfferViewData
import com.akmal.androidtask.utils.ResultData
import kotlinx.coroutines.flow.Flow

interface OfferRepository {
    suspend fun getOffers(): Flow<ResultData<List<OfferViewData>>>
}