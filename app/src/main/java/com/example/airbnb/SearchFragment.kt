package com.example.airbnb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.airbnb.databinding.FragmentSearchBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    private var information = arrayListOf("섬", "국립공원", "통나무집")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        val lockerAdapter = MenuVPAdapter(this)
        binding.menuContentVp.adapter = lockerAdapter
        TabLayoutMediator(binding.menuContentTb, binding.menuContentVp){
                tab, position -> tab.text = information[position]
        }.attach()

        return binding.root
    }



}