package com.example.rick_morty.presentation.ui.fragment.locationCharacter

import androidx.fragment.app.viewModels
import com.example.rick_morty.base.BaseFragment
import com.example.rick_morty.data.model.locationCharcter.LocationsResponseItem
import com.example.rick_morty.databinding.FragmentLacotionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment : BaseFragment<FragmentLacotionBinding>(FragmentLacotionBinding::inflate) {

    private val viewModel: LocationViewModel by viewModels()
    private val adapter : LocationAdapter by lazy { LocationAdapter() }

    override fun setupUI() {
        viewModel.getLocations()
    }

    override fun setupObServer() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setData(it.results as ArrayList<LocationsResponseItem>)
            binding.rvLocation.adapter = adapter
        }
    }
}