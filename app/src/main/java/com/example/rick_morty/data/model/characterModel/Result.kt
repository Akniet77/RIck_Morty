package com.example.rick_morty.data.model.characterModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Result(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("image")
    val imgUrl: String,
    @SerializedName("name")
    val nameCharacter: String,
    @SerializedName("species")
    val type: String,
    @SerializedName("status")
    val statusLife: String,

)