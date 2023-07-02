package com.akmal.androidtask.data.mapper

import com.akmal.androidtask.data.remote.model.response.Offer
import com.akmal.androidtask.data.remote.model.response.OffersResponse
import com.akmal.androidtask.ui.main.model.OfferViewData

fun OffersResponse?.toOfferViews(): List<OfferViewData> =
    this?.offers?.map { it.toOfferView() } ?: emptyList()

fun Offer.toOfferView(): OfferViewData =
    OfferViewData(
        id = id,
        name = name,
        brand = brand,
        image = image.url
    )

