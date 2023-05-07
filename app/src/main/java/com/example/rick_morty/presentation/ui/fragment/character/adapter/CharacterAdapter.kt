package com.example.rick_morty.presentation.ui.fragment.character.adapter

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rick_morty.databinding.ItemMovieBinding

class CharacterAdapter : Adapter<CharacterAdapter.AdapterViewHolder>() {
    private var list: ArrayList<com.example.rick_morty.data.model.Result> = arrayListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = AdapterViewHolder(
        ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CharacterAdapter.AdapterViewHolder, position: Int) {
        holder.onBind(list[position])
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

        fun bind(listItem: Movie) {
            binding.image.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${binding.image}", Toast.LENGTH_SHORT)
                    .show()
            }
            binding.txtName.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${binding.txtName.text}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}




