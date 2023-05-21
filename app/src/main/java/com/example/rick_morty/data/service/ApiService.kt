package com.example.rick_morty.data.service


import com.example.rick_morty.data.model.characterModel.MainResponse
import com.example.rick_morty.data.model.characterModel.Result
import com.example.rick_morty.data.model.episodeCharacter.EpisodeResponseItem
import com.example.rick_morty.data.model.locationCharcter.LocationsResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    fun getCharacters(
        @Query("page")page: Int? = 1
    ) : retrofit2.Call<MainResponse<Result>>

    @GET("character/{id}")
    fun getDetailCharacter(
        @Path("id") id: String,
    ): Call<Result>

    @GET("location")
    fun getLocation(
        @Query("page") page :Int? = 1
    ): Call<MainResponse<LocationsResponseItem>>

    @GET("episode")
    fun getEpisode(
        @Query("page") page: Int? = 1
    ): Call<MainResponse<EpisodeResponseItem>>
}