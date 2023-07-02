package com.akmal.androidtask.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akmal.androidtask.databinding.ItemOfferBinding
import com.akmal.androidtask.ui.main.model.OfferViewData
import com.akmal.androidtask.utils.extensions.loadImage

class OffersAdapter : RecyclerView.Adapter<OffersAdapter.Holder>() {
    private val items: MutableList<OfferViewData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemOfferBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<OfferViewData>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    inner class Holder(private val binding: ItemOfferBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: OfferViewData) = with(binding) {
            image.loadImage(data.image, 8)
            tvId.text = StringBuilder().append("id: ").append(data.id)
            tvName.text = data.name
            tvBrand.text = data.brand
        }
    }
}
