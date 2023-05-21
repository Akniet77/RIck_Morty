package com.example.rick_morty.presentation.ui.fragment.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rick_morty.data.model.characterModel.Result
import com.example.rick_morty.data.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
  private val repository: LocalRepository
): ViewModel(){

    var liveData: LiveData<List<Result>> = MutableLiveData()

    fun getFavoriteCharacter() {
        liveData = repository.getFavoriteCharacters()
    }
}