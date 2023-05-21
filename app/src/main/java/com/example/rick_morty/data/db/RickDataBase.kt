package com.example.rick_morty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [com.example.rick_morty.data.model.characterModel.Result:: class], version = 2)
abstract class RickDataBase: RoomDatabase() {
    abstract fun getDao(): RickDao
}