package com.example.rick_morty.presentation.ui.fragment.favorite

import androidx.lifecycle.ViewModelProvider
import com.example.rick_morty.base.BaseFragment
import com.example.rick_morty.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {

    private val adapter by lazy { FavoriteAdapter()}
    private val viewModel by lazy { ViewModelProvider(requireActivity())[FavoriteViewModel::class.java] }

    override fun setupUI() {
        binding.rvFavorite.adapter = adapter
        viewModel.getFavoriteCharacter()

    }

    override fun setupObServer() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
    }

}
