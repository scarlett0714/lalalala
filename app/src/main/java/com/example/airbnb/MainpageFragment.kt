package com.example.airbnb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.airbnb.databinding.FragmentMainpageBinding

class MainpageFragment : Fragment(){

    lateinit var binding: FragmentMainpageBinding
    lateinit var accommodationDB: AccommodationDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentMainpageBinding.inflate(inflater, container, false)
        accommodationDB = AccommodationDatabase.getInstance(requireContext())!!
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initRecyclerview()
    }

    private fun initRecyclerview(){
        binding.mainpageInfoRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val songRVAdapter = MainpageRVAdapter()

        //DB update
        songRVAdapter.setMyItemClickListener(object : MainpageRVAdapter.MyItemClickListener{
            override fun onRemoveSong(songId: Int) {
                //좋아요 해제 상태로 만들기
                accommodationDB.songDao().updateIsLikeById(false, songId)
            }

        })

        binding.mainpageInfoRecyclerView.adapter = songRVAdapter

        songRVAdapter.addSongs(accommodationDB.songDao().getLikedSongs(true) as ArrayList<Accommodation>)
    }
}