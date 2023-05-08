package com.example.rick_morty.data.service


import com.example.rick_morty.data.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    fun getCharacters() : retrofit2.Call<MainResponse<com.example.rick_morty.data.model.Result>>

    @GET("character/{id}")
    fun getDetailCharacter(
        @Path("id") id: String,
    ): Call<com.example.rick_morty.data.model.Result>
}