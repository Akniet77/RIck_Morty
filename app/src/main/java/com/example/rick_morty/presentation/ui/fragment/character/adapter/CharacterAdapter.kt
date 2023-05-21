package com.example.rick_morty.presentation.ui.fragment.character.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rick_morty.data.model.characterModel.Result
import com.example.rick_morty.databinding.ItemMovieBinding

class CharacterAdapter(
    private val click : (id: Int) -> Unit,
    private val onLongClick: (model: Result) -> Unit
) : Adapter<CharacterAdapter.AdapterViewHolder>() {
    private var list: ArrayList<Result> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: ArrayList<Result> = arrayListOf()){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AdapterViewHolder(
        ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CharacterAdapter.AdapterViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            click(position)
        }
        holder.itemView.setOnLongClickListener {
            holder.binding.linearLayout.alpha = 0.5f
            onLongClick(list[position])
            true
        }

    }

    override fun getItemCount() = list.size


    inner class AdapterViewHolder( val binding: ItemMovieBinding) : ViewHolder(binding.root) {

        fun onBind(result: Result) {
            result.imgUrl.let { binding.image.loadImage(it) }
            binding.txtName.text = result.nameCharacter
            binding.txtRassa.text = result.type
            binding.txtGender.text = result.gender
            binding.txtStatus.text = result.statusLife
        }
    }
}




