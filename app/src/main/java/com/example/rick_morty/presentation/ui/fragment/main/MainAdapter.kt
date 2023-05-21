package com.example.rick_morty.presentation.ui.fragment.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rick_morty.presentation.ui.fragment.character.CharacterFragment
import com.example.rick_morty.presentation.ui.fragment.episodeCharacter.EpisodeCharacterFragment
import com.example.rick_morty.presentation.ui.fragment.locationCharacter.LocationFragment

class MainAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> CharacterFragment()
                1 -> LocationFragment()
                2 -> EpisodeCharacterFragment()
                else -> CharacterFragment()
            }
        }
}
