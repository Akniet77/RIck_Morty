package com.example.rick_morty.presentation.ui.fragment.DetailCharacter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rick_morty.data.repository.RickAndMortyRepository

class DetailViewModel : ViewModel(){

    private val repo = RickAndMortyRepository()
    var liveData: LiveData<com.example.rick_morty.data.model.Result> = MutableLiveData()

    fun getDetail(id: String) {
        liveData = repo.getDetail(id)
    }
}