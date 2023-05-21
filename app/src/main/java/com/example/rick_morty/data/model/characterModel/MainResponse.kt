package com.example.rick_morty.data.model.characterModel

data class MainResponse<T>(
    val info: Info,
    val results: List<T>
)