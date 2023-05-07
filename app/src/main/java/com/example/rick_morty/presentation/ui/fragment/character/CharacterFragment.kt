package com.example.rick_morty.presentation.ui.fragment.character

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.rick_morty.base.BaseFragment
import com.example.rick_morty.databinding.FragmentCharacterBinding

class CharacterFragment : BaseFragment<FragmentCharacterBinding>(FragmentCharacterBinding:: inflate) {
    private val viewModel by lazy { ViewModelProvider(requireActivity())[CharacterViewModel::class.java] }
    


    override fun setupUI() {
        viewModel.getCharacter()

    }

    override fun setupObServer() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.results[0].nameCharacter, Toast.LENGTH_SHORT).show()
        }
    }
}