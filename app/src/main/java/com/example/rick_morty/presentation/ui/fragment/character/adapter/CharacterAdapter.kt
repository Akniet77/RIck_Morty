package com.example.rick_morty.presentation.ui.fragment.character.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rick_morty.databinding.ItemMovieBinding

class CharacterAdapter(private val click : (id: Int) -> Unit) : Adapter<CharacterAdapter.AdapterViewHolder>() {
    private var list: ArrayList<com.example.rick_morty.data.model.Result> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<com.example.rick_morty.data.model.Result> = arrayListOf()){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AdapterViewHolder(
        ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CharacterAdapter.AdapterViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            click(list[position].id)
        }
    }

    override fun getItemCount() = list.size


    class AdapterViewHolder(private val binding: ItemMovieBinding) : ViewHolder(binding.root) {

        fun onBind(result: com.example.rick_morty.data.model.Result) {
            result.imgUrl?.let { binding.image.loadImage(it) }
            binding.txtName.text = result.nameCharacter
            binding.txtRassa.text = result.type
            binding.txtGender.text = result.gender
            binding.txtStatus.text = result.statusLife
        }
    }
}




