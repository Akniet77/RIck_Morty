package com.example.rick_morty.data.model.episodeCharacter

import com.example.rick_morty.data.model.characterModel.Info


data class EpisodeResponse(
    val info: Info,
    val results: List<EpisodeResponseItem>
)