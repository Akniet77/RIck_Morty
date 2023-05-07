package com.example.rick_morty.presentation.ui.fragment.character.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String){
    Glide.with(this).load(url).centerCrop().into(this)
}