package com.example.rick_morty.presentation.ui.fragment.favorite

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.rick_morty.data.model.characterModel.Result
import com.example.rick_morty.databinding.ItemMovieBinding
import com.example.rick_morty.presentation.ui.fragment.character.adapter.loadImage

class FavoriteAdapter : Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var list: ArrayList<Result> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Result>){
        this.list = list as ArrayList<Result>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FavoriteViewHolder (
        ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
       holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    class FavoriteViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(result: Result) {
            result.imgUrl.let { binding.image.loadImage(it) }
            binding.txtName.text = result.nameCharacter
            binding.txtRassa.text = result.type
            binding.txtGender.text = result.gender
            binding.txtStatus.text = result.statusLife
        }

    }
}