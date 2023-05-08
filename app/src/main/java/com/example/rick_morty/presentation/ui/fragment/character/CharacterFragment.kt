package com.example.rick_morty.presentation.ui.fragment.character

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rick_morty.R
import com.example.rick_morty.base.BaseFragment
import com.example.rick_morty.data.model.Result
import com.example.rick_morty.databinding.FragmentCharacterBinding
import com.example.rick_morty.presentation.ui.fragment.character.adapter.CharacterAdapter

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding>(FragmentCharacterBinding::inflate){

    private val viewModel by lazy { ViewModelProvider(requireActivity())[CharacterViewModel::class.java] }
    lateinit var adapter: CharacterAdapter

    override fun setupUI() {
        adapter = CharacterAdapter( click = { id ->
            val bundle = Bundle()
            bundle.putInt("id", id)
            findNavController().navigate(R.id.detailCharacterFragment, bundle)
        })
        viewModel.getCharacter()
        binding.recyclerMovieList.setHasFixedSize(true)
    }

    override fun setupObServer() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setList(it.results as ArrayList<Result>)
            binding.recyclerMovieList.adapter = adapter
        }
    }
}