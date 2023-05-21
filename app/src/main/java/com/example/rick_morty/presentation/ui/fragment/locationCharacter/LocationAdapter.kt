package com.example.rick_morty.presentation.ui.fragment.locationCharacter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_morty.data.model.locationCharcter.LocationsResponseItem
import com.example.rick_morty.databinding.ItemLocationBinding
import com.example.rick_morty.presentation.ui.fragment.character.adapter.loadImage

class LocationAdapter: RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private var locationList: ArrayList<LocationsResponseItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: ArrayList<LocationsResponseItem> = arrayListOf()){
        locationList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= LocationViewHolder(
        ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: LocationAdapter.LocationViewHolder, position: Int) {
        holder.onBind(locationList[position])
    }

    override fun getItemCount() = locationList.size

    class LocationViewHolder(private val binding: ItemLocationBinding):RecyclerView.ViewHolder(binding.root) {
        fun onBind(locationsResponseItem: LocationsResponseItem) {
            locationsResponseItem.url.let { binding.imageView2.loadImage(it) }
            binding.tvName.text = locationsResponseItem.name
            binding.tvType.text = locationsResponseItem.type
        }
    }
}