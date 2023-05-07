package com.example.rick_morty.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rick_morty.data.model.MainResponse
import com.example.rick_morty.data.model.Result
import com.example.rick_morty.data.service.ApiService
import com.example.rick_morty.data.service.RetrofitService.retrofit
import retrofit2.Call
import retrofit2.Response

class RickAndMortyRepository {
    private val apiService = retrofit.create(ApiService::class.java)

    fun getCharacter(): LiveData<MainResponse<com.example.rick_morty.data.model.Result>>{
        val liveData = MutableLiveData<MainResponse<com.example.rick_morty.data.model.Result>>()
        apiService.getCharacters().enqueue(object : retrofit2.Callback<MainResponse<com.example.rick_morty.data.model.Result>> {
            override fun onResponse(
                call: Call<MainResponse<Result>>,
                response: Response<MainResponse<Result>>
            ) {
                if (response.isSuccessful && response.body() != null){
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<MainResponse<Result>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("olol", it) }
            }

        })
        return liveData
    }

}