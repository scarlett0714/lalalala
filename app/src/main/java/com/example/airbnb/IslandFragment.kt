package com.example.airbnb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.airbnb.databinding.FragmentIslandBinding

class IslandFragment : Fragment() {
    lateinit var binding: FragmentIslandBinding

    lateinit var islandRVAdapter: IslandRVAdapter
    val datas = mutableListOf<IslandData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIslandBinding.inflate(inflater, container, false)

        initRecycler()
        return binding.root
    }

    private fun initRecycler() {
        binding.islandInfoRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        islandRVAdapter = IslandRVAdapter()
        binding.islandInfoRv.adapter = islandRVAdapter

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
}