package com.example.rick_morty.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rick_morty.data.model.MainResponse
import com.example.rick_morty.data.model.Result
import com.example.rick_morty.data.service.ApiService
import com.example.rick_morty.data.service.RetrofitService.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RickAndMortyRepository {
    private val apiService = retrofit.create(ApiService::class.java)

    fun getCharacter(): LiveData<MainResponse<Result>>{
        val liveData = MutableLiveData<MainResponse<Result>>()
        apiService.getCharacters().enqueue(object : retrofit2.Callback<MainResponse<Result>> {
            override fun onResponse(
                call: Call<MainResponse<Result>>,
                response: Response<MainResponse<Result>>
            ) {
                    liveData.value = response.body()
            }

            override fun onFailure(call: Call<MainResponse<Result>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("olol", it) }
            }

        })
        return liveData
    }


    fun getDetail(id: String): LiveData<Result> {
        val liveData = MutableLiveData<Result>()
        apiService.getDetailCharacter(id).enqueue(object : Callback<Result> {
            override fun onResponse(
                call: Call<Result>,
                response: Response<Result>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                t.localizedMessage?.let { Log.e("olol", it) }
            }

        })
        return liveData
    }
}