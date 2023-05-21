package com.example.rick_morty.data.model.locationCharcter

data class LocationsResponseItem(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)