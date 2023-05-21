package com.example.rick_morty.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RickDao {

    @Query("select * from result")
    fun getAllCharacter(): LiveData<List<com.example.rick_morty.data.model.characterModel.Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacter(result: com.example.rick_morty.data.model.characterModel.Result)
}