package com.example.rick_morty.presentation.ui.fragment.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rick_morty.data.model.characterModel.MainResponse
import com.example.rick_morty.data.model.characterModel.Result
import com.example.rick_morty.data.repository.LocalRepository
import com.example.rick_morty.data.repository.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: RickAndMortyRepository,
    private val localRepository: LocalRepository
):  ViewModel(){


    var liveData: LiveData<MainResponse<Result>> = MutableLiveData()


    fun getCharacter(page : Int) {
        liveData = repository.getCharacter(page)
    }

    fun addCharacter(result:Result){
        localRepository.addCharacter(result)
    }
}