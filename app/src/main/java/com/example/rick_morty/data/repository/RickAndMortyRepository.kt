package com.example.rick_morty.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rick_morty.data.model.characterModel.MainResponse
import com.example.rick_morty.data.model.characterModel.Result
import com.example.rick_morty.data.model.episodeCharacter.EpisodeResponseItem
import com.example.rick_morty.data.model.locationCharcter.LocationsResponseItem
import com.example.rick_morty.data.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(private val apiService: ApiService) {

    val liveData = MutableLiveData<MainResponse<Result>>()
    fun getCharacter(page: Int): LiveData<MainResponse<Result>> {
        apiService.getCharacters(page = page).enqueue(object : retrofit2.Callback<MainResponse<Result>> {
            override fun onResponse(
                call: Call<MainResponse<Result>>,
                response: Response<MainResponse<Result>>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<MainResponse<Result>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("ololo", it) }
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
                t.localizedMessage?.let { Log.e("ololo", it) }
            }

        })
        return liveData
    }


    fun getEpisodes(): LiveData<MainResponse<EpisodeResponseItem>> {
        val liveData = MutableLiveData<MainResponse<EpisodeResponseItem>>()
        apiService.getEpisode().enqueue(object: Callback<MainResponse<EpisodeResponseItem>>{
            override fun onResponse(
                call: Call<MainResponse<EpisodeResponseItem>>,
                response: Response<MainResponse<EpisodeResponseItem>>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<MainResponse<EpisodeResponseItem>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("ololo", it) }
            }

        })
        return liveData
    }

    fun getLocations(): LiveData<MainResponse<LocationsResponseItem>>{
        val liveData = MutableLiveData<MainResponse<LocationsResponseItem>>()
        apiService.getLocation().enqueue(object : Callback<MainResponse<LocationsResponseItem>>{
            override fun onResponse(
                call: Call<MainResponse<LocationsResponseItem>>,
                response: Response<MainResponse<LocationsResponseItem>>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<MainResponse<LocationsResponseItem>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("ololo", it) }
            }
        })
        return liveData
    }
}