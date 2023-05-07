package com.example.rick_morty.presentation.ui.fragment.character

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rick_morty.R
import com.example.rick_morty.base.BaseFragment
import com.example.rick_morty.data.model.MainResponse
import com.example.rick_morty.data.model.Result
import com.example.rick_morty.data.service.ApiService
import com.example.rick_morty.data.service.RetrofitService
import com.example.rick_morty.databinding.FragmentCharacterBinding
import com.example.rick_morty.presentation.ui.fragment.character.adapter.CharacterAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding>(FragmentCharacterBinding::inflate){

    private val viewModel by lazy { ViewModelProvider(requireActivity())[CharacterViewModel::class.java] }
    lateinit var mService: ApiService
    lateinit var adapter: CharacterAdapter

    override fun setupUI() {
        adapter = CharacterAdapter( click = { id ->
            val bundle = Bundle()
            bundle.putInt("id", id)
            findNavController().navigate(R.id.detailCharacterFragment, bundle)
        })
        viewModel.getCharacter()
        mService = RetrofitService.retrofit.create()
        binding.recyclerMovieList.setHasFixedSize(true)


        getAllMovieList()
    }

    override fun setupObServer() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.results[0].nameCharacter, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAllMovieList() {
        mService.getCharacters().enqueue(object : Callback<MainResponse<Result>> {
            override fun onFailure(call: Call<MainResponse<Result>>, t: Throwable) {
                Log.e("ololo", "___${t.stackTrace}___" )
            }
            override fun onResponse(
                call: Call<MainResponse<Result>>,
                response: Response<MainResponse<Result>>
            ) {
                adapter.setList(response.body()!!.results as ArrayList<Result>)
                binding.recyclerMovieList.adapter = adapter
            }
        })
    }
}