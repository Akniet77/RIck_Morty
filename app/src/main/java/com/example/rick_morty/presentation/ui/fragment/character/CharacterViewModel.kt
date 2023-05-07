package com.example.rick_morty.presentation.ui.fragment.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rick_morty.data.model.MainResponse
import com.example.rick_morty.data.repository.RickAndMortyRepository

class CharacterViewModel : ViewModel(){

    private val repository = RickAndMortyRepository()
    var liveData: LiveData<MainResponse<com.example.rick_morty.data.model.Result>> = MutableLiveData()

    fun getCharacter() {
        liveData = repository.getCharacter()
    }
}