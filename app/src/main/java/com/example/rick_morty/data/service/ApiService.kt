package com.example.rick_morty.data.service


import com.example.rick_morty.data.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    fun getCharacters() : retrofit2.Call<MainResponse<com.example.rick_morty.data.model.Result>>
}