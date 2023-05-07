package com.example.rick_morty.presentation.ui.fragment.DetailCharacter

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.rick_morty.base.BaseFragment
import com.example.rick_morty.data.model.Result
import com.example.rick_morty.data.service.ApiService
import com.example.rick_morty.data.service.RetrofitService
import com.example.rick_morty.databinding.FragmentDetailCharacterBinding
import com.example.rick_morty.presentation.ui.fragment.character.adapter.loadImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class DetailCharacterFragment :
    BaseFragment<FragmentDetailCharacterBinding>(FragmentDetailCharacterBinding::inflate){

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[DetailViewModel::class.java]
    }
    lateinit var apiService : ApiService


    override fun setupUI() {
        if(arguments != null) {
            val id = arguments?.getInt("id").toString()

            viewModel.getDetail(id)
            apiService = RetrofitService.retrofit.create()
            getDetailCharacter(id)
        }
    }

    override fun setupObServer() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show()
        }
    }

    fun getDetailCharacter(id: String) {
        apiService.getDetailCharacter(id).enqueue(object : Callback<Result> {
            override fun onResponse(
                call: Call<Result>,
                response: Response<Result>
            ) {
                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show()
                response.body()?.let { binding.img.loadImage(it.imgUrl) }
                binding.txtName.text = response.body()?.nameCharacter
                binding.txtGender.text = response.body()?.gender
                binding.txtRassa.text = response.body()?.type
                binding.txtStatus.text = response.body()?.statusLife
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
//Rest для

}