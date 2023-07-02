package com.akmal.androidtask.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.akmal.androidtask.R
import com.akmal.androidtask.databinding.FragmentMainBinding
import com.akmal.androidtask.ui.main.adapter.OffersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class OfferFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: OfferViewModel by viewModels()
    private val adapter: OffersAdapter by lazy { OffersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews()
        setupObservers()
    }

    private fun setupViews() = with(binding) {
        rv.adapter = this@OfferFragment.adapter
    }

    private fun setupObservers() {
        viewModel.offers.onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)

        viewModel.messageFlow.onEach {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)

        viewModel.progressFlow.onEach {
            binding.progress.isVisible = it
        }.launchIn(lifecycleScope)
    }
}