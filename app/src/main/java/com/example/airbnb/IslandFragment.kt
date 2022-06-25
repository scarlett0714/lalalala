package com.example.airbnb

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.airbnb.databinding.FragmentIslandBinding

class IslandFragment : Fragment(), IslandView {
    lateinit var binding: FragmentIslandBinding

    lateinit var islandRVAdapter: IslandRVAdapter
    val datas = mutableListOf<IslandData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIslandBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onStart() {
        super.onStart()

        //service 생성시, 1.setview, 2.API호출
        val islandService = IslandService()
        islandService.setIslandView(this)

        islandService.sender(1) //원래는 안줘도 됨
        islandService.sender2(1) //원래는 안줘도 됨

        initRecycler()
    }

    private fun initRecycler() {
        binding.islandInfoRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        islandRVAdapter = IslandRVAdapter()
        binding.islandInfoRv.adapter = islandRVAdapter


        //dummy
        datas.apply {
            add(IslandData(R.drawable.black_star, "MV, 몰디브", "12345", "12345", "12345"))
            add(IslandData(R.drawable.black_star, "MV, 몰디브", "12345", "12345", "12345"))
            add(IslandData(R.drawable.black_star, "MV, 몰디브", "12345", "12345", "12345"))
            add(IslandData(R.drawable.black_star, "MV, 몰디브", "12345", "12345", "12345"))
            add(IslandData(R.drawable.black_star, "MV, 몰디브", "12345", "12345", "12345"))

            islandRVAdapter.datas = datas
            islandRVAdapter.notifyDataSetChanged()

        }
    }

    override fun onIslandSuccess(result: IslandResult) {
        Log.d("yaho", result.toString())
    }

    override fun onIslandFailure(code: Int) {
        TODO("Not yet implemented")
    }

    override fun onIslandSuccess2(resultImg: IslandResultImg) {
        Log.d("yaho2", resultImg.toString())
    }

    override fun onIslandFailure2(code: Int) {
        TODO("Not yet implemented")
    }
}