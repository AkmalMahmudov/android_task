package com.akmal.androidtask.ui.main

import androidx.lifecycle.viewModelScope
import com.akmal.androidtask.data.repository.OfferRepository
import com.akmal.androidtask.ui.base.BaseViewModel
import com.akmal.androidtask.ui.main.model.OfferViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfferViewModel @Inject constructor(private val repo: OfferRepository) : BaseViewModel() {
    init {
        getData()
    }

    private var _offers = MutableStateFlow<List<OfferViewData>>(emptyList())
    val offers: StateFlow<List<OfferViewData>> = _offers.asStateFlow()

    private fun getData() = viewModelScope.launch {
        repo.getOffers().onResult(
            success = { _offers.emit(it) },
            error = { _messageFlow.tryEmit(it.firstOrNull() ?: "") },
            loading = { _progressFlow.tryEmit(it) }
        )
    }
}