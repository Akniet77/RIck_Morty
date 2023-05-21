package com.example.rick_morty.presentation.ui.fragment.episodeCharacter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rick_morty.data.model.episodeCharacter.EpisodeResponseItem
import com.example.rick_morty.databinding.ItemEpisodeBinding
import com.example.rick_morty.presentation.ui.fragment.character.adapter.loadImage

class EpisodeAdapter : Adapter<EpisodeAdapter.EpisodeAdapterViewHolder>() {

    private var episodeList: ArrayList<EpisodeResponseItem> = arrayListOf()


    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: ArrayList<EpisodeResponseItem> = arrayListOf()){
        episodeList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EpisodeAdapterViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: EpisodeAdapter.EpisodeAdapterViewHolder, position: Int) {
        holder.onBind(episodeList[position])

    }

    override fun getItemCount() = episodeList.size

    class EpisodeAdapterViewHolder(private val binding: ItemEpisodeBinding) : ViewHolder(binding.root) {
        fun onBind(episodeResponseItem: EpisodeResponseItem) {
            episodeResponseItem.url.let { binding.imageView2.loadImage(it) }
            binding.tvEpisodeName.text = episodeResponseItem.name
            binding.tvEpisode.text = episodeResponseItem.episode
            binding.tvAirDate.text = episodeResponseItem.air_date

        }

    }
}