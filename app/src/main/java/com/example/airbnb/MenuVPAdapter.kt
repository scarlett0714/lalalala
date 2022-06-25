package com.example.airbnb

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MenuVPAdapter (fragment: Fragment) :FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MainpageFragment()
            //1 -> MusicFileFragment()
            //else -> SavedAlbumFragment()
            else -> MainpageFragment()
        }
    }

}