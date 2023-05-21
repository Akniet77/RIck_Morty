package com.example.rick_morty.presentation.ui.fragment.character

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rick_morty.R
import com.example.rick_morty.base.BaseFragment
import com.example.rick_morty.data.model.characterModel.Result
import com.example.rick_morty.databinding.FragmentCharacterBinding
import com.example.rick_morty.presentation.ui.fragment.character.adapter.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<FragmentCharacterBinding>(FragmentCharacterBinding::inflate){

    private val viewModel by lazy { ViewModelProvider(requireActivity())[CharacterViewModel::class.java] }
    lateinit var adapter: CharacterAdapter
    private var page : Int = 1

    override fun setupUI() {

        adapter = CharacterAdapter( click = { id ->
            val bundle = Bundle()
            bundle.putInt("id", id + 1)
            findNavController().navigate(R.id.detailCharacterFragment, bundle)
        }, onLongClick = {
            Toast.makeText(requireContext(), it.nameCharacter, Toast.LENGTH_SHORT).show()
            viewModel.addCharacter(it)
        })
        viewModel.getCharacter(page)
        binding.recyclerMovieList.adapter = adapter
    }

    override fun setupObServer() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.addList(it.results as ArrayList<Result>)
        }

        binding.refresh.setOnRefreshListener {
            binding.refresh.isRefreshing = false
            page++
            viewModel.getCharacter(page)
        }


    }
}