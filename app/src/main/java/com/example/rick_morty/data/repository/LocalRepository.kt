package com.example.rick_morty.data.repository

import androidx.lifecycle.LiveData
import com.example.rick_morty.data.db.RickDao
import com.example.rick_morty.data.model.characterModel.Result
import javax.inject.Inject

class LocalRepository @Inject constructor(private val rickDao: RickDao) {

    fun getFavoriteCharacters(): LiveData<List<Result>> {
        return rickDao.getAllCharacter()
    }
    fun addCharacter(result: Result){
        rickDao.addCharacter(result)
    }
}